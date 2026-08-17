package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CharacterTest {

    @Test
    public void shouldStartWith1000Health() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
    }

}
