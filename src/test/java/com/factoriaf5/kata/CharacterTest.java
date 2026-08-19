package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void shouldStartWith1000Health() {
        Character character = new Character();

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void shouldStartWith1Level() {
        Character character = new Character();

        assertEquals(1, character.getLevel());
    }

    @Test
    public void shouldStartAlive() {
        Character character = new Character();

        assertTrue(character.isAlive());
    }

    @Test
    public void shouldReduceHealthWhenDamaged() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 100, 1);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void shouldDieWhenDamageExceedsHealth() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 1500, 1);

        assertEquals(0, target.getHealth());
        assertFalse(target.isAlive());
    }

    @Test
    public void shouldIncreaseHealthWhenHealed() {
        Character character = new Character();
        character.setHealth(500);

        character.heal(character, 200);

        assertEquals(700, character.getHealth());
    }

    @Test
    public void shouldNotHealWhenDead() {
        Character healer = new Character();
        Character target = new Character();

        healer.dealDamage(target, 1500, 1);
        healer.heal(target, 1000);

        assertEquals(0, target.getHealth());
    }

    @Test
    public void shouldNotExceedMaxHealthWhenHealed() {
        Character character = new Character();

        character.dealDamage(character, 100, 1);
        character.heal(character, 200);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void shouldNotDamageSelf() {
        Character character = new Character();

        character.dealDamage(character, 100, 1);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void shouldOnlyHealSelf() {
        Character healer = new Character();
        Character target = new Character();

        healer.dealDamage(target, 200, 1);
        healer.heal(target, 200);
        assertEquals(800, target.getHealth());
    }

    @Test
    public void shouldReduceDamageWhenTargetIsHigherLevel() {
        Character attacker = new Character();
        Character target = new Character();

        target.setLevel(6);
        attacker.dealDamage(target, 100, 1);

        assertEquals(950, target.getHealth());
    }

    @Test
    public void shouldIncreaseDamageWhenTargetIsLowerLevel() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.setLevel(6);
        attacker.dealDamage(target, 100, 1);

        assertEquals(850, target.getHealth());
    }

    @Test
    public void shouldNotDamageWhenOutOfRange() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 100, 20);

        assertEquals(1000, target.getHealth());
    }

    @Test
    public void shouldJoinFaction() {
        Character character = new Character();

        character.joinFaction("Elfos");

        assertTrue(character.getFactions().contains("Elfos"));
    }

    @Test
    public void shouldLeaveFaction() {
        Character character = new Character();
        character.joinFaction("Elfos");
        character.leaveFaction("Elfos");

        assertFalse(character.getFactions().contains("Elfos"));
    }

    @Test
    public void shouldNotDamageAllies() {
        Character attacker = new Character();
        Character target = new Character();
        attacker.joinFaction("Elfos");
        target.joinFaction("Elfos");
        attacker.dealDamage(target, 100, 1);

        assertEquals(1000, target.getHealth());
    }

}
