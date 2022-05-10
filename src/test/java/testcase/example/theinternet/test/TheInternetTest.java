package testcase.example.theinternet.test;

import charles.com.interfaces.SeleniumHelper;
import charles.com.setup.SeleniumHelperSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testcase.example.theinternet.components.TheInternetABTestComponent;
import testcase.example.theinternet.pageobjects.TheInternetPage;
import testcase.example.utils.UrlUtils;

class TheInternetTest extends SeleniumHelperSetup implements SeleniumHelper, TheInternetABTestComponent {

    @Test
    void test1() {
        navigate(UrlUtils.URL_THE_INTERNET.concat("/context_menu"));
        Assertions.assertEquals("Context Menu", findByTagName(TheInternetPage.TITLE_BY_TAG_NAME).getText());
    }

    @Test
    void test2() {
        goToABTest();
    }
}
