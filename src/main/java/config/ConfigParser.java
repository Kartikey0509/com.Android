package config;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigParser {
    private Properties properties;

    public ConfigParser() {
        // Create a system independent file path
        final Path configFile = Paths.get(
                System.getProperty("user.dir"),
                "src", "test", "resources", "config.properties"
        );
        try {
            InputStream fileReader = new FileInputStream(configFile.toString());
            properties = new Properties();
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public String get(final String key) {
        return properties.getProperty(key);
    }
}
