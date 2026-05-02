package creational_patterns;

import domain.Notification;
import domain.Member;

public abstract class NotificationCreator {
    public abstract Notification createNotification(String id, Member member);

    public void sendNotification(String id, Member member) {
        Notification notification = createNotification(id, member);
        notification.generate();
        notification.deliver();
    }
}