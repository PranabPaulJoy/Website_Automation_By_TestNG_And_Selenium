# Web_Automation_By_TestNG

**TestNG** is one of the most widely used open-source testing framework used in automation testing suite.
- TestNG is a very important framework when you are actually developing the framework from scratch level.
- TestNG provides you full control over the test cases and the execution of the test cases. Due to this reason, TestNG is also known as a testing framework.
- Cedric Beust is the developer of a TestNG framework.
- If you want to run a test case A before that as a pre-request you need to run multiple test cases before you begin a test case A. You can set and map with the help of TestNG so that prerequest test cases run first and then only it will trigger a test case A. In such a way, you can control the test cases.
- The TestNG framework came after Junit, and the TestNG framework adds more powerful functionality and is easier to use.
- It is an open-source automated TestNG framework. In TestNG, **NG** stands for **" Next Generation"**.
- The TestNG framework eliminates the limitations of the older framework by providing more powerful and flexible test cases with help of easy annotations, grouping, sequencing, and parametrizing.

**Selenium** is a free (open-source) automated testing framework used to validate web applications across different browsers and platforms. You can use multiple programming languages like Java, C#, Python, etc. to create Selenium Test Scripts. Testing done using the Selenium testing tool is usually referred to as **Selenium Testing**.
Selenium automates web browsers. It is most famous for enabling rapid, repeatable web app testing, which allows developers to ship new releases faster and with confidence.
In most organizations, it is the job of quality analyst (QA) engineers to test web applications by using Selenium. They are required to write scripts that can help maximize accuracy and test coverage to make changes in the project and maintain the infrastructure of the test.

## Technology used:
- IntelliJ 
- Selenium 
## Framework used:
- TestNG
## How to run this project:
- Clone this project 
-  Execute the following command ``` gradle clean Test ```

## Website used for this automation:
- https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

## Prerequisite:
**This dependency is required to run this project**

    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation group: 'org.testng', name: 'testng', version: '7.8.0'

    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.11.0'

    // https://mvnrepository.com/artifact/commons-io/commons-io
    implementation group: 'commons-io', name: 'commons-io', version: '2.13.0'

    // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'

    // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'

    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation group: 'io.qameta.allure', name: 'allure-testng', version: '2.23.0'

## Scenarios:
Login as an admin to https://opensource-demo.orangehrmlive.com/
2. Go to the PIM menu and create a new employee.
3. Now go to the dashboard again and search by the employee id to check if the employee is found
4. Now go to the Directory menu and search by employee name and check if the employee is found
5. Logout the session.
6. Now login with the newly created employee creds
7. Assert your full name is showing besides the profile icon.
8. Go to my info
9. Scroll down and select Gender and Blood Type as O+ and save it. Then logout the user.
10. Create a smoke suite configuration which will run only following features (positive cases only):
- Login to admin
- Search by the employee id if found
- Logout admin and login to the employee ID you created last
- Update the blood Group as AB-
- Logout the user
  
## Report:

This repository generates an automatic report and an Allure report.

![report](https://github.com/PranabPaulJoy/Web_Automation_By_TestNG/assets/127541697/4a8f67fd-d3ae-4880-8e37-76c15cb50a2c)

**Allure Report**
![allure](https://github.com/PranabPaulJoy/Web_Automation_By_TestNG/assets/127541697/f7450896-0f0f-4e8c-b40e-44502468b996)

![screencapture-localhost-63342-TestNGAssignment-allure-report-index-html-2023-09-29-02_01_36](https://github.com/PranabPaulJoy/Web_Automation_By_TestNG/assets/127541697/a0a7bc08-2b78-4418-8ba4-3e1cab9dbe3c)

![allure re](https://github.com/PranabPaulJoy/Web_Automation_By_TestNG/assets/127541697/719536ac-47a0-49e3-99fa-5d4d1e52900f)

## Project Video:

https://github.com/PranabPaulJoy/Web_Automation_By_TestNG/assets/127541697/69639b54-c386-443f-80eb-271733b2925f

