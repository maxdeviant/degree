![Logo](/images/stark.png)

Stark
-----
>A clearer path to the software development process.

#Table of Contents
1. [Overview](#overview)  
2. [Principles](#principles)
3. [Process](#process-script)
4. [Planning](#planning)
5. [Roles](#roles)
6. [Execution](#execution)
7. [Compliance](#compliance)
8. [Debriefing](#debriefing)

#Overview

Stark aims to be the process of choice for developers looking for a clear and low-hassle approach to software development. Clear, common-sense principles combined with deep Git integration creates a compelling workflow to write code in.

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

##Process Script
Planning||
---|---
1| Project Manager is chosen
2| Establish methods of communication
3| Create goals and completion time for weekly sprint
4| Divide tasks
5| Iteration Commencement
6| Acceptance Phase
7| Repeat 3-7 until completion

Design||
---|---
1| Develop working code
2| Implement security aspects
3| Fix bugs/errors that occur
4| Refactoring

Implementation||
---|---
1| Coding standards are agreed upon by the team
2| Code is written individually or in pairs depending on the level of the programmer
3| Code is inspected to ensure that the content meets the standard requirements
4| Code is reviewed: Programmer(s) makes a review checklist, error tacking log, and code inspection script for each week

Quality Assurance||
---|---
1| Quality assurance team will be established
2| Unit tests will be documented. Each test will contain the intended functionality of the design based on the iteration and ser goals
3| Security Analyst involvement: performs tests halfway through and at the end of each iteration
4| Customer Involvement: Customer will be consulted at the end of each iteration to ensure the project is moving in the direction they desire
5| Produce the final product that contains the least amount of errors possible and is cost efficient to the consumer

|Process Modification||
---|---
|| Quality Assurance team will determine if process needs modifications based off feedback from the development team, management, data assessment, and SEI Input|
1| Development teams and management will record written concerns about current process and changes to process will be recorded|
2| Data Assessment - examins the tends pertaining to time-till-completion and defect injection/removal |
3| SEI Input follows any changes enforced by the Institute|

###Project Manager (Hand of the King) is chosen

Depending on the neccessity, at the beginning of the project a project manager is to be selected. Durring the first meeting the development team (small council) will decide if a manager is neccessary or not, and in the case that one is needed, elect a person to fill this role. It is the duty of the Project manager to ensure that all work is completed on time and is do not try to handle too many tasks at once. This individual should be a person that is familiar with the process and is capable of managing workloads and time-estimates for completion. As the main organiser for the team, the project manager should be able to keep the development team is following the proper guidelines and is comfortable going to the manager with any questons or concerns they might have.

In addition to managing workloads, the project manager is also responsible for keeping the project on schedule. At the end of every iteration the Project Manager should collect progress forms and backlogs stating what tasks were completed and when. Using these logs, the Manager should adjust the amount of work that each team member takes on in order to ensure that everyone is working efficiently.

In the case that The Hand does not satisfy the requirements, then the small council will convene and reach a majority vote whether or not the hand should be replaced. Should this occur, the Hand will be executed and replaced with a more suitable paw...I mean member.

###Goal Setting Meeting

At the beginning of the project a goal setting meeting will be held with the Project Manager(Should there be one, otherwise the Development team will be present instead) and the Customer. Durring this meeting major goals for the project will be determined and user stories will be created. This includes what the functionality of the project will be, features that should be included, and establishing a rough completion time that the project will be complete. The Customer should also be informed of any costs that might be incured durring the development of the projects, and should be made aware that the timeline and prices may change over the development of the project.

After the initial goal setting meeting, smaller additional goal setting meetings will occur after 3-4 iterations to refocus the team and analyse the project timeline. Any goals set durring these meetings should be restricted to things that can be completed within four or five iterations to aviod taking on tasks that are too far in the future.

In addition to creating user stories and setting goals, the methods of communication will also be set durring the first Goal Setting meeting. Methods of communication should change depending on the work environmnet the teamis working with. Smaller evironments may be able to run fine using post-it notes or some similar medium. Larger environments or environments that have the development team spilt over a large area may be required to use e-mail or messenger arrow.

The decision of the main method of communication should be documneted, in addition all notes and inqueries should be logged to keep a history of interaction between team memebers. This will allow a timeline to be established when issues occur and allow members to track how past issues that were similar to be solved.

###Create User Stories

This process is left solely to the customer for creation and development. This is because the user stories should be the major functions of the project that the customer wants incorperated. The user stories should be presented in a manner that keeps them short and simple for fast development. Whether to use a digital or paper medium is up to be decided between the customer and the Project Manager. After the user stories are presented, they will be presented to the development team and distributed.

In order to keep development of the project flowing more important user stories will be handled first. These include base functionality of the project and ensures that the project works, even if it is not user friendly. Secondary tasks, such as making the project user friendly or navigation will be handled after all base functions work. Additional tasks, such as layout and aesthetic choices will be handeled last.

###Devide Tasks

Different members of the development team will select a number of tasks that they are to complete by the end of the iteration. The number of tasks that each memeber selects will be based on individual skill and the judgement of the Project Manager. In order to avoid overworking a member early in the project, members will be restricted to three tasks for the first iteration. After that, the Project Manager should work with the development team to maximize the efficiency of each member.

Task will be selected from the user stories created by the customer, and will be rewritten by the developer to explain exactly what they will be developing. This new definition of the user story will be confirmed by the customer to ensure that the developer and the customer are on the same page.

###Iteration Commencement

Each iteration should be between two-four weeks long. In order to keep the project moving, each developer should be assigned tasks that they can complete within this timeframe. After each iteration there should be a team meeting to assign new tasks to the developers and ensure everyone has an acceptable amount of work.

The iteration should should begin by a team meeting in which all facets of the project must attend. (Customer, Project Manager, Development Team, ect.) Durring this meeting everyone on the development team should present how far they are on thier individual tasks and report on the progress. Durring this time developers should inform the rest of the group if each task is on track to be finished by the end of the iteration. If the task is not on schedule, then a period of time dedicated to resolving any issues the developer is having can be utilized. Should the case be that group effort cannot resolve the issue with the task, the project manager can choose to reassign the task to someone else, or discuss with the customer about alternatives.



#Planning
>"In preparing for battle I have always found that plans are useless, but planning is indispensable." – Dwight D. Eisenhower

##1. Plan your work.

Planning should be the first task in every software iteration.

##2. Work your plan.

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

The small council is chaired by the king, Hand, key individuals from the development team, and from other teams in the company, such as marketing. The small council is responsible for discussing project updates, deadlines, and any other issues or concerns that have arisen during the course of development.

The size of the small council may vary, but an ideal number of members is seven.

It is advised that the small council meet regularly for maximum efficiency.

#Execution
>"Our job is to execute." – Mark V. Hurd

#Compliance
>"All I want is compliance with my wishes, after reasonable discussion." – Winston Churchill

Each developer is to be held to the defined compliance standards. This serves to establish a uniform process across the entire development process and ultimately lead to high-quality code.

All compliance standards can be found in the [compliance](/compliance/index.md) docs.

#Debriefing
>"It is easy to be wise after the event." – Arthur Conan Doyle

At the end of each iteration, some time should be allotted for debriefing team members on the completed iteration.