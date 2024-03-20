# worldlineTestingTask1
To provide a README.md file for your TestNG test class, you can include details such as the purpose of the class, its functionality, file location, and any other relevant information. Below is a sample README.md template for your Demo class:

---

# TestNG Automation Demo

## Purpose
This TestNG automation script is designed to perform various tests on the Coursera website. It utilizes Selenium WebDriver to interact with the website's elements and validate their attributes. The script is divided into multiple test methods, each focusing on a specific aspect of the website's functionality.

## File Location
The `Demo.java` file contains the source code for the automation script. It is located in the `src/test/java/Assessment/TestNG` package within the project directory.

## Test Methods
1. **selectBrowser():** This method selects the browser (Chrome or Firefox) for test execution based on the parameter provided.
2. **maxScreen():** This method maximizes the browser window.
3. **testSearch():** This method performs a search on the Coursera website and retrieves attributes of the search box element. It also validates the search functionality.
4. **testLink():** This method verifies the attributes of the "Log In" link on the Coursera website.
5. **testLinkAttributes():** This method clicks on the "Log In" link, enters credentials, submits the form, and verifies the error message displayed for invalid credentials.

## Usage
To run the automation script:
1. Ensure that the necessary WebDriver executables (chromedriver and geckodriver) are available in the specified locations (`C:\chromedriver-win64\chromedriver.exe` and `D:\geckodriver-v0.34.0-win64\geckodriver.exe`).
2. Execute the `selectBrowser()` method with the desired browser parameter (`chrome` or `firefox`) to launch the browser.
3. Execute the individual test methods as needed.

## Dependencies
- Selenium WebDriver
- TestNG
- (added them into pom.xml file as using maven approach for this project)
