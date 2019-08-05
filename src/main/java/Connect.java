import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Connect {

    private WebDriver driver;
    private String username;
    private String password;

    public Connect(String username, String password) {
        this.username = username;
        this.password = password;
        openBrowser(username, password);
    }

    private void openBrowser(String username, String password) {
        driver = new FirefoxDriver();
        driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
        }
        login("orei30477@gmail.com", "1620010");
//        login(username, password);
    }

    private void login(String username, String password) {

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        try {
            Thread.sleep(750);
        } catch(InterruptedException ex) {
        }

        List<WebElement> loginBtn = driver.findElements(By.cssSelector("button._0mzm-.sqdOP.L3NKy"));
        loginBtn.get(0).click();

        try {
            Thread.sleep(750);
        } catch(InterruptedException ex) {
        }

        List<WebElement> notNowBtn = driver.findElements(By.cssSelector("button[class='aOOlW HoLwm ']"));
        System.out.println(notNowBtn);
//        notNowBtn.get(0).click();
    }
}
