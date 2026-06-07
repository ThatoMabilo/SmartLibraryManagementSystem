package za.ac.cput.repositories;

import za.ac.cput.domain.Reservation;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends Repository<Reservation, String> {
    List<Reservation> findByMemberId(String memberId);
    List<Reservation> findByBookId(String bookId);
    List<Reservation> findByStatus(String status);
    List<Reservation> findActiveReservations();
    List<Reservation> findExpiredReservations(LocalDateTime currentDate);
    boolean isBookReserved(String bookId);
    int getReservationQueuePosition(String bookId, String memberId);
}