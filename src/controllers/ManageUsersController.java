package controllers;

import javax.swing.*;
import models.UserManager;
import views.ManageUsersView;

public class ManageUsersController {
    private ManageUsersView view;
    private UserManager userManager;

    public ManageUsersController(ManageUsersView view, UserManager userManager) {
        this.view = view;
        this.userManager = userManager;

        this.view.addAddUserListener(e -> addUser());
        this.view.addRemoveUserListener(e -> removeUser());

        updateUserList();
    }

    private void addUser() {
        String username = view.getUsername();
        String password = view.getPassword();
        String role = view.getRole();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Username and password cannot be empty.");
            return;
        }

        userManager.addUser(username, password, role);
        updateUserList();
        JOptionPane.showMessageDialog(view, "User added successfully.");
    }

    private void removeUser() {
        String selectedUser = view.getSelectedUser();
        if (selectedUser == null) {
            JOptionPane.showMessageDialog(view, "No user selected.");
            return;
        }

        if (userManager.removeUser(selectedUser.split(" - ")[0])) {
            updateUserList();
            JOptionPane.showMessageDialog(view, "User removed successfully.");
        } else {
            JOptionPane.showMessageDialog(view, "Failed to remove user.");
        }
    }

    private void updateUserList() {
        view.getUserListModel().clear();
        for (var user : userManager.getUsers()) {
            view.addUserToList(user.getUsername() + " - " + user.getRole());
        }
    }
}
