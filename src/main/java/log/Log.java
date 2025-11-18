package log;

public class Log {
    public static void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public static void error(String message) {
        System.out.println("[ERROR] " + message);
    }
}
