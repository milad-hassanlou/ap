package ap.exercises.ex6.scraper.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class ImageParser {

    private static String getImageUrlInLine(String line) {
        String imageUrl = null;
        int urlStartIndex = line.indexOf("src=\"");
        int urlEndIndex = line.indexOf("\"", urlStartIndex + "src=\"".length());
        if (urlStartIndex >= 0 && urlEndIndex >= 0) {
            imageUrl = line.substring(urlStartIndex + "src=\"".length(), urlEndIndex);
            if (imageUrl.indexOf("/") == 0) {
                imageUrl = "https://www.znu.ac.ir" + imageUrl;
            }

            List<String> imagesExtensions = new ArrayList<>(Arrays.asList(".jpg", ".jpeg", ".png"));
            boolean bool = false;
            for (String extension : imagesExtensions) {
                if (imageUrl.toLowerCase().endsWith(extension)) {
                    bool = true;
                    break;
                }
            }
            if (!bool) {
                imageUrl = null;
            }
        }
        return imageUrl;
    }


    public static List<String> getAllImagesUrls(Path htmlPath) {
        try {
            return Files.lines(htmlPath)
                    .map(s -> getImageUrlInLine(s))
                    .filter(s -> s != null)
                    .distinct()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(("Error InReading Html File For it's Images: ") + e.getMessage());
            return new ArrayList<>();
        }
    }
}
