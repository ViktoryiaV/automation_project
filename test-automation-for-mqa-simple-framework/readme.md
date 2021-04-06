## Simple Test Automation Framework

### Structure

#### Framework Core (generic page each project)

- src/main/groovy
    - `my.testframework.helpers`: Generic Base Helper class
    - `my.testframework.pages`: Generic Base Page class
    - `my.testframework.utils`: Generic utils and tools
        - `ConfigsReader`: reads configuration from `configuration.properties`
        - Reporter: Setup reporting configs
        - `DriverManager`: responsible for manage browser session
        - `WaitUtil`: responsible for waiting for conditions
    - `my.testframework.utils.uielements`: Selenium WebElement wrappers

#### Project Tests (project-specific)

- src/main/test
    - `project.helpers`: Project Specific Helpers
    - `project.pages`: Project Specific Page classes
    - `project.tests`: Project tests
        - `BaseTest`: Base Parent test for the project

    - `project.utils`: Project utils (preconditions, cleanup, data-generation)

### Configs

- src/test/groovy/configuration.properties

```properties
# available: chrome, firefox
browser=${browser}
# e.g. https://todomvc.com/examples/backbone/
base.url=${base.url}
```

#### Maven profiles

- default
    ```xml
    <properties>
        <browser>chrome</browser>
        <suite.name>testng</suite.name>
    </properties>
    ```
- chrome
  ```xml
    <properties>
        <browser>chrome</browser>
    </properties>
    ```
- firefox
  ```xml
    <properties>
        <browser>firefox</browser>
    </properties>
    ```  
- qa
  ```xml
    <properties>
        <base.url>https://todomvc.com/examples/backbone/</base.url>
    </properties>
    ```  
- dev
  ```xml
    <properties>
        <base.url>https://todomvc.com/examples/angularjs/#/</base.url>
    </properties>
    ```

### Run tests command

```shell
mvn clean test -Dsuite.name=testng -Pchrome,qa -s .m2/settings.xml
```

### Test HTML Report

- target/html-report/index.html