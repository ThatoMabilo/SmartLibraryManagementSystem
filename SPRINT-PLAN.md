# SPRINT-PLAN.md — Smart Library Management System

---

## Sprint 1 Plan

---

## Sprint Goal

Implement core authentication and book catalogue management functionality.

---

## Sprint Duration

2 weeks

---

## Selected User Stories

The following stories were selected from the Must-have items in the product backlog. They represent the foundational layer of the system and must be completed before any other feature can be built.

| Story ID | User Story                                                                                                            | Effort (Story Points) |
| -------- | --------------------------------------------------------------------------------------------------------------------- | --------------------- |
| US-001   | As a new member, I want to register an account so that I can access the library system                                | 2                     |
| US-002   | As a library member, I want to log in with my email and password so that I can access my account and library features | 3                     |
| US-003   | As a library member, I want to search for books by title, author, or genre so that I can find what I need             | 3                     |
| US-004   | As a librarian, I want to add, edit, and delete books from the catalogue so that the catalogue stays accurate         | 3                     |
| US-014   | As a system administrator, I want all passwords to be stored securely so that member data is protected                | 1                     |

**Total Story Points: 12**

---

## Sprint Backlog

| Task ID | Task Description                                                                               | Assigned To | Estimated Hours | Status |
| ------- | ---------------------------------------------------------------------------------------------- | ----------- | --------------- | ------ |
| T-001   | Set up Spring Boot project structure with MVC architecture                                     | Dev Team    | 3               | To Do  |
| T-002   | Create MySQL database schema - users, books, loans, reservations, fines tables                 | Dev Team    | 3               | To Do  |
| T-003   | Implement BCrypt password hashing on registration                                              | Dev Team    | 2               | To Do  |
| T-004   | Develop user registration API endpoint (POST /api/auth/register)                               | Dev Team    | 3               | To Do  |
| T-005   | Develop login API endpoint with JWT token generation (POST /api/auth/login)                    | Dev Team    | 4               | To Do  |
| T-006   | Implement JWT auth filter and role-based access control middleware                             | Dev Team    | 4               | To Do  |
| T-007   | Develop book search API endpoint with title, author, and genre filters (GET /api/books)        | Dev Team    | 4               | To Do  |
| T-008   | Develop book catalogue CRUD API endpoints (POST, PUT, DELETE /api/books)                       | Dev Team    | 5               | To Do  |
| T-009   | Build React registration and login pages with form validation                                  | Dev Team    | 4               | To Do  |
| T-010   | Build React book catalogue search page with results display                                    | Dev Team    | 4               | To Do  |
| T-011   | Build React librarian catalogue management page                                                | Dev Team    | 4               | To Do  |
| T-012   | Connect React frontend to Spring Boot API using Axios                                          | Dev Team    | 3               | To Do  |
| T-013   | Write and execute test cases TC-001, TC-002, TC-003, TC-004, TC-005, TC-006 from TEST-CASES.md | Dev Team    | 3               | To Do  |

**Total Estimated Hours: 46**

---

## How This Sprint Contributes to the MVP

The MVP for this system is something simple. A member can register, log in, and search for books, and a librarian can manage the catalogue. That is what Sprint 1 is focused on delivering. By the end of it the system should have working authentication, a searchable catalogue, and a secure backend. Without these pieces in place nothing else in the backlog can be built or tested.
