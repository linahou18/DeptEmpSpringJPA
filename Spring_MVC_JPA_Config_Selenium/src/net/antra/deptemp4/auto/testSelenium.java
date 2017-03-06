package net.antra.deptemp4.auto;



import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testSelenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  static Wait<WebDriver> wait;
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/nina/Downloads/chromedriver");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 5);
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
	driver.get(baseUrl + "/DeptEmp4/");
    driver.findElement(By.linkText("Go to main page")).click();
    driver.findElement(By.cssSelector("td")).click();
    driver.findElement(By.xpath("//tr[3]/td")).click();
    driver.findElement(By.xpath("//tr[5]/td")).click();
    driver.findElement(By.xpath("//tr[7]/td")).click();
    driver.findElement(By.linkText("Department")).click();
    driver.findElement(By.linkText("Back to Main Page")).click();
    driver.findElement(By.linkText("Employee")).click();
    driver.findElement(By.linkText("Back to Main Page")).click();
    driver.findElement(By.linkText("back")).click();
    driver.get(baseUrl + "/DeptEmp4/");
    driver.findElement(By.linkText("Go to main page")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

