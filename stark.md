![Logo](stark.png)

stark
-----
>A clearer path to the software development process.

#Table of Contents
1. [Overview](#overview)  
2. [Principles](#principles)

#Overview

Stark aims to be the process of choice for developers looking for a clear and low-hassle approach to software development. Clear, common-sense principles combined with deep Git integration creates a compelling workflow to write code in.

#Principles
##1. Commit early, commit often.

This adage – borrowed from Git – is ingrained heavily in the Stark process. Commits cost nothing to make, which means there is no excuse for not committing on a regular basis. A habit of committing after adding or changing any piece of code makes it simple to track changes over a longer period.

##2. Code over comments.

Documentation and comments have their place in code, and go a long way in enabling other developers to easily understand the interactions of a particular subroutine or complex logic gate. However, comments should not be prioritized when working on a new feature. No reason in writing perfectly good comments that will be scrapped before a merge.

##3. Branch out.

Do not commit to master. That's an order! All major changes start with a branch. Name it something intelligent, such as the feature being added. Once a branch is created, use commits to manage small changes within the branch. And if the implentation of a sub-feature may end up being incredibly messy, make a seperate branch for that as well. Much like commits, branches are free: use them.

##4. Keep it clean.

No one wants to look at messy code. Ensure that all code is properly formatted, documented, and commented before any and all code reviews. This will make the review process easier, as well as making the reviewed code merge-ready at the end of the review.