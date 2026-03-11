package com.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CellStyleFactory {
    private static final Map<String, CellStyle> pool = new HashMap<>();

    public static CellStyle getStyle(String fontName, int fontSize,
                                     boolean bold, boolean italic,
                                     String textColor, String bgColor,
                                     String alignment, String numberFormat) {

        String key = fontName + fontSize + bold + italic
                + textColor + bgColor + alignment + numberFormat;

        if (!pool.containsKey(key)) {
            pool.put(key, new CellStyle(fontName, fontSize, bold, italic,
                    textColor, bgColor, alignment, numberFormat));
            System.out.println("  [StyleFactory] Створено новий стиль: " + key);
        }
        return pool.get(key);
    }

    public static int poolSize()       { return pool.size(); }
    public static void printPool() {
        System.out.println("  [StyleFactory] Пул стилів (" + pool.size() + " унікальних):");
        pool.values().forEach(s -> System.out.println("    • " + s));
    }
}
