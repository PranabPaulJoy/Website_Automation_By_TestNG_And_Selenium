package page;

public class UserModel {
    private String firstname;

    private String lastname;
    private String employeeid;

    private String username;

    private String password;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmployeeid() {
        return employeeid;
    }
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel(){

    }
    public UserModel(String firstname, String lastname, String employeeid, String username, String password){
        this.firstname=firstname;
        this.lastname=lastname;
        this.employeeid=employeeid;
        this.username=username;
        this.password=password;
    }
}
