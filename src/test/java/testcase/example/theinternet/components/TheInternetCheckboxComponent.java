package testcase.example.theinternet.components;

import charles.com.interfaces.SeleniumHelper;
import org.junit.jupiter.api.Assertions;
import testcase.example.theinternet.pageobjects.TheInternetPage;
import testcase.example.utils.UrlUtils;

public interface TheInternetCheckboxComponent extends SeleniumHelper {

    default void clickCheckbox() {
        navigate(UrlUtils.URL_THE_INTERNET.concat("/checkboxes"));
        clickByTagName(TheInternetPage.CHECKBOX_FIELD_BY_TAG_NAME, 0);
        Assertions.assertTrue(findAllByTagName(TheInternetPage.CHECKBOX_FIELD_BY_TAG_NAME).get(0).isSelected());
    }
}
