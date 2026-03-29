# USE-CASE-SPECIFICATIONS.md — Smart Library Management System

---

## Use Case Specifications

Below are the detailed specifications for the 8 use cases I considered most critical to the system. Each specification describes the purpose, conditions, and step-by-step flow of the use case including alternative paths where things can go wrong.

---

### UC-01: Register Account

**Actor:** New Member

**Description:** Allows a new user to create an account on the system so they can access library services.

**Precondition:** The user has not previously registered and is not logged in.

**Postcondition:** A new member account is created and stored in the database. The user can immediately log in with their credentials.

**Basic Flow:**

1. User navigates to the registration page
2. User enters their full name, email address, and password
3. User submits the registration form
4. System validates that all fields are filled in and the email is not already registered
5. System hashes the password using BCrypt and saves the account to the database
6. System redirects the user to the login page with a success message

**Alternative Flows:**

A1 — Email already registered:

- At step 4, if the email address already exists in the database the system displays an error message telling the user the email is already in use and prompts them to log in instead

A2 — Missing fields:

- At step 4, if any required field is empty the system highlights the missing fields and asks the user to complete them before submitting

---

### UC-02: Login

**Actor:** Library Member, Librarian, System Administrator, Library Manager, Academic Staff

**Description:** Allows a registered user to log in to the system and access features based on their assigned role.

**Precondition:** The user has a registered account and is not currently logged in.

**Postcondition:** The user is authenticated and redirected to their role-appropriate dashboard. A JWT token is issued and stored for the session.

**Basic Flow:**

1. User navigates to the login page
2. User enters their email address and password
3. User submits the login form
4. System validates the credentials against the database
5. System generates a JWT token containing the user's role
6. User is redirected to their dashboard based on their role

**Alternative Flows:**

A1 — Incorrect credentials:

- At step 4, if the email or password is incorrect the system displays a generic error message saying the credentials are invalid without specifying which field is wrong

A2 — Deactivated account:

- At step 4, if the account has been deactivated by an administrator the system displays a message informing the user that their account is inactive and to contact the library

---

### UC-03: Search Books

**Actor:** Library Member, Academic Staff, Librarian

**Description:** Allows users to search the book catalogue by title, author, or genre and view real-time availability.

**Precondition:** The user is logged in.

**Postcondition:** A list of books matching the search query is displayed along with their availability status.

**Basic Flow:**

1. User navigates to the catalogue search page
2. User enters a search term in the search bar
3. User selects a search filter — title, author, or genre
4. User submits the search
5. System queries the database for matching books
6. System displays the results including book title, author, genre, and number of available copies

**Alternative Flows:**

A1 — No results found:

- At step 6, if no books match the search query the system displays a clear message saying no results were found and suggests the user try a different search term

A2 — Empty search:

- At step 4, if the search field is empty the system displays all books in the catalogue

---

### UC-04: Reserve Book

**Actor:** Library Member, Academic Staff

**Description:** Allows a member to place a reservation on a book that currently has no available copies.

**Precondition:** The user is logged in and the book they want to reserve has zero available copies.

**Postcondition:** A reservation record is created for the member and added to the reservation queue for that book.

**Basic Flow:**

1. User searches for a book using UC-03
2. User selects a book that shows as unavailable
3. User clicks the Reserve button
4. System checks that the book has no available copies
5. System checks that the member does not already have an active reservation for the same book
6. System creates a reservation record and adds it to the queue
7. System displays a confirmation message showing the member's position in the queue

**Alternative Flows:**

A1 — Book becomes available:

- At step 4, if the book has available copies the system informs the user the book is available and prompts them to ask a librarian to issue a loan instead

A2 — Duplicate reservation:

- At step 5, if the member already has an active reservation for the same book the system displays a message saying they are already in the queue

---

### UC-05: Issue Book Loan

**Actor:** Librarian

**Description:** Allows a librarian to issue a book loan to a registered member, reducing the available copy count and setting a due date.

**Precondition:** The librarian is logged in, the book has at least one available copy, and the member has no account restrictions.

**Postcondition:** A loan record is created, the available copy count is reduced by one, and the due date is set to 14 days from the issue date.

**Basic Flow:**

1. Librarian navigates to the issue loan page
2. Librarian searches for the member by name or email
3. Librarian searches for the book by title or ISBN
4. System confirms the book has available copies
5. Librarian confirms the loan
6. System creates a loan record with the issue date and due date
7. System reduces the available copy count by one
8. The loan appears immediately in the member's borrowing history

**Alternative Flows:**

A1 — No available copies:

- At step 4, if the book has no available copies the system informs the librarian and suggests checking the reservation queue

A2 — Member not found:

- At step 2, if no member matches the search the system displays a message saying the member was not found and suggests registering them first

---

### UC-06: Process Book Return

**Actor:** Librarian

**Description:** Allows a librarian to process the return of a borrowed book, updating availability and calculating any overdue fines.

**Precondition:** The librarian is logged in and an active loan exists for the book being returned.

**Postcondition:** The loan is marked as returned, the available copy count increases by one, and any overdue fine is calculated and added to the member's profile.

**Basic Flow:**

1. Librarian navigates to the active loans page
2. Librarian searches for the loan by member name or book title
3. Librarian selects the relevant loan record
4. System checks whether the return date is past the due date
5. Librarian confirms the return
6. System marks the loan as returned
7. System increases the available copy count by one
8. If overdue, system calculates the fine at R2.00 per day and adds it to the member's balance

**Alternative Flows:**

A1 — Loan not found:

- At step 2, if no matching loan is found the system displays a message saying no active loan was found for the given details

A2 — No fine applicable:

- At step 4, if the book is returned on or before the due date no fine is calculated and the return is processed normally

---

### UC-07: Manage Book Catalogue

**Actor:** Librarian

**Description:** Allows a librarian to add new books, edit existing book details, and delete books from the catalogue.

**Precondition:** The librarian is logged in.

**Postcondition:** The catalogue is updated and the changes are immediately reflected in search results.

**Basic Flow:**

1. Librarian navigates to the catalogue management page
2. Librarian selects whether to add, edit, or delete a book
3. For adding: Librarian enters the book title, author, ISBN, genre, year, and number of copies and submits
4. For editing: Librarian searches for the book, updates the relevant fields, and saves
5. For deleting: Librarian searches for the book and confirms the deletion
6. System saves the changes to the database
7. Changes are immediately visible in the catalogue search

**Alternative Flows:**

A1 — Duplicate ISBN on add:

- At step 3, if the ISBN already exists in the catalogue the system displays an error saying the book already exists and suggests editing the existing record instead

A2 — Book has active loans on delete:

- At step 5, if the book being deleted has active loans the system warns the librarian and prevents deletion until all copies are returned

---

### UC-08: View Admin Summary

**Actor:** Librarian, System Administrator, Library Manager

**Description:** Allows authorised users to view a summary dashboard showing key library statistics including total members, books, active loans, and overdue loans.

**Precondition:** The user is logged in with a Librarian, Administrator, or Manager role.

**Postcondition:** The summary dashboard is displayed with up to date counts pulled directly from the database.

**Basic Flow:**

1. User navigates to the admin summary page
2. System queries the database for the total number of registered members
3. System queries the database for the total number of books in the catalogue
4. System queries the database for the number of currently active loans
5. System queries the database for the number of overdue loans
6. System displays all counts on the summary page

**Alternative Flows:**

A1 — Unauthorised access:

- If a Member attempts to access the admin summary page directly via the URL the system returns an unauthorised error and redirects them to their own dashboard
