public class User{
    @Override
    public String toString() {
        return "User{" +
                "username='" + username22 + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    public String getUsername() {
        return username22;
    }

    public void setUsername(String username) {
        this.username22 = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    private String username22;
    private String password;

}