package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Loginpage {
    private WebDriver driver;
    private WebDriverWait wait;

    //web elements
    private By userNameField = By.cssSelector("input[name='username']");
    private By passwordField = By.cssSelector("input[name='password']");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By invalidErrormessage = By.xpath("//p[contains(.,'credentials')]");
    private By requiredErrormessage = By.cssSelector("span.oxd-input-field-error-message");

    public Loginpage(WebDriver driver){

        this.driver  = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //methods
    public void addusername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(username);
    }

    public void addpassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

    public boolean isInvalidErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidErrormessage));
        return driver.findElement(invalidErrormessage).isDisplayed();

    }

    public boolean isRequiredErrormessagevisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredErrormessage));
        return driver.findElement(requiredErrormessage).isDisplayed();

    }

    public boolean isDuplicateRequiredMessageVisible(){
        List<WebElement> requiredErrorList = driver.findElements(requiredErrormessage);
        for(int i=0 ; i<requiredErrorList.size() ; i++){
            if(!requiredErrorList.get(i).isDisplayed()){
                return false;
            }
        }
        return true;
    }


}
