# QA Automation Assignment

## Project Title: QumuQa Task

  In GitHub you will find 2 projects:

### QumuQa Project:

  This is the original project which you have sent me. I have 

   - Removed all the dependencies in the task and added new dependencies
   - Removed some paths and added some new paths in the structure
   - Used Page Object Model (POM) design pattern
   - Implemented my own Driver Class built based on singleton design pattern
   - Designed and implemented utility classes
   - Stored all configuration details in properties files named “TestData.properties”
   - Used TestDataReader class to read all details in properties files TestData.properties
   - Used Plugins to generate cucumber-report (RunnerTest / CukesRunner class) and to run only failed tests (RunnerTest / FailedTestRunner class)

### QumuMaven Project:

  This is the project I have designed and implemented from scratch based on the requirements.


# Tools:

   - IntelliJ IDEA 2019.3.4
   - Maven
   - Java 13
   - Page Object Model (POM)
   - Cucumber BDD
   - Gherkin
   - Junit
   - TestNG
   - RestAssured
   - Json
   - POJO
   - Selenium Webdriver
   - GitHub    


# Reporting:

Below you will see how to generate reports:

   - Go to menu on the right side and find “Maven”
   - Double click “verify” under “Lifecycle”. After running verify, you will see success status.
   - Go to the left panel, right click on any of the html files starting with “overview” under “target / cucumber-html-reports” such as overview-features.html and select “Open in Browser” and use one of the browsers to see report
