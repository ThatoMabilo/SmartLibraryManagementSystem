# STAKEHOLDERS.md — Smart Library Management System

---

## Stakeholder Analysis

Below I have identified the main stakeholders involved in my Smart Library Management System, along with their roles, concerns, pain points, and measurable success metrics.

---

### 1. Library Member (Student)

| Field               | Detail                                                                                                                                                                                                                                                                                     |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Role**            | A student who is registered on the system and uses it to find books, borrow them, reserve ones that are taken, and keep track of what they owe in fines.                                                                                                                                   |
| **Key Concerns**    | They mainly want to know if a book is available before making the trip to the library, be kept in the loop about their reservations, and always know exactly how much they owe in fines so that there are no surprises.                                                                    |
| **Pain Points**     | The most frustrating thing is walking to the library and finding out the book you needed is already borrowed by someone else. On top of that, there is no easy way to keep track of when books are due back, which means fines can quietly build up without the student even realising it. |
| **Success Metrics** | A student should be able to check if a book is available and reserve it without leaving their room. Their fine balance should always be visible on their profile so they are never caught off guard when they try to borrow something.                                                     |

---

### 2. Librarian

| Field               | Detail                                                                                                                                                                                                                                                                                                                             |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | A staff member who works at the library and is responsible for the day to day operations, things like lending books out, processing returns when members bring them back, keeping the catalogue up to date, and recording when fines have been paid.                                                                               |
| **Key Concerns**    | They want to spend less time doing things manually and more time actually helping members. Having a clear view of all current loans and overdue items in one place would make their job a lot easier, and being able to update the catalogue quickly without hassle is something they care about a lot.                            |
| **Pain Points**     | Right now librarians have to manually figure out which books are overdue and calculate fines themselves, which is both time consuming and easy to get wrong. There is also no single place to see all active loans at once, and updating the catalogue is a slow process that often leads to mistakes.                             |
| **Success Metrics** | The librarian should be able to open the system and immediately see all active loans and overdue items without having to dig through records. Fines should calculate on their own without the librarian doing any manual working out, and updating the catalogue should be quick enough that it does not interrupt their workflow. |

---

### 3. System Administrator

| Field               | Detail                                                                                                                                                                                                                                                                                                                                                                                        |
| ------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | Someone on the technical side who makes sure the system is running properly, handles things like creating and managing user accounts, and steps in when something goes wrong with the platform.                                                                                                                                                                                               |
| **Key Concerns**    | They care most about the system actually being up and available when people need it. They also need to be able to control who has access to what, making sure a regular member cannot accidentally or intentionally get into areas of the system that are meant for librarians or admins only.                                                                                                |
| **Pain Points**     | Without a proper admin interface, managing user accounts becomes a messy process done directly in the database which is risky and time consuming. On top of that, if something breaks it is very hard to figure out what went wrong without any logs. Poorly implemented security also means there is nothing stopping someone from accessing parts of the system they should not be able to. |
| **Success Metrics** | The admin should be able to handle everything related to user accounts from one place without having to touch the database directly. The system should also stay up and running throughout the library's operating hours without unexpected crashes or downtime.                                                                                                                              |

---

### 4. Library Manager

| Field               | Detail                                                                                                                                                                                                                                                                                 |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | A senior member of the library staff who does not necessarily handle day to day tasks like issuing loans, but needs a high level view of how the library is operating so they can make informed decisions.                                                                             |
| **Key Concerns**    | They want to be able to see at a glance how the library is being used, things like how many books are out on loan, how many are overdue, and whether staff are keeping up with returns. Without this kind of visibility it is hard to know if things are running smoothly or not.      |
| **Pain Points**     | Currently the only way to get an overview of what is happening in the library is to physically ask staff, which is inefficient and unreliable. There is also no data available to help decide things like which books are being borrowed the most and should have more copies ordered. |
| **Success Metrics** | The manager should be able to open the summary page and immediately see the numbers they care about like how many members are registered, how many books are in the catalogue, how many loans are active, and how many are overdue...all without having to ask anyone.                 |

---

### 5. IT Support Staff

| Field               | Detail                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | Someone on the IT side who is responsible for making sure the environment the system runs on stays healthy, things like keeping the hosting platform running smoothly and making sure the database is being backed up regularly so no data is lost.                                                                                                                                                                        |
| **Key Concerns**    | They need the system to be straightforward to set up and redeploy if something goes wrong, not something that requires hours of configuration every time. The code should also be written and documented clearly enough that they can understand what is going on without having to chase down the original developer, and the database needs to be backed up regularly so that a failure does not mean losing everything. |
| **Pain Points**     | Nothing is more frustrating for IT staff than a system that takes forever to get back up after something goes wrong because the deployment process is unclear or undocumented. Poorly written code with no comments makes debugging a nightmare, especially when the person who wrote it is not around to explain it.                                                                                                      |
| **Success Metrics** | If something goes wrong, IT staff should be able to get the system back up from GitHub to Railway.app within 30 minutes without needing to figure things out from scratch. The code should also be documented well enough that a developer who has never seen the project before can pick it up and understand what is going on without too much struggle.                                                                 |

---

### 6. University Academic Staff (Researcher / Lecturer)

| Field               | Detail                                                                                                                                                                                                                                                                                                                  |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | Lecturers and researchers who borrow books for their work rather than just casual reading. They tend to need multiple books at a time and often need them for longer periods compared to a regular student.                                                                                                             |
| **Key Concerns**    | They want to be able to reserve books ahead of time so they are not caught without the resources they need for their research or lectures. Knowing roughly when a reserved book will become available would also help them plan their work better.                                                                      |
| **Pain Points**     | Popular titles get borrowed quickly and academic staff often find themselves competing with students for the same books. There is also no way for them to check on their reservations without physically going to the library or asking a librarian, which is inconvenient especially when they are busy with teaching. |
| **Success Metrics** | Academic staff should be able to place a reservation and check on it anytime through the website without having to contact the library directly. The current status of all their reservations should always be visible on their profile so they can plan around it.                                                     |

---

### 7. New Library Member (First-Time User)

| Field               | Detail                                                                                                                                                                                                                                                                                                      |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Role**            | Someone who has just signed up and is using the system for the very first time. They should not need anyone to show them how it works, the interface should be clear enough that they can figure it out on their own.                                                                                       |
| **Key Concerns**    | The system should be easy enough to use that a new member can figure it out without anyone helping them or handing them a guide. Signing up should also be quick, if registration asks for too much information upfront, people will give up before they even get started.                                  |
| **Pain Points**     | A confusing interface is a problem because not everyone will have a librarian nearby to help them figure it out. Registration that asks for too many details upfront is also off-putting, most people will abandon the process if it feels like too much effort before they have even used the system once. |
| **Success Metrics** | Someone visiting the platform for the first time should be able to sign up and search for a book within 5 minutes without needing any help. If it takes longer than that, the registration or navigation process is probably too complicated.                                                               |
