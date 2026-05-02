# CLASS-DIAGRAM.md — Smart Library Management System

---

## Class Diagram

Below is the class diagram that represents the full structure of the system, showing all classes, their attributes and methods, and the relationships between them including association, composition, and inheritance.

---

```mermaid
classDiagram

    class Member {
        -memberId: String
        -fullName: String
        -email: String
        -passwordHash: String
        -fineBalance: Double
        -accountStatus: String
        +register(): void
        +login(): String
        +searchBooks(query: String): List
        +reserveBook(bookId: String): void
        +viewBorrowingHistory(): List
        +viewFines(): Double
    }

    class Librarian {
        -librarianId: String
        -fullName: String
        -email: String
        -passwordHash: String
        -role: String
        +issueLoan(memberId: String, bookId: String): void
        +processReturn(loanId: String): void
        +manageCatalogue(): void
        +markFinePaid(fineId: String): void
        +viewAdminSummary(): Map
    }

    class Book {
        -bookId: String
        -title: String
        -author: String
        -ISBN: String
        -genre: String
        -yearPublished: int
        -totalCopies: int
        -availableCopies: int
        +checkAvailability(): boolean
        +addToCatalogue(): void
        +updateDetails(): void
        +removeFromCatalogue(): void
    }

    class Loan {
        -loanId: String
        -issueDate: Date
        -dueDate: Date
        -returnDate: Date
        -status: String
        -fineAmount: Double
        +issueLoan(): void
        +processReturn(): void
        +calculateFine(): Double
        +markAsClosed(): void
    }

    class Reservation {
        -reservationId: String
        -reservationDate: Date
        -status: String
        -queuePosition: int
        +placeReservation(): void
        +cancelReservation(): void
        +markAsReady(): void
        +markAsFulfilled(): void
    }

    class Fine {
        -fineId: String
        -amount: Double
        -status: String
        -createdDate: Date
        -paidDate: Date
        +calculateAmount(): Double
        +markAsPaid(): void
        +waiveFine(): void
    }

    class Notification {
        -notificationId: String
        -message: String
        -type: String
        -status: String
        -createdDate: Date
        +generate(): void
        +deliver(): void
        +markAsRead(): void
        +dismiss(): void
        +archive(): void
    }

    class UserAccount {
        -userId: String
        -email: String
        -passwordHash: String
        -role: String
        -createdDate: Date
        +authenticate(): boolean
        +generateToken(): String
        +deactivate(): void
        +reactivate(): void
    }

    %% Inheritance
    Member --|> UserAccount : extends
    Librarian --|> UserAccount : extends

    %% Associations
    Member "1" --> "0..*" Loan : borrows
    Member "1" --> "0..*" Reservation : places
    Member "1" --> "0..*" Notification : receives

    Librarian "1" --> "0..*" Loan : manages
    Librarian "1" --> "0..*" Book : manages

    %% Composition
    Loan "1" *-- "0..1" Fine : generates

    %% Aggregation
    Book "1" o-- "0..*" Loan : associated with
    Book "1" o-- "0..*" Reservation : associated with

    %% Multiplicity
    Loan "0..*" --> "1" Book : for
    Reservation "0..*" --> "1" Book : for
    Fine "0..1" --> "1" Loan : belongs to
    Notification "0..*" --> "1" Member : belongs to
```

---

## Key Design Decisions

**Inheritance: UserAccount as a base class:**
Both Member and Librarian share common attributes like email, passwordHash, and role. Rather than duplicating these in both classes I created a UserAccount base class that both extend. This keeps the authentication logic in one place and makes it easier to add new user types in the future without changing existing classes.

**Composition: Loan and Fine:**
A Fine cannot exist without a Loan, if the loan is deleted then the fine has no meaning. This makes the relationship a composition rather than a simple association. The Fine is fully owned by the Loan that generated it.

**Aggregation: Book and Loan / Book and Reservation:**
A Book can exist without any active Loans or Reservations. When a loan is closed or a reservation is fulfilled the Book continues to exist independently. This makes these relationships aggregations rather than compositions.

**Separation of Member and Librarian:**
Even though both extend UserAccount, Member and Librarian have distinctly different methods. A Member can search and reserve books while a Librarian can issue loans and manage the catalogue. Keeping them as separate classes enforces the role-based access control I defined in FR-02 and makes the system easier to secure.

**Notification as a standalone class:**
Notifications could have been handled as simple messages, but making Notification a full class allows the system to track the status of each alert, archive them, and link them back to the member they belong to. This supports the state transitions defined in STATE-DIAGRAMS.md.
