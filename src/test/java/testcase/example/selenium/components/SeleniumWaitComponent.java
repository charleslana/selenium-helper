package testcase.example.selenium.components;

import charles.com.interfaces.SeleniumHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import testcase.example.selenium.pageobjects.SeleniumPage;
import testcase.example.utils.UrlUtils;

public interface SeleniumWaitComponent extends SeleniumHelper {

    default void searchWait() {
        navigate(UrlUtils.URL_SELENIUM);
        clearByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME);
        typeByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME, "Waits");
        waitVisibilityByClassName(SeleniumPage.DROPDOWN_MENU_SEARCH_BY_CLASSNAME);
        typeByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME, Keys.ENTER);
        Assertions.assertTrue(getTitle().contains("Waits"));
    }
}
