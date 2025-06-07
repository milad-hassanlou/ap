package ap.exercises.ex6.scraper;

import ap.exercises.ex6.scraper.fetcher.ImageDownloader;
import ap.exercises.ex6.scraper.fetcher.MP3Downloader;
import ap.exercises.ex6.scraper.parser.ImageParser;
import ap.exercises.ex6.scraper.parser.SongParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main_EX6_SC3 {
    //Download Urls, Images, Songs
    private String baseFolderPath;

    public Main_EX6_SC3(String basePath) {
        this.baseFolderPath = basePath;
    }

    private List<Path> htmlPaths() {
        List<Path> htmlPathsList = new ArrayList<>();
        try {
            Files.walk(Paths.get(baseFolderPath))
                    .filter(path -> Files.isRegularFile(path))
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase("main.html"))
                    .forEach(path -> htmlPathsList.add(path));
        } catch (IOException e) {
            System.out.println("Error In Reading File: " + e.getMessage());
        }
        return htmlPathsList;
    }


    public void startDownloadImagesAndMp3() {
        List<Path> htmlPathsList = this.htmlPaths();
        for (Path htmlPath : htmlPathsList) {
            String mainDirectory = htmlPath.getParent().getParent().toString();
            List<String> imageUrlsList = ImageParser.getAllImagesUrls(htmlPath);
            List<String> mp3UrlsList = SongParser.getAllSongsUrls(htmlPath);
            for (int i = 0; i < imageUrlsList.size(); i++) {
                try {
                    ImageDownloader.downloadImage(imageUrlsList.get(i), mainDirectory + "/image/" + (i + 1) + ".jpg");
                } catch (FileNotFoundException e) {
                    System.out.println("Error: The requested page does not exist.... " + e.getMessage());
                }catch (Exception a){
                    System.out.println("Error Downloading Image from: " + a.getMessage());
                }
            }
            for (int j = 0; j < mp3UrlsList.size(); j++) {
                try {
                    MP3Downloader.downloadMP3(mp3UrlsList.get(j), mainDirectory + "/song/" + (j + 1) + ".mp3");
                } catch (Exception e) {
                    System.out.println("Error Downloading MP3 from: " + e.getMessage());

                }
            }
        }
    }
}
