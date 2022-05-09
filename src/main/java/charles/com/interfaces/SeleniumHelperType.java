package charles.com.interfaces;

import org.openqa.selenium.WebElement;

public interface SeleniumHelperType extends SeleniumHelperElement {

    default void typeByClassName(String className, CharSequence textToType) {
        sendKeys(findByClassName(className), textToType);
    }

    default void typeByClassName(String className, Integer classNameIndex, CharSequence textToType) {
        sendKeys(findAllByClassName(className).get(classNameIndex), textToType);
    }

    default void typeByCss(String css, CharSequence textToType) {
        sendKeys(findByCss(css), textToType);
    }

    default void typeByCss(String css, Integer cssIndex, CharSequence textToType) {
        sendKeys(findAllByCss(css).get(cssIndex), textToType);
    }

    default void typeById(String id, CharSequence textToType) {
        sendKeys(findById(id), textToType);
    }

    default void typeByLinkText(String linkText, CharSequence textToType) {
        sendKeys(findByLinkText(linkText), textToType);
    }

    default void typeByLinkText(String linkText, Integer linkTextIndex, CharSequence textToType) {
        sendKeys(findAllByLinkText(linkText).get(linkTextIndex), textToType);
    }

    default void typeByName(String name, CharSequence textToType) {
        sendKeys(findByName(name), textToType);
    }

    default void typeByName(String name, Integer nameIndex, CharSequence textToType) {
        sendKeys(findAllByName(name).get(nameIndex), textToType);
    }

    default void typeByPartialLinkText(String partialLinkText, CharSequence textToType) {
        sendKeys(findByPartialLinkText(partialLinkText), textToType);
    }

    default void typeByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex, CharSequence textToType) {
        sendKeys(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex), textToType);
    }

    default void typeByTagName(String tagName, CharSequence textToType) {
        sendKeys(findByTagName(tagName), textToType);
    }

    default void typeByTagName(String tagName, Integer tagNameIndex, CharSequence textToType) {
        sendKeys(findAllByTagName(tagName).get(tagNameIndex), textToType);
    }

    default void typeByXpath(String xpath, CharSequence textToType) {
        sendKeys(findByXpath(xpath), textToType);
    }

    default void typeByXpath(String xpath, Integer xpathIndex, CharSequence textToType) {
        sendKeys(findAllByXpath(xpath).get(xpathIndex), textToType);
    }

    private void sendKeys(WebElement webElement, CharSequence charSequence) {
        webElement.sendKeys(charSequence);
    }
}
