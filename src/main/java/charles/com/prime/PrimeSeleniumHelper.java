package charles.com.prime;

import charles.com.factory.DriverFactory;
import charles.com.interfaces.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PrimeSeleniumHelper implements SeleniumHelper {

    public PrimeSeleniumHelper() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(className = "p-autocomplete-input")
    private List<WebElement> autoCompleteInput;
    @FindBy(className = "p-autocomplete-item")
    private List<WebElement> autoCompleteItem;
    @FindBy(className = "p-autocomplete-panel")
    private WebElement autoCompletePanel;
    @FindBy(className = "p-dropdown")
    private List<WebElement> dropdown;
    @FindBy(className = "p-dropdown-item")
    private List<WebElement> dropdownItem;
    @FindBy(className = "p-dropdown-items-wrapper")
    private WebElement dropdownItemsWrapper;

    public void clickDropdown(Integer dropdownItemIndex) {
        clickDropdown(0, dropdownItemIndex);
    }

    public void clickDropdown(Integer dropdownIndex, Integer dropdownItemIndex) {
        click(dropdown, dropdownIndex);
        waitVisibility(dropdownItemsWrapper);
        click(dropdownItem, dropdownItemIndex);
        waitInvisibility(dropdownItemsWrapper);
    }

    public void typeAutocomplete(String textToType) {
        typeAutocomplete(0, textToType);
    }

    public void typeAutocomplete(Integer autoCompleteIndex, String textToType) {
        type(autoCompleteInput.get(autoCompleteIndex), textToType);
        waitVisibility(autoCompletePanel);
        click(autoCompleteItem, 0);
        waitInvisibility(autoCompletePanel);
    }
}
