package com.patterns.structural.bridge;

import java.util.ArrayList;
import java.util.List;

public class GroupLeader extends Character {
    private List<Character> squad = new ArrayList<>();

    public GroupLeader(String heroName, Archetype archetype) {
        super(heroName, archetype);
    }

    public void addToSquad(Character member) {
        squad.add(member);
    }

    /** Лідер надихає загін, спираючись на свій архетип. */
    public void inspireSquad() {
        System.out.println("  [" + heroName + " — " + archetype.getName() + "] "
                + "Піднімає бойовий дух загону! Навичка: «" + archetype.getPrimarySkill() + "»");
        for (Character member : squad) {
            System.out.println("    → " + member.heroName
                    + " (" + member.archetype.getName() + ") готовий до бою!");
        }
    }

    /** Лідер координує атаку всього загону. */
    public void orderGroupAttack() {
        System.out.println("  [" + heroName + "] Командує атаку:");
        performAttack();
        for (Character member : squad) {
            member.performAttack();
        }
    }
}
