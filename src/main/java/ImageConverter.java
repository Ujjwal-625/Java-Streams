import java.io.*;

public class ImageConverter {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";  // Original image file
        String outputImagePath = "output.jpg"; // Converted image file

        try {
            // Convert image to byte array
            byte[] imageData = convertImageToByteArray(inputImagePath);

            // Write byte array back to a new image file
            writeByteArrayToImage(imageData, outputImagePath);

            System.out.println("Image conversion successful. Check 'output.jpg'!");

        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }

    // Converts an image file to a byte array
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // Read in chunks of 4 KB
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Writes a byte array to an image file
    public static void writeByteArrayToImage(byte[] data, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // Write in chunks of 4 KB
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
