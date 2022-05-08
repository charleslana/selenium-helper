package testcase.example.components;

import charles.com.interfaces.SeleniumHelper;
import charles.com.interfaces.SeleniumHelperElements;
import org.junit.jupiter.api.Assertions;
import testcase.example.pageobjects.TheInternetPage;

public interface TheInternetCheckboxComponent extends SeleniumHelper, SeleniumHelperElements {

    default void clickCheckbox() {
        navigate("https://the-internet.herokuapp.com/checkboxes");
        clickByTagName(TheInternetPage.CHECKBOX_FIELD_BY_TAG_NAME, 0);
        Assertions.assertTrue(findAllByTagName(TheInternetPage.CHECKBOX_FIELD_BY_TAG_NAME).get(0).isSelected());
    }
}
