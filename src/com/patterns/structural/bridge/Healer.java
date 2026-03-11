package com.patterns.structural.bridge;

public class Healer implements Archetype{
    @Override public String getName()         { return "Цілитель"; }
    @Override public String getPrimarySkill() { return "Відновлення"; }

    @Override
    public String attack() {
        return "вражає посохом і накладає отруту [шкода: 30, -10 HP/раунд]";
    }

    @Override
    public String defend() {
        return "накладає ауру захисту [+25 HP/раунд усьому загону]";
    }

    @Override
    public String specialAbility() {
        return "ВОСКРЕСІННЯ — повертає до бою одного загиблого союзника з 50% HP";
    }

    @Override
    public String getStats() {
        return "СИЛ:25 | ВИТ:60 | ІНТ:80 | СПР:55";
    }
}
