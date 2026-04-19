# REFLECTION.md — Smart Library Management System

---

## Reflection: Challenges Faced in Balancing Stakeholder Needs

---

When I started identifying the stakeholders for this system I quickly realised that the same feature can mean very different things depending on who you are asking. What one person sees as essential, another might see as unnecessary complexity. The clearest example of this was the tension between what Members want and what IT Support Staff need. Members naturally want as many features as possible like notifications, real-time updates, and reservation tracking. But the more features you add, the harder the system becomes to maintain and deploy, which is exactly what IT staff are trying to avoid. I decided to leave automated email notifications out of scope entirely. It felt like a big feature to cut at first, but keeping it would have added significant complexity for something that is not critical to the core experience.

Balancing regular Members against Academic Staff was also tricky. Lecturers and researchers often need books for longer and would probably prefer some kind of priority in the reservation queue. But giving them priority feels unfair to regular members who reserved a book first. I decided to keep reservations first-come-first-served because it is simple and fair, even if it is not ideal for academic staff. The Library Manager presented a different kind of challenge. They want data and reports to help them make decisions, which makes sense. But honestly I think a full analytics dashboard with charts and historical trends goes beyond what is necessary for the core system at this stage, so I plan to include a basic summary page that shows the key numbers, which should be enough to meet that need without expanding the scope too far.

Security versus usability was something I also thought about throughout the whole process. JWT and BCrypt are non-negotiable for a system that handles personal data, but they do add complexity. My plan is to include both while keeping the login and registration experience as straightforward as possible so it does not feel like a barrier to new users. Overall, balancing stakeholder needs made me think more carefully about who I am actually building this for. Before doing the stakeholder analysis I was mostly thinking about the system from a technical perspective, but going through each stakeholder one by one made me realise that the real challenge is not writing the code, it is making sure the right people get what they need from it. There is no solution that satisfies everyone completely, so I had to make deliberate choices about where to draw the line. I am fairly confident though that the decisions I made strike a reasonable balance.

---

## Reflection: Challenges in Translating Requirements to Use Cases and Test Cases

---

Going into this assignment, I assumed translating requirements into use cases would be simple because I had everything documented from Assignment 4. What I didn't anticipate was how much thought was required to go from a list of requirements to something that actually describes how a real person would interact with the system step by step.

The first challenge I ran into was figuring out how many actors to include in the use case diagram. In Assignment 4 I identified seven stakeholders, but not all of them interact with the system in meaningfully different ways. Academic Staff, for example, use the system in almost exactly the same way as a regular Library Member. I had to decide whether to treat them as a separate actor or simply note that they share the same use cases. In the end I kept them as a separate actor because their context is different even if their interactions are not, and it felt important to show that the system serves both groups. Another challenge was drawing the line between what counts as a use case and what is just a step inside a use case. For example, checking book availability could be its own use case or it could just be part of reserving a book or issuing a loan. I decided to model it as a separate use case with an include relationship because it is something the system does in multiple places and it honestly made the diagram easier to read and understand.

Writing the alternative flows for each use case specification was definitely harder than I expected. It is easy to write down the happy path where everything goes right, but thinking through all the ways something could go wrong requires a different kind of thinking. I had to ask myself for each step what happens if the data is missing, what happens if the user does not have permission, and what happens if the record does not exist. This made me realise that a lot of the robustness of a system comes not from the main flow but from how well it handles the edge cases. The test cases presented their own challenges. Writing functional test cases was manageable because I could trace each one directly back to a functional requirement in the previous assignment. The harder part was writing the non-functional test cases, particularly the performance test. It is one thing to say the system should return results within 3 seconds, but defining exactly how to test that in a meaningful way requires thinking about the environment, the load, and the tools needed to simulate real usage. I plan to use Postman for the security tests and a load testing tool for the performance tests once the system is deployed, but at this stage those tests obviously can't be fully executed yet.

One thing I found genuinely useful about translating requirements to use cases and doing the test cases, was that it forced me to think about the system from the user's perspective rather than the developer's perspective. When writing requirements it is easy to stay abstract, but writing a use case specification requires you to imagine a real person sitting in front of the screen and walking through every click and response. That shift in perspective helped me spot a few gaps in my requirements that I had not noticed before, such as what happens when a member tries to reserve a book they have already reserved, which I ended up adding as an alternative flow.

What surprised me most about this phase in the assignment was how much it changed the way I think about the system. I came in thinking I already had a solid understanding of what I was building, but working through the use cases and test cases made me realise there were details I had not fully thought through. Going into the development phase I honestly feel more prepared than I expected to be at this point.

---

## Reflection: Challenges in Agile Planning

---

Agile planning honestly sounded simple on paper. You take your requirements, break them into user stories, estimate the effort, and decide what goes into the first sprint. What I did not realise until I actually sat down to do it was how many small decisions are involved, and how uncomfortable it is to make those decisions without anyone else to bounce ideas off.

The first thing I got stuck on was writing user stories that actually followed the "As a [role], I want [action] so that [benefit]" format in a way that felt meaningful. It sounds simple but it is easy to write something that technically fits the format without actually saying anything useful. Something like "As a library member, I want to search for books so that I can find books" follows the format but actually tells you nothing. I kept having to stop and ask myself what the person using this feature actually gets out of it, and that was harder to answer than I expected.

