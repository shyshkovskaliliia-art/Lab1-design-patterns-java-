package com.patterns.structural.bridge;

public class Solofighter extends Character {
    public SoloFighter(String heroName, Archetype archetype) {
        super(heroName, archetype);
    }

    /** Одиночний боєць виконує повний цикл бою сам. */
    public void executeFullCombatCycle() {
        System.out.println("  [" + heroName + " — одиночний боєць] Починає сутичку:");
        performAttack();
        performDefend();
        useSpecialAbility();
    }
}
