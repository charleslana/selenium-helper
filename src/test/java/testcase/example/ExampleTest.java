package testcase.example;

import charles.com.interfaces.SeleniumHelper;
import charles.com.setup.SeleniumHelperSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testcase.example.selenium.components.SeleniumWaitComponent;
import testcase.example.theinternet.components.TheInternetCheckboxComponent;
import testcase.example.theinternet.pageobjects.TheInternetPage;
import testcase.example.utils.UrlUtils;

class ExampleTest extends SeleniumHelperSetup implements SeleniumHelper, SeleniumWaitComponent, TheInternetCheckboxComponent {

    @Test
    void test1() {
        navigate(UrlUtils.URL_SELENIUM);
        Assertions.assertTrue(getTitle().contains("Selenium"));
    }

    @Test
    void test2() {
        navigate(UrlUtils.URL_SELENIUM.concat("/downloads"));
        Assertions.assertTrue(getTitle().contains("Downloads"));
    }

    @Test
    void test3() {
        navigate(UrlUtils.URL_THE_INTERNET.concat("/login"));
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
    void test5() {
        searchWait();
    }
}
