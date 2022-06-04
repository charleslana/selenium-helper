package charles.com.extension;

import charles.com.annotation.Recorder;
import charles.com.factory.RecorderFactory;
import charles.com.properties.PropertiesOperations;
import charles.com.setup.RecorderSetup;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

public class RecorderExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        RecorderFactory.getInstance().removeRecorderObject();
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        if (!Boolean.parseBoolean(PropertiesOperations.getPropertyValueByKey("headless"))) {
            Method method = context.getTestMethod().orElseThrow();
            Recorder recorder = method.getAnnotation(Recorder.class);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsConfiguration);
            Rectangle captureSize = new Rectangle(0, 0, screenSize.width, screenSize.height - insets.bottom);
            RecorderSetup screenRecorder = new RecorderSetup(graphicsConfiguration, captureSize, new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI), new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60), new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)), null, new File(System.getProperty("user.dir").concat(String.format("%ssrc%stest%sresources%svideo", File.separator, File.separator, File.separator, File.separator))), recorder.name());
            RecorderFactory.getInstance().setRecorder(screenRecorder);
            screenRecorder.start();
        }
    }
}
