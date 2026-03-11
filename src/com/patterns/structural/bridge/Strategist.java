package com.patterns.structural.bridge;

public class Strategist implements Archetype {
    @Override public String getName()         { return "Стратег"; }
    @Override public String getPrimarySkill() { return "Тактичне планування"; }

    @Override
    public String attack() {
        return "аналізує слабкість і завдає точного удару [шкода: 55, -30% захисту ворога]";
    }

    @Override
    public String defend() {
        return "передбачає атаку і відступає [ухилення: 85%]";
    }

    @Override
    public String specialAbility() {
        return "ГЕНІЙ ТАКТИКИ — весь загін отримує +40% до атаки на 2 раунди";
    }

    @Override
    public String getStats() {
        return "СИЛ:40 | ВИТ:50 | ІНТ:100 | СПР:85";
    }
}
