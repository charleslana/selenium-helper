package charles.com.factory;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    private ExtentFactory() {
    }

    private static final ExtentFactory instance = new ExtentFactory();
    ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

    public ExtentTest getExtent() {
        return extent.get();
    }

    public void setExtent(ExtentTest extentTestObject) {
        extent.set(extentTestObject);
    }

    public void removeExtentObject() {
        extent.remove();
    }

    public static ExtentFactory getInstance() {
        return instance;
    }
}
