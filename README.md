*Selenium Tests*

This repository contains Selenium tests for the home24 application. This project can be used as a pattern for creating tests using
SpringFramework, Junit and PageObject Pattern.

*Page Object pattern*

For more info around this pattern, read this wiki page: http://code.google.com/p/selenium/wiki/PageObjects

*Dependencies*

Make sure you have Java installed on your system, if not follow the vendor instructions for installing them on your operating system. 
If you want to start tests without IDE, maven also should be installed on your system.
At least chrome browser should be installed on you system.
Tests can be started at Windows, Linux, Mac based systems. 

*Project Structure*

The project follows the standard Maven structure, so all the tests go in the src/test/java folder.



*Running Tests*

The following steps should get you set up for running Selenium tests locally on your machine:

1) Clone this repository to your local machine.
2) Open the project directory in IDE.
3) Find *.java file in test folder, open it and start tests. Test also can be start by maven plugin(lifecycle: test).

*Properties*

application.properties file has been added to the project and allow the user to choose browsers, where test will be started.
Examples:
webdriver.driver=chrome - means that tests will be started on chrome browser
base.url=https://www.home24.de/ - defines base url for tests

*Browsers*

The following are valid for use in the webdriver.driver property:
 - chrome
 - firefox

*Further Notes*

The project is just a starting point, feel free to modify it according to your needs.
