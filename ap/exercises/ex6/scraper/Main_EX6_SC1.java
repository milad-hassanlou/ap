package ap.exercises.ex6.scraper;

import ap.exercises.ex6.scraper.Conf;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Main_EX6_SC1 {
    // It's Better to Determine FilePath in Conf Class (Due to Commit Pushing It's Here)
    private String imagesFilePath = Conf.IMAGES_FILE_PATH;

    public void fillImagesFile() {

        ArrayList<String> filePaths = new ArrayList<>();
        for (int i = 1; i <= 224; i++) {
            filePaths.add("fetched_html/" + i + ".html");
        }

        Set<String> imagesAddress = filePaths.stream()
                .map(s -> {
                    try {
                        return Files.lines(Paths.get(s))
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        return null;
                    }
                })
                .filter(s -> s != null)
                .flatMap(s -> s.stream())
                .map(s -> getFirstImageUrl(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .collect(Collectors.toSet());

        try {
            PrintWriter out = new PrintWriter(imagesFilePath);
            for (String img : imagesAddress) {
                out.println(img);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFirstImageUrl(String htmlLine) {
        String imageUrl = null;
        int startIndex = htmlLine.indexOf("src=\"");
        if (startIndex >= 0) {
            try {
                int srcLength = "src=\"".length();
                int endIndex = htmlLine.indexOf("\"", startIndex + srcLength + 1);
                imageUrl = htmlLine.substring(startIndex + srcLength , endIndex);
            } catch (Exception e) {

            }
        }
        return imageUrl;
    }
}

