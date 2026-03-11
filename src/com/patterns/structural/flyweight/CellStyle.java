package com.patterns.structural.flyweight;

public class CellStyle {
    private final String fontName;
    private final int    fontSize;
    private final boolean bold;
    private final boolean italic;
    private final String textColor;
    private final String bgColor;
    private final String alignment;   // LEFT, CENTER, RIGHT
    private final String numberFormat; // GENERAL, INTEGER, CURRENCY, PERCENT, DATE

    public CellStyle(String fontName, int fontSize, boolean bold, boolean italic,
                     String textColor, String bgColor,
                     String alignment, String numberFormat) {
        this.fontName     = fontName;
        this.fontSize     = fontSize;
        this.bold         = bold;
        this.italic       = italic;
        this.textColor    = textColor;
        this.bgColor      = bgColor;
        this.alignment    = alignment;
        this.numberFormat = numberFormat;
    }

    /** Рендерить вміст комірки з урахуванням стилю. */
    public String render(String value, int row, int col) {
        String formatted = formatValue(value);
        String style = String.format("%s%s%s%d",
                bold   ? "B" : "",
                italic ? "I" : "",
                fontName.substring(0, Math.min(3, fontName.length())),
                fontSize);
        return String.format("  [%s%d] %-14s | стиль:%-10s | текст:%-8s | фон:%-9s | %s",
                columnLetter(col), row + 1, formatted, style,
                textColor, bgColor, alignment);
    }

    private String formatValue(String value) {
        if (value == null || value.isBlank()) return "";
        try {
            double num = Double.parseDouble(value);
            return switch (numberFormat) {
                case "INTEGER"  -> String.valueOf((long) num);
                case "CURRENCY" -> String.format("%.2f грн", num);
                case "PERCENT"  -> String.format("%.1f%%", num * 100);
                default         -> value;
            };
        } catch (NumberFormatException e) {
            return value;
        }
    }

    private String columnLetter(int col) {
        StringBuilder sb = new StringBuilder();
        col++;
        while (col > 0) {
            col--;
            sb.insert(0, (char) ('A' + col % 26));
            col /= 26;
        }
        return sb.toString();
    }

    public String getKey() {
        return fontName + fontSize + bold + italic + textColor + bgColor + alignment + numberFormat;
    }

    @Override
    public String toString() {
        return String.format("CellStyle{%s %d%s%s %s/%s %s %s}",
                fontName, fontSize,
                bold ? " Bold" : "", italic ? " Italic" : "",
                textColor, bgColor, alignment, numberFormat);
    }
}
