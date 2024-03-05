package homeWork2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class HomeWork2AbstractTest {
    @BeforeEach
    void init() {

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Map<String, Object> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableLog", true);
        Configuration.browserCapabilities.setCapability("selenoid:options", options);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        open("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void finish() {
        WebDriverRunner.closeWebDriver();
    }
}
