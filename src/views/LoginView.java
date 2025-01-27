package views;  
  
import java.awt.*;
import java.awt.event.ActionListener;  
import javax.swing.*;  
  
public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JComboBox<String> roleComboBox;
    private JLabel messageLabel;

    public LoginView() {
        // Set up frame
        setTitle("Login Forensik Information");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top Panel for Image
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(new Color(240, 240, 240));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Load and Resize Image
        ImageIcon originalIcon = new ImageIcon("Doberman.jpg"); 
        Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(imageLabel, BorderLayout.CENTER);

        // Center Panel for Form
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        // // Role ComboBox
        // roleComboBox = new JComboBox<>(new String[]{"Admin", "User"});
        // roleComboBox.setPreferredSize(new Dimension(200, 30));
        // roleComboBox.setBorder(BorderFactory.createTitledBorder("Role"));

        centerPanel.add(usernameField);
        centerPanel.add(passwordField);
        // centerPanel.add(roleComboBox);
        centerPanel.add(passwordField);

        // Bottom Panel for Login Button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(loginButton, BorderLayout.CENTER);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

  
    public String getUsername() {  
        return usernameField.getText();  
    }  
  
    public String getPassword() {  
        return new String(passwordField.getPassword());  
    }  
  
    // public String getSelectedRole() {  
    //     return (String) roleComboBox.getSelectedItem();  
    // }  
  
    public void setMessage(String message) {  
        if (messageLabel == null) {  
            messageLabel = new JLabel();  
            messageLabel.setForeground(Color.RED);  
            add(messageLabel, BorderLayout.SOUTH);  
        }  
        messageLabel.setText(message);  
    }  
  
    public void addLoginListener(ActionListener listener) {  
        loginButton.addActionListener(listener);  
    }  
}  
