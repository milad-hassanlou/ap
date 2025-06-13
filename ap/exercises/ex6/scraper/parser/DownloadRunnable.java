package ap.exercises.ex6.scraper.parser;

import ap.exercises.ex6.scraper.fetcher.ImageDownloader;
import ap.exercises.ex6.scraper.fetcher.MP3Downloader;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public class DownloadRunnable implements Runnable{
    private List<Path> htmlPathsList;

    public void addHtmlPathToList(Path htmlPathsList) {
        this.htmlPathsList.add(htmlPathsList);
    }

    public void run(){

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

