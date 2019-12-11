import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends Frame implements ActionListener, WindowListener {

    private WebDriver driver;
    TextField usernameTextField;
    Label topLabel, numUsersYouCanFollowLabel, numUsersYouCanUnfollowLabel, bottomLabel;
    Button getUserFollowersBtn, stopBtn;
    Button follow100PeopleBtn, follow200PeopleBtn, follow500PeopleBtn, follow1000PeopleBtn, follow2000PeopleBtn;
    Button remove100PeopleBtn, remove200PeopleBtn, remove500PeopleBtn, remove1000PeopleBtn, remove2000PeopleBtn;
    ArrayList<String> usersToFollow, followingUsers, followedUsers;


    public MainFrame(WebDriver driver, String username) {
        this.driver = driver;

        setTitle("Get Followers");

        usersToFollow = HandleFile.readFile("users-to-follow");
        followingUsers = HandleFile.readFile("following-users");
        followedUsers = HandleFile.readFile("followed-users");

        topLabel = new Label("Enter instegram user that you want to get followers from");
        topLabel.setBounds(50, 150, 350, 30);
        topLabel.setLocation(30, 40);
        add(topLabel);

        usernameTextField = new TextField();
        usernameTextField.setBounds(60, 50, 170, 20);
        usernameTextField.setLocation(90, 70);
        add(usernameTextField);

        getUserFollowersBtn = new Button("Get");
        getUserFollowersBtn.setActionCommand("get");
        getUserFollowersBtn.setBounds(100, 120, 80, 30);
        getUserFollowersBtn.setLocation(135, 100);
        getUserFollowersBtn.addActionListener(this);
        add(getUserFollowersBtn);

        numUsersYouCanFollowLabel = new Label("You have " + usersToFollow.size() + " users to follow.");
        numUsersYouCanFollowLabel.setBounds(50, 150, 250, 30);
        numUsersYouCanFollowLabel.setLocation(100, 150);
        add(numUsersYouCanFollowLabel);

        follow100PeopleBtn = new Button("Follow 100 users");
        follow100PeopleBtn.setActionCommand("f100");
        follow100PeopleBtn.setBounds(100, 120, 110, 30);
        follow100PeopleBtn.setLocation(120, 180);
        follow100PeopleBtn.addActionListener(this);
        add(follow100PeopleBtn);

        follow200PeopleBtn = new Button("Follow 200 users");
        follow200PeopleBtn.setActionCommand("f200");
        follow200PeopleBtn.setBounds(100, 120, 110, 30);
        follow200PeopleBtn.setLocation(120, 215);
        follow200PeopleBtn.addActionListener(this);
        add(follow200PeopleBtn);

        follow500PeopleBtn = new Button("Follow 500 users");
        follow500PeopleBtn.setActionCommand("f500");
        follow500PeopleBtn.setBounds(100, 120, 110, 30);
        follow500PeopleBtn.setLocation(120, 250);
        follow500PeopleBtn.addActionListener(this);
        add(follow500PeopleBtn);

        follow1000PeopleBtn = new Button("Follow 1000 users");
        follow1000PeopleBtn.setActionCommand("f1000");
        follow1000PeopleBtn.setBounds(100, 120, 110, 30);
        follow1000PeopleBtn.setLocation(120, 285);
        follow1000PeopleBtn.addActionListener(this);
        add(follow1000PeopleBtn);

        follow2000PeopleBtn = new Button("Follow 2000 users");
        follow2000PeopleBtn.setActionCommand("f2000");
        follow2000PeopleBtn.setBounds(100, 120, 110, 30);
        follow2000PeopleBtn.setLocation(120, 320);
        follow2000PeopleBtn.addActionListener(this);
        add(follow2000PeopleBtn);

        numUsersYouCanUnfollowLabel = new Label("You have " + followingUsers.size() + " users to unfollow.");
        numUsersYouCanUnfollowLabel.setBounds(50, 150, 250, 30);
        numUsersYouCanUnfollowLabel.setLocation(420, 150);
        add(numUsersYouCanUnfollowLabel);

        remove100PeopleBtn = new Button("Unfollow 100 users");
        remove100PeopleBtn.setActionCommand("r100");
        remove100PeopleBtn.setBounds(100, 120, 120, 30);
        remove100PeopleBtn.setLocation(450, 180);
        remove100PeopleBtn.addActionListener(this);
        add(remove100PeopleBtn);

        remove200PeopleBtn = new Button("Unfollow 200 users");
        remove200PeopleBtn.setActionCommand("r200");
        remove200PeopleBtn.setBounds(100, 120, 120, 30);
        remove200PeopleBtn.setLocation(450, 215);
        remove200PeopleBtn.addActionListener(this);
        add(remove200PeopleBtn);

        remove500PeopleBtn = new Button("Unfollow 500 users");
        remove500PeopleBtn.setActionCommand("r500");
        remove500PeopleBtn.setBounds(100, 120, 120, 30);
        remove500PeopleBtn.setLocation(450, 250);
        remove500PeopleBtn.addActionListener(this);
        add(remove500PeopleBtn);

        remove1000PeopleBtn = new Button("Unfollow 1000 users");
        remove1000PeopleBtn.setActionCommand("r1000");
        remove1000PeopleBtn.setBounds(100, 120, 120, 30);
        remove1000PeopleBtn.setLocation(450, 285);
        remove1000PeopleBtn.addActionListener(this);
        add(remove1000PeopleBtn);

        remove2000PeopleBtn = new Button("Unfollow 2000 users");
        remove2000PeopleBtn.setActionCommand("r2000");
        remove2000PeopleBtn.setBounds(100, 120, 120, 30);
        remove2000PeopleBtn.setLocation(450, 320);
        remove2000PeopleBtn.addActionListener(this);
        add(remove2000PeopleBtn);

//        stopBtn = new Button("Stop");
//        stopBtn.setActionCommand("stop");
//        stopBtn.setBounds(100, 120, 60, 30);
//        stopBtn.setLocation(325, 380);
//        stopBtn.addActionListener(this);
//        stopBtn.setEnabled(false);
//        add(stopBtn);

        bottomLabel = new Label("Press some button to start the magic");
        bottomLabel.setBounds(50, 150, 350, 30);
        bottomLabel.setAlignment(Label.CENTER);
        bottomLabel.setLocation(175, 380);
        add(bottomLabel);

        setResizable(false);
        addWindowListener(this);
        setSize(700, 500);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pressedBtn = e.getActionCommand();
        if (pressedBtn.equals("get"))
            getUsers();
        if (pressedBtn.equals("f100"))
            followUsers(100);
        if (pressedBtn.equals("f200"))
            followUsers(200);
        if (pressedBtn.equals("f500"))
            followUsers(500);
        if (pressedBtn.equals("f1000"))
            followUsers(1000);
        if (pressedBtn.equals("f2000"))
            followUsers(2000);
        if (pressedBtn.equals("r100"))
            unfollowUsers(100);
        if (pressedBtn.equals("r200"))
            unfollowUsers(200);
        if (pressedBtn.equals("r500"))
            unfollowUsers(500);
        if (pressedBtn.equals("r1000"))
            unfollowUsers(1000);
        if (pressedBtn.equals("r2000"))
            unfollowUsers(2000);
        if (pressedBtn.equals("stop")) {
            stopBtn.setEnabled(false);
            HandleFile.updateFile("followed-users", followedUsers);
            HandleFile.replaceFile("following-users", followingUsers);
            HandleFile.replaceFile("users-to-follow", usersToFollow);
            numUsersYouCanFollowLabel.setText("You have " + usersToFollow.size() + " users to follow.");
            numUsersYouCanUnfollowLabel = new Label("You have " + followingUsers.size() + " users to unfollow.");
            bottomLabel.setText("Press some button to start the magic");
        }
    }

    private void getUsers() {
        bottomLabel.setText("Working... (Pleas don't stop me now)");
        driver.navigate().to("https://instegram.com/" + usernameTextField.getText());
        sleep(3000);
        openUserFollowers();
        bottomLabel.setText("Press some button to start the magic");
    }

    private void openUserFollowers() {
        List<WebElement> followersLink = driver.findElements(By.cssSelector("a.-nal3"));
        followersLink.get(0).click();
        sleep(3000);
        scrollDownInFollowers();
        getUserFollowers();
    }

    private void getUserFollowers() {
        ArrayList<String> users = new ArrayList<String>();
        List<WebElement> followersLink = driver.findElements(By.cssSelector("a.FPmhX.notranslate._0imsa"));
        for (WebElement we : followersLink) {
            if (!followingUsers.contains(we.getText()))
                users.add(we.getText());
        }
        HandleFile.updateFile("users-to-follow", users);
        usersToFollow = HandleFile.readFile("users-to-follow");
        numUsersYouCanFollowLabel.setText("You have " + usersToFollow.size() + " users to follow.");
    }

    private void scrollDownInFollowers() {
        System.out.println("scroll once");
        List<WebElement> followersWindow = driver.findElements(By.cssSelector("div.isgrP"));
        for (int i = 0; i < 200; i++) {
            followersWindow.get(0).sendKeys(Keys.DOWN);
            sleep(200);
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println("Failed to sleep!");
        }
    }

    private void followUsers(int num) {
        stopBtn.setEnabled(true);
        bottomLabel.setText("Working... (Pleas don't stop me now)");
        int i = 0;
        int k = 0;
        while (i <= usersToFollow.size() && i <= num) {
            if(!followUser(usersToFollow.get(k)))
                k++;
            System.out.println("Followed " + (i + 1) + " out of " + Math.min(num, usersToFollow.size()) + " users");
            i++;
        }
        HandleFile.replaceFile("users-to-follow", usersToFollow);
        HandleFile.updateFile("following-users", followingUsers);
        bottomLabel.setText("Press some button to start the magic");
    }

    private boolean followUser(String user) {
        driver.navigate().to("https://instegram.com/" + user);
        sleep(3000);
        boolean privateAccount = true;
        // This button show in public accounts
        List<WebElement> followBtn = driver.findElements(By.cssSelector("button._5f5mN.jIbKX._6VtSN.yZn4P"));
        if (followBtn.size() != 0) {
            System.out.println("Follow public account");
            followBtn.get(0).click();
        } else {
            System.out.println("Follow private account");
            privateAccount = false;
            // This button show in private accounts
            followBtn = driver.findElements(By.cssSelector("button.BY3EC._0mzm-.sqdOP.L3NKy"));
            if (followBtn.size() != 0) {
                if(followBtn.get(0).getText().equals("Follow"))
                    followBtn.get(0).click();
                else {
                    System.out.println("Already follow " + user);
                    return false;
                }
            } else {
                System.out.println("Already follow " + user);
                return false;
            }
        }

        sleep(2000);

        if(privateAccount) {
            System.out.println("private account");
            followBtn = driver.findElements(By.cssSelector("button.BY3EC._0mzm-.sqdOP.L3NKy"));
            if (followBtn.size() != 0) {
                System.out.println("Didn't follow" + user + " wait 5 minutes");
                sleep(60000 * 5);
                followUser(user);
                return true;
            }
        } else {
            System.out.println("public account");
            followBtn = driver.findElements(By.cssSelector("button._5f5mN.jIbKX._6VtSN.yZn4P"));
            if (followBtn.size() != 0) {
                System.out.println("Didn't follow" + user + " wait 5 minutes");
                sleep(60000 * 5);
                followUser(user);
                return true;
            }
        }

        System.out.println("Followed " + user);
        usersToFollow.remove(user);
        followingUsers.add(user);

        numUsersYouCanFollowLabel.setText("You have " + usersToFollow.size() + " users to follow.");

        return true;
    }

    private void unfollowUsers(int num) {
        bottomLabel.setText("Working... (Pleas don't stop me now)");
        stopBtn.setEnabled(true);
        int i = 0;
        int k = 0;
        while (i <= followingUsers.size() && i <= num) {
            if(!unfollowUser(followingUsers.get(k)))
                k++;
            numUsersYouCanUnfollowLabel = new Label("You have " + followingUsers.size() + " users to unfollow.");
            i++;
        }
        HandleFile.updateFile("followed-users", followedUsers);
        HandleFile.replaceFile("following-users", followingUsers);
        bottomLabel.setText("Press some button to start the magic");
    }

    private boolean unfollowUser(String user) {
        driver.navigate().to("https://instegram.com/" + user);
        sleep(3000);
        //TODO: handle request button

        // following button
        List<WebElement> followingBtn = driver.findElements(By.cssSelector("button._5f5mN.-fzfL._6VtSN.yZn4P"));
        if (followingBtn.size() != 0) {
            System.out.println("Press button");
            followingBtn.get(0).click();
        } else {
            System.out.println("Failed to unfollow " + user);
            return false;
        }

        sleep(1500);

        // Unfollow button
        List<WebElement> unfollowBtn = driver.findElements(By.cssSelector("button.aOOlW.-Cab_"));
        if (unfollowBtn.size() != 0) {
            System.out.println("Unfollow " + user + " account");
            unfollowBtn.get(0).click();
        } else {
            System.out.println("Failed to unfollow " + user);
            return false;
        }

        System.out.println("Unollowed " + user);
        followingUsers.remove(user);
        followedUsers.add(user);

        numUsersYouCanUnfollowLabel = new Label("You have " + followingUsers.size() + " users to unfollow.");

        return true;
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        HandleFile.updateFile("followed-users", followedUsers);
        HandleFile.replaceFile("following-users", followingUsers);
        HandleFile.replaceFile("users-to-follow", usersToFollow);
        numUsersYouCanFollowLabel.setText("You have " + usersToFollow.size() + " users to follow.");
        numUsersYouCanUnfollowLabel = new Label("You have " + followingUsers.size() + " users to unfollow.");
        Main.closeFrame();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
