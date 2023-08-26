package com.udemy.spring.springseleniumpractice.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    public WebDriver chromeDriver() {

//        WebDriverManager.chromedriver().browserVersion("114.0.5735.199").setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        return new ChromeDriver(options);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setAcceptInsecureCerts(true);
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(cp);
//        WebDriverManager.chromedriver().browserVersion("114.0.5735.199").setup();
//        WebDriverManager.chromedriver().browserVersion("116.0.5845.97").setup();
        String propertiesPath = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\";
        System.setProperty("webdriver.chrome.driver", propertiesPath + "chromedriver.exe");
        return new ChromeDriver(chromeOptions);

        /*
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.setAcceptInsecureCerts(true);
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(cp);

        String propertiesPath = System.getProperty("user.dir") + "\\src\\test\\drivers\\";
        System.setProperty("webdriver.chrome.driver", propertiesPath + "chromedriver.exe");
        this.driver = new ChromeDriver(chromeOptions);
        */


    }
    //ChromeDriver 114.0.5735.16
    //114.0.5735.199

    /*@Bean
public WebDriver chromeDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");
    chromeOptions.setAcceptInsecureCerts(true);
    DesiredCapabilities cp = new DesiredCapabilities();
    cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    chromeOptions.merge(cp);
    WebDriverManager.chromedriver().browserVersion("114.0.5735.199").setup();
    return new ChromeDriver(chromeOptions);
    */

//    @Bean
//    public EdgeDriver edgeDriver() {
//        WebDriverManager.edgedriver().browserVersion("114.0.1823.67").setup();
//        return new EdgeDriver();
//    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }

}
