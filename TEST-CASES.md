# TEST-CASES.md — Smart Library Management System

---

## Test Cases

Below are the test cases I put together to validate the functional and non-functional requirements of the system. Each test case is traceable to a requirement defined in the REQUIREMENTS.md.

---

## Functional Test Cases

| Test Case ID | Requirement ID | Description                                    | Steps                                                                                                | Expected Result                                                                                       | Actual Result | Status |
| ------------ | -------------- | ---------------------------------------------- | ---------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ------------- | ------ |
| TC-001       | FR-01          | New user registers successfully                | 1. Navigate to registration page. 2. Enter full name, email, and password. 3. Click Register         | Account is created and user is redirected to login page with a success message                        | -             | -      |
| TC-002       | FR-01          | Registration with duplicate email              | 1. Navigate to registration page. 2. Enter an email that already exists. 3. Click Register           | System displays an error message saying the email is already registered                               | -             | -      |
| TC-003       | FR-02          | Member logs in and sees Member dashboard       | 1. Navigate to login page. 2. Enter valid Member credentials. 3. Click Login                         | User is redirected to the Member dashboard. Librarian features are not visible                        | -             | -      |
| TC-004       | FR-02          | Librarian logs in and sees Librarian features  | 1. Navigate to login page. 2. Enter valid Librarian credentials. 3. Click Login                      | User is redirected to the Librarian dashboard with access to catalogue management and loan processing | -             | -      |
| TC-005       | FR-03          | Member searches for a book by title            | 1. Log in as a Member. 2. Navigate to catalogue search. 3. Enter a book title. 4. Click Search       | Results display within 3 seconds showing matching books with availability status                      | -             | -      |
| TC-006       | FR-03          | Search returns no results                      | 1. Log in as a Member. 2. Enter a title that does not exist in the catalogue. 3. Click Search        | System displays a clear message saying no results were found                                          | -             | -      |
| TC-007       | FR-05          | Librarian issues a book loan                   | 1. Log in as Librarian. 2. Search for a member. 3. Search for an available book. 4. Confirm the loan | Loan record is created, available copy count reduces by one, due date is set to 14 days from today    | -             | -      |
| TC-008       | FR-06          | Librarian processes a book return with no fine | 1. Log in as Librarian. 2. Find an active loan that is not overdue. 3. Confirm return                | Loan is marked as returned, available copy count increases by one, no fine is added                   | -             | -      |
| TC-009       | FR-06          | Librarian processes an overdue return          | 1. Log in as Librarian. 2. Find an active loan that is past the due date. 3. Confirm return          | Loan is marked as returned, fine is calculated at R2.00 per overdue day and added to member profile   | -             | -      |
| TC-010       | FR-07          | Member reserves an unavailable book            | 1. Log in as Member. 2. Search for a book with zero available copies. 3. Click Reserve               | Reservation is created and member is shown their position in the queue                                | -             | -      |
| TC-011       | FR-07          | Member attempts to reserve an available book   | 1. Log in as Member. 2. Search for a book with available copies. 3. Click Reserve                    | System informs the member the book is available and a reservation is not needed                       | -             | -      |
| TC-012       | FR-09          | Fine balance displays on member profile        | 1. Log in as Member who has an overdue loan. 2. Navigate to profile page                             | Outstanding fine balance is displayed correctly based on number of days overdue at R2.00 per day      | -             | -      |

---

## Non-Functional Test Cases

### Performance Test

**Requirement:** NFR-10 — Book search queries shall return results within 3 seconds under normal operating conditions.

| Test Case ID | Requirement ID | Description                          | Steps                                                                                                                                  | Expected Result                                                                                     | Actual Result | Status |
| ------------ | -------------- | ------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- | ------------- | ------ |
| TC-NFR-01    | NFR-10         | Search performance under normal load | 1. Log in as a Member. 2. Enter a search term in the catalogue. 3. Record the time from submission to results displaying               | Search results are returned and displayed within 3 seconds                                          | -             | -      |
| TC-NFR-02    | NFR-07         | System performance under high load   | 1. Simulate 1,000 concurrent users sending search requests to the system simultaneously. 2. Record API response times for each request | All API responses are returned within 3 seconds under the simulated load with no errors or timeouts | -             | -      |

---

### Security Test

**Requirement:** NFR-09 — All API routes except registration and login shall be protected by JWT authentication.

| Test Case ID | Requirement ID | Description                                 | Steps                                                                                                                | Expected Result                                                                    | Actual Result | Status |
| ------------ | -------------- | ------------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- | ------------- | ------ |
| TC-NFR-03    | NFR-09         | Accessing a protected route without a token | 1. Send a GET request to a protected endpoint such as /api/books without including a JWT token in the request header | System returns a 401 Unauthorised response and does not return any data            | -             | -      |
| TC-NFR-04    | NFR-08         | Passwords are stored as hashed values       | 1. Register a new user with a known password. 2. Directly inspect the database record for that user                  | The password field contains a BCrypt hash and not the original plain text password | -             | -      |

---
