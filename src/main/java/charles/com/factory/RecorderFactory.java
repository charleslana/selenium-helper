package charles.com.factory;

import charles.com.setup.RecorderSetup;

import java.io.IOException;

public class RecorderFactory {

    private RecorderFactory() {
    }

    private static final RecorderFactory instance = new RecorderFactory();
    ThreadLocal<RecorderSetup> recorder = new ThreadLocal<>();

    public RecorderSetup getRecorder() {
        return recorder.get();
    }

    public void setRecorder(RecorderSetup recorderSetupObject) {
        recorder.set(recorderSetupObject);
    }

    public void removeRecorderObject() throws IOException {
        if (getRecorder() != null) {
            recorder.get().stop();
            recorder.remove();
        }
    }

    public static RecorderFactory getInstance() {
        return instance;
    }
}
