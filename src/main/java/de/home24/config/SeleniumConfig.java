package de.home24.config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Ayzat on 20.12.2016.
 */
@Configuration
public class SeleniumConfig {

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws InterruptedException {
        String webDriver = environment.getRequiredProperty("webdriver.driver").toLowerCase();

        if (webDriver.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        } else if (webDriver.equals("firefox")) {
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver();
        } else {
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        }
    }
}
