package fr.EcommerceApp.user;

import java.util.ArrayList;
import lombok.Getter;

public class ManageUser {
    @Getter
    public ArrayList<User> listOfUsers;

    public ManageUser() {
        this.listOfUsers = new ArrayList<>();
    }

    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public User getUserByEmail(String email) {
        for (User u : this.listOfUsers) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }
}
