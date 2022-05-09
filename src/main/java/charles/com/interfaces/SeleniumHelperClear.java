package charles.com.interfaces;

public interface SeleniumHelperClear extends SeleniumHelperElement {

    default void clearByClassName(String className) {
        findByClassName(className).clear();
    }

    default void clearByClassName(String className, Integer classNameIndex) {
        findAllByClassName(className).get(classNameIndex).clear();
    }

    default void clearByCss(String css) {
        findByCss(css).clear();
    }

    default void clearByCss(String css, Integer cssIndex) {
        findAllByCss(css).get(cssIndex).clear();
    }

    default void clearById(String id) {
        findById(id).clear();
    }

    default void clearByLinkText(String linkText) {
        findByLinkText(linkText).clear();
    }

    default void clearByLinkText(String linkText, Integer linkTextIndex) {
        findAllByLinkText(linkText).get(linkTextIndex).clear();
    }

    default void clearByName(String name) {
        findByName(name).clear();
    }

    default void clearByName(String name, Integer nameIndex) {
        findAllByName(name).get(nameIndex).clear();
    }

    default void clearByPartialLinkText(String partialLinkText) {
        findByPartialLinkText(partialLinkText).clear();
    }

    default void clearByPartialLinkText(String partialLinkText, Integer partialLinkTextIndex) {
        findAllByPartialLinkText(partialLinkText).get(partialLinkTextIndex).clear();
    }

    default void clearByTagName(String tagName) {
        findByTagName(tagName).clear();
    }

    default void clearByTagName(String tagName, Integer tagNameIndex) {
        findAllByTagName(tagName).get(tagNameIndex).clear();
    }

    default void clearByXpath(String xpath) {
        findByXpath(xpath).clear();
    }

    default void clearByXpath(String xpath, Integer xpathIndex) {
        findAllByXpath(xpath).get(xpathIndex).clear();
    }
}
