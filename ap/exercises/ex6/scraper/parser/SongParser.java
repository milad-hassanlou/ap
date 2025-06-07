package ap.exercises.ex6.scraper.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SongParser {

    private static String getSongUrlInLine(String line) {
        String songUrl = null;
        int urlStartIndex = line.indexOf("src=\"");
        int urlEndIndex = line.indexOf("\"", urlStartIndex + "src=\"".length());
        if (urlStartIndex >= 0 && urlEndIndex >= 0) {
            songUrl = line.substring(urlStartIndex + "src=\"".length(), urlEndIndex);

            if (songUrl.indexOf("/") == 0) {
                songUrl = "https://www.znu.ac.ir" + songUrl;
            }

            if (!songUrl.toLowerCase().endsWith(".mp3")) {
                songUrl = null;
            }
        }
        return songUrl;
    }


    public static List<String> getAllSongsUrls(Path htmlPath) {
        try {
            return Files.lines(htmlPath)
                    .map(s -> getSongUrlInLine(s))
                    .filter(s -> s != null)
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(("Error InReading Html File For it's Images: ") + e.getMessage());
            return new ArrayList<>();
        }
    }
}
