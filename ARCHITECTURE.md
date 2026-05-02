# ARCHITECTURE.md — Smart Library Management System

---

## 1. Project Title

**Smart Library Management System**

---

## 2. Domain

This system falls within the domain of Library and Information Services. This domain involves the organisation, storage, and lending of physical and digital resources to registered members. It is governed by borrowing rules, membership policies, and fine structures that vary between institutions but follow a consistent pattern.

---

## 3. Problem Statement

Many libraries continue to use outdated systems that members are unable to utilise outside of the library. This system aims to address this issue by providing a centralised web platform from which members can search and reserve books, as well as librarians can handle loans and fines...all through a browser. The architecture is intended to be simple, quick to deploy, and simple to manage.

---

## 4. Individual Scope & Feasibility Justification

Considering I am working on this individually over one semester, I made the architecture as minimal as possible. The system consists of three major components: a React frontend, a Spring Boot backend, and a MySQL database, all of which I am familiar with and can realistically build and deploy on my own within the time frame I have.

---

## 5. C4 Architectural Diagrams

To describe the architecture of this system, I used the C4 model, which allowed me to break it down into four layers, starting with who uses the system and gradually zooming in to show how each component is designed and where it runs.

| Level                    | Description                                                        |
| ------------------------ | ------------------------------------------------------------------ |
| **Level 1 – Context**    | Shows how the system fits into the world and who interacts with it |
| **Level 2 – Container**  | Shows the high-level technical building blocks of the system       |
| **Level 3 – Component**  | Zooms into a specific container to show its internal components    |
| **Level 4 – Deployment** | Shows how and where the system is hosted                           |

---

## 6. Level 1 — System Context Diagram

```mermaid
graph TD
    Member["Library Member\nSearches catalogue,\nborrows and reserves books,\nviews fines on their profile"]
    Librarian["Librarian\nManages books, loans,\nreturns, and member fines"]
    Admin["System Administrator\nManages user accounts\nand views system summary"]

    SLMS["Smart Library\nManagement System\n(Web Application)\nCentral platform for all\nlibrary operations"]

    DB["MySQL Database\nPersistent storage for all\nlibrary data"]

    Member -->|"Searches, reserves,\nviews borrowing history"| SLMS
    Librarian -->|"Issues loans, manages\ncatalogue and fines"| SLMS
    Admin -->|"Views summary,\nmanages users"| SLMS
    SLMS -->|"Reads and writes\nall library data"| DB
```

---

## 7. Level 2 — Container Diagram

```mermaid
graph TD
    Member["Library Member"]
    Librarian["Librarian"]
    Admin["System Administrator"]

    subgraph SLMS["Smart Library Management System"]
        WebApp["Web Frontend\n(React.js)\nSingle Page Application\nRuns in the user's browser"]
        API["Backend API\n(Java + Spring Boot)\nRESTful API server\nHandles all business logic\nPort: 8080"]
        DB["MySQL Database\nStores: users, books,\nloans, reservations, fines\nPort: 3306"]
    end

    Member -->|"HTTPS"| WebApp
    Librarian -->|"HTTPS"| WebApp
    Admin -->|"HTTPS"| WebApp
    WebApp -->|"REST API calls\nJSON over HTTP"| API
    API -->|"SQL queries\nvia Spring Data JPA"| DB
```

---

## 8. Level 3 — Component Diagram (Backend API)

```mermaid
graph TD
    WebApp["Web Frontend\n(React.js)"]

    subgraph API["Backend API — Java + Spring Boot"]
        AuthController["Auth Controller\nHandles registration,\nlogin, and JWT issuance"]
        BookController["Book Controller\nCRUD operations for\nthe book catalogue\nand availability logic"]
        LoanController["Loan Controller\nIssues loans, processes\nreturns, and tracks\nborrowing history"]
        ReservationController["Reservation Controller\nManages reservation\nqueue per book"]
        FineController["Fine Controller\nCalculates overdue fines,\ndisplays balance,\nmarks fines as paid"]
        AdminController["Admin Controller\nReturns summary counts\nfor the dashboard page"]
        Middleware["JWT Auth Filter\nVerifies tokens and\nenforces role-based\naccess on all routes"]
    end

    DB["MySQL Database"]

    WebApp -->|"All requests\npass through"| Middleware
    Middleware --> AuthController
    Middleware --> BookController
    Middleware --> LoanController
    Middleware --> ReservationController
    Middleware --> FineController
    Middleware --> AdminController

    AuthController -->|"SQL via JPA"| DB
    BookController -->|"SQL via JPA"| DB
    LoanController -->|"SQL via JPA"| DB
    ReservationController -->|"SQL via JPA"| DB
    FineController -->|"SQL via JPA"| DB
    AdminController -->|"SQL via JPA"| DB
```

