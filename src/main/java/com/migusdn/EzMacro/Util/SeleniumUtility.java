package com.migusdn.EzMacro.Util;


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

public class SeleniumUtility implements Runnable{
    private WebDriver driver;
    private Task task;

    private String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private String WEB_DRIVER_PATH = System.getProperty("user.home")+ File.separator+"chromedriver";

    public SeleniumUtility(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(task.getTarget_url());
            //System.out.println(driver.getPageSource());
            ArrayList<TaskElement> taskList = task.getTaskList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }
}
