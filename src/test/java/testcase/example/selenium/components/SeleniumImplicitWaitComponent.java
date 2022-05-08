package testcase.example.selenium.components;

import charles.com.interfaces.SeleniumHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import testcase.example.selenium.pageobjects.SeleniumPage;

public interface SeleniumImplicitWaitComponent extends SeleniumHelper {

    default void searchImplicitWait() {
        navigate("https://www.selenium.dev/");
        clearByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME);
        typeByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME, "Implicit wait");
        waitVisibilityByClassName(SeleniumPage.DROPDOWN_MENU_SEARCH_BY_CLASSNAME);
        typeByClassName(SeleniumPage.SEARCH_FIELD_BY_CLASSNAME, Keys.ENTER);
        Assertions.assertTrue(getTitle().contains("Waits"));
    }
}
