package com.factoriaf5.kata;

public class Character {

    private int health = 1000;
    private int level = 1;
    private boolean isAlive = true;

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

    public void dealDamage(Character target, int amount) {
        int newHealth = target.getHealth() - amount;
        target.setHealth(newHealth);
    }

}
