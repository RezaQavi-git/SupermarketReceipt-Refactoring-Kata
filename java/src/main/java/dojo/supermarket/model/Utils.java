package dojo.supermarket.model;


public class Utils {

    private final int columns;

    public Utils() {
        this(40);
    }

    public Utils(int columns) {
        this.columns = columns;
    }

    public String formatLineWithWhitespace(String name, String value) {
        StringBuilder line = new StringBuilder();
        line.append(name);
        int whitespaceSize = this.columns - name.length() - value.length();
        for (int i = 0; i < whitespaceSize; i++) {
            line.append(" ");
        }
        line.append(value);
        line.append('\n');
        return line.toString();
    }

    public String presentPrice(double price) {
        return String.format(Locale.UK, "%.2f", price);
    }

}
