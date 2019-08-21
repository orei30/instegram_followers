import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Main {

    private static Frame frame;

    public static void main(String[] args) {
        frame = new LoginFrame();
    }

    public static void loginSucceed(WebDriver driver, String username) {
        closeFrame();
        frame = new MainFrame(driver, username);
    }

    public static void closeFrame() {
        frame.dispose();
    }
}