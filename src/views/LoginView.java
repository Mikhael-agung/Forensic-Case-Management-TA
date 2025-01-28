package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginView() {
        // Set up frame
        setTitle("Login Forensik Information");
        setSize(350, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top Panel for Image and Title
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(240, 240, 240));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTitle1 = new JLabel("FORENSIK");
        labelTitle1.setFont(new Font("JUA", Font.BOLD, 24));
        labelTitle1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelTitle2 = new JLabel("INFORMATION");
        labelTitle2.setFont(new Font("JUA", Font.BOLD, 24));
        labelTitle2.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Load and Resize Image
        ImageIcon originalIcon = new ImageIcon("Doberman.jpg");
        Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(labelTitle1);
        topPanel.add(labelTitle2);
        topPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        topPanel.add(imageLabel);

        // Center Panel for Form
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        centerPanel.add(usernameField);
        centerPanel.add(passwordField);

        // Bottom Panel for Login Button and Message
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);

        messageLabel = new JLabel(" "); // Placeholder for message
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        bottomPanel.add(loginButton, BorderLayout.CENTER);
        bottomPanel.add(messageLabel, BorderLayout.SOUTH);

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

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}
