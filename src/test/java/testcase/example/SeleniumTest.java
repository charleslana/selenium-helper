package testcase.example;

import charles.com.interfaces.SeleniumHelper;
import charles.com.setup.SeleniumHelperSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testcase.example.components.SeleniumImplicitWaitComponent;
import testcase.example.components.TheInternetCheckboxComponent;
import testcase.example.pageobjects.TheInternetPage;

class SeleniumTest extends SeleniumHelperSetup implements SeleniumHelper, TheInternetCheckboxComponent, SeleniumImplicitWaitComponent {

    @Test
    void test1() {
        navigate("https://www.selenium.dev/");
        Assertions.assertTrue(getTitle().contains("Selenium"));
    }

    @Test
    void test2() {
        navigate("https://www.selenium.dev/downloads/");
        Assertions.assertTrue(getTitle().contains("Downloads"));
    }

    @Test
    void test3() {
        navigate("https://the-internet.herokuapp.com/login");
        typeById(TheInternetPage.USERNAME_FIELD_BY_ID, "tomsmith");
        typeByName(TheInternetPage.PASSWORD_FIELD_BY_NAME, "SuperSecretPassword!");
        clickByTagName(TheInternetPage.LOGIN_BUTTON_BY_TAG_NAME);
        Assertions.assertTrue(getUrl().contains("/secure"));
    }

    @Test
    void test4() {
        clickCheckbox();
    }

    @Test
    void test5() throws InterruptedException {
        searchImplicitWait();
    }
}
