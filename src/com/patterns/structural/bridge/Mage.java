package com.patterns.structural.bridge;

public class Mage implements Archetype{
    @Override public String getName()         { return "Маг"; }
    @Override public String getPrimarySkill() { return "Заклинання"; }

    @Override
    public String attack() {
        return "випускає вогняну кулю [шкода: 110, ігнорує броню]";
    }

    @Override
    public String defend() {
        return "створює магічний щит [поглинання: 50%, відбиває 20% шкоди назад]";
    }

    @Override
    public String specialAbility() {
        return " МЕТЕОРИТНИЙ ДОЩ — масова атака по всіх ворогах [шкода: 75 кожному]";
    }

    @Override
    public String getStats() {
        return "СИЛ:20 | ВИТ:35 | ІНТ:100 | СПР:60";
    }
}
