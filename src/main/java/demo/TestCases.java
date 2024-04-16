package demo;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.click();
        searchBox.sendKeys("calculator");
        searchBox.sendKeys(Keys.ENTER);
        String HomePageUrl = driver.getCurrentUrl();
        if (HomePageUrl.contains("calculator")) {
            System.out.println("Google Calculator loaded");
        } else {
            System.out.println("Google Calculator not loaded");
        }
        WebElement initilaDisplay = driver.findElement(By.id("cwos"));
        String initilaDisplayText = initilaDisplay.getText();
        if (Integer.parseInt(initilaDisplayText) == 0) {
            System.out.println("initial display shows zero(0)");
            System.out.println("TestCase Passed");
        } else {
            System.out.println("Initial display not showing zero(0)");
            System.out.println("TestCase failed");
        }

        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.click();
        searchBox.sendKeys("calculator");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // Addition operation
        driver.findElement(By.xpath("//div[@jsname='Ax5wH']")).click();
        driver.findElement(By.xpath("//div[@aria-label='plus']")).click();
        driver.findElement(By.xpath("//div[@jsname='rk7bOd']")).click();
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        WebElement addResult = driver.findElement(By.id("cwos"));
        String addResultText = addResult.getText();
        if (Integer.parseInt(addResultText) == 12) {
            System.out.println("Addition operation performed successfully");
        } else {
            System.out.println("Addition operation failed");
        }
        Thread.sleep(2000);

        // Subtraction operation
        driver.findElement(By.xpath("//div[@jsname='N10B9']")).click();
        driver.findElement(By.xpath("//div[@jsname='Ax5wH']")).click();
        driver.findElement(By.xpath("//div[@aria-label='minus']")).click();
        driver.findElement(By.xpath("//div[@jsname='T7PMFe']")).click();
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        WebElement subResult = driver.findElement(By.id("cwos"));
        String subResultText = subResult.getText();
        if (Integer.parseInt(subResultText) == 7) {
            System.out.println("Subtraction operation performed successfully");
        } else {
            System.out.println("Subtraction operation failed");
        }
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.click();
        searchBox.sendKeys("calculator");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        // Multiplication operation
        driver.findElement(By.xpath("//div[@jsname='N10B9']")).click();
        driver.findElement(By.xpath("//div[@jsname='bkEvMb']")).click();
        driver.findElement(By.xpath("//div[@aria-label='multiply']")).click();
        driver.findElement(By.xpath("//div[@jsname='KN1kY']")).click();
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        WebElement mulResult = driver.findElement(By.id("cwos"));
        String mulResultText = mulResult.getText();
        if (Integer.parseInt(mulResultText) == 30) {
            System.out.println("Multiplication operation performed successfully");
        } else {
            System.out.println("Multiplication operation failed");
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@aria-label='all clear']")).click();
        WebElement display = driver.findElement(By.id("cwos"));
        String displayText = display.getText();
        if (Integer.parseInt(displayText) == 0) {
            System.out.println("All clear operation performed successfully");
        } else {
            System.out.println("All clear operation failed");
        }

    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.click();
        searchBox.sendKeys("calculator");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //Division operation
        driver.findElement(By.xpath("//div[@jsname='lVjWed']")).click();
        driver.findElement(By.xpath("//div[@jsname='bkEvMb']")).click();
        driver.findElement(By.xpath("//div[@aria-label='divide']")).click();
        driver.findElement(By.xpath("//div[@jsname='xAP7E']")).click();
        driver.findElement(By.xpath("//div[@aria-label='equals']")).click();
        WebElement divResult = driver.findElement(By.id("cwos"));
        String divResultText = divResult.getText();
        if (Integer.parseInt(divResultText) == 5) {
            System.out.println("Division operation performed successfully");
        } else {
            System.out.println("Division operation failed");
        }
  }
}
