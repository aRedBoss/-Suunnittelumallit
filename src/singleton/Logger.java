package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    private Logger() {
        this.fileName = "default_log.txt";
        openFile(fileName);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        close();
        this.fileName = fileName;
        openFile(fileName);
    }

    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }

    public void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error closing file: " + e.getMessage());
        }
    }
}

