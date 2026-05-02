package creational_patterns;

import domain.Member;
import domain.Librarian;
import domain.UserAccount;

public class UserFactory {

    public static UserAccount createUser(String type, String userId, String fullName, String email, String passwordHash) {
        switch (type.toUpperCase()) {
            case "MEMBER":
                return new Member(userId, fullName, email, passwordHash);
            case "LIBRARIAN":
                return new Librarian(userId, fullName, email, passwordHash);
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}