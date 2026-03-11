package com.patterns.structural.bridge;

public class Assassin implements Archetype{
    @Override public String getName()         { return "Асасін"; }
    @Override public String getPrimarySkill() { return "Скрадливість"; }

    @Override
    public String attack() {
        return "завдає удару в спину з тіні [шкода: 130, критичний удар x2]";
    }

    @Override
    public String defend() {
        return "зникає в тіні [невидимість на 1 раунд, скидає ціль]";
    }

    @Override
    public String specialAbility() {
        return "🗡  СМЕРТЕЛЬНИЙ ВИРОК — миттєво усуває ціль з HP < 25%";
    }

    @Override
    public String getStats() {
        return "СИЛ:70 | ВИТ:40 | ІНТ:65 | СПР:100";
    }
}
