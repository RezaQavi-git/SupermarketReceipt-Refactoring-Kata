package dojo.supermarket.model;

import java.util.Locale;

public class Utils {

    private static int columns;

    public Utils() {
        this(40);
    }

    public Utils(int columns) {
        this.columns = columns;
    }

    public static String formatLineWithWhitespace(String name, String value) {
        StringBuilder line = new StringBuilder();
        line.append(name);
        int whitespaceSize = columns - name.length() - value.length();
        for (int i = 0; i < whitespaceSize; i++) {
            line.append(" ");
        }
        line.append(value);
        line.append('\n');
        return line.toString();
    }

    public static String presentPrice(double price) {
        return String.format(Locale.UK, "%.2f", price);
    }

}
