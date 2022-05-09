package testcase.example.theinternet.commons;

import charles.com.interfaces.SeleniumHelper;

public interface TheInternetCommons extends SeleniumHelper {

    default void clickNavigateLink(String linkText) {
        clickByLinkText(linkText);
    }
}
