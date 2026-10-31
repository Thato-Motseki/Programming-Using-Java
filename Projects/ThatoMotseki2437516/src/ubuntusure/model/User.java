package ubuntusure.model;
/**
 *
 * @author thato
 */

public class User {

    private int userID;
    private int roleID;
    private String firstname;
    private String surname;
    private String username;
    private String passwordHash;
    private String email;
    private boolean active;
    private String roleName;

    public User() {
    }

    public User(int userID, int roleID, String firstname,
                String surname, String username, String passwordHash,
                String email, boolean active, String roleName) {

        this.userID = userID;
        this.roleID = roleID;
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.active = active;
        this.roleName = roleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

