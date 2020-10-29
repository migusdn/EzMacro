package com.migusdn.EzMacro.Util;


import com.migusdn.EzMacro.Enum.Command;
import com.migusdn.EzMacro.Enum.TargetType;
import com.migusdn.EzMacro.Macro.Task;
import com.migusdn.EzMacro.Macro.TaskElement;
import com.migusdn.EzMacro.Setting.UserSetting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class SeleniumUtility implements Runnable{
    private static JavascriptExecutor js;
    private static WebDriver driver;
    private final Task task;

    private final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private final String WEB_DRIVER_PATH = System.getProperty("user.home")+ File.separator+"chromedriver";

    public SeleniumUtility(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            //driver.get(task.getTarget_url());
            //System.out.println(driver.getPageSource());
            Iterator<TaskElement> taskList= task.getTaskList().iterator();
            //command에 따라서 한번, target에 따라서 한번
            while(taskList.hasNext()){
                commandExec(taskList.next());
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }
    public void commandExec(TaskElement TElement) throws NullPointerException{
        TargetType targetType = TElement.getTargetType();
        String target = TElement.getTarget();
        switch(TElement.getCommand()){
            case open:{
                driver.get(task.getTarget_url());
                break;
            }
            case loop:{
                break;
            }
            case click:{
                driver.findElement(targetExec(targetType, target)).click();
                break;
            }
            case mouseOver:{
                break;
            }
            case runScript: {
                js.executeScript(target);
                break;
            }
            case doubleClick:{
                Actions builder = new Actions(driver);
//                builder.doubleClick(targetExec(targetType,target)).perform();
                break;
            }
            case setWindowSize:{
                break;
            }
            //index의 경우 간단히 전환하면 가능함
            case selectFrame:{
                driver.switchTo().frame(Integer.parseInt(target));
                break;
            }
        }
    }
    public By targetExec(TargetType targetType, String target){
        switch(targetType){
            case css:{
                return By.cssSelector(target);
            }
            case name:{
                return By.name(target);
            }
            case time:{
                break;
            }
            case xpath:{
                return By.xpath(target);
            }
            case linkText:{
                return By.linkText(target);
            }
            case id:{
                return By.id(target);
            }
        }
        return null;
    }
}
