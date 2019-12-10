# Groceries Scraper

**Author:** Victor Rotaru 

**Date:** 10th December 2019 Version: 1.0

**Purpose:**  Scrape a Sainsbury's website HTML page compose of grocery items and return the list of items and related data as JSON 

**IDE:** Netbeans

**Dependencies:** Java 8 JDK must be installed in order to run the application.

**Build tool:** Maven 3.6.0 

The below steps outline how to build and run the project:

1. Install Apache Maven as per the instructions located here [Apache Maven](https://maven.apache.org/install.html)
2. Open a Windows CMD / Linux Console / MacOS shell and go inside the project folder
3. To build the project type: (Windows) `mvn.cmd clean install <enter>` (Unix) `mvn clean install <enter>`
4. To run only the tests type: (Windows) `mvn.cmd test <enter>` (Unix) `mvn test <enter>`
5. To run the application type: (Windows) `mvn.cmd exec:java` <enter> (Unix) `mvn exec:java <enter>`

### TODO
As the HTML scraping is a very brittle process in order to catch the changes made to the page a validation component after the HTML scraping might be a good idea
