package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dashboardIcon=  By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");

    public DashboardPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public boolean isDashbordIconVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIcon));
        return driver.findElement(dashboardIcon).isDisplayed();
    }


}
