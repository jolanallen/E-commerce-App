package fr.EcommerceApp.user;

public class RegularUser extends User {
    public RegularUser(String username, String email, String password, int id_user) {
        super(username, email, password, UserType.REGULAR, id_user);
    }

    public void browseProducts() {
        System.out.println("Browsing products.");
    }
}
