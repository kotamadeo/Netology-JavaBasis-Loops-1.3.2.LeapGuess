public class Utils {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }

    public String getAnsiReset() {
        return ANSI_RESET;
    }

    public String getAnsiBlack() {
        return ANSI_BLACK;
    }

    public String getAnsiRed() {
        return ANSI_RED;
    }

    public String getAnsiGreen() {
        return ANSI_GREEN;
    }

    public String getAnsiYellow() {
        return ANSI_YELLOW;
    }

    public String getAnsiBlue() {
        return ANSI_BLUE;
    }

    public String getAnsiPurple() {
        return ANSI_PURPLE;
    }

    public String getAnsiCyan() {
        return ANSI_CYAN;
    }

    public String getAnsiWhite() {
        return ANSI_WHITE;
    }
}
