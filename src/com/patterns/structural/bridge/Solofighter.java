package com.patterns.structural.bridge;

public class Solofighter extends Character {
    public void SoloFighter() {
        SoloFighter(null, null);
    }

    public void SoloFighter(String heroName, Archetype archetype) {
        super(heroName, archetype);
    }

    public void executeFullCombatCycle() {
        System.out.println("  [" + heroName + " — одиночний боєць] Починає сутичку:");
        performAttack();
        performDefend();
        useSpecialAbility();
    }
}
