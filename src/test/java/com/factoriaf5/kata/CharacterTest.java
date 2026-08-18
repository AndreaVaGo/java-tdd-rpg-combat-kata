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

        attacker.dealDamage(target, 100);

        assertEquals(900, target.getHealth());
    }

    @Test
    public void shouldDieWhenDamageExceedsHealth() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 1500);

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

        healer.dealDamage(target, 1500);
        healer.heal(target, 1000);

        assertEquals(0, target.getHealth());
    }

    @Test
    public void shouldNotExceedMaxHealthWhenHealed() {
        Character character = new Character();

        character.dealDamage(character, 100);
        character.heal(character, 200);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void shouldNotDamageSelf() {
        Character character = new Character();

        character.dealDamage(character, 100);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void shouldOnlyHealSelf() {
        Character healer = new Character();
        Character target = new Character();

        healer.dealDamage(target, 200);
        healer.heal(target, 200);
        assertEquals(800, target.getHealth());
    }

}
