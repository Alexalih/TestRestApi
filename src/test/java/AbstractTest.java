import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {
    static Properties prop =new Properties();
    private static InputStream config;
    private static String baseUrl;
    private static String apiKey;
    private static String searchRecipes;

    @BeforeAll
    static void unitTest() throws IOException {
     config = new FileInputStream("src/main/resources/my.properties");
     prop.load(config);
     baseUrl = prop.getProperty("baseUrl");
     apiKey = prop.getProperty("apiKey");
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getSearchRecipes() {
        return searchRecipes;
    }
}
