package charles.com.utils;

public class FunctionUtils {

    private FunctionUtils() {
    }

    public static String getResourcesWebDriverDir() {
        return System.getProperty("user.dir").concat("/src/main/resources/webdriver/");
    }
}
