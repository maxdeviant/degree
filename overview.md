#Overview

##Principles
>"Rules are not necessarily sacred, principles are." – Franklin D. Roosevelt

###1. Commit early, commit often.

This adage – borrowed from Git – is ingrained heavily in the Stark process. Commits cost nothing to make, which means there is no excuse for not committing on a regular basis. A habit of committing after adding or changing any piece of code makes it simple to track changes over a longer period.

###2. Code over comments.

Documentation and comments have their place in code, and go a long way in enabling other developers to easily understand the interactions of a particular subroutine or complex logic gate. However, comments should not be prioritized when working on a new feature. No reason in writing perfectly good comments that will be scrapped before a merge.

###3. Branch out.

Do not commit to master. That's an order! All major changes start with a branch. Name it something intelligent, such as the feature being added. Once a branch is created, use commits to manage small changes within the branch. And if the implentation of a sub-feature may end up being incredibly messy, make a seperate branch for that as well. Much like commits, branches are free: use them.

###4. Keep it clean.

No one wants to look at messy code. Ensure that all code is properly formatted, documented, and commented before any and all code reviews. This will make the review process easier, as well as making the reviewed code merge-ready at the end of the review.


##Roles
>"Individually, we are one drop. Together, we are an ocean." – Ryunosuke Satoro

###King

The highest position in Stark is that of the king. The king is responsible for all executive decisions in the development process and is responsible for working closely with marketing and business teams, as well as shareholders and users.

While other team members, specifically the Hand, are allowed to give their counsel to the king, all decisions ultimately lie with him.

This role may be static or fluid, with one member – such as a senior developer – being made the permanent king, or having the king chosen at the beginning of each iteration.

###Hand of the King

The Hand of the King is second in command on the development team. The Hand is responsible for making critical decisions on the king's behalf. This frees up the hierarchy and prevents the king from being too overwhelmed with managerial tasks. This also enables development to continue even in the king's absence.

It is up to the Hand to pay attention to the development process, both in and out of small council meetings, and advise the king in his decision making.

The Hand does not have to be a senior developer. In fact, choosing a Hand who contrasts the current king in terms of knowledge, expertise, and even personality may be beneficial. This will allow the Hand to advise the king on areas he may not be familiar with.

###Small Council

The small council is chaired by the King, Hand, key individuals from the development team, and from other teams in the company, such as marketing. The small council is responsible for discussing project updates, deadlines, and any other issues or concerns that have arisen during the course of development.

The size of the small council may vary, but an ideal number of members is seven.

It is advised that the small council meet regularly for maximum efficiency.

###Lord Commander

The Lord Commander is in charge of security for the development process, as well as the software being developed.

As head of the Kingsguard, the Lord Commander's responsibilites are to ensure that each code segment is undergoing the proper security processes, and ensuring feature integrity from a security standpoint.

By allowing the Lord Commander to focus solely on security, the chance that insecure features will be pushed through the testing and review process is greatly reduced.

###Kingsguard

The Kingsguard is a group of developers under the Lord Commander's command in charge of reviewing all features for security vulnerabilities. This group should be comprised of security experts or senior developers with a good handle on software security.

At least member of the Kingsguard is to be present at each code review to scrutinize features for security flaws while they are still in the development process.

##Planning

At the beginning of a project, a king and Hand must be chosen for that project. The individuals chosen must have exemplary leadership skills as well as experience with or a good working knowledge of the technologies and platforms that will be used in the project.

Once these two have been selected, the other members of the small council may be selected. At the beginning of a project, it is permitted for temporary members to be appointed to the small council, namely any clients or other individuals who may have an important say in the planning and designing process. These members may be kept on or replaced after the planning phase, depending on the nature of the project and the amount of external influence needed for its completion.

##Design

Once a small council has been selected, the designing process may begin, following the rules outlined in the Design section. This time will be spent drawing up the specifications for the software package being developed as the end result of this project, as well as breaking the package down into core components.

With the help of the client, the members of the small council should work towards a projected timeline of completion, assigning complementary features to different milestones along the timeline. Ideally these milestones should mirror sprint lengths, usually a time of two to four weeks.

##Execution

Once the project design as a whole is finished, the actual development portion may begin. The small council members are to meet and select features to develop during the upcoming sprint. While these features may have already been selected as part of a project milestone, it is up to the small council's discretion what features are selected for this particular sprint.