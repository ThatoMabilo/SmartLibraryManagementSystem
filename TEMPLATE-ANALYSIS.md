# TEMPLATE-ANALYSIS.md — Smart Library Management System

---

## GitHub Project Template Analysis

Before deciding how to set up the project board I spent some time looking at the different templates GitHub offers. I wanted to make sure I was choosing something that actually suited the way this project is being built rather than just picking the default. Below is a comparison of the three templates I looked at.

---

## Template Comparison Table

| Feature                   | Basic Kanban                                                                                  | Automated Kanban                                                                                                                        | Bug Triage                                                                                                              | Team Planning                                                                                                |
| ------------------------- | --------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| **Columns and Workflow**  | To Do, In Progress, Done. Simple linear flow with no automation                               | To Do, In Progress, Done. Same structure but cards move automatically based on the issue status                                         | Needs Triage, High Priority, Low Priority, Closed. Workflow is focused on sorting and resolving bugs                    | Backlog, Ready, In Progress, In Review, Done. Designed for team-based sprint planning with more stages       |
| **Automation Features**   | None. All cards must be moved manually by the user                                            | Issues auto-move to In Progress when opened and to Done when closed                                                                     | New issues are automatically labelled for triage; resolved bugs auto-close                                              | No automation. Designed for manual team coordination and planning discussions                                |
| **Suitability for Agile** | Suitable for basic Agile workflows but requires discipline to keep the board updated manually | Well suited for Agile. Automation keeps the board accurate without any extra effort, supporting continuous delivery and sprint tracking | Not well suited for Agile feature development. Focused on bug management rather than iterative delivery of user stories | Suitable for Agile teams but assumes multiple people are involved in planning, reviewing, and approving work |

---

## Chosen Template: Automated Kanban

I went with the Automated Kanban template and the main reason is the automation. Since I am working alone, having cards move on their own when issues are opened or closed means I do not have to remember to update the board manually. With the Basic Kanban I would have to drag every card myself, which is the kind of thing that is easy to forget when you are focused on actually writing code. A board that is out of date is not useful to anyone.

The column structure also fits naturally with how I planned the sprint in SPRINT-PLAN.md. Tasks start in To Do, move to In Progress when I start working on them, and end up in Done when they are complete. That flow matches exactly what I already have documented, which makes it easier to track progress without having to translate between two different systems.

Having the board linked to GitHub Issues was another reason I went with this template. All 14 user stories from Assignment 6 are already set up as issues, so they connect to the board automatically without any extra work. That keeps everything in one place and makes it easy to trace any task back to the requirement it came from.

I also liked that this template is easy to extend. I added a Testing column and a Blocked column to reflect how I actually plan to work through features, and that was straightforward to do. The Bug Triage template would have needed a lot of restructuring to work for feature development, and the Team Planning template is built around having a team which basically does not apply to this project.
