package org.example;

import java.util.ArrayList;
import lombok.Getter;

public class AllUsers {
    @Getter
    private ArrayList<User> listOfUsers;

    public AllUsers (){
        this.listOfUsers = new ArrayList<>();
    }

    public void addUser(User user){
        listOfUsers.add(user);
    }
}