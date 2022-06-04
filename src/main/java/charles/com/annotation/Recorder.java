package charles.com.annotation;

import charles.com.extension.RecorderExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation responsible for recorder video
 *
 * @author Charles Lana
 * @version 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RecorderExtension.class)
public @interface Recorder {

    /**
     * Method to get the name
     *
     * @return String
     */
    String name() default "Test";
}
