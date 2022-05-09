package charles.com.interfaces;

public interface SeleniumHelperGetText extends SeleniumHelperElement {

    default String getTextByClassName(String className) {
        return findByClassName(className).getText();
    }

    default String getTextByClassName(String className, Integer classNameIndex) {
        return findAllByClassName(className).get(classNameIndex).getText();
    }

    default String getTextByCss(String css) {
        return findByCss(css).getText();
    }

    default String getTextByCss(String css, Integer cssIndex) {
        return findAllByCss(css).get(cssIndex).getText();
    }

    default String getTextById(String id) {
        return findById(id).getText();
    }

    default String getTextByLinkText(String linkText) {
        return findByLinkText(linkText).getText();
    }

    default String getTextByLinkText(String linkText, Integer linkTextIndex) {
        return findAllByLinkText(linkText).get(linkTextIndex).getText();
    }

    default String getTextByName(String name) {
        return findByName(name).getText();
    }

    default String getTextByName(String name, Integer nameIndex) {
        return findAllByName(name).get(nameIndex).getText();
    }

    default String getTextByPartialLinkText(String partialLinkText) {
        return findByPartialLinkText(partialLinkText).getText();
    }

    default String getTextByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        return findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).getText();
    }

    default String getTextByTagName(String tagName) {
        return findByTagName(tagName).getText();
    }

    default String getTextByTagName(String tagName, Integer tagNameIndex) {
        return findAllByTagName(tagName).get(tagNameIndex).getText();
    }

    default String getTextByXpath(String xpath) {
        return findByXpath(xpath).getText();
    }

    default String getTextByXpath(String xpath, Integer xpathIndex) {
        return findAllByXpath(xpath).get(xpathIndex).getText();
    }
}
