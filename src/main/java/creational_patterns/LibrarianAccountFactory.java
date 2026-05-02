package creational_patterns;

import domain.Librarian;
import domain.Notification;

public class LibrarianAccountFactory implements AccountFactory {
    @Override
    public Librarian createUser(String userId, String fullName, String email, String passwordHash) {
        return new Librarian(userId, fullName, email, passwordHash);
    }

    @Override
    public Notification createWelcomeNotification(String notificationId, domain.Member member) {
        return new Notification(notificationId, "Your librarian account is ready. You can now manage loans and the catalogue.", "WELCOME", member);
    }
}
