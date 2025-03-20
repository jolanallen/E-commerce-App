package org.example;

import java.util.ArrayList;
import lombok.Getter;


public class AllUsers {
    @Getter
    public ArrayList<User> listOfUsers;

    public AllUsers (){
        this.listOfUsers = new ArrayList<>();
    }

    public void addUser(User user){
        listOfUsers.add(user);
    }

    public User getUserByEmail(String email) {
        for (User user : listOfUsers) {
            if (user.getEmail().equalsIgnoreCase(email)) { // Ignorer la casse
                return user;
            }
        }
        return null; // Retourne null si aucun utilisateur trouvé
    }
}