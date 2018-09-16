package TestTask;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

import javax.swing.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestowanieStrony {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void setRadioButtonTest() {

        driver.get("http://demo.nopcommerce.com/register");
    WebElement singleRadioButton = driver.findElement(By.xpath("//*[@id = 'gender-male']"));
        if(!singleRadioButton.isSelected()){
            singleRadioButton.click();
        }
        assertTrue("Radio Button is not Clicked", singleRadioButton.isSelected());

        WebElement fillingFirstName = driver.findElement(By.xpath("//*[@id = 'FirstName']"));
        fillingFirstName.sendKeys("Karol");

        WebElement fillingLastName = driver.findElement(By.xpath("//*[@id = 'LastName']"));
        fillingLastName.sendKeys("Marczyk");

//        SELECT
        Select Day = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
        Day.selectByValue("1");

        Select Month = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthMonth']")));
        Month.selectByValue("1");

        Select year = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")));
        year.selectByValue("1990");

        WebElement fillingEmail = driver.findElement(By.xpath("//*[@id = 'Email']"));
        fillingEmail.sendKeys("Karmarcz@super.Man");
    }
    @Test
    public void fillTheFirstNameTest() {
        driver.get("http://demo.nopcommerce.com/register");

        Select year = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthYear']")));
        year.selectByValue("1990");
    }
}
