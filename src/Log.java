public class Log {
   // Created Log File
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
        // Implement file writing logic here
        // e.g., using FileWriter or BufferedWriter
    }
}
