package com.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Trunk extends TreeComponent{
    private final String  species;
    private final int     ageYears;
    private final double  heightM;
    private final double  ownWeight;
    private final List<TreeComponent> mainBranches = new ArrayList<>();

    public Trunk(String species, int ageYears, double heightM, double ownWeightKg) {
        super(species);
        this.species   = species;
        this.ageYears  = ageYears;
        this.heightM   = heightM;
        this.ownWeight = ownWeightKg * 1000;
    }

    public void addBranch(TreeComponent branch) {
        mainBranches.add(branch);
    }

    @Override
    public double getPhotosynthesisArea() {
        return mainBranches.stream()
                .mapToDouble(TreeComponent::getPhotosynthesisArea)
                .sum();
    }

    @Override
    public int countLeaves() {
        return mainBranches.stream()
                .mapToInt(TreeComponent::countLeaves)
                .sum();
    }

    @Override
    public double getWeight() {
        double branchesWeight = mainBranches.stream()
                .mapToDouble(TreeComponent::getWeight)
                .sum();
        return ownWeight + branchesWeight;
    }

    @Override
    public void display(int indent) {
        System.out.printf("%s🌳 %s  (вік: %d р., висота: %.1f м)%n",
                indent(indent), species, ageYears, heightM);
        System.out.printf("%s   Листків: %d  |  Фотосинтез: %.1f см²  |  Маса: %.0f г%n",
                indent(indent), countLeaves(), getPhotosynthesisArea(), getWeight());
        System.out.println(indent(indent) + "   " + "─".repeat(52));
        for (TreeComponent branch : mainBranches) {
            branch.display(indent + 1);
        }
    }

    @Override
    public void seasonChange(String season) {
        System.out.println("\n  🌳 " + species + " реагує на сезон: " + season.toUpperCase());
        System.out.println("  " + "─".repeat(48));
        for (TreeComponent branch : mainBranches) {
            branch.seasonChange(season);
        }
        System.out.printf("  Підсумок після «%s»: листків=%d, фотосинтез=%.1f см²%n",
                season, countLeaves(), getPhotosynthesisArea());
    }
}
