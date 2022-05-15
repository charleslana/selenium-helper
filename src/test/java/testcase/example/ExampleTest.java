package testcase.example;

import charles.com.interfaces.SeleniumHelper;
import charles.com.setup.SeleniumHelperSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testcase.example.prime.PrimeAutocompleteHelper;
import testcase.example.prime.PrimeCalendarHelper;
import testcase.example.prime.PrimeDropdownHelper;
import testcase.example.selenium.components.SeleniumWaitComponent;
import testcase.example.theinternet.components.TheInternetCheckboxComponent;
import testcase.example.theinternet.pageobjects.TheInternetPage;
import testcase.example.utils.UrlUtils;

import java.time.LocalDate;

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

    @Test
    void test6() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/dropdown"));
        PrimeDropdownHelper prime = new PrimeDropdownHelper();
        prime.click(0);
    }

    @Test
    void test7() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/autocomplete"));
        PrimeAutocompleteHelper prime = new PrimeAutocompleteHelper();
        prime.type(1, "Brazil");
    }

    @Test
    void test8() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/calendar"));
        PrimeCalendarHelper prime = new PrimeCalendarHelper();
        prime.selectDatePopup(13, LocalDate.of(2000, 12, 31));
    }
}
