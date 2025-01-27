package views;  
  
import java.awt.*;
import java.awt.event.ActionListener;  
import javax.swing.*;  
  
public class ManageUsersView extends JFrame {  
    private JTextField usernameField;  
    private JPasswordField passwordField;  
    private JComboBox<String> roleComboBox;  
    private JButton addUserButton;  
    private JButton removeUserButton;  
    private JList<String> userList;  
    private DefaultListModel<String> userListModel;  
  
    // Konstanta untuk ukuran komponen  
    private static final int TEXT_FIELD_WIDTH = 200;  
    private static final int TEXT_FIELD_HEIGHT = 30;  
    private static final int BUTTON_WIDTH = 150;  
    private static final int BUTTON_HEIGHT = 40;  
  
    public DefaultListModel<String> getUserListModel() {  
        return userListModel;  
    }  
  
    public ManageUsersView() {  
        // Pengaturan frame  
        setTitle("Kelola Pengguna");  
        setSize(400, 500);  
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setLocationRelativeTo(null);  
  
        // Main panel  
        JPanel mainPanel = new JPanel();  
        mainPanel.setLayout(new BorderLayout(10, 10));  
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  
  
        // Panel input untuk username, password, dan role  
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));  
        inputPanel.setBorder(BorderFactory.createTitledBorder("Detail Pengguna"));  
  
        JLabel usernameLabel = new JLabel("Username:");  
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);  
        inputPanel.add(usernameLabel);  
  
        usernameField = new JTextField();  
        usernameField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));  
        inputPanel.add(usernameField);  
  
        JLabel passwordLabel = new JLabel("Password:");  
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);  
        inputPanel.add(passwordLabel);  
  
        passwordField = new JPasswordField();  
        passwordField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));  
        inputPanel.add(passwordField);  
  
        JLabel roleLabel = new JLabel("Role:");  
        roleLabel.setHorizontalAlignment(SwingConstants.RIGHT);  
        inputPanel.add(roleLabel);  
  
        roleComboBox = new JComboBox<>(new String[]{"Kepala Penyidik", "Penyidik"});  
        roleComboBox.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));  
        inputPanel.add(roleComboBox);  
  
        mainPanel.add(inputPanel, BorderLayout.NORTH);  
  
        // Panel tombol untuk Tambah dan Hapus  
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  
  
        addUserButton = new JButton("Tambah Pengguna");  
        addUserButton.setBackground(new Color(70, 130, 180));  
        addUserButton.setForeground(Color.WHITE);  
        addUserButton.setFocusPainted(false);  
        addUserButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));  
        buttonPanel.add(addUserButton);  
  
        removeUserButton = new JButton("Hapus Pengguna");  
        removeUserButton.setBackground(new Color(220, 20, 60));  
        removeUserButton.setForeground(Color.WHITE);  
        removeUserButton.setFocusPainted(false);  
        removeUserButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));  
        buttonPanel.add(removeUserButton);  
  
        mainPanel.add(buttonPanel, BorderLayout.CENTER);  
  
        // Panel daftar pengguna  
        userListModel = new DefaultListModel<>();  
        userList = new JList<>(userListModel);  
        userList.setBorder(BorderFactory.createTitledBorder("Daftar Pengguna"));  
        JScrollPane scrollPane = new JScrollPane(userList);  
        scrollPane.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, 200));  
  
        mainPanel.add(scrollPane, BorderLayout.SOUTH);  
  
        // Menambahkan panel utama ke frame  
        add(mainPanel);  
    }  
  
    // Getter methods  
    public String getUsername() {  
        return usernameField.getText();  
    }  
  
    public String getPassword() {  
        return new String(passwordField.getPassword());  
    }  
  
    public String getRole() {  
        return (String) roleComboBox.getSelectedItem();  
    }  
  
    public void addUserToList(String user) {  
        userListModel.addElement(user);  
    }  
  
    public String getSelectedUser() {  
        return userList.getSelectedValue();  
    }  
  
    // Listener methods  
    public void addAddUserListener(ActionListener listener) {  
        addUserButton.addActionListener(listener);  
    }  
  
    public void addRemoveUserListener(ActionListener listener) {  
        removeUserButton.addActionListener(listener);  
    }  
  
    // Metode utama untuk pengujian  
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
            ManageUsersView view = new ManageUsersView();  
            view.setVisible(true);  
        });  
    }  
}  
