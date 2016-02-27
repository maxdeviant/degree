#9. Quality Assurance & Testing

In order to ensure the highest standards for code going into the software package Stark relies heavily on code reviews to ensure maximum code quality. No code should be committed to a larger branch until it is full vetted and found to adhere to all of the coding compliance standards, as well as be free of bugs and security flaws.

This way, code is always checked for quality from the bottom up, assuring developers that the code in the master and main sub-repositories is healthy.

##Code Reviews

Code reviews are to be conducted on a regular basis throughout the course of the sprint. The developer should prepare a testing environment in a suitable location to accommodate the reviewers, who consist of other developers familiar with the language and platform the code is in, as well as a member of the Kingsguard.

Prior to the review the developer should test the feature to be reviewed against the project test suite to ensure that all preliminary issues are caught and dealt with accordindly. Additionally, depending on the nature of the feature, it may be prudent for the developer to also run the code against a profiling test to check for things such as database read/write errors, memory leaks, and overall execution performance.

Once this information has been prepared, the developer will present the results of the unit tests to the reviewers. At this point, the developer will walk the reviewers through the code. The developers will look for lines of code that are in need of fixing, predominantely areas with messy logic that may be able to be optimized. Areas where code does not adhere to the coding compliance standards will also need to be addressed at this time.

Meanwhile, the member of the Kingsguard will be on the lookout for any security vulnerabilties in the code as it is reviewed.

If the feature passes the code review process then the developer may submit a pull request to the parent branch. If the developer in charge of the parent branch is satisfied with the code being submitted, then the pull request is granted and the feature is merged into the branch.

However, if the feature does not pass the code review, the developer must go back and fix the offending lines of code and rerunning unit tests before scheduling another code review for a later date.

##Unit Testing

While Stark does not provide any strict guidelines for testing code, it is recommended that the team uses a testing method that is familiar to them. Test-driven development and Behaviour-driven development are both widely popular in software development circles, but the one that is used is entirely up to the company's discretion. However, the fact remains that some sort of unit testing should be employed to ensure maxiumum efficiency and code quality.

Unit tests are to be written prior to the code review and should cover as many test cases as possible, including edge cases. This will greatly decrease the chance of faulty code making it to the code review itself and risk not getting caught.