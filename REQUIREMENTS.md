# REQUIREMENTS.md — Smart Library Management System

---

## System Requirements Document

This document outlines what the Smart Library Management System needs to be able to do and how well it needs to do it. Every requirement listed here ties back to a concern raised by one of the stakeholders identified in STAKEHOLDERS.md.

---

## Stakeholder Traceability Summary

This table below shows which functional requirements address each stakeholder's concerns, making it easy to trace every requirement back to a real need.

| Stakeholder               | Functional Requirements                         |
| ------------------------- | ----------------------------------------------- |
| Library Member (Student)  | FR-01, FR-03, FR-05, FR-06, FR-07, FR-08, FR-09 |
| Librarian                 | FR-02, FR-04, FR-05, FR-06, FR-09, FR-10        |
| System Administrator      | FR-02, FR-10, FR-11                             |
| Library Manager           | FR-04, FR-10                                    |
| University Academic Staff | FR-03, FR-07, FR-08, FR-12                      |
| New Library Member        | FR-01                                           |
| IT Support Staff          | NFR-03, NFR-04, NFR-05, NFR-06                  |

---

## Section 1: Functional Requirements

Below are the functional requirements the system needs to meet in order to be useful. Each one includes an acceptance criterion so that there is a clear and measurable way to know whether the requirement has been met or not.

---

### FR-01: User Registration

**Statement:** The system shall allow new users to register by providing their full name, email address, and password.

**Stakeholder:** New Library Member, Library Member

**Acceptance Criteria:** A new user can complete registration in under 2 minutes and immediately log in using their credentials. Duplicate email addresses shall be rejected with a clear error message.

---

### FR-02: Role-Based Login

**Statement:** The system shall allow users to log in and be granted access based on their assigned role — Member or Librarian.

**Stakeholder:** Library Member, Librarian, System Administrator

**Acceptance Criteria:** A Member logging in shall only see Member features. A Librarian logging in shall have access to catalogue management and loan processing. Attempting to access a restricted route without the correct role shall return an unauthorised error.

---

### FR-03: Book Search

**Statement:** The system shall allow Members and Librarians to search the book catalogue by title, author, or genre.

**Stakeholder:** Library Member, University Academic Staff

**Acceptance Criteria:** Search results shall display within 3 seconds and include the book title, author, genre, and real-time availability status. Searches with no results shall display a clear "no results found" message.

---

### FR-04: Book Catalogue Management

**Statement:** The system shall allow Librarians to add, edit, and delete books from the catalogue.

**Stakeholder:** Librarian, Library Manager

**Acceptance Criteria:** A Librarian can add a new book with title, author, ISBN, genre, year, and number of copies. Edited details shall be reflected immediately. Deleted books shall be removed from search results instantly.

---

### FR-05: Issue a Book Loan

**Statement:** The system shall allow a Librarian to issue a book loan to a registered Member.

**Stakeholder:** Librarian, Library Member

**Acceptance Criteria:** The system shall reduce the available copy count by one upon issuing a loan. A due date of 14 days from the issue date shall be automatically assigned. The loan shall appear in the Member's borrowing history immediately.

---

### FR-06: Process a Book Return

**Statement:** The system shall allow a Librarian to process the return of a borrowed book.

**Stakeholder:** Librarian, Library Member

**Acceptance Criteria:** Upon return, the available copy count shall increase by one. If the return date is past the due date, the system shall automatically calculate and display the overdue fine. The loan record shall be marked as returned.

---

### FR-07: Book Reservation

**Statement:** The system shall allow a Member to place a reservation on a book that is currently on loan.

**Stakeholder:** Library Member, University Academic Staff

**Acceptance Criteria:** A Member can only reserve a book that has zero available copies. Reservations shall be stored in the order they were placed. A Member shall not be able to reserve the same book twice at the same time.

---

### FR-08: View Borrowing History

**Statement:** The system shall allow Members to view a list of all their past and current loans.

**Stakeholder:** Library Member, University Academic Staff

**Acceptance Criteria:** The borrowing history page shall display the book title, issue date, due date, return date, and loan status for each record. The most recent loans shall appear at the top.

---

### FR-09: Fine Calculation and Display

**Statement:** The system shall automatically calculate overdue fines at a rate of R2.00 per day past the due date and display the outstanding balance on the Member's profile.

