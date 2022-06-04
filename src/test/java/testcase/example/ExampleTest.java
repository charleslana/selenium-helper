package testcase.example;

import charles.com.annotation.Recorder;
import charles.com.interfaces.SeleniumHelper;
import charles.com.setup.SeleniumHelperTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testcase.example.jqueryui.pageobjects.JQueryUiPage;
import testcase.example.lambdatest.pageobjects.LambdaTestPage;
import testcase.example.letcode.pageobjects.LetCodePage;
import testcase.example.prime.PrimeAutocompleteHelper;
import testcase.example.prime.PrimeCalendarHelper;
import testcase.example.prime.PrimeDropdownHelper;
import testcase.example.selenium.components.SeleniumWaitComponent;
import testcase.example.selenium.pageobjects.SeleniumPage;
import testcase.example.theinternet.components.TheInternetCheckboxComponent;
import testcase.example.theinternet.pageobjects.TheInternetPage;
import testcase.example.utils.UrlUtils;

import java.time.LocalDate;

class ExampleTest extends SeleniumHelperTest implements SeleniumHelper, SeleniumWaitComponent, TheInternetCheckboxComponent {

    @Test
    void testGoToSelenium() {
        navigate(UrlUtils.URL_SELENIUM);
        Assertions.assertTrue(getTitle().contains("Selenium"));
    }

    @Test
    void testGoToDownload() {
        navigate(UrlUtils.URL_SELENIUM.concat("/downloads"));
        Assertions.assertTrue(getTitle().contains("Downloads"));
    }

    @Test
    @Recorder
    void loginTest() {
        navigate(UrlUtils.URL_THE_INTERNET.concat("/login"));
        typeById(TheInternetPage.USERNAME_FIELD_BY_ID, "tomsmith");
        typeByName(TheInternetPage.PASSWORD_FIELD_BY_NAME, "SuperSecretPassword!");
        clickByTagName(TheInternetPage.LOGIN_BUTTON_BY_TAG_NAME);
        Assertions.assertTrue(getUrl().contains("/secure"));
    }

    @Test
    void checkboxTest() {
        clickCheckbox();
    }

    @Test
    void searchTest() {
        searchWait();
    }

    @Test
    void dropdownTest() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/dropdown"));
        PrimeDropdownHelper prime = new PrimeDropdownHelper();
        prime.click(0);
    }

    @Test
    void autocompleteTest() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/autocomplete"));
        PrimeAutocompleteHelper prime = new PrimeAutocompleteHelper();
        prime.type(1, "Brazil");
    }

    @Test
    void calendarTest() {
        navigate(UrlUtils.URL_PRIMEFACES.concat("/primeng/calendar"));
        PrimeCalendarHelper prime = new PrimeCalendarHelper();
        prime.selectDatePopup(13, LocalDate.of(2000, 12, 31));
    }

    @Disabled
    void skippedTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/support"));
        Assertions.assertTrue(getDriver().getTitle().contains("Support"));
    }

    @Test
    void errorTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/error"));
        clickByLinkText(SeleniumPage.ACTION_CREATE_ISSUE_BY_LINK_TEXT);
        Assertions.assertEquals(getUrl(), UrlUtils.URL_SELENIUM.concat("/documentation/"));
    }

    @Test
    void newWindowTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/documentation/webdriver/browser/windows"));
        clickByLinkText(SeleniumPage.ACTION_NEW_WINDOW_BY_LINK_TEXT);
        await(ExpectedConditions.numberOfWindowsToBe(2));
        switchWindow();
        Assertions.assertEquals("Selenium", getTitle());
    }

    @Test
    void defaultWindowTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/documentation/webdriver/browser/windows"));
        clickByLinkText(SeleniumPage.ACTION_NEW_WINDOW_BY_LINK_TEXT);
        await(ExpectedConditions.numberOfWindowsToBe(2));
        switchWindow();
        Assertions.assertEquals("Selenium", getTitle());
        switchWindow();
        Assertions.assertEquals("Working with windows and tabs | Selenium", getTitle());
    }

    @Test
    void frameTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/selenium/docs/api/java/index.html?overview-summary.html"));
        switchFrame(SeleniumPage.PACKAGE_LIST_FRAME_BY_NAME);
        clickByLinkText(SeleniumPage.ACTION_ORG_OPENQA_SELENIUM_BY_LINK_TEXT);
        switchFrame();
        switchFrame(2);
        clickByLinkText(SeleniumPage.ACTION_HELP_BY_LINK_TEXT);
        sleep(1000);
    }

    @Test
    void moveTest() {
        navigate(UrlUtils.URL_LAMBDA_TEST);
        move(findByXpath(LambdaTestPage.ACTION_DEVELOPERS_BY_XPATH));
        clickByXpath(LambdaTestPage.ACTION_API_BY_XPATH);
        Assertions.assertEquals(UrlUtils.URL_LAMBDA_TEST.concat("/support/api-doc/"), getUrl());
    }

    @Test
    void dragDropTest() {
        navigate(UrlUtils.URL_LET_CODE.concat("/dropable"));
        dragDrop(findById(LetCodePage.DRAGGABLE_BY_ID), findById(LetCodePage.DROPPABLE_BY_ID));
        sleep(1000);
    }

    @Test
    @Recorder(name = "Should be draggable")
    void testDragDropByLocation() {
        navigate(UrlUtils.URL_JQUERYUI.concat("/draggable"));
        switchFrame(0);
        dragDropByLocation(findById(JQueryUiPage.DRAGGABLE_BY_ID), 50, 20);
        sleep(1000);
    }

    @Test
    @Recorder
    void navigateTest() {
        navigate(UrlUtils.URL_SELENIUM);
        navigateTo(UrlUtils.URL_THE_INTERNET);
        navigateBack();
        navigateForward();
    }

    @Test
    void alertTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/documentation/webdriver/browser/alerts"));
        clickByLinkText(SeleniumPage.ACTION_EXAMPLE_ALERT_BY_LINK_TEXT);
        await(ExpectedConditions.alertIsPresent());
        alertAccept();
    }

    @Test
    void confirmTest() {
        navigate(UrlUtils.URL_SELENIUM.concat("/documentation/webdriver/browser/alerts"));
        clickByLinkText(SeleniumPage.ACTION_EXAMPLE_CONFIRM_BY_LINK_TEXT);
        await(ExpectedConditions.alertIsPresent());
        Assertions.assertEquals("Are you sure?", getAlertText());
        alertDismiss();
    }

    @Test
    void promptTest() {
        navigate(UrlUtils.URL_THE_INTERNET.concat("/javascript_alerts"));
        clickByXpath(TheInternetPage.BUTTON_PROMPT_BY_XPATH);
        await(ExpectedConditions.alertIsPresent());
        typeAlert("Test");
        alertAccept();
        Assertions.assertEquals("You entered: Test", findById(TheInternetPage.RESULT_BY_ID).getText());
    }
}
