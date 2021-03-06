package testcase.example.prime;

import charles.com.factory.DriverFactory;
import charles.com.interfaces.SeleniumHelperWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PrimeDropdownHelper implements SeleniumHelperWait {

    public PrimeDropdownHelper() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(className = "p-dropdown-item")
    private List<WebElement> dropdownItems;
    @FindBy(className = "p-dropdown-items-wrapper")
    private WebElement dropdownItemsWrapper;
    @FindBy(className = "p-dropdown")
    private List<WebElement> dropdowns;

    public void click(Integer dropdownItemIndex) {
        click(0, dropdownItemIndex);
    }

    public void click(Integer dropdownIndex, Integer dropdownItemIndex) {
        dropdowns.get(dropdownIndex).click();
        waitVisibility(dropdownItemsWrapper);
        dropdownItems.get(dropdownItemIndex).click();
        waitInvisibility(dropdownItemsWrapper);
    }
}
