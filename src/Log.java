import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// Log code is finalised
public class Log {
    private static Log instance;
    private StringBuffer logBuffer;

    private Log() {
        logBuffer = new StringBuffer();
    }

    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Log an event
    public void logEvent(String event) {
        logBuffer.append(event).append("\n");
    }

    // Get the entire log as a string
    public String getLog() {
        return logBuffer.toString();
    }

    // Write the log to a file
    public void writeLogToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(logBuffer.toString());
            System.out.println("Log written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing log to file: " + e.getMessage());
        }
    }

    // Display the log in the console
    public void displayLog() {
        System.out.println("---- Log Events ----");
        System.out.println(logBuffer.toString());
    }
}
