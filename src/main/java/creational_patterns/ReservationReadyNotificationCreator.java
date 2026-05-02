package creational_patterns;

import domain.Member;
import domain.Notification;

public class ReservationReadyNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification(String id, Member member) {
        return new Notification(id, "Your reserved book is now available for collection.", "RESERVATION_READY", member);
    }
}
