package com.patterns.structural.bridge;

public class Warrior implements Archetype {
    @Override public String getName()         { return "Воїн"; }
    @Override public String getPrimarySkill() { return "Ближній бій"; }

    @Override
    public String attack() {
        return "завдає потужного удару мечем [шкода: 85]";
    }

    @Override
    public String defend() {
        return "піднімає щит і блокує атаку [поглинання: 70%]";
    }

    @Override
    public String specialAbility() {
        return "⚔  БЕРСЕРК — подвоює шкоду на 3 раунди, ігноруючи біль";
    }

    @Override
    public String getStats() {
        return "СИЛ:95 | ВИТ:80 | ІНТ:30 | СПР:40";
    }
}
