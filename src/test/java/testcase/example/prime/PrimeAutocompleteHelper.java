package testcase.example.prime;

import charles.com.factory.DriverFactory;
import charles.com.interfaces.SeleniumHelperWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PrimeAutocompleteHelper implements SeleniumHelperWait {

    public PrimeAutocompleteHelper() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(className = "p-autocomplete-input")
    private List<WebElement> autoCompleteInputs;
    @FindBy(className = "p-autocomplete-item")
    private List<WebElement> autoCompleteItems;
    @FindBy(className = "p-autocomplete-panel")
    private WebElement autoCompletePanel;

    public void type(String textToType) {
        type(0, textToType);
    }

    public void type(Integer autoCompleteIndex, String textToType) {
        autoCompleteInputs.get(autoCompleteIndex).sendKeys(textToType);
        waitVisibility(autoCompletePanel);
        autoCompleteItems.get(0).click();
        waitInvisibility(autoCompletePanel);
    }
}
