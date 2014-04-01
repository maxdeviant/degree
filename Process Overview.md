#Principles
>"Rules are not necessarily sacred, principles are." – Franklin D. Roosevelt

##1. Commit early, commit often.

This adage – borrowed from Git – is ingrained heavily in the Stark process. Commits cost nothing to make, which means there is no excuse for not committing on a regular basis. A habit of committing after adding or changing any piece of code makes it simple to track changes over a longer period.

##2. Code over comments.

Documentation and comments have their place in code, and go a long way in enabling other developers to easily understand the interactions of a particular subroutine or complex logic gate. However, comments should not be prioritized when working on a new feature. No reason in writing perfectly good comments that will be scrapped before a merge.

##3. Branch out.

Do not commit to master. That's an order! All major changes start with a branch. Name it something intelligent, such as the feature being added. Once a branch is created, use commits to manage small changes within the branch. And if the implentation of a sub-feature may end up being incredibly messy, make a seperate branch for that as well. Much like commits, branches are free: use them.

##4. Keep it clean.

No one wants to look at messy code. Ensure that all code is properly formatted, documented, and commented before any and all code reviews. This will make the review process easier, as well as making the reviewed code merge-ready at the end of the review.


#Roles
>"Individually, we are one drop. Together, we are an ocean." – Ryunosuke Satoro

##King

The highest position in Stark is that of the king. The king is responsible for all executive decisions in the development process and is responsible for working closely with marketing and business teams, as well as shareholders and users.

While other team members, specifically the Hand, are allowed to give their counsel to the king, all decisions ultimately lie with him.

This role may be static or fluid, with one member – such as a senior developer – being made the permanent king, or having the king chosen at the beginning of each iteration.

##Hand of the King

The Hand of the King is second in command on the development team. The Hand is responsible for making critical decisions on the king's behalf. This frees up the hierarchy and prevents the king from being too overwhelmed with managerial tasks. This also enables development to continue even in the king's absence.

It is up to the Hand to pay attention to the development process, both in and out of small council meetings, and advise the king in his decision making.

The Hand does not have to be a senior developer. In fact, choosing a Hand who contrasts the current king in terms of knowledge, expertise, and even personality may be beneficial. This will allow the Hand to advise the king on areas he may not be familiar with.

##Small Council

The small council is chaired by the King, Hand, key individuals from the development team, and from other teams in the company, such as marketing. The small council is responsible for discussing project updates, deadlines, and any other issues or concerns that have arisen during the course of development.

The size of the small council may vary, but an ideal number of members is seven.

It is advised that the small council meet regularly for maximum efficiency.

##Lord Commander

The Lord Commander is second in command on the security team.  The Lord Commander is reponsible for managing the kingsguard, and reports to the King in regards to the project's security status. 

It is the Lord Commander's role to oversee the review and security analysis of the project, which is performed by the kingsguard. The Commander is responsible for giving reports at each debriefing on defects and security flaws found during the iteration.

The Lord Commander is a key position within the corporation, and is not designated per project. In addition the Kingsguard, this is assigned to all projects currently held by the corporation with the sole task of monitoring security.

##Kingsguard

The kingsguard is a small group chaired by the Lord Commander whose task is to assist the small council with the security aspects of development. Their role in development is to analyze any code that is committed for potential security risks.

#Planning

* Crown a King and Hand of the King (If deemed necessary)
* Form the Small Council
* Meet with the Client
* Consult with Kingsguard on Security

#Design

* The Hand and Small Council convene to discuss features for next sprint
* Sprints can last from around 2-4 weeks

#Debriefing (Review)
>"It is easy to be wise after the event." – Arthur Conan Doyle

At the end of each iteration, some time should be allotted for debriefing team members and the client on the completed iteration.

