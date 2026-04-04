# PRODUCT-BACKLOG.md — Smart Library Management System

---

## Product Backlog

Below is the full list of user stories organised by priority. I used MoSCoW to decide what needs to be built first and what can wait, and I used the Fibonacci sequence (1, 2, 3, 5, 8) to estimate how much effort each story requires, where 1 means it is relatively quick and 8 means it will take significant work.

---

## Backlog Table

| Story ID | User Story                                                                                                            | Priority (MoSCoW) | Effort Estimate (Story Points) | Dependencies           |
| -------- | --------------------------------------------------------------------------------------------------------------------- | ----------------- | ------------------------------ | ---------------------- |
| US-001   | As a new member, I want to register an account so that I can access the library system                                | Must-have         | 2                              | None                   |
| US-002   | As a library member, I want to log in with my email and password so that I can access my account and library features | Must-have         | 3                              | US-001                 |
| US-003   | As a library member, I want to search for books by title, author, or genre so that I can find what I need             | Must-have         | 3                              | US-002                 |
| US-004   | As a librarian, I want to add, edit, and delete books from the catalogue so that the catalogue stays accurate         | Must-have         | 3                              | US-002                 |
| US-005   | As a librarian, I want to issue a book loan to a member so that borrowing is recorded and tracked                     | Must-have         | 5                              | US-002, US-004         |
| US-006   | As a librarian, I want to process a book return so that availability is updated and fines are calculated              | Must-have         | 5                              | US-005                 |
| US-013   | As a library member, I want the system to be easy to use without any training                                         | Must-have         | 2                              | US-001, US-002, US-003 |
| US-014   | As a system administrator, I want all passwords to be stored securely so that member data is protected                | Must-have         | 1                              | US-001                 |
| US-007   | As a library member, I want to reserve a book that is currently on loan so that I can secure my place in the queue    | Should-have       | 5                              | US-003, US-005         |
| US-008   | As a library member, I want to view my borrowing history so that I can keep track of books I have borrowed            | Should-have       | 2                              | US-005                 |
| US-009   | As a library member, I want to see my outstanding fine balance on my profile so that I am never caught off guard      | Should-have       | 3                              | US-006                 |
| US-010   | As a library manager, I want to view an admin summary page so that I can quickly see how the library is performing    | Should-have       | 3                              | US-005, US-006         |
| US-011   | As a system administrator, I want to manage user accounts so that I can control who has access to the system          | Could-have        | 2                              | US-002                 |
| US-012   | As a library member, I want to view my active reservations and my position in the queue                               | Could-have        | 2                              | US-007                 |

---

## Prioritization Justification

**Must-have stories (US-001 to US-006, US-013, US-014):**
These stories form the absolute core of the system. If registration, login, book search, catalogue management, and the ability to issue and return loans are not working then the system cannot function at all. US-013 and US-014 are included here because usability and password security are non-negotiable from the start...a system that is hard to use or insecure, fails its most basic stakeholder expectations. These stories directly address the success metrics of the Library Member and Librarian stakeholders identified in STAKEHOLDERS.md.

**Should-have stories (US-007 to US-010):**
These stories add significant value to the system but the core can function without them temporarily. Reservations, borrowing history, fine display, and the admin summary all address real stakeholder concerns but are not needed for a first working version. They will be delivered in the second sprint.

**Could-have stories (US-011 to US-012):**
These stories are useful but have the least impact on the day to day experience of most users. Account management and reservation queue visibility are nice to have and will be tackled once the higher priority work is done.

**Won't-have:**
Automated email notifications and payment gateway integration were deliberately excluded from scope in Assignment 3 and remain out of scope for the backlog.
