package charles.com.setup;

import charles.com.properties.PropertiesOperations;
import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecorderSetup extends ScreenRecorder {

    public RecorderSetup(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    private final String name;

    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException(String.format("%s is not a directory.", movieFolder));
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(PropertiesOperations.getPropertyValueByKey("report-datetime-format"));
        return new File(movieFolder, name.concat("-").concat(dateFormat.format(new Date())).concat(".").concat(Registry.getInstance().getExtension(fileFormat)));
    }
}
