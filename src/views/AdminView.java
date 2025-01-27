package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminView extends JFrame {
    private JButton manageUsersButton;
    private JButton viewLogsButton;
    private JButton viewReportsAndStatsButton; // Tombol baru
    private JButton backupDataButton; // Tombol untuk backup data
    private JButton logoutButton;

    public AdminView() {
        setTitle("Admin Dashboard");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Welcome, Admin!", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(headerLabel);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        manageUsersButton = new JButton("Manage Users");
        viewLogsButton = new JButton("View Logs");
        viewReportsAndStatsButton = new JButton("View Reports and Statistics");
        backupDataButton = new JButton("Backup Data");
        logoutButton = new JButton("Logout");

        // Style buttons
        JButton[] buttons = {manageUsersButton, viewLogsButton, viewReportsAndStatsButton, backupDataButton, logoutButton};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.setFocusPainted(false);
            button.setBackground(new Color(70, 130, 180));
            button.setForeground(Color.WHITE);
            button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        buttonPanel.add(manageUsersButton);
        buttonPanel.add(viewLogsButton);
        buttonPanel.add(viewReportsAndStatsButton);
        buttonPanel.add(backupDataButton);
        buttonPanel.add(logoutButton);

        // Footer panel
        JPanel footerPanel = new JPanel();
        JLabel footerLabel = new JLabel("© 2025 Admin Dashboard | All Rights Reserved", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerPanel.add(footerLabel);

        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    public void addManageUsersListener(ActionListener listener) {
        manageUsersButton.addActionListener(listener);
    }

    public void addViewLogsListener(ActionListener listener) {
        viewLogsButton.addActionListener(listener);
    }

    public void addViewReportsAndStatsListener(ActionListener listener) {
        viewReportsAndStatsButton.addActionListener(listener); // Listener baru
    }

    public void addBackupDataListener(ActionListener listener) {
        backupDataButton.addActionListener(listener); // Listener baru
    }

    public void addLogoutListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}
