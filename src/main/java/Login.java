import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

public class Login {

    private static WebDriver driver;
    private String email;
    private String password;
    private String username;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
        openBrowser(email, password);
    }

    private void openBrowser(String email, String password) {
//        File path = new File("phantomjs.exe");
//        System.setProperty("phantomjs.binary.path",path.getAbsolutePath());
//        driver = new PhantomJSDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
        }
//        login("orei30477@gmail.com", "1620010");
        login(email, password);
    }

    private void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        sleep(750);

        List<WebElement> loginBtn = driver.findElements(By.cssSelector("button._0mzm-.sqdOP.L3NKy"));
        loginBtn.get(0).click();

        sleep(3000);

        List<WebElement> notNowBtn = driver.findElements(By.cssSelector("button.aOOlW.HoLwm"));
        if(notNowBtn.size() == 0) {
            System.out.println("didnt login yet");
            sleep(3000);
            notNowBtn = driver.findElements(By.cssSelector("button.aOOlW.HoLwm"));
        }
//        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        System.out.println("File:" + srcFile);
//        try {
//            FileUtils.copyFile(srcFile, new File("screenshot_.png"));
//        } catch (Exception e) {
//
//        }
//        System.out.println("Done");
        notNowBtn.get(0).click();

        List<WebElement> usernameElement = driver.findElements(By.cssSelector("a.gmFkV"));
        username = usernameElement.get(0).getText();

        if(username != null) {
            Main.loginSucceed(driver, username);
        } else {
            LoginFrame.loginFailed();
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            System.out.println("Failed to sleep!");
        }
    }
}
