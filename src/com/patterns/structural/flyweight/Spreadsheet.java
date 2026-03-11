package com.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {
    private final String name;
    private final List<Cell> cells = new ArrayList<>();

    public Spreadsheet(String name) {
        this.name = name;
    }

    public Cell addCell(int row, int col, String value, CellStyle style) {
        Cell cell = new Cell(row, col, value, style);
        cells.add(cell);
        return cell;
    }

    public void render() {
        System.out.println("\n  Таблиця: «" + name + "» (" + cells.size() + " комірок)");
        System.out.println("  " + "─".repeat(80));
        cells.forEach(Cell::render);
        System.out.println("  " + "─".repeat(80));
    }

    public int cellCount()  { return cells.size(); }

    public static Spreadsheet buildBudgetReport(int rows) {
        Spreadsheet sheet = new Spreadsheet("Бюджетний звіт");

        // Заздалегідь отримуємо стилі з пулу (не створюємо нові)
        CellStyle headerStyle = CellStyleFactory.getStyle(
                "Arial", 12, true, false,
                "#FFFFFF", "#2E75B6", "CENTER", "GENERAL");

        CellStyle labelStyle = CellStyleFactory.getStyle(
                "Arial", 11, false, false,
                "#000000", "#D6E4F0", "LEFT", "GENERAL");

        CellStyle currencyStyle = CellStyleFactory.getStyle(
                "Arial", 11, false, false,
                "#000000", "#FFFFFF", "RIGHT", "CURRENCY");

        CellStyle totalStyle = CellStyleFactory.getStyle(
                "Arial", 11, true, false,
                "#000000", "#FFE699", "RIGHT", "CURRENCY");

        CellStyle percentStyle = CellStyleFactory.getStyle(
                "Arial", 10, false, true,
                "#375623", "#E2EFDA", "RIGHT", "PERCENT");

        String[] headers = {"Категорія", "Бюджет", "Витрати", "% виконання"};
        for (int c = 0; c < headers.length; c++) {
            sheet.addCell(0, c, headers[c], headerStyle);
        }

        String[][] data = {
                {"Зарплата",     "500000", "487500", "0.975"},
                {"Оренда",       "120000", "120000", "1.000"},
                {"Маркетинг",    "80000",  "73200",  "0.915"},
                {"IT-обладнання","150000", "162000", "1.080"},
                {"Навчання",     "40000",  "31500",  "0.788"},
        };

        for (int r = 0; r < Math.min(rows, data.length); r++) {
            sheet.addCell(r + 1, 0, data[r][0], labelStyle);
            sheet.addCell(r + 1, 1, data[r][1], currencyStyle);
            sheet.addCell(r + 1, 2, data[r][2], currencyStyle);
            sheet.addCell(r + 1, 3, data[r][3], percentStyle);
        }

        Cell totalBudget = sheet.addCell(rows + 1, 1, "1390000", totalStyle);
        totalBudget.setFormula("SUM(B2:B" + (rows + 1) + ")");

        Cell totalSpent = sheet.addCell(rows + 1, 2, "1374200", totalStyle);
        totalSpent.setFormula("SUM(C2:C" + (rows + 1) + ")");

        sheet.addCell(rows + 1, 0, "РАЗОМ", totalStyle);
        sheet.addCell(rows + 1, 3, "0.9886", percentStyle);

        return sheet;
    }
}
