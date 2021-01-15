package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;

public class HomePage extends CommonFunctions {

        @FindBy(css="div.hueEpF")
        WebElement registerLink ;

        @FindBy(xpath="//button[contains(text(),'50')]")
        WebElement loginLink;

        public HomePage(WebDriver driver) {
                super();
        }

        public void clickShowRecords()
        {
            clickElement(registerLink,2);
        }

        public void clickRecordNumber()
        {
            clickElement(loginLink,1);
        }
        

}
