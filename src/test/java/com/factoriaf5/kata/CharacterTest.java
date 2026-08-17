package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
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


    /*Un personaje puede curar a otro personaje.
    Los personajes muertos no pueden ser curados.
    La curación no puede elevar la salud por encima de 1000. */
}
