package ap.exercises.ex6.scraper;

import ap.exercises.ex6.scraper.parser.DownloadRunnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main_EX8 {

    private String baseFolderPath;

    public Main_EX8(String basePath) {
        this.baseFolderPath = basePath;
    }

    private List<Path> getHtmlPaths() {
        List<Path> htmlPaths = new ArrayList<>();
        try {
            Files.walk(Paths.get(baseFolderPath))
                    .filter(path -> Files.isRegularFile(path))
                    .filter(path -> path.getFileName().toString().equalsIgnoreCase("main.html"))
                    .forEach(path -> htmlPaths.add(path));
        } catch (IOException e) {
            System.out.println("Error In Reading File: " + e.getMessage());
        }
        return htmlPaths;
    }

    private int getConfigFileData() {
        File path = new File(Conf.CONFIG_FILE_PATH);
        try (Scanner scan = new Scanner((path))) {
            if (scan.hasNext()) {
                String configContent = scan.nextLine();
                String threadCount = configContent.substring(configContent.indexOf("=") + 1);
                return Integer.parseInt(threadCount);
            } else {
                System.out.println("Unable to Get Storage Type. -> " + Conf.CONFIG_FILE_PATH + "Is Empty.");
                return -1;
            }
        } catch (
                Exception e) {
            System.out.println("Unable to Open: " + Conf.CONFIG_FILE_PATH + "->" + e.getMessage());
            return -1;
        }
    }


    public void startDownloadingImagesAndMp3() {
        List<Path> htmlPathsList = this.getHtmlPaths();
        int threadCount = getConfigFileData();
        DownloadRunnable[] objects = new DownloadRunnable[threadCount];
        for (int i = 0; i < threadCount; i++) {
            objects[i] = new DownloadRunnable();
        }

        //Distribution:
        boolean isFinished = false;
        while (true) {
            for (int i = 0; i < threadCount; i++) {
                if (htmlPathsList.isEmpty()) {
                    isFinished = true;
                    break;
                }
                objects[i].addHtmlPathToList(htmlPathsList.get(0));
                htmlPathsList.remove(0);
            }
            if (isFinished) {
                break;
            }
        }

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(objects[i]);
            thread.start();
        }
    }
}