**Stakeholder:** Library Member, Librarian

**Acceptance Criteria:** The fine amount shall update daily based on the number of days overdue. The Member's profile page shall always show the current outstanding fine balance. A Librarian shall be able to mark a fine as paid after receiving payment.

---

### FR-10: Admin Summary Dashboard

**Statement:** The system shall provide an admin summary page displaying the total number of registered members, books in the catalogue, active loans, and overdue loans.

**Stakeholder:** Library Manager, System Administrator

**Acceptance Criteria:** All counts on the summary page shall reflect the current state of the database in real time. The page shall be accessible to Librarians and Administrators only.

---

### FR-11: User Account Management

**Statement:** The system shall allow a System Administrator to create, update, and deactivate user accounts.

**Stakeholder:** System Administrator

**Acceptance Criteria:** A deactivated account shall not be able to log in. Account changes shall take effect immediately without requiring a system restart.

---

### FR-12: View Active Reservations

**Statement:** The system shall allow a Member to view all their current reservations and their position in the reservation queue.

**Stakeholder:** Library Member, University Academic Staff

**Acceptance Criteria:** The reservations page shall display the book title, date reserved, and current queue position for each active reservation. Fulfilled reservations shall be clearly marked.

---

## Section 2: Non-Functional Requirements

The following requirements define the quality standards the system must meet. Unlike functional requirements which focus on what the system does, these focus on how well it does it, covering areas such as security, performance, maintainability, and deployability.

---

### Usability

**NFR-01:**
The interface shall be simple and easy to navigate for both Members and Librarians on a desktop browser without requiring any training or user manual.

Measurable Criterion: A first-time user shall be able to register and complete a book search within 5 minutes of visiting the platform.

---

**NFR-02:**
All error messages displayed by the system shall be written in plain, non-technical language so that any user can understand what went wrong and what to do next.

Measurable Criterion: No error message shall contain HTTP status codes or stack trace information visible to the end user.

---

### Deployability

**NFR-03:**
The system shall be deployable on Railway.app directly from the GitHub repository without requiring manual server configuration.

Measurable Criterion: A fresh deployment from GitHub to a live Railway.app URL shall be completable within 30 minutes by a developer familiar with the codebase.

---

**NFR-04:**
The system shall use environment variables for all sensitive configuration such as database credentials and JWT secret keys, so that it can be deployed across different environments without code changes.

Measurable Criterion: Switching between a local development environment and the Railway.app production environment shall require only environment variable changes and no code modifications.

---

### Maintainability

**NFR-05:**
The backend code shall follow the MVC (Model-View-Controller) architecture pattern so that the data, business logic, and API layers are clearly separated and easy to update independently.

Measurable Criterion: A new developer should be able to locate the correct file to modify for any given feature within 10 minutes of reviewing the project structure.

---

**NFR-06:**
The codebase shall include inline comments on all non-obvious methods and a README that explains how to set up and run the project locally.

Measurable Criterion: A developer with Java and Spring Boot experience shall be able to run the project locally within 20 minutes using only the README instructions.

---

### Scalability

**NFR-07:**
The system shall support up to 1,000 registered members accessing the platform concurrently without noticeable degradation in response times.

Measurable Criterion: Under a simulated load of 1,000 concurrent users, API response times shall remain under 3 seconds for all standard operations.

---

### Security

**NFR-08:**
All user passwords shall be hashed using BCrypt before being stored in the database. Plain text passwords shall never be stored or logged.

Measurable Criterion: A direct inspection of the database shall show only hashed password values with no plain text entries.

---

**NFR-09:**
All API routes except registration and login shall be protected by JWT authentication. Requests without a valid token shall receive a 401 Unauthorised response.

Measurable Criterion: Sending a request to any protected endpoint without a valid JWT token shall always return a 401 status code regardless of the request content.

---

### Performance

**NFR-10:**
Book search queries shall return results within 3 seconds under normal operating conditions.

Measurable Criterion: A search query against a catalogue of up to 10,000 books shall return results in under 3 seconds on the Railway.app hosted environment.

---

**NFR-11:**
The admin summary dashboard shall load and display all counts within 3 seconds of the page being opened.

Measurable Criterion: The dashboard page shall fully render within 3 seconds when accessed by a user with a stable internet connection.
