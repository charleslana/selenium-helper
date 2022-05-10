package charles.com.interfaces;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public interface SeleniumHelperWait extends SeleniumHelperAwait, SeleniumHelperElement {

    default void waitInvisibility(WebElement element) {
        await(ExpectedConditions.invisibilityOf(element));
    }

    default void waitInvisibility(List<WebElement> element, Integer invisibilityIndex) {
        await(ExpectedConditions.invisibilityOf(element.get(invisibilityIndex)));
    }

    default void waitInvisibilityByClassName(String className) {
        await(ExpectedConditions.invisibilityOf(findByClassName(className)));
    }

    default void waitInvisibilityByClassName(String className, Integer classNameIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByClassName(className).get(classNameIndex)));
    }

    default void waitInvisibilityByCss(String css) {
        await(ExpectedConditions.invisibilityOf(findByCss(css)));
    }

    default void waitInvisibilityByCss(String css, Integer cssIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByCss(css).get(cssIndex)));
    }

    default void waitInvisibilityById(String id) {
        await(ExpectedConditions.invisibilityOf(findById(id)));
    }

    default void waitInvisibilityByLinkText(String linkText) {
        await(ExpectedConditions.invisibilityOf(findByLinkText(linkText)));
    }

    default void waitInvisibilityByLinkText(String linkText, Integer linkTextIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByLinkText(linkText).get(linkTextIndex)));
    }

    default void waitInvisibilityByName(String name) {
        await(ExpectedConditions.invisibilityOf(findByName(name)));
    }

    default void waitInvisibilityByName(String name, Integer nameIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByName(name).get(nameIndex)));
    }

    default void waitInvisibilityByPartialLinkText(String partialLinkText) {
        await(ExpectedConditions.invisibilityOf(findByPartialLinkText(partialLinkText)));
    }

    default void waitInvisibilityByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex)));
    }

    default void waitInvisibilityByTagName(String tagName) {
        await(ExpectedConditions.invisibilityOf(findByTagName(tagName)));
    }

    default void waitInvisibilityByTagName(String tagName, Integer tagNameIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByTagName(tagName).get(tagNameIndex)));
    }

    default void waitInvisibilityByXpath(String xpath) {
        await(ExpectedConditions.invisibilityOf(findByXpath(xpath)));
    }

    default void waitInvisibilityByXpath(String xpath, Integer xpathIndex) {
        await(ExpectedConditions.invisibilityOf(findAllByXpath(xpath).get(xpathIndex)));
    }

    default void waitVisibility(WebElement element) {
        await(ExpectedConditions.visibilityOf(element));
    }

    default void waitVisibility(List<WebElement> element, Integer visibilityIndex) {
        await(ExpectedConditions.visibilityOf(element.get(visibilityIndex)));
    }

    default void waitVisibilityByClassName(String className) {
        await(ExpectedConditions.visibilityOf(findByClassName(className)));
    }

    default void waitVisibilityByClassName(String className, Integer classNameIndex) {
        await(ExpectedConditions.visibilityOf(findAllByClassName(className).get(classNameIndex)));
    }

    default void waitVisibilityByCss(String css) {
        await(ExpectedConditions.visibilityOf(findByCss(css)));
    }

    default void waitVisibilityByCss(String css, Integer cssIndex) {
        await(ExpectedConditions.visibilityOf(findAllByCss(css).get(cssIndex)));
    }

    default void waitVisibilityById(String id) {
        await(ExpectedConditions.visibilityOf(findById(id)));
    }

    default void waitVisibilityByLinkText(String linkText) {
        await(ExpectedConditions.visibilityOf(findByLinkText(linkText)));
    }

    default void waitVisibilityByLinkText(String linkText, Integer linkTextIndex) {
        await(ExpectedConditions.visibilityOf(findAllByLinkText(linkText).get(linkTextIndex)));
    }

    default void waitVisibilityByName(String name) {
        await(ExpectedConditions.visibilityOf(findByName(name)));
    }

    default void waitVisibilityByName(String name, Integer nameIndex) {
        await(ExpectedConditions.visibilityOf(findAllByName(name).get(nameIndex)));
    }

    default void waitVisibilityByPartialLinkText(String partialLinkText) {
        await(ExpectedConditions.visibilityOf(findByPartialLinkText(partialLinkText)));
    }

    default void waitVisibilityByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        await(ExpectedConditions.visibilityOf(findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex)));
    }

    default void waitVisibilityByTagName(String tagName) {
        await(ExpectedConditions.visibilityOf(findByTagName(tagName)));
    }

    default void waitVisibilityByTagName(String tagName, Integer tagNameIndex) {
        await(ExpectedConditions.visibilityOf(findAllByTagName(tagName).get(tagNameIndex)));
    }

    default void waitVisibilityByXpath(String xpath) {
        await(ExpectedConditions.visibilityOf(findByXpath(xpath)));
    }

    default void waitVisibilityByXpath(String xpath, Integer xpathIndex) {
        await(ExpectedConditions.visibilityOf(findAllByXpath(xpath).get(xpathIndex)));
    }
}
