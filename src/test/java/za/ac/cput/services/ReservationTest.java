package za.ac.cput.services;



import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Book;
import za.ac.cput.domain.Member;
import za.ac.cput.domain.Reservation;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void shouldCreateReservationSuccessfully() {

        Book book = new Book();
        Member member = new Member();
        LocalDate date = LocalDate.now();
        Reservation reservation =
                new Reservation(
                        "R001",
                        book,
                        member,
                        date
                );

        assertNotNull(reservation);
        assertEquals(book, reservation.getBook());
        assertEquals(member, reservation.getMember());
    }

    @Test
    void reservationDateShouldNotBeNull() {
        LocalDate date = LocalDate.now();
        Reservation reservation = new Reservation();

        assertNotNull(reservation.getReservationDate());
    }

    @Test
    void shouldCancelReservation() {

        Reservation reservation = new Reservation();

        reservation.setCancelled(true);

        assertTrue(reservation.isCancelled());
    }
}