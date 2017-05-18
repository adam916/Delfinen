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

    public void addMembers() {
        try{
            Scanner input = new Scanner(System.in);
            // System.out.println("Hvad skal file hedde");
            // String navn = input.next();
            // Læs fra text fil
            File f = new File("Members.txt");
            // Opretter ny fil hvis den ikke er der i forvejen
            f.createNewFile();
            //PrintStream file = new PrintStream(new File("person.txt"));
            Scanner scan = new Scanner(f);
            ArrayList<Users> members = new ArrayList<Users>();
 
            while(scan.hasNextLine())
            {
                members.add(new Users(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean()));   
            }


            // ArrayListe af personer

            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i));
            }
             
            System.out.print ("Hvilken person vil du redigere ");
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


            // Skriver til text filen
            PrintStream file = new PrintStream(f);
            members.add(new Users());
            
            for(int i = 0; i < members.size(); i++)
            {
                // file.println();   
                
                file.print(members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge());
                
                // ingen linieskift til den sidste person i arraylisten
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

    public int getAge() {
        return age;
    }

    // End of getters

}