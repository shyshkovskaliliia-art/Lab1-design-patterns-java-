package com.patterns.structural.bridge;

public class Character {
    protected String heroName;
    protected Archetype archetype;

    public Character(String heroName, Archetype archetype) {
        this.heroName  = heroName;
        this.archetype = archetype;
    }

    public void introduce() {
        System.out.printf("  %-18s | Архетип: %-12s | %s%n",
                heroName, archetype.getName(), archetype.getStats());
    }

    public void performAttack() {
        System.out.println("  " + heroName + " " + archetype.attack());
    }

    public void performDefend() {
        System.out.println("  " + heroName + " " + archetype.defend());
    }

    public void useSpecialAbility() {
        System.out.println("  " + heroName + " використовує особливу здібність:");
        System.out.println("    " + archetype.specialAbility());
    }
}
