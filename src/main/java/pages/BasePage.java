package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected WebElement getElement(By locator)
    {
        WebElement element=null;
        try{
            element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return element;
    }

    protected List<WebElement> getElementList(By locator) {

        return driver.findElements(locator);
    }

    protected void typeIn(By locator, String text)
    {
        WebElement element=getElement(locator);
        element.clear();
        element.sendKeys(text);
    }


    protected void clickOnElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (ElementClickInterceptedException ex) {
            //logger.warn("ElementClickInterceptedException occurred!");
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            hoverAndClick(locator);
        } catch (StaleElementReferenceException staleEl) {
            getElement(locator).click();
            //logger.warn("Stale Element Exception occurred.");
        } catch (TimeoutException te) {
            te.printStackTrace();
            WebElement element = getElement(locator);
            js.executeScript("arguments[0].click();", element);
            //logger.warn("TimeoutException occurred!");
        } catch (Exception e) {
            e.printStackTrace();
            //logger.error("FAILED - Unable to click on element " + locator.toString());
        }
    }
    protected void hoverAndClick(By locator){
        new Actions(driver)
                .moveToElement(getElement(locator))
                .click()
                .perform();
    }

    private void hover(By locator){
        new Actions(driver)
                .moveToElement(getElement(locator))
                .perform();
    }

    protected void scrollToMyElement(By locator){
        WebElement element = getElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    protected boolean matchesExpectedText(By locator, String expectedText)
    {
        WebElement element=getElement(locator);
        if (element.getText().trim().equals(expectedText))
        {
            System.out.println("pass");
            return true;
        }
        else {
            System.out.println("fail");

        }
        return false;
    }



    protected String randomMejl() {
        Random r = new Random();
        int zamisljeniBroj = r.nextInt(1000);
        String mejl = ("tijana" + zamisljeniBroj + "@" + "yopmail.com");
        return mejl;
    }




}
