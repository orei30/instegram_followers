import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends Frame implements ActionListener, WindowListener {

    private Frame loginFrame;
    private TextField usernameTextField;
    private TextField passwordTextField;
    private Label label;
    private Button loginBtn;

    public LoginFrame() {
        setTitle("Login");

        label = new Label("Login to your instegram user");
        label.setBounds(50, 150, 300, 30);
        label.setLocation(30, 40);
        add(label);

        label = new Label("Username:");
        label.setBounds(20, 150, 70, 20);
        label.setLocation(30, 70);
        add(label);

        usernameTextField = new TextField();
        usernameTextField.setBounds(60, 50, 170, 20);
        usernameTextField.setLocation(30, 90);
        add(usernameTextField);

        label = new Label("Password:");
        label.setBounds(20, 150, 70, 20);
        label.setLocation(30, 130);
        add(label);

        passwordTextField = new TextField();
        passwordTextField.setBounds(60, 50, 170, 20);
        passwordTextField.setLocation(30, 150);
        add(passwordTextField);

        Button loginBtn = new Button("LOGIN");
        loginBtn.setBounds(100, 120, 80, 30);
        loginBtn.setLocation(30, 180);
        loginBtn.addActionListener(this);
        add(loginBtn);

        setResizable(false);
        addWindowListener(this);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        new Login(usernameTextField.getText(), passwordTextField.getText());
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
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
