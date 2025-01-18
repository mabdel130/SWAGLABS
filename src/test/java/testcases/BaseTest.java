package testcases;

import common.MyScreenRecorder;
import drivers.DriverFactory;
import org.testng.annotations.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.BasePage.quitBrowser;
import static util.Utlity.openBrowserNetworkTab;


public class BaseTest {

    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeSuite
    public void bruteforce() throws Exception {
        MyScreenRecorder.startRecording("LOGIN.TEST");

    }

    @Parameters("browsername")
    @BeforeTest
    public void OpenBrower(@Optional String browsername) throws AWTException {
        setDriver(DriverFactory.getNewInstance(""));

        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        getDriver().get("https://www.saucedemo.com/v1/");
          openBrowserNetworkTab();

    }

    @AfterTest
    public void TearDown() {
        quitBrowser(getDriver());
    }
    @AfterSuite
    public void afterSuite() throws Exception {
      MyScreenRecorder.stopRecording();

    }
}


