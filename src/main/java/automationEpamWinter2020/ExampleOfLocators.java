package automationEpamWinter2020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleOfLocators {

    private static WebDriver driver;

    @Test
    public void simpleGoogleSearch() {
        driver = new ChromeDriver();

        // 1-2 слайди
        WebElement searchByClassName = driver.findElement(By.className("className"));
        WebElement searchById = driver.findElement(By.id("id"));
        WebElement searchByLinkText = driver.findElement(By.linkText("link test here(test that inside the \"a\" tag)"));
        WebElement searchByName = driver.findElement(By.name("name"));
        WebElement searchTagName = driver.findElement(By.tagName("tagName"));

        // 3 слайд
        //CSS
        //<input id="123_nameOfId_443" class="classNameHere secondClassName" name="inputName" value="inputValue">

        //by id
        driver.findElement(By.cssSelector("#123_nameOfId_443"));
        driver.findElement(By.cssSelector("input#123_nameOfId_443"));

        //by class
        driver.findElement(By.cssSelector(".classNameHere"));
        driver.findElement(By.cssSelector("input.classNameHere"));
        driver.findElement(By.cssSelector(".classNameHere.secondClassName"));

        //by value
        driver.findElement(By.cssSelector("<tagname>[type='value']")); //general

        driver.findElement(By.cssSelector("input[name='inputName']"));
        driver.findElement(By.cssSelector("input[value='inputValue']"));

        //4 слайд
        //Matches

        //Exact match
        //<div id="idName">
        driver.findElement(By.cssSelector("div[id='idName']"));

        //Prefix match
        //<div id="idName_randomText">
        driver.findElement(By.cssSelector("div[id^='idName']"));

        //Suffix match
        //<div id="randomText_idName">
        driver.findElement(By.cssSelector("div[id$='idName']"));

        //Substring match
        //<div id="randomText_idName_randomText">
        driver.findElement(By.cssSelector("div[id*='idName']"));

        // 5 слайд
        // <div id="divId">
        //      <a href="url">url text here </a>
        // </div>
        // child
        driver.findElement(By.cssSelector("div#divId a"));

        // <ul id="list">
        //      <li>one</li>
        //      <li>two</li>
        //      <li>three</li>
        // </ul>
        // nth-child
        driver.findElement(By.cssSelector("#list li:nth-child(n)"));










    }
}
