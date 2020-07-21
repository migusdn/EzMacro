package com.migusdn.EzMacro.Util;


import com.migusdn.EzMacro.Macro.Task;
import org.openqa.selenium.WebDriver;
import com.migusdn.EzMacro.Setting.UserSetting;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtility implements Runnable{
    private WebDriver driver;
    private Task task;

    private String TARGET_URL;
    private String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private String WEB_DRIVER_PATH = "/Users/hyunwoopark/chromedriver";

    @Override
    public void run() {
        TARGET_URL = "https://naver.com";
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(TARGET_URL);
            System.out.println(driver.getPageSource());

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            driver.close();
        }

    }
}
