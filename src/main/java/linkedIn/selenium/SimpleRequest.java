package linkedIn.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleRequest {

    private static WebDriver driver;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver79.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void finalize() {
//        driver.quit();
    }

    @Test
    public void simpleGoogleSearch() {
        driver.get("https://www.google.com");

        WebElement searchElement = driver.findElement(By.name("q"));
        searchElement.sendKeys("google");
        searchElement.submit();
    }

    @Test
    public void keyboardAndMouseInput() {
        driver.get("https://formy-project.herokuapp.com/keypress");

        WebElement submitField = driver.findElement(By.id("name"));
        submitField.click();
        submitField.sendKeys("Nikita Tkachenko");

        WebElement button = driver.findElement(By.id("button"));
        button.click();
    }

    @Test
    public void autocomplete() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocompleteAddress = driver.findElement(By.id("autocomplete"));
        autocompleteAddress.sendKeys("1555 park Blvd, Palo Alto, CA");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
    }

    @Test
    public void scrollToTheElement() {
        driver.get("https://formy-project.herokuapp.com/scroll");

        WebElement fullNameInput = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fullNameInput);
        fullNameInput.sendKeys("Mykyta Tkachenko");

        WebElement dateInput = driver.findElement(By.id("date"));
        dateInput.sendKeys("01/01/2020");

    }

    @Test
    public void switchingBetweenWindows() {
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle = driver.getWindowHandle();

        for (String handle :
                driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.switchTo().window(originalHandle);
    }

    @Test
    public void switchingToAlert() {
        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void executeJavascript() {
        driver.get("https://formy-project.herokuapp.com/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);
    }

    @Test(enabled = false)
    public void dragAndDrop() {
        driver.get("https://formy-project.herokuapp.com/dragdrop");

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();
    }

}
