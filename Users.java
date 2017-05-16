import java.util.ArrayList;
public class Users {
    private int userid;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private int phone;
    private String paymentmethod;
    private boolean competitionswimmer = false;
    private boolean admin = false ;

    public Users(String firstname, String lastname, int age, String email, int phone, boolean competitionswimmer, boolean admin) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.competitionswimmer = competitionswimmer;
        this.admin = admin;
    }

    public Users() {
    }

    public void addMembers() {

    }

    // Admin login with preset password
    public void isAdmin() {
        System.out.print("Enter password: ");
        String passWordInput = System.console().readLine();
        if (passWordInput.equals("password")) {
            System.out.println("You are now logged in as an admin.");
            admin = true;
        }else {
            System.out.println("Wrong password - You are not an admin.");
            admin = false;
        }
    }

    // Setters for most of our attributes
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setCompetitionswimmer(boolean competitionswimmer) {
        this.competitionswimmer = competitionswimmer;
    }
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    // End of setters - now getters for most of our attributes.
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }
    public String getPaymentmethod() {
        return paymentmethod;
    }

    public boolean getCompetitionswimmer() {
        return competitionswimmer;
    }

    public boolean getAdmin() {
        return admin;
    }

    // End of getters

}