package com.factoriaf5.kata;

import java.util.Set;
import java.util.HashSet;

public class Character {

    private int health = 1000;
    private int level = 1;
    private boolean isAlive = true;
    private int range = 2;
    private Set<String> factions = new HashSet<>();

    public Set<String> getFactions() {
        return factions;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    private int calculateDamage(Character target, int amount) {
        if (target.getLevel() - this.getLevel() >= 5) {
            amount = amount / 2;
        }

        if (this.getLevel() - target.getLevel() >= 5) {
            amount = amount + amount / 2;
        }

        return amount;
    }

    private void applyDamage(Character target, int amount) {
        int newHealth = target.getHealth() - amount;

        if (newHealth < 0) {
            newHealth = 0;
        }

        if (newHealth == 0) {
            target.setAlive(false);
        }

        target.setHealth(newHealth);
    }

    public void dealDamage(Character target, int amount, int distance) {
        if (this == target) {
            return;
        }

        if (distance > this.getRange()) {
            return;
        }

        if (this.isAllyOf(target)) {
            return;
        }

        amount = calculateDamage(target, amount);
        applyDamage(target, amount);
    }

    public void heal(Character target, int amount) {
        if (this != target && !this.isAllyOf(target)) {
            return;
        }

        if (!target.isAlive()) {
            return;
        }

        int newHealth = target.getHealth() + amount;

        if (newHealth > 1000) {
            newHealth = 1000;
        }

        target.setHealth(newHealth);
    }

    public void joinFaction(String faction) {
        factions.add(faction);
    }

    public void leaveFaction(String faction) {
        factions.remove(faction);
    }

    private boolean isAllyOf(Character target) {
        for (String faction : this.factions) {
            if (target.getFactions().contains(faction)) {
                return true;
            }
        }
        return false;
    }

}
