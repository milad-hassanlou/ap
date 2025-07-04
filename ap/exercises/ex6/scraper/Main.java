package ap.exercises.ex6.scraper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String domainAddress = Conf.DOMAIN_ADDRESS;
        String savePath = Conf.SAVE_DIRECTORY;
        String specialSavePath = Conf.SAVE_DIRECTORY_SPECIAL_URL;

        DomainHtmlScraper domainHtmlScraper = new DomainHtmlScraper(domainAddress,savePath);
        domainHtmlScraper.start();

        Main_EX6_SC2 download = new Main_EX6_SC2(domainAddress,specialSavePath);
        download.startUrlParser();

        Main_EX8 downloadImageAndSong = new Main_EX8(specialSavePath);
        downloadImageAndSong.startDownloadingImagesAndMp3();

//        Main_EX6_SC3 imageAndSong = new Main_EX6_SC3(specialSavePath);
//        imageAndSong.startDownloadImagesAndMp3();
    }
}