---

## 9. Level 3 — Component Diagram (Frontend Web App)

```mermaid
graph TD
    Browser["User's Browser"]

    subgraph Frontend["Web Frontend — React.js"]
        Router["React Router\nManages page navigation\nand protected routes"]
        AuthContext["Auth Context\nStores JWT token and\ncurrent user session state"]

        subgraph Pages["Pages"]
            LoginPage["Login / Register\nPage"]
            CataloguePage["Book Catalogue\nSearch Page"]
            MyLoansPage["My Loans &\nReservations Page"]
            MyProfilePage["My Profile &\nFines Page"]
            AdminPage["Admin Summary\nPage"]
        end

        subgraph Components["Reusable Components"]
            BookCard["BookCard\nDisplays book info\nand availability"]
            LoanTable["LoanTable\nLists active and\npast loans"]
            FineDisplay["FineDisplay\nShows outstanding\nfine balance"]
            SummaryCard["SummaryCard\nAdmin count widgets"]
        end

        APIClient["API Client\n(Axios)\nCentralised HTTP client\nattaches JWT to requests"]
    end

    BackendAPI["Backend API\n(Java Spring Boot)"]

    Browser --> Router
    Router --> AuthContext
    Router --> LoginPage
    Router --> CataloguePage
    Router --> MyLoansPage
    Router --> MyProfilePage
    Router --> AdminPage

    CataloguePage --> BookCard
    MyLoansPage --> LoanTable
    MyProfilePage --> FineDisplay
    AdminPage --> SummaryCard

    LoginPage --> APIClient
    CataloguePage --> APIClient
    MyLoansPage --> APIClient
    MyProfilePage --> APIClient
    AdminPage --> APIClient

    APIClient -->|"REST over HTTPS"| BackendAPI
```

---

## 10. Level 4 — Deployment Diagram

```mermaid
graph TD
    subgraph UserDevice["User's Device"]
        Browser["Any Web Browser\nAccesses the app via\na public Railway URL"]
    end

    subgraph Railway["Railway.app (Free Hosting)"]
        FrontendService["Frontend Service\nReact.js app\nAuto-deployed from GitHub\nPublic URL provided by Railway"]
        BackendService["Backend Service\nJava Spring Boot JAR\nAuto-deployed from GitHub\nPort: 8080"]
        DBService["MySQL Service\nRailway-managed MySQL\nInternal connection only\nPersistent data storage"]
    end

    Browser -->|"HTTPS"| FrontendService
    FrontendService -->|"Internal HTTP\nPort 8080"| BackendService
    BackendService -->|"Internal MySQL\nPort 3306"| DBService
```

---

## 11. End-to-End Data Flow

```mermaid
sequenceDiagram
    actor Member
    participant Frontend as React Frontend
    participant API as Spring Boot API
    participant DB as MySQL Database

    Member->>Frontend: Search for a book
    Frontend->>API: GET /api/books?query=...
    API->>DB: SELECT * FROM books WHERE title LIKE ...
    DB-->>API: Matching book records
    API-->>Frontend: JSON list of books
    Frontend-->>Member: Displays search results

    Member->>Frontend: Reserve an unavailable book
    Frontend->>API: POST /api/reservations
    API->>DB: INSERT INTO reservations
    DB-->>API: Reservation saved
    API-->>Frontend: Success response
    Frontend-->>Member: "Reservation placed!"

    Member->>Frontend: View my profile and fines
    Frontend->>API: GET /api/fines/me
    API->>DB: SELECT loans WHERE due_date < NOW() AND member_id = ?
    DB-->>API: Overdue loan records
    API-->>Frontend: Calculated fine amount
    Frontend-->>Member: Displays outstanding fine balance
```

---

## 12. Key Architectural Decisions

| Decision             | Choice                      | Justification                                                                                                  |
| -------------------- | --------------------------- | -------------------------------------------------------------------------------------------------------------- |
| Frontend framework   | React.js                    | I chose React because I am already familiar with it and it works well for building single page applications    |
| Backend framework    | Java + Spring Boot          | Java is the language I am most comfortable with and Spring Boot makes it straightforward to build REST APIs    |
| Database             | MySQL                       | I chose MySQL because it fits well with the relational nature of library data and is easy to set up on Railway |
| Authentication       | JWT (JSON Web Tokens)       | JWT allows me to protect API routes and manage user roles without storing session data on the server           |
| Deployment           | Railway.app                 | Railway lets me deploy directly from GitHub without needing to configure servers or use Docker                 |
| Architecture pattern | MVC (Model-View-Controller) | MVC keeps my code organised by separating the data, business logic, and presentation layers clearly            |
