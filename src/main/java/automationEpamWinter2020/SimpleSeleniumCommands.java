package automationEpamWinter2020;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SimpleSeleniumCommands {

    private static final String PATH_TO_THE_CHROME_DRIVER_ON_EPAM_LAPTOP = "C:\\WebDrivers\\chromedriver79.exe";
    private static final String PATH_TO_THE_CHROME_DRIVER_ON_HOME_LAPTOP = "B:\\Drivers\\chromedriver79.exe";
    private static WebDriver driver;

    @BeforeClass
    public void init() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_THE_CHROME_DRIVER_ON_HOME_LAPTOP);
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

    // після 12 слайда
    @Test
    public void autocompleteWithTreadSleep() {
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
    public void autocompleteWithImplicitlyWait() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocompleteAddress = driver.findElement(By.id("autocomplete"));
        autocompleteAddress.sendKeys("1555 park Blvd, Palo Alto, CA");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
    }

    @Test
    public void autocompleteWithExplicitWait() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocompleteAddress = driver.findElement(By.id("autocomplete"));
        autocompleteAddress.sendKeys("1555 park Blvd, Palo Alto, CA");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement autocompleteResult =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("pac-item")));
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

    // 6 слайд
    @Test
    public void radioButton() {
        driver.get("https://formy-project.herokuapp.com/radiobutton");

        WebElement firstRadioButton = driver.findElement(By.id("radio-button-1"));
        firstRadioButton.click();

        WebElement secondRadioButton = driver.findElement(By.cssSelector("input[value='option2']"));
        secondRadioButton.click();

        WebElement thirdRadioButton = driver.findElement(By.xpath("//div[@class='container']/div[3]/input"));
        thirdRadioButton.click();
    }

    @Test
    public void datePicker() {
        driver.get("https://formy-project.herokuapp.com/datepicker");

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("03/03/2020");
        datePicker.sendKeys(Keys.RETURN);
    }

    @Test
    public void dropDownMenu() {
        driver.get("https://formy-project.herokuapp.com/dropdown");

        WebElement dropDownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenu.click();

        WebElement pageScroll = driver.findElement(By.linkText("Page Scroll"));
        pageScroll.click();

    }

    @Test
    public void fileUpload() {
        driver.get("https://formy-project.herokuapp.com/fileupload");

        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys("B:\\For me\\photo.jpg");

    }

}