Prioritisation was honestly the hardest part. When you are working alone there is no one to push back on your decisions, no product owner to challenge you, and no team to negotiate with. I had to create that resistance myself. My first instinct was to mark almost everything as Must-have because when you have designed something yourself every feature feels essential. What helped was asking a simple question...can the system actually work without this right now? That question made it easier to separate what is truly necessary from what is just nice to have.

Effort estimation was its own challenge, I used the Fibonacci sequence for story points like the brief suggested, but putting a number on work you have not done yet is genuinely uncomfortable. I kept going back and forth on things like whether the login feature deserved a 2 or a 3, or whether reservations were closer to a 5 or an 8. In a real Scrum team you would do planning poker and talk it through until everyone agrees. Doing it alone means the estimates are entirely based on your own gut feeling, which is not always reliable.

Selecting stories for the sprint made me face up to something I had been avoiding, which is that two weeks is not a lot of time. I originally planned to include the loan issuing feature in Sprint 1 but when I totalled up the estimated hours I was already at 46, which felt like more than enough for one sprint. Cutting it was the right decision but it did not feel good at the time.

My biggest takeaway in this phase of the assignment is that Agile is not really a process, it is a way of thinking. The planning poker, the retrospectives, the daily standups, all of that exists because working alone and staying honest with yourself is actually really difficult. This assignment gave me a small taste of why those things matter, and it made me appreciate why Agile teams are built around people rather than just plans.

---

## Reflection: Challenges in Template Selection and Kanban Customisation

---

Picking a template seemed like it would take five minutes. GitHub does not offer that many options and they all look similar at first. But once I had to write down why I chose one over the others I realised I had not thought about it carefully enough, and the same thing happened when I started customising the board. What looked like simple decisions turned out to need more thought than I expected.

The first challenge was understanding the difference between the Basic Kanban and the Automated Kanban well enough to make a genuine argument for one over the other. On the surface they look almost identical...both have To Do, In Progress, and Done columns. The real difference is in the automation, and to understand why that matters required me to think about what it actually feels like to maintain a board manually over a long project. It is easy to forget to move a card when you are deep in writing code, and a board that is out of sync with reality is not useful to anyone. That realisation made the Automated Kanban the obvious choice, but it honestly took me a while to get there.

Deciding which custom columns to add was another challenge. The brief asked for at least two new columns and my first instinct was to add columns that sounded impressive rather than columns that would actually be useful. I initially considered adding columns like "Code Review" and "Deployment" but then I remembered that I am working alone and there is no one to review my code. Adding those columns would have looked good on paper but would have actually been meaningless in practice. I settled on Testing and Blocked because they reflect real stages in my actual workflow, not an imaginary team process.

Comparing GitHub Projects to other tools like Trello and Jira was interesting because I had to think about what makes GitHub Projects specifically useful for this project rather than just listing general differences. The biggest advantage of GitHub Projects over Trello is the native integration with Issues and pull requests. In Trello you would have to manually create cards and keep them in sync with your code repository, whereas in GitHub everything lives in the same place. Jira is more powerful than GitHub Projects in terms of reporting and advanced sprint management, but it is also significantly more complex to set up and maintain. GitHub Projects gives me enough structure to stay organised without being so complex that managing the tool starts to feel like a separate task on its own.

The thing that surprised me most about this partcular phase of the assignment was how much the Kanban board changed the way I think about the work ahead. Having all the user stories visible as cards in a To Do column makes the project feel more concrete and manageable than a list of requirements in a markdown file. It is easier to see what needs to happen next and harder to pretend you are making progress when the cards are not actually moving.

---

## Reflection: Object State Modeling and Activity Workflow Modeling

---

This assignment felt different from everything that came before it. Most of the previous assignments involved writing things down in one form or another, requirements, specifications, user stories. This one required me to actually think about how the system behaves over time and express that visually, which turned out to be a little bit more difficult than I anticipated.

The first thing I struggled with was figuring out how detailed to make the state diagrams. For something like a Book Loan it was tempting to keep adding states to make the diagram look more thorough. But the more states I added the harder the diagram became to follow, and at some point it stops being useful. I kept having to ask myself whether a new state actually represented something meaningful happening to the object or whether I was just adding it to fill space. That question helped me keep the diagrams focused.

Activity diagrams had a similar problem but from a different angle. The question there was not how many states to show but how many decision points and parallel actions were actually worth including. In the Process Book Return workflow for example I could have broken the fine calculation down into much smaller steps. But those details belong in the code, not the diagram. The diagram is supposed to show the logic at a high level, not map out every single thing the system does internally.

Connecting the diagrams back to the Agile user stories from Assignment 6 was an interesting exercise. User stories describe what someone wants to achieve, but state and activity diagrams describe how the system behaves to make that happen. Getting from one to the other required me to re-read each story and ask what actually needs to happen inside the system for that outcome to be possible. Doing that helped me spot a few gaps I had not noticed before, like what should happen to a reservation if the member's account gets deactivated. One thing this assignment made clear is that state diagrams and activity diagrams answer completely different questions. A state diagram is about a single object and what it can be at any given moment. An activity diagram is about a process and who does what to move it forward. I needed both to get a full picture of the system, and working through them separately helped me understand the difference in a way that just reading about it never would have.

The most useful outcome of this assignment was the edge cases it forced me to think about. Questions like what happens if a member tries to borrow while suspended, or what happens to reservations when a book gets deleted. Those are the kinds of details that are easy to skip over when you are working at the requirements level but they become very real problems during implementation. Having thought through them now should make the actual development phase a lot smoother.
