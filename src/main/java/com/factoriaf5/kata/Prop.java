package com.factoriaf5.kata;

public class Prop implements Damageable {

    private int health = 1000;
    private boolean isAlive = true;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

}
