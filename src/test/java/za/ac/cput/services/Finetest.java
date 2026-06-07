package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Fine;

import static org.junit.jupiter.api.Assertions.*;

class FineTest {

    @Test
    void shouldCreateFineSuccessfully() {

        Fine fine = new Fine(50.00);

        assertEquals(50.00, fine.getAmount());
    }

    @Test
    void fineAmountShouldNotBeNegative() {

        assertThrows(IllegalArgumentException.class,
                () -> new Fine(-10.00));
    }

    @Test
    void shouldUpdateFineAmount() {

        Fine fine = new Fine(20.00);

        fine.setAmount(40.00);

        assertEquals(40.00, fine.getAmount());
    }
}