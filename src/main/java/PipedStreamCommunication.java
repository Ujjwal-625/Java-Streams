import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            System.out.println("Writer: Writing message...");
            pos.write(message.getBytes()); // Write data to the pipe
            pos.close(); // Close stream after writing
        } catch (IOException e) {
            System.out.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            System.out.println("Reader: Waiting for message...");
            byte[] buffer = new byte[1024];
            int length = pis.read(buffer); // Read data from the pipe
            System.out.println("Reader received: " + new String(buffer, 0, length));
            pis.close(); // Close stream after reading
        } catch (IOException e) {
            System.out.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreamCommunication {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connecting the streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start(); // Start writing thread
            reader.start(); // Start reading thread
        } catch (IOException e) {
            System.out.println("Pipe Error: " + e.getMessage());
        }
    }
}
