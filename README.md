# Smart Library Management System

## Overview

The Smart Library Management System is a web application I'm developing to assist libraries manage their daily operations more efficiently. The concept started from noticing how frustrating it may be to visit a library only to discover that the book you need is already borrowed, with no convenient method to find out or reserve it ahead of time. This system will allow members to search for books and make reservations, while librarians handle loans, returns, and penalties using a simple web interface. The project will be constructed in phases during the semester, starting with the core foundation and gradually adding functionality until a fully functional system is delivered.

---

## Key Features

- **User Authentication** — Secure login and registration for Members and Librarians
- **Book Catalogue** — Search, browse, add, edit, and remove books
- **Borrow & Return** — Librarians can issue and process book loans
- **Reservations** — Members can reserve books that are currently borrowed
- **Fine Calculation** — Overdue fines are automatically calculated and displayed on screen
- **Admin Summary** — Simple dashboard showing total books, active loans, and members

---

## Project Documentation

| Document                                                   | Description                                                                                                                     |
| ---------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| [SPECIFICATION.md](./SPECIFICATION.md)                     | Full system specification including domain, problem statement, scope, functional and non-functional requirements, and use cases |
| [ARCHITECTURE.md](./ARCHITECTURE.md)                       | C4 architectural diagrams covering Context, Container, Component, and Deployment views                                          |
| [STAKEHOLDERS.md](./STAKEHOLDERS.md)                       | Stakeholder analysis including roles, concerns, pain points, and success metrics                                                |
| [REQUIREMENTS.md](./REQUIREMENTS.md)                       | Full System Requirements Document with functional and non-functional requirements                                               |
| [USE-CASE-DIAGRAM.md](./USE-CASE-DIAGRAM.md)               | UML use case diagram with written explanation of actors and relationships                                                       |
| [USE-CASE-SPECIFICATIONS.md](./USE-CASE-SPECIFICATIONS.md) | Detailed specifications for 8 critical use cases                                                                                |
| [TEST-CASES.md](./TEST-CASES.md)                           | Functional and non-functional test cases traceable to requirements                                                              |
| [USER-STORIES.md](./USER-STORIES.md)                       | User stories derived from functional requirements and use cases                                                                 |
| [PRODUCT-BACKLOG.md](./PRODUCT-BACKLOG.md)                 | Prioritized product backlog using MoSCoW with effort estimates                                                                  |
| [SPRINT-PLAN.md](./SPRINT-PLAN.md)                         | Sprint 1 plan including sprint goal, selected stories, and task breakdown                                                       |
| [TEMPLATE-ANALYSIS.md](./TEMPLATE-ANALYSIS.md)             | Comparison of GitHub project templates and justification for chosen template                                                    |
| [KANBAN-EXPLANATION.md](./KANBAN-EXPLANATION.md)           | Definition and explanation of the Kanban board, WIP limits, and Agile alignment                                                 |
| [STATE-DIAGRAMS.md](./STATE-DIAGRAMS.md)                   | State transition diagrams for 8 key system objects                                                                              |
| [ACTIVITY-DIAGRAMS.md](./ACTIVITY-DIAGRAMS.md)             | Activity diagrams for 8 key system workflows                                                                                    |
| [REFLECTION.md](./REFLECTION.md)                           | Reflection on challenges in state and activity modeling                                                                         |

---

## Kanban Board Customisation

The project board for this system is based on the Automated Kanban template and has been customised with two additional columns to better reflect the actual development workflow:

| Column  | Purpose                                                                                                    |
| ------- | ---------------------------------------------------------------------------------------------------------- |
| Testing | For features that have been built and are being validated against the acceptance criteria in TEST-CASES.md |
| Blocked | For work that cannot move forward until a dependency or issue is resolved                                  |

The full explanation of the board including WIP limits and Agile alignment can be found in [KANBAN-EXPLANATION.md](./KANBAN-EXPLANATION.md).

---

## Technology Stack

| Layer    | Technology            |
| -------- | --------------------- |
| Frontend | React.js              |
| Backend  | Java + Spring Boot    |
| Database | MySQL                 |
| Auth     | JWT (JSON Web Tokens) |
| Hosting  | Railway.app           |

---

## Author

Student: Thato Anikie Mabilo
Student number: 222148349
Lecturer: Dr. Boniface Kabaso
Assignment 8: Smart Library Management System
