package ap.exercises.ex5;

import java.util.ArrayList;
import java.util.List;

public class Main_EX5 {
    private ArrayList<String> urlsList;
    private ArrayList<Integer> countList;

    public Main_EX5() {
        urlsList = new ArrayList<>();
        countList = new ArrayList<>();
    }

    public void add(String url) {
        if (urlsList.contains(url)) {
            int index = urlsList.indexOf(url);
            countList.set(index, countList.get(index) + 1);
        } else {
            urlsList.add(url);
            countList.add(1);
        }
    }


    public List<String> getTop(int k) {
        for (int i = countList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (countList.get(j) < countList.get(j + 1)) {

                    int temp = countList.get(j);
                    countList.set(j, countList.get(j + 1));
                    countList.set(j + 1, temp);

                    String strTemp = urlsList.get(j);
                    urlsList.set(j, urlsList.get(j + 1));
                    urlsList.set(j + 1, strTemp);
                }
            }
        }
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < Math.min(k, urlsList.size()); i++) {
            resultList.add(urlsList.get(i));
        }
        return resultList;
    }
}
