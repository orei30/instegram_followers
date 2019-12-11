import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame implements ActionListener, WindowListener {

    private static TextField usernameTextField;
    private static TextField passwordTextField;
    private static Label topLabel, usernameLabel, passwordLabel;
    private static Button loginBtn;

    public LoginFrame() {
        setTitle("Login");

        topLabel = new Label("Login to your instegram user");
        topLabel.setBounds(50, 150, 300, 30);
        topLabel.setLocation(30, 40);
        add(topLabel);

        usernameLabel = new Label("Username:");
        usernameLabel.setBounds(20, 150, 70, 20);
        usernameLabel.setLocation(30, 70);
        add(usernameLabel);

        usernameTextField = new TextField();
        usernameTextField.setBounds(60, 50, 170, 20);
        usernameTextField.setLocation(30, 90);
        add(usernameTextField);

        passwordLabel = new Label("Password:");
        passwordLabel.setBounds(20, 150, 70, 20);
        passwordLabel.setLocation(30, 130);
        add(passwordLabel);

        passwordTextField = new TextField();
        passwordTextField.setBounds(60, 50, 170, 20);
        passwordTextField.setLocation(30, 150);
        add(passwordTextField);

        loginBtn = new Button("LOGIN");
        loginBtn.setBounds(100, 120, 80, 30);
        loginBtn.setLocation(30, 180);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setResizable(false);
        addWindowListener(this);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        usernameLabel.setVisible(false);
        usernameTextField.setVisible(false);
        passwordLabel.setVisible(false);
        passwordTextField.setVisible(false);
        loginBtn.setVisible(false);
        topLabel.setText("Working...");
        new Login(usernameTextField.getText(), passwordTextField.getText());
    }

    public static void loginFailed() {
        usernameLabel.setVisible(true);
        usernameTextField.setVisible(true);
        passwordLabel.setVisible(true);
        passwordTextField.setVisible(true);
        loginBtn.setVisible(true);
        topLabel.setText("Failed pleas try again");
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        Main.closeFrame();
    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }
}
