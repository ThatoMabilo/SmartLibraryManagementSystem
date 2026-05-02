package creational_patterns;

import domain.Notification;
import domain.UserAccount;

public interface AccountFactory {
    UserAccount createUser(String userId, String fullName, String email, String passwordHash);
    Notification createWelcomeNotification(String notificationId, domain.Member member);
}

