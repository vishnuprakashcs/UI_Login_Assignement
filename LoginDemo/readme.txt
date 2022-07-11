1. Created two tests cases to test the valid and invalid login attemps.

LoginAndLogoutTest.java: "$\git\UI_Login_Assignement\LoginDemo\src\test\java\TestCases\LoginAndLogoutTest.java"
InvalidLoginAttemptTest.java: "$\git\UI_Login_Assignement\LoginDemo\src\test\java\TestCases\InvalidLoginAttemptTest.java"

2. Added 'page object model' to lacate the elements in Login page and Dashbaord page

3. Created for running these tests in a remote webdriver. So docker container running is integrated with the execution.

4. TestNG.xml file includes the tests and when it runs all the tests executed in a docker container.
	In SeUpFixture the batfiles are run before the testsuite and the containers are started stopped after the testsuite.
5. After each execution TestNG automatically create a report under testout folder ("$\git\UI_Login_Assignement\LoginDemo\test-output\index.html")
6. Added this code to git hub and integrated Jenkins to create a pipeline.

