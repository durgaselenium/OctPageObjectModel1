# 🔹 Selenium Automation Framework – Regression Suite
**Project:** OctPageObjectModel1  

This project is a Selenium Automation Framework designed using **Java**, **TestNG**, and **Page Object Model (POM)** structure.  
It integrates **Maven**, **Allure Reports**, and **ChainTest HTML Reports** for professional-level automation reporting.


## 🚀 Project Overview
| Feature | Description |
|----------|--------------|
| **Framework Type** | Page Object Model (POM) |
| **Build Tool** | Maven |
| **Testing Framework** | TestNG |
| **Reports** | Allure + ChainTest |
| **IDE** | Eclipse |
| **Execution** | Command Line (Maven) |


## 🧰 Tech Stack
| Tool / Library | Purpose |
|----------------|----------|
| **Java 21** | Core programming |
| **Selenium WebDriver 4.38.0** | Browser automation |
| **TestNG 7.10.2** | Test execution |
| **Maven** | Build & dependency management |
| **Allure 2.23.0** | Interactive HTML reporting |
| **ChainTest 1.0.12** | Simple HTML test report |
| **Apache POI** | Excel file handling |
| **Log4j / SLF4J** | Logging support |


## 📁 Project Structure
(project folders and files tree here)

OctPageObjectModel1/
├── src/
│ ├── main/java/ → Utilities, Base classes, Browser setup
│ └── test/java/ → Page classes and test scripts
│
├── src/test/resources/
│ └── testrunners/
│ └── testng_regression.xml → TestNG suite file
│
├── target/
│ └── chaintest/ → HTML reports (index.html, email.html)
│ └── resources/ → Screenshots folder
│
├── allure-results/ → Allure raw result data
├── pom.xml → Maven dependencies and plugins
└── README.md → Project documentation


## ▶️ How to Run the Project
Run this Maven command from your project root:
mvn clean install -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml


Allure command:
allure serve allure-results

ChainTest Report Steps:
Open target/chaintest/index.html or email.html for ChainTest report.

Failure TestCases Screenshots are stored in:
target/chaintest/resources/
