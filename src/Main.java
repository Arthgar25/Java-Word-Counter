import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String fileName = "jobRequirements.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            Striung line;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }
}