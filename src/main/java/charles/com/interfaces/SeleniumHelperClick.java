package charles.com.interfaces;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface SeleniumHelperClick extends SeleniumHelperElement {

    default void click(WebElement element) {
        element.click();
    }

    default void click(List<WebElement> element, Integer clickIndex) {
        element.get(clickIndex).click();
    }

    default void clickByClassName(String className) {
        findByClassName(className).click();
    }

    default void clickByClassName(String className, Integer classNameIndex) {
        findAllByClassName(className).get(classNameIndex).click();
    }

    default void clickByCss(String css) {
        findByCss(css).click();
    }

    default void clickByCss(String css, Integer cssIndex) {
        findAllByCss(css).get(cssIndex).click();
    }

    default void clickById(String id) {
        findById(id).click();
    }

    default void clickByLinkText(String linkText) {
        findByLinkText(linkText).click();
    }

    default void clickByLinkText(String linkText, Integer linkTextIndex) {
        findAllByLinkText(linkText).get(linkTextIndex).click();
    }

    default void clickByName(String name) {
        findByName(name).click();
    }

    default void clickByName(String name, Integer nameIndex) {
        findAllByName(name).get(nameIndex).click();
    }

    default void clickByPartialLinkText(String partialLinkText) {
        findByPartialLinkText(partialLinkText).click();
    }

    default void clickByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).click();
    }

    default void clickByTagName(String tagName, Integer tagNameIndex) {
        findAllByTagName(tagName).get(tagNameIndex).click();
    }

    default void clickByTagName(String tagName) {
        findByTagName(tagName).click();
    }

    default void clickByXpath(String xpath) {
        findByXpath(xpath).click();
    }

    default void clickByXpath(String xpath, Integer xpathIndex) {
        findAllByXpath(xpath).get(xpathIndex).click();
    }
}
