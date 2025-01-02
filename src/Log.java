import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
   // Created Log File Required 
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

    public void logEvent(String event) {
        logBuffer.append(event).append("\n");
    }

    public String getLog() {
        return logBuffer.toString();
    }

    public void writeLogToFile(String filename) {
    	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
             writer.write(logBuffer.toString());
             System.out.println("Log written to file: " + filename);
         } catch (IOException e) {
             System.err.println("Error writing log to file: " + e.getMessage());
         }
    }
}
