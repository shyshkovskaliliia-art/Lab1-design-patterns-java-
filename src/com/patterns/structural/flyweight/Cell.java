package com.patterns.structural.flyweight;

public class Cell {
    private final int    row;
    private final int    col;
    private       String value;
    private       String formula;
    private       CellStyle style;    // посилання на flyweight

    public Cell(int row, int col, String value, CellStyle style) {
        this.row     = row;
        this.col     = col;
        this.value   = value;
        this.style   = style;
        this.formula = null;
    }

    public void setValue(String value)     { this.value = value; }
    public void setFormula(String formula) { this.formula = formula; }
    public void setStyle(CellStyle style)  { this.style = style; }

    public String getValue()   { return value; }
    public String getFormula() { return formula; }
    public int getRow()        { return row; }
    public int getCol()        { return col; }

    public void render() {
        String display = (formula != null) ? value + " [=" + formula + "]" : value;
        System.out.println(style.render(display, row, col));
    }
}
