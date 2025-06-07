package ap.exercises.ex6.scraper;

import ap.exercises.ex6.scraper.fetcher.HtmlFetcher;
import ap.exercises.ex6.scraper.parser.HtmlParser;
import ap.exercises.ex6.scraper.utils.DirectoryTools;

import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.List;

public class Main_EX6_SC2 {
    private String domainAddress;
    private String savingBaseDirectory;
    private static int printCount=1;

    public Main_EX6_SC2(String domainAddress, String savingBaseDirectory) {
        this.domainAddress = domainAddress;
        this.savingBaseDirectory = savingBaseDirectory;
    }

    public void startUrlParser() {
        try {
            List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
            List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
            urls.stream()
                    .filter(s -> s.contains(".znu.ac.ir"))
                    .forEach(s -> downloadUrlInFolder(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadUrlInFolder(String url) {
        String savePath = manageSavePath(url);
        downloadAndSave(url, savePath);
    }

    private String manageSavePath(String url) {
        //Create File Path
        String savePath = savingBaseDirectory;
        //Subdomain in Path
        int subDomainStartPoint = url.indexOf("://") + "://".length();
        int subDomainEndPoint = url.indexOf(".znu.ac.ir");
        if(subDomainStartPoint>=0 && subDomainEndPoint>=0) {
            String pathUnit1 = url.substring(subDomainStartPoint, subDomainEndPoint);
            if (!pathUnit1.equals("www")) {
                savePath += "/_" + pathUnit1;
            }
        }
        //SubPath in Path
        int domainPathStartPoint = url.indexOf("/", "https://".length() + 1);
        if (domainPathStartPoint >= 0) {
            String pathUnit2 = url.substring(domainPathStartPoint);
            savePath += pathUnit2;
        }
        savePath += "/html";

        return savePath;
    }

    private void downloadAndSave(String url, String savePath) {
        try {
            List<String> htmlLines = HtmlFetcher.fetchHtml(url);
            DirectoryTools.createDirectory(savePath);

            PrintWriter write = new PrintWriter(savePath += "/main.html");
            for (String line : htmlLines) {
                write.println(line);
            }
            write.close();
            System.out.println("[" + printCount + "]" + "url: " + url + " Saved.");
            printCount++;
        } catch (UnknownHostException e) {
            System.out.println("Domain Address :"+ url + " does Not Exist! ");
        } catch (Exception e) {
            System.out.println("!!!save or fetch failed: " + e.getMessage());
        }
    }
}
