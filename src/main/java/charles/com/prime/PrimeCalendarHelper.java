package charles.com.prime;

import charles.com.factory.DriverFactory;
import charles.com.interfaces.SeleniumHelperClick;
import charles.com.interfaces.SeleniumHelperWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class PrimeCalendarHelper implements SeleniumHelperClick, SeleniumHelperWait {

    public PrimeCalendarHelper() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }

    @FindBy(className = "p-calendar")
    private List<WebElement> calendars;
    @FindBy(className = "p-datepicker-calendar")
    private List<WebElement> datepickerCalendars;
    @FindBy(css = ".p-datepicker-calendar td > span:not(.p-disabled)")
    private List<WebElement> datepickerDays;
    @FindBy(className = "p-datepicker-year")
    private List<WebElement> datepickerYears;
    @FindBy(className = "p-monthpicker")
    private WebElement monthPicker;
    @FindBy(className = "p-monthpicker-month")
    private List<WebElement> monthPickerMonths;
    @FindBy(className = "p-yearpicker")
    private WebElement yearPicker;
    @FindBy(className = "p-yearpicker-year")
    private List<WebElement> yearPickerYears;

    public void selectDatePopup(LocalDate date) {
        selectDatePopup(0, date);
    }

    public void selectDatePopup(Integer calendarIndex, LocalDate date) {
        click(calendars.get(calendarIndex));
        waitVisibility(datepickerCalendars.get(0));
        click(datepickerYears, 0);
        waitVisibility(yearPicker);
        selectYearPicker(date);
        waitInvisibility(yearPicker);
        waitVisibility(monthPicker);
        selectMonthPicker(date);
        waitInvisibility(monthPicker);
        selectDayPicker(date);
        waitInvisibility(datepickerCalendars.get(0));
    }

    private void selectDayPicker(LocalDate date) {
        for (WebElement day : datepickerDays) {
            if (day.getText().equals(String.valueOf(date.getDayOfMonth()))) {
                click(day);
                break;
            }
        }
    }

    private void selectMonthPicker(LocalDate date) {
        for (WebElement month : monthPickerMonths) {
            if (month.getText().equalsIgnoreCase(date.getMonth().toString())) {
                click(month);
                break;
            }
        }
    }

    private void selectYearPicker(LocalDate date) {
        for (WebElement year : yearPickerYears) {
            if (year.getText().equals(String.valueOf(date.getYear()))) {
                click(year);
                break;
            }
        }
    }
}
