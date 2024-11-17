package labs.lab_6.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {

        Scanner scanner = null;

        try {
            File file = new File("C:\\Users\\akkau\\IdeaProjects\\ITandP\\src\\labs\\lab_6\\task1\\file.txt");
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {
            String line = scanner.next();
            line = line.toLowerCase().replaceAll("[\"'./,?!(){}0-9-]", "");
            if(line.isEmpty()) continue;

            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));

    }
}
