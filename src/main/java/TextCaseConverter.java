import java.io.*;

public class TextCaseConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";   // File to read from
        String outputFile = "output.txt"; // File to write to

        try {
            convertUppercaseToLowercase(inputFile, outputFile);
            System.out.println("Conversion successful! Check 'output.txt'.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    // Reads a file and converts all uppercase characters to lowercase before writing to another file
    public static void convertUppercaseToLowercase(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Maintain line breaks
            }
        }
    }
}
