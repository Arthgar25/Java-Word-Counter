import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String fileName = "jobRequirements.txt";
        String excludedFile = "excluded.txt";

        HashMap<String, Integer> frequency = new HashMap<>();
        HashSet<String> excludedWords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(excludedFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                excludedWords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            System.out.println("Error reading exclude file: " + e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = br.readLine()) != null){
                String[] words = line.split("\\W+");

                for(String word : words){
                    if(word.isEmpty())continue;

                    word = word.toLowerCase();
                    if(excludedWords.contains(word)) continue;
                    if(word.matches("\\d+")) continue;
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        frequency.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}