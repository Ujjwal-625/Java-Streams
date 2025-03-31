import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB buffer

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "des.txt";

        long startTime = System.nanoTime();
        copyFileUsingBufferedStreams(sourceFile, destFile);
        long endTime = System.nanoTime();

        System.out.println("Buffered Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void copyFileUsingBufferedStreams(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully using buffered streams.");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}

