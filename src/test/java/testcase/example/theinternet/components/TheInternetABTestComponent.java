package testcase.example.theinternet.components;

import org.junit.jupiter.api.Assertions;
import testcase.example.theinternet.commons.TheInternetCommons;
import testcase.example.utils.UrlUtils;

public interface TheInternetABTestComponent extends TheInternetCommons {

    default void goToABTest() {
        navigate(UrlUtils.URL_THE_INTERNET);
        clickNavigateLink("A/B Testing");
        Assertions.assertTrue(getUrl().contains("/abtest"));
    }
}
