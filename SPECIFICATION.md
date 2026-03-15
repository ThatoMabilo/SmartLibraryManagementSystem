# SPECIFICATION.md — Smart Library Management System

---

## 1. Project Title

**Smart Library Management System**

---

## 2. Domain

**Domain: Library and Information Services**

A library is a facility where people may borrow books and other materials, with regulations governing how long items can be kept, what happens if they are returned late, and how members can reserve items that are temporarily unavailable. Libraries serve a diverse population, including students, academic staff, and the general public. With more services moving online, people expect to be able to interact with their library digitally...checking availability, reserving books, and monitoring borrowing history without having to visit the library in person. This system is aimed at academic libraries that seek a simple web-based platform to handle their daily operations.

---

## 3. Problem Statement

While many libraries have implemented library management software, these systems are often legacy platforms that are outdated, difficult to use, and inaccessible from outside the library facility. Members must still visit in person to verify availability, reservation queues are poorly communicated, and borrowing history is hidden in systems only staff have access to. The Smart Library Management System attempts to update this experience by providing a simple, user-friendly web platform where members may explore the library and manage their borrowing from anywhere, while librarians manage loans, returns, and fines from a single interface.

---

## 4. Individual Scope & Feasibility Justification

I chose to focus on the core features that make a library system functional. Features such as book management, borrowing, reservations, and fines. I deliberately left out email notifications and payment processing to keep the project realistic within a single semester. I broke up the system into 6 manageable phases:

| Phase   | Deliverable                                                     |
| ------- | --------------------------------------------------------------- |
| Phase 1 | Project setup, MySQL database schema, user authentication (JWT) |
| Phase 2 | Book catalogue — add, edit, delete, and search books            |
| Phase 3 | Borrowing and return system                                     |
| Phase 4 | Reservation system                                              |
| Phase 5 | Fine calculation and admin summary page                         |
| Phase 6 | Testing, final polish, and deployment to Railway.app            |

---

## 5. Stakeholders

| Stakeholder          | Role                                                               |
| -------------------- | ------------------------------------------------------------------ |
| Library Member       | Searches catalogue, borrows and reserves books, views fines        |
| Librarian            | Manages catalogue, processes loans and returns, views member fines |
| System Administrator | Manages user accounts and views the admin summary page             |

---

## 6. Functional Requirements

### 6.1 User Management

- 1: The system will allow users to register with their name, email, and password
- 2: The system will support two roles: Member and Librarian
- 3: The system will allow users to log in and log out securely using JWT authentication
- 4: The system will restrict access to Librarian features from Member accounts

### 6.2 Book Catalogue

- 5: The system will allow Librarians to add new books to the catalogue
- 6: The system will allow Librarians to edit and delete existing book records
- 7: Each book record will include: title, author, ISBN, genre, year, and number of available copies
- 8: The system will allow Members and Librarians to search books by title, author, or genre
- 9: The system will display the real-time availability status of each book

### 6.3 Borrowing System

- 10: The system will allow a Librarian to issue a book loan to a Member
- 11: The system will set a default loan period of 14 days from the issue date
- 12: The system will allow a Librarian to process a book return and update availability
- 13: The system will maintain a borrowing history record for each Member

### 6.4 Reservation System

- 14: The system will allow a Member to reserve a book that is currently on loan
- 15: The system will maintain reservations in the order they were placed
- 16: The system will mark a reservation as fulfilled when the book is returned and re-issued to the reserving Member

### 6.5 Fine Calculation

- 17: The system will automatically calculate overdue fines at a rate of R2.00 per day past the due date
- 18: The system will display the outstanding fine amount on the Member's profile page
- 19: The system will allow a Librarian to mark a fine as paid after receiving payment in person

### 6.6 Admin Summary

- 20: The system will display the total number of registered members
- 21: The system will display the total number of books in the catalogue
- 22: The system will display the number of currently active loans and overdue loans

---

## 7. Non-Functional Requirements

| ID  | Requirement     | Description                                                                                                         |
| --- | --------------- | ------------------------------------------------------------------------------------------------------------------- |
| 01  | Performance     | Search results should load within 3 seconds so that users are not kept waiting                                      |
| 02  | Security        | Passwords will be hashed using BCrypt and all API routes will be protected using JWT to prevent unauthorised access |
| 03  | Usability       | The interface should be simple and easy to navigate for both members and librarians on a desktop browser            |
| 04  | Scalability     | The system should be able to handle up to 1,000 registered members without slowing down                             |
| 05  | Maintainability | The code will follow the MVC pattern and include comments where necessary to make it easy to understand and update  |

---

## 8. Use Cases

### 01: Member Searches for a Book

**User:** Library Member
**Given:** Member is logged in
**Flow:**

1. Member enters a search term in the catalogue search bar
2. System queries the database and returns matching results
3. Member views book details and availability status
4. If unavailable, Member can place a reservation

### 02: Librarian Issues a Book Loan

**User:** Librarian
**Given:** Librarian is logged in, book is available, Member has no borrowing blocks
**Flow:**

1. Librarian searches for the Member and the book
2. System confirms availability and that the Member has no unpaid fines above the limit
3. Librarian confirms the loan
4. System reduces available copies by one, creates a loan record, and sets the due date

### 03: Librarian Processes a Return

**User:** Librarian
**Given:** Librarian is logged in, active loan exists for the book
**Flow:**

1. Librarian locates the active loan record
2. System calculates any overdue fine if the return date is past the due date
3. Librarian confirms the return
4. System marks the loan as returned and increases available copies by one
5. If a reservation exists for the book, the system flags it for the next Member

---
