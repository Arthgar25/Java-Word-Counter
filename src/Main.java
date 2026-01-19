import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String dataFile = "jobRequirements.txt";
        String excludeFile = "excluded.txt";

        Map<String, Integer> frequency = new HashMap<>();
        Set<String> excludedWords = new HashSet<>();

        // 1. Load excluded words
        try (BufferedReader br = new BufferedReader(new FileReader(excludeFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                excludedWords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("Error reading exclude file: " + e.getMessage());
        }

        // 2. Read job requirements and count words
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    word = word.toLowerCase();

                    if (excludedWords.contains(word)) continue;
                    if (word.matches("\\d+")) continue; // optional: skip numbers

                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading data file: " + e.getMessage());
        }

        // 3. Print results
        List<Map.Entry<String, Integer>> sortedList =
                new ArrayList<>(frequency.entrySet());

        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}