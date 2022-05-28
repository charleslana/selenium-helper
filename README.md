# Selenium Helper 🆘 Documentation

## 💡 Introduction

> *This documentation is in 🇺🇸 English, however the Portuguese documentation from 🇧🇷 Brazil is available by
clicking [here](README_PT_BR.md)*

**Selenium Helper** is a testing tool based on the open source selenium testing framework and written in java.

The idea was to unify testing tools in just one set of libraries for running automated tests 🤖 and containing a broader
test creation model.

We know that pure selenium does not contain reports or logs of information to inform the user, so a system was created
that deals with the delivery of this information, in addition it is a customized framework so that the programmer who
uses it to create his automated tests does not take so much work, however you can use selenium functions natively.

By contacting the tool, you will be able to see in real time the information logs for each test action and at the end of
them you will have the option to check the report with their respective successes and errors.

Selenium helper in addition to being based on selenium, it contains several other libraries that will give you agility
and support in tests, some of them are:

_Selenium, WebDriver Manager, Extent Reports, JUnit._

## 📚 Detailed specifications

Selenium Helper has integration with the following technologies:

- Java 18
- Selenium 4
- Junit 5
- Log4j12
- WebDriver Manager
- Extent report
- Lombok
- Apache Commons

## 🏘 Architecture

The Project has two divisions of list environment, one containing the core which is the main and the other containing
the test folder.

Reports and screenshots folder inside the test folder under resources

### 🚫 What can't I change for production use?

The project contains two folders, test and main, main and all its contents cannot be deleted, but can be changed to suit
your needs.

### ✅ What can I change?

In the test folder there are several examples of some ways of implementing tests together with variations, but you can
delete them without problems, ***⚠ remembering that you should not delete the resources' folder from the test folder.***

## 💾 Installation

Is an IDE that compiles Java, IntelliJ, Netbeans, Eclipse is required.

Just clone the project or download the project to your environment.

After downloading and extracting the file to a desired folder, open the project in your IDE and download the library
dependencies.

You will navigate in the project folder to the ExampleTest.java file that is inside the test folder.

Now just run the test that makes up the @Test

## annotation 🔧 Initial setup

After installation, navigate to the file that is in the resources' folder of the test environment with the name:
config.properties.

This file has input settings for which criteria you want to trigger

| Parameter               | Values                  | Default                                                                                                  |
|-------------------------|-------------------------|----------------------------------------------------------------------------------------------------------|
| browser                 | (chrome, firefox, edge) | chrome                                                                                                   |
| headless                | (true or false)         | false                                                                                                    |
| web-driver-wait         | número inteiro          | 10                                                                                                       |
| report-theme            | (standard, dark)        | dark                                                                                                     |
| report-logo-url         | string url              | https://raw.githubusercontent.com/charleslana/test/579b6782913acc56571ce7d25fd1707dd6edce08/selenium.svg |
| report-datetime-format  | formato de datatime     | yyyy-MM-dd HH-mm-ss                                                                                      |
| open-report-after-tests | (true or false)         | true                                                                                                     |

## 🐛 The Tests

With the help of Junit that comes in the project you can create several test cases,
It is important to know that after creating a test class it is necessary to extend the SeleniumHelperTest class and
implement the SeleniumHelper class

`SeleniumHelperTest` - Class to start initial test settings

`SeleniumHelper` - Class responsible for page element controls

The examples listed can serve as a pattern for your tests as it is based on components with separate interfaces.

### 📝 How to create my tests?

```java
    class MyTest extends SeleniumHelperTest implements SeleniumHelper {

    @Test
    void myTest() {
        navigate("https://www.selenium.dev/documentation");
        clickByLinkText("Create documentation issue");
        Assertions.assertEquals(getUrl(), "https://www.selenium.dev/documentation/");
    }
}
```

## 🔑 SeleniumHelper API

| Method                            | Parameters                    | Return           |
|-----------------------------------|-------------------------------|------------------|
| getDriver                         |                               | WebDriver        |
| getTitle                          |                               | String           |
| getUrl                            |                               | String           |
| navigate                          | String                        | String           |
| await                             | Function                      | void             |
| clearByClassName                  | String                        | void             |
| clearByClassName                  | String, Integer               | void             |
| clearByCss                        | String                        | void             |
| clearByCss                        | String, Integer               | void             |
| clearById                         | String                        | void             |
| clearByLinkText                   | String                        | void             |
| clearByLinkText                   | String, Integer               | void             |
| clearByName                       | String                        | void             |
| clearByName                       | String, Integer               | void             |
| clearByPartialLinkText            | String                        | void             |
| clearByPartialLinkText            | String, Integer               | void             |
| clearByTagName                    | String                        | void             |
| clearByTagName                    | String, Integer               | void             |
| clearByXpath                      | String                        | void             |
| clearByXpath                      | String, Integer               | void             |
| clickByClassName                  | String                        | void             |
| clickByClassName                  | String, Integer               | void             |
| clickByCss                        | String                        | void             |
| clickByCss                        | String, Integer               | void             |
| clickById                         | String                        | void             |
| clickByLinkText                   | String                        | void             |
| clickByLinkText                   | String, Integer               | void             |
| clickByName                       | String                        | void             |
| clickByName                       | String, Integer               | void             |
| clickByPartialLinkText            | String                        | void             |
| clickByPartialLinkText            | String, Integer               | void             |
| clickByTagName                    | String                        | void             |
| clickByTagName                    | String, Integer               | void             |
| clickByXpath                      | String                        | void             |
| clickByXpath                      | String, Integer               | void             |
| find                              | By                            | WebElement       |
| findByClassName                   | String                        | WebElement       |
| findByCss                         | String                        | WebElement       |
| findById                          | String                        | WebElement       |
| findByLinkText                    | String                        | WebElement       |
| findByName                        | String                        | WebElement       |
| findByPartialLinkText             | String                        | WebElement       |
| findByTagName                     | String                        | WebElement       |
| findByXpath                       | String                        | WebElement       |
| findAll                           | By                            | List<WebElement> |
| findAllByClassName                | String                        | List<WebElement> |
| findAllByCss                      | String                        | List<WebElement> |
| findAllByLinkText                 | String                        | List<WebElement> |
| findAllByName                     | String                        | List<WebElement> |
| findAllByPartialLinkText          | String                        | List<WebElement> |
| findAllByTagName                  | String                        | List<WebElement> |
| findAllByXpath                    | String                        | List<WebElement> |
| typeByClassName                   | String, CharSequence          | void             |
| typeByClassName                   | String, Integer, CharSequence | void             |
| typeByCss                         | String, CharSequence          | void             |
| typeByCss                         | String, Integer, CharSequence | void             |
| typeById                          | String, CharSequence          | void             |
| typeByLinkText                    | String, CharSequence          | void             |
| typeByLinkText                    | String, Integer, CharSequence | void             |
| typeByName                        | String, CharSequence          | void             |
| typeByName                        | String, Integer, CharSequence | void             |
| typeByPartialLinkText             | String, CharSequence          | void             |
| typeByPartialLinkText             | String, Integer, CharSequence | void             |
| typeByTagName                     | String, CharSequence          | void             |
| typeByTagName                     | String, Integer, CharSequence | void             |
| typeByXpath                       | String, CharSequence          | void             |
| typeByXpath                       | String, Integer, CharSequence | void             |
| waitInvisibility                  | WebElement                    | void             |
| waitInvisibility                  | List<WebElement>, Integer     | void             |
| waitInvisibilityByClassName       | String                        | void             |
| waitInvisibilityByClassName       | String, Integer               | void             |
| waitInvisibilityByCss             | String                        | void             |
| waitInvisibilityByCss             | String, Integer               | void             |
| waitInvisibilityById              | String                        | void             |
| waitInvisibilityByLinkText        | String                        | void             |
| waitInvisibilityByLinkText        | String, Integer               | void             |
| waitInvisibilityByName            | String                        | void             |
| waitInvisibilityByName            | String, Integer               | void             |
| waitInvisibilityByPartialLinkText | String                        | void             |
| waitInvisibilityByPartialLinkText | String, Integer               | void             |
| waitInvisibilityByTagName         | String                        | void             |
| waitInvisibilityByTagName         | String, Integer               | void             |
| waitInvisibilityByXpath           | String                        | void             |
| waitInvisibilityByXpath           | String, Integer               | void             |
| waitUrlContains                   | String                        | void             |
| waitVisibility                    | WebElement                    | void             |
| waitVisibility                    | List<WebElement>, Integer     | void             |
| waitVisibilityByClassName         | String                        | void             |
| waitVisibilityByClassName         | String, Integer               | void             |
| waitVisibilityByCss               | String                        | void             |
| waitVisibilityByCss               | String, Integer               | void             |
| waitVisibilityById                | String                        | void             |
| waitVisibilityByLinkText          | String                        | void             |
| waitVisibilityByLinkText          | String, Integer               | void             |
| waitVisibilityByName              | String                        | void             |
| waitVisibilityByName              | String, Integer               | void             |
| waitVisibilityByPartialLinkText   | String                        | void             |
| waitVisibilityByPartialLinkText   | String, Integer               | void             |
| waitVisibilityByTagName           | String                        | void             |
| waitVisibilityByTagName           | String, Integer               | void             |
| waitVisibilityByXpath             | String                        | void             |
| waitVisibilityByXpath             | String, Integer               | void             |

## 💻 Support

Selenium Helper uses the WebDriver Manager library that helps in the automatic installation of browser drivers. That way
browser support will be the same as what selenium supports.

### 📌 Which operating system does it support?

It has been tested on Linux only, you can test to see if it works on other OS.

## 💪 Contribution

Since the project is free to use as per the license, you can contribute new ideas and improvements, feel free to
comment, create a pull request or open an issue.

Contributions are always welcome!

See [`CONTRIBUTING.md`](CONTRIBUTING.md) for how to get started.

Please follow the [`CODE_OF_CONDUCT.md`](CODE_OF_CONDUCT.md) of this project.

## 🎥 Demo

Access the demo video and use [YouTube](https://youtu.be/4_xqpoCL5L4)

## 📄 License

[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](LICENSE.md )

## 📢 Author

- [@charleslana](https://www.github.com/charleslana)