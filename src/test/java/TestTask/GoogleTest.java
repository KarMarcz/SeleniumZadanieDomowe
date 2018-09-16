package TestTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleTest {
    private WebDriver driver;

@Before
public void setUp(){
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/chromedriver_Linux64");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
@Test
public void verifyIsWorkingGoogle() throws InterruptedException {
    driver.get("https://www.google.pl/");
    WebElement isIdHere = driver.findElement(By.id("hplogo"));
    Thread.sleep(3000);
    assertTrue("id is not here", isIdHere.isDisplayed());
}
    @Test
    public void verifyIsWorkingGoogle2() throws InterruptedException {
        driver.get("https://www.google.pl/");
        String isIdHere = driver.getTitle();
        Thread.sleep(3000);
        assertEquals("Czy widzi logo", "Google", isIdHere);
    }
@After
public void tearDown() {
    driver.close();
}
}