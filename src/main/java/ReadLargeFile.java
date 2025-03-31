import java.io.*;

public class ReadLargeFile {
    public static void main(String[] args) {
        String filePath = "large_file.txt"; // Change this to your actual file path
        readAndFilterErrors(filePath);
    }

    public static void readAndFilterErrors(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error: Unable to read the file!");
        }
    }
}
