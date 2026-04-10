# KANBAN-EXPLANATION.md — Smart Library Management System

---

## Kanban Board

A Kanban board is basically a visual way of keeping track of work. You have columns that represent different stages of progress, and each piece of work is a card that moves across those columns as it gets done. The idea is that at any point you can look at the board and immediately know what has not been started yet, what is currently being worked on, and what is finished. It is much easier to get that picture from a board than from a list or a document.

---

## How My Board Visualises Workflow

For this project I set up the board with the following columns:

| Column          | Purpose                                                                                             |
| --------------- | --------------------------------------------------------------------------------------------------- |
| **To Do**       | User stories and tasks that have been identified and are waiting to be started                      |
| **In Progress** | Work that is currently being actively developed                                                     |
| **Testing**     | Features that have been built and are being tested against the acceptance criteria in TEST-CASES.md |
| **Blocked**     | Tasks that cannot move forward due to a dependency or unresolved issue                              |
| **Done**        | Work that has been completed, tested, and meets the acceptance criteria                             |

Every user story from USER-STORIES.md has its own GitHub Issue on the board. As I work through the project the cards move from left to right, so at any point I can see exactly where things stand without having to check multiple documents or try to remember what I have and have not done yet.

---

## Work In Progress (WIP) Limits

One of the rules I tried to stick to with Kanban is not having too many things in progress at the same time. It is very easy to start five tasks and finish none of them, which looks busy but gets nothing done.

For this project I have set the following WIP limits:

| Column      | WIP Limit                                                         |
| ----------- | ----------------------------------------------------------------- |
| In Progress | 3 tasks maximum                                                   |
| Testing     | 2 tasks maximum                                                   |
| Blocked     | Should always be 0, blocked tasks need to be resolved immediately |

Keeping In Progress limited to 3 tasks means I stay focused on completing work before picking up something new. If the In Progress column reaches its limit the next step is to finish one of those tasks before starting another, rather than just adding more cards to the column.

---

## How the Board Supports Agile Principles

**Continuous delivery**
The board encourages me to finish one thing properly before moving on to the next. That way, I am always producing something that actually works rather than having five half-finished features at the same time. This aligns with the Agile principle of delivering working software frequently.

**Adaptability**
If something changes or a new priority comes up, I can reorder the To Do column or add a new card without disrupting whatever is already in progress. This makes it easy to respond to changes without throwing the whole plan off.

**Traceability**
Every card on the board is linked to a GitHub issue, which is in turn linked to a user story and a functional requirement from REQUIREMENTS.md. This means any piece of work on the board can be traced all the way back to a stakeholder need identified in STAKEHOLDERS.md.

**Transparency**
The board gives a real-time view of what is happening at any point. Even though I am working alone, having everything visible in one place makes it easier to stay on track and identify when something is taking longer than expected.

---

## New Columns Justification

**Testing column**
I added a Testing column because jumping straight from In Progress to Done felt dishonest. A feature is not done just because the code is written, it still needs to be checked against the acceptance criteria in TEST-CASES.md. Having a dedicated column for that makes the distinction clear.

**Blocked column**
I added a Blocked column because when you are working alone it is very easy to leave a "stuck task" (lack of a better word) sitting in In Progress and just mentally move on from it. Having a dedicated column for blocked work means it is visible and harder to ignore until it gets resolved.
