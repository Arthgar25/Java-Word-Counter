import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String fileName = "jobRequirements.txt";
        HashMap<String, Integer> frequency = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = br.readLine()) != null){
                String[] words = line.split("//W+");

                for(String word : words){
                    if(word.isEmpty())continue;

                    word = word.toLowerCase();
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        frequency.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}