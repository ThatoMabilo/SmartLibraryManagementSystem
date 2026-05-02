package creational_patterns;

import domain.Member;
import domain.Notification;

public class OverdueNotificationCreator extends NotificationCreator {
    @Override
    public Notification createNotification(String id, Member member) {
        return new Notification(id, "Your book is overdue. A fine of R2.00 per day is being applied.", "OVERDUE", member);
    }
}
