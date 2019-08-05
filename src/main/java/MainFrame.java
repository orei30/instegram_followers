import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends Frame implements ActionListener {

    TextField username;
    TextField password;
    Label label;
    Button loginBtn;

    public MainFrame() {

        setTitle("Title");

        label = new Label("Second Label.");
        label.setBounds(50,150, 100,30);
        label.setLocation(30, 30);
        add(label);

        username = new TextField();
        username.setBounds(60,50,170,20);
        username.setLocation(30, 60);
        add(username);

        password = new TextField();
        password.setBounds(60,50,170,20);
        password.setLocation(30, 90);
        add(password);

        Button loginBtn = new Button("LOGIN");
        loginBtn.setBounds(100,120,80,30);
        loginBtn.setLocation(30, 120);
        loginBtn.addActionListener(this);
        add(loginBtn);


        setSize(750,750);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        label.setText(username.getText());
        new Connect(username.getText(), password.getText());
    }
}
