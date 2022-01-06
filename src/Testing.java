import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testing {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement select = driver.findElement(By.className("gLFyf"));
        select.sendKeys("facebook login");
        select.click();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/login/");
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("xxxxxx@gmail.com");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("xxxxxx");
        driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[aria-label='Search Facebook']")).sendKeys("your keyword ");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='k4urcfbm']/div"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("correct friend name")) ;
            option.click();
            Thread.sleep(5000);
            String parentWindow = driver.getWindowHandle();
            for (String childWindowHandle : driver.getWindowHandles()) {
                if (!childWindowHandle.equalsIgnoreCase(parentWindow)) {
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                }
              System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Message')]")).getText());
                driver.findElement(By.xpath("//span[contains(text(),'Message')]")).click();
                Thread.sleep(3000);
                WebElement action = driver.findElement(By.xpath("//div[@class='_1mf _1mj']"));
           action.sendKeys("Hi");

          action.findElement(By.xpath("//*[name()='path' and contains(@d,'M16.691502')]")).click();
                Thread.sleep(3000);
            }

            driver.quit();
        }
    }
        }

