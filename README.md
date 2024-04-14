# Wikimedia Test Automation Framework
* [Description](#description)
* [Getting Started](#getting-started)
  * [Java](#java)
  * [Maven](#maven)
* [Executing Tests](#executing-tests)
* [Test Result Analysis](#test-result-analysis)
  * [Reporting](#reporting)
  * [Logging](#logging)
* [Tools and Technologies](#tools-and-technologies)
* [Project structure](#project-structure)
* [Feature Highlights](#feature-highlights)
* [Future Development](#future-development)

## Description
This repository contains comprehensive automation tests designed for the Wikimedia API. It provides distinct integration (API) test suites focused on backend functionality and holistic system verification. Users can leverage these suites to ensure robust testing coverage across all facets of the application.
## Getting Started
To commence work on the project, it's essential to have the following tools and technologies configured:

#### Java
- Recommended version: Java 8 (or higher)
- To download: https://www.oracle.com/java/technologies/downloads/
- Installation guideline: https://docs.oracle.com/en/java/javase/18/install/overview-jdk-installation.html
- To check the current version installed:
```bash
java -version
```

#### Maven
- Recommended version: Maven 3.8 (or higher)
- To download: https://maven.apache.org/download.cgi
- Installation guideline: https://maven.apache.org/install.html
- To check the current version installed:
```bash
mvn -version
```

## Executing Tests

- To execute **the API Regression Suite** using a command line interface, use the following maven goal from the main directory:
```bash
mvn clean test -DtestSuite=api_regression.xml
```
Tests can be executed using an IDE by running the src/test/resources/test-suites/api_regression.xml file as well.

## Test Result Analysis
### Reporting
- A report will be created after each execution in: './test-output/' folder.

### Logging
- Log files will be created after each execution with time stamp in: './test-output/Test Execution Logs' folder

## Tools and Technologies
- Core Technologies: Java, Rest-Assured, TestNG
- Build Automation: Maven
- Assertions: Hamcrest Matchers
- Reporting: Allure Reports/ TestNG reports
- Logging: SLF4J, Logback, TestNG

## Project Structure
The project uses both main and test levels.
### main
In the project main is broken into 3 packages
#### base
- ApiBase class has to be extended for each api test class. This abstract class consists with request building and sending common methods.
#### listeners
- This package consists with the listener class which is used for logging. TestNG listeners are used here.
#### utils
- This package consists with the utility classes where constants are stored, property files are read, common supporting methods are placed etc.
#### resources
- jsonSchemaFiles directory consists with the schema files which are used for validating the responses.
- also this directory consists with the logback xml file which configures logging.
### test
- Consists with the API test classes and their helper classes
#### resources
- test-suites directory includes all the testNG runner files for API tests
- config.properties file which consists with the property values
### test-output
- Created after a test execution
- Consists of automatic test reports and logs
## Feature Highlights
- JSON schema validation for APIs
- Executing tests in groups
- Support for parallel test execution
- Report creation after each execution
- Execution log creation with the help of test listeners after each execution
- Ability to change attributes from property file level
- CI/CD integration
## Future Development
- Utilizing Serialization and Deserialization techniques to effectively test complex APIs and ensure robust functionality.
- Leveraging APIs for streamlined test data creation and cleanup processes, resulting in improved execution efficiency and easier maintenance.
- Enhancing CI/CD scripts by incorporating parameterization and post-action functionalities for greater flexibility and automation.
- Implementing automated test results analysis leveraging machine learning capabilities provided by tools like Report Portal for in-depth insights and trend analysis.
- Incorporating retry mechanisms for failed test scripts to improve test robustness and reliability in dynamic environments.
- Integrating test automation executions with test management systems to facilitate seamless tracking, monitoring, and reporting for enhanced visibility and control.