package testcase.example.selenium.components;

import charles.com.interfaces.SeleniumHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import testcase.example.selenium.pageobjects.SeleniumPage;
import testcase.example.utils.UrlUtils;

public interface SeleniumWaitComponent extends SeleniumHelper {

    default void searchWait() {
        navigate(UrlUtils.URL_SELENIUM);
        clickByCss(SeleniumPage.SEARCH_BUTTON_BY_CSS);
        typeById(SeleniumPage.SEARCH_FIELD_BY_ID, "Waits");
        waitInvisibilityByClassName(SeleniumPage.SEARCH_EMPTY_BY_CLASSNAME);
        typeById(SeleniumPage.SEARCH_FIELD_BY_ID, Keys.ENTER);
        Assertions.assertTrue(getTitle().contains("Waits"));
    }
}
