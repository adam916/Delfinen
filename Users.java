import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



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


        public void createMember() {
        try{
            Scanner input = new Scanner(System.in);

            File f = new File("Members.txt");

            f.createNewFile();

            Scanner scan = new Scanner(f);
            ArrayList<Users> members = new ArrayList<Users>();
 
            while(scan.hasNextLine())
            {
                members.add(new Users(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean()));   
            }

            System.out.print ("opret et nyt medlem");
            System.out.print("Tast fornavn ");
            String fornavn = input.next();
            //members.setFirstname(fornavn);

            System.out.print("Tast efternavn ");
            String efternavn = input.next();
            //members.setLastname(efternavn);
            
            System.out.print("Tast alder ");
            int age = input.nextInt();
            //members.setAge(age);

            System.out.print("Tast email ");
            String email = input.next();
            //members.setEmail(email);

            System.out.print("Tast telefonnummer ");
            int tlf = input.nextInt();
            //members.setPhone(tlf);

            System.out.print("Konkurrencesvømmer? ");
            boolean competition = input.nextBoolean();
            //members.setCompetitionswimmer(competition);

            System.out.print("Admin rettigheder? ");
            boolean admin = input.nextBoolean();
            //members.setAdmin(admin);


            members.add(new Users(fornavn, efternavn, age, email, tlf, competition, admin));

            // Gemmer oplysningerne i Members.text
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++)
            {
                file.print(members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() + " " + members.get(i).getPhone() + " " + members.get(i).getCompetitionswimmer() + " " + members.get(i).getAdmin());
                if(i != members.size() -1)
                {
                    file.println();
                }
            }
        
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }








    public void editMembers() {
        try{
            Scanner input = new Scanner(System.in);

            File f = new File("Members.txt");

            f.createNewFile();

            Scanner scan = new Scanner(f);
            ArrayList<Users> members = new ArrayList<Users>();
 
            while(scan.hasNextLine())
            {
                members.add(new Users(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean()));   
            }

            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i));
            }
             
            System.out.print ("Hvilket medlem vil du redigere oplysningerne på? ");
            int number = input.nextInt();

            System.out.print("Tast fornavn ");
            String fornavn = input.next();
            members.get(number).setFirstname(fornavn);

            System.out.print("Tast efternavn ");
            String efternavn = input.next();
            members.get(number).setLastname(efternavn);
            
            System.out.print("Tast alder ");
            int age = input.nextInt();
            members.get(number).setAge(age);

            System.out.print("Tast email ");
            String email = input.next();
            members.get(number).setEmail(email);

            System.out.print("Tast telefonnummer ");
            int tlf = input.nextInt();
            members.get(number).setPhone(tlf);

            System.out.print("Konkurrencesvømmer? ");
            boolean competition = input.nextBoolean();
            members.get(number).setCompetitionswimmer(competition);

            System.out.print("Admin rettigheder? ");
            boolean admin = input.nextBoolean();
            members.get(number).setAdmin(admin);

            // Gemmer oplysningerne i Members.text
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++)
            {
                file.print(members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() + " " + members.get(i).getPhone() + " " + members.get(i).getCompetitionswimmer() + " " + members.get(i).getAdmin());
                if(i != members.size() -1)
                {
                    file.println();
                }
            }
        
        } catch(Exception e)
        {
            System.out.println(e);
        }
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

    public void setAge(int age) {
        this.age = age;
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

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    public int getPhone() {
        return phone;
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

    public int getAge() {
        return age;
    }

    // End of getters

    public String toString()
    {
        return firstname + " " + lastname + " " + age + " " + email + " " + phone + " " + competitionswimmer + " " + admin;
    }

}