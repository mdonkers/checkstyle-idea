package org.infernus.idea.checkstyle.model;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * A configuration file accessible via the IDE classpath.
 */
public class ClassPathConfigurationLocation extends ConfigurationLocation {

    /**
     * Create a new classpath configuration.
     */
    ClassPathConfigurationLocation() {
        super(ConfigurationType.CLASSPATH);
    }

    @NotNull
    protected InputStream resolveFile() throws IOException {
        final InputStream in = ClassPathConfigurationLocation.class.getResourceAsStream(getLocation());
        if (in == null) {
            throw new IOException("Invalid classpath location: " + getLocation());
        }

        return in;
    }

    @Override
    public Object clone() {
        return cloneCommonPropertiesTo(new ClassPathConfigurationLocation());
    }
}
