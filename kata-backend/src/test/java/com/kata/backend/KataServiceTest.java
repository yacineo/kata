package com.kata.backend;

import com.kata.backend.exception.CustomIllegalArgumentException;
import com.kata.backend.service.impl.KataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KataServiceTest {

    private KataService service;

    @BeforeEach
    public void setUp() {
        service = new KataService();
    }


    @Test
    public void shouldReturnExceptionWhenWhenNumberIsGreaterThan100() {
        int number = ThreadLocalRandom.current().nextInt(101, 1000);
        assertThrows(CustomIllegalArgumentException.class, () -> {
            service.transformNumber(number);
        });
    }

    @Test
    public void shouldReturnExceptionWhenNumberIsLowerThan0() {
        int number = -ThreadLocalRandom.current().nextInt(1, 1000);
        assertThrows(CustomIllegalArgumentException.class, () -> {
            service.transformNumber(number);
        });
    }

    @Test
    public void shouldReturnTheNumberAsAStringWhenNoneOfTheRulesApply() {
        assertEquals("1", service.transformNumber(1));
        assertEquals("2", service.transformNumber(2));
        assertEquals("4", service.transformNumber(4));
        assertEquals("94", service.transformNumber(94));
        assertEquals("98", service.transformNumber(98));
    }

    @Test
    public void shouldReturnFOOWhenDivisibilityBy3() {
        assertEquals("FOO", service.transformNumber(6));
    }

    @Test
    public void shouldReturnFOOFOOWhenDivisibilityBy3AndContainsOneOccurrenceOf3() {

        assertEquals("FOOFOO", service.transformNumber(3));

    }

    @Test
    public void shouldReturnFOOFOOFOOWhenDivisibilityBy3AndContainsTwoOccurrencesOf3() {

        assertEquals("FOOFOOFOO", service.transformNumber(33));
    }

    @Test
    public void shouldReturnBARWhenDivisibilityBy5() {
        assertEquals("BAR", service.transformNumber(10));
    }

    @Test
    public void shouldReturnBARBARWhenBARDivisibilityBy5AndContainsOneOccurrenceOf5() {
        assertEquals("BARBAR", service.transformNumber(5));
    }

    @Test
    public void shouldReturnBARBARBARWhenDivisibilityBy5AndContainsTwoOccurrencesOf5() {
        assertEquals("BARBARBAR", service.transformNumber(55));
    }

    @Test
    public void shouldReturnFOOBARWhenDivisibilityBy3And5() {
        assertEquals("FOOBAR", service.transformNumber(60));
        assertEquals("FOOBAR", service.transformNumber(90));
    }

    @Test
    public void shouldReturnQuixWhenContainsOneOccurrenceOf7() {
        assertEquals("QUIX", service.transformNumber(7));
    }

    @Test
    public void shouldReturnQUIXQUIXWhenContainsTwoOccurrencesOf7() {
        assertEquals("QUIXQUIX", service.transformNumber(77));
    }

    @Test
    public void shouldReturnBARFOOWhenContains5And3() {
        assertEquals("BARFOO", service.transformNumber(53));
    }
    @Test
    public void shouldReturnBARFOOBARWhenDivisibilityBy5AndContains3And5() {
        assertEquals("BARFOOBAR", service.transformNumber(35));
    }
}
