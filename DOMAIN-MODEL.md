# DOMAIN-MODEL.md — Smart Library Management System

---

## Domain Model

Below I have described the main entities that make up the system, their attributes, responsibilities, relationships, and the business rules that govern how they behave.

---

## Domain Entities

### 1. Member

| Field              | Detail                                                                                                                                                                          |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Attributes**     | memberId, fullName, email, passwordHash, role, fineBalance, accountStatus                                                                                                       |
| **Methods**        | register(), login(), searchBooks(), reserveBook(), viewBorrowingHistory(), viewFines()                                                                                          |
| **Relationships**  | Has many Loans, has many Reservations, has many Notifications                                                                                                                   |
| **Business Rules** | A member cannot borrow a book if their account is Suspended. A member cannot place a duplicate reservation on the same book. A member account must have a unique email address. |

A Member borrows Books through a Loan. A Member reserves Books through a Reservation when no copies are available. A Member receives Notifications when their loan becomes overdue or their reservation becomes ready.

---

### 2. Book

| Field              | Detail                                                                                                                                                    |
| ------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Attributes**     | bookId, title, author, ISBN, genre, yearPublished, totalCopies, availableCopies                                                                           |
| **Methods**        | addToCatalogue(), updateDetails(), removeFromCatalogue(), checkAvailability()                                                                             |
| **Relationships**  | Has many Loans, has many Reservations, belongs to CatalogueEntry                                                                                          |
| **Business Rules** | A book cannot be deleted from the catalogue if it has active loans. Available copies cannot go below zero. A book's ISBN must be unique in the catalogue. |

A Book is borrowed by Members through Loans. A Book can have many Reservations placed against it when all copies are on loan. A Book is managed by a Librarian who can add, update, or remove it from the catalogue.

---

### 3. Loan

| Field              | Detail                                                                                                                                                                                                                                     |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Attributes**     | loanId, issueDate, dueDate, returnDate, status, fineAmount                                                                                                                                                                                 |
| **Methods**        | issueLoan(), processReturn(), calculateFine(), markAsClosed()                                                                                                                                                                              |
| **Relationships**  | Belongs to Member, belongs to Book, associated with Fine                                                                                                                                                                                   |
| **Business Rules** | A loan due date is always set to 14 days from the issue date. A fine of R2.00 per day is calculated automatically when a book is returned after the due date. A loan status can be Active, Overdue, Returned, ReturnedWithFine, or Closed. |

A Loan belongs to one Member and one Book. A Loan generates one Fine if the book is returned after the due date. A Loan is issued and closed by a Librarian.

---

### 4. Reservation

| Field              | Detail                                                                                                                                                                                                        |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Attributes**     | reservationId, reservationDate, status, queuePosition                                                                                                                                                         |
| **Methods**        | placeReservation(), cancelReservation(), markAsReady(), markAsFulfilled()                                                                                                                                     |
| **Relationships**  | Belongs to Member, belongs to Book                                                                                                                                                                            |
| **Business Rules** | A reservation can only be placed if the book has zero available copies. Reservations are processed in first-come-first-served order. A member cannot have more than one active reservation for the same book. |

A Reservation belongs to one Member and one Book. A Reservation is created when a Member wants a Book that is currently on loan and is fulfilled when the Book becomes available and the Loan is issued to that Member.

---

### 5. Fine

| Field              | Detail                                                                                                                                                                                                |
| ------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Attributes**     | fineId, amount, status, createdDate, paidDate                                                                                                                                                         |
| **Methods**        | calculateAmount(), markAsPaid(), waiveFine()                                                                                                                                                          |
| **Relationships**  | Belongs to Loan, belongs to Member                                                                                                                                                                    |
| **Business Rules** | A fine is automatically created when a loan becomes overdue. The fine amount increases by R2.00 for each day the book remains unreturned. A fine can only be marked as paid or waived by a Librarian. |

A Fine belongs to one Loan and is associated with the Member who took out that loan. A Fine cannot exist without the Loan that generated it. A Fine is resolved by a Librarian after the member pays in person.

---

### 6. Librarian

| Field              | Detail                                                                                                                                                                                           |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Attributes**     | librarianId, fullName, email, passwordHash, role                                                                                                                                                 |
| **Methods**        | issueLoan(), processReturn(), manageCatalogue(), markFinePaid(), viewAdminSummary()                                                                                                              |
| **Relationships**  | Manages many Loans, manages many Books, manages many Fines                                                                                                                                       |
| **Business Rules** | A librarian has elevated access compared to a regular member. Only a librarian can issue loans, process returns, and mark fines as paid. A librarian cannot delete a book that has active loans. |

A Librarian manages Books by adding, editing, and removing them from the catalogue. A Librarian issues Loans to Members and processes returns. A Librarian resolves Fines by marking them as paid after receiving payment from the Member.

---

### 7. Notification

| Field              | Detail                                                                                                                                                                              |
| ------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Attributes**     | notificationId, message, type, status, createdDate                                                                                                                                  |
| **Methods**        | generate(), deliver(), markAsRead(), dismiss(), archive()                                                                                                                           |
| **Relationships**  | Belongs to Member, triggered by Loan or Reservation                                                                                                                                 |
| **Business Rules** | A notification is generated automatically when a loan becomes overdue or a reservation becomes Ready. A notification can only be dismissed or archived by the member it belongs to. |

A Notification belongs to one Member and is triggered by either a Loan becoming overdue or a Reservation becoming ready. A Notification is delivered to the Member's profile page and moves through states from Generated to Archived as described in STATE-DIAGRAMS.md.

---

## Entity Relationship Summary

| Relationship                 | Type                        | Description                                                                |
| ---------------------------- | --------------------------- | -------------------------------------------------------------------------- |
| Member borrows Book          | Association via Loan        | A member can have many loans, each loan is for one book                    |
| Member reserves Book         | Association via Reservation | A member can have many reservations, each reservation is for one book      |
| Loan generates Fine          | Composition                 | An overdue loan generates one fine, the fine cannot exist without the loan |
| Member receives Notification | Association                 | A member can receive many notifications                                    |
| Librarian manages Book       | Association                 | A librarian can manage many books in the catalogue                         |
| Librarian manages Loan       | Association                 | A librarian issues and closes loans                                        |
