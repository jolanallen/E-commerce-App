package fr.EcommerceApp.user;

public class AdminUser extends User {
    public AdminUser(String username, String email, String password, int id_user) {
        super(username, email, password, UserType.ADMIN, id_user);
    }

    public void manageUsers() {
        System.out.println("Managing users.");
    }
}
