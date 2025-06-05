package ap.exercises.ex6.scraper;

import ap.exercises.ex6.scraper.fetcher.HtmlFetcher;
import ap.exercises.ex6.scraper.parser.HtmlParser;
import ap.exercises.ex6.scraper.store.HtmlFileManager;

import java.io.IOException;
import java.util.*;

public class DomainHtmlScraper {
    private String domainAddress;
    private Queue<String> queue;

    private HtmlFileManager htmlFileManager;

    public DomainHtmlScraper(String domainAddress, String savePath) {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.htmlFileManager=new HtmlFileManager(savePath);
    }

    public void start() throws IOException {
        Set<String> checked = new HashSet<>();      //***
        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
        this.htmlFileManager.save(htmlLines);
        checked.add(domainAddress);                //***

        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines);
        queue.addAll(new HashSet<>(urls));
        int counter=1;

        while (!queue.isEmpty()){
            String url = queue.remove();
            if(checked.contains(url)){     //***
                continue;                  //***
            }                              //***
            counter++;
            try {
                checked.add(url);            //***
                htmlLines = HtmlFetcher.fetchHtml(url);      //***  Not domainAddress
                this.htmlFileManager.save(htmlLines);

                urls = HtmlParser.getAllUrlsFromList(htmlLines);
                queue.addAll(new HashSet<>(urls));
            }
            catch (Exception e){
                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
            }
            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
        }
        System.out.println("Operation complete");
    }

}
