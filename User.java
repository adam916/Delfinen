import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private int phone;
    private boolean competitionswimmer = false;
    private boolean admin = false ;
    private boolean activemembership;

    ArrayList<User> members = new ArrayList<User>();

    public User(int userid, String firstname, String lastname, int age, String email, int phone, boolean activemembership, boolean competitionswimmer, boolean admin) {
        this.userid= userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.activemembership = activemembership;
        this.competitionswimmer = competitionswimmer;
        this.admin = admin;
    }

    public User() {
    }

    public void createMember() {
    
        try{
            Scanner input = new Scanner(System.in);

            File f = new File("Members.txt");

            f.createNewFile();

            Scanner scan = new Scanner(f);
            ArrayList<User> members = new ArrayList<User>();
            
            while(scan.hasNextLine())
            {   
                members.add(new User(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean()));
            }

            System.out.println("Du har valgt at oprette et nyt medlem" );
            System.out.print("Tast fornavn ");
            String firstname = input.next();

            System.out.print("Tast efternavn ");
            String lastname = input.next();
            
            System.out.println("Tast et unikt id");
            int userid = input.nextInt();

            System.out.print("Tast alder ");
            int age = input.nextInt();

            System.out.print("Tast email ");
            String email = input.next();

            System.out.print("Tast telefonnummer ");
            int phone = input.nextInt();

            System.out.print("Aktivt medlemsskab? (true/false) ");
            boolean activemembership = input.nextBoolean();

            System.out.print("Konkurrencesvømmer? (true/false) ");
            boolean competition = input.nextBoolean();

            System.out.print("Admin rettigheder? (true/false) ");
            boolean admin = input.nextBoolean();

            // Adds the newly made member to our arraylist
            members.add(new User(userid, firstname, lastname, age, email, phone, activemembership, competition, admin));

            // Saves the information in our file named Members.text
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++){
                file.print(members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() +
                " " + members.get(i).getPhone() + " " + members.get(i).getActivemembership() + " "  + members.get(i).getCompetitionswimmer() + " " + members.get(i).getAdmin());   
                
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

    public void editMember() {
        Scanner input = new Scanner(System.in);
       
        try{
           
            File f = new File("Members.txt");

            f.createNewFile();

            Scanner scan = new Scanner(f);
            ArrayList<User> members = new ArrayList<User>();

            while(scan.hasNextLine())
            {
                members.add(new User(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean()));   
            }

            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i));
            }
             
            System.out.print ("Hvilket medlem vil du redigere oplysningerne på? ");
            int number = input.nextInt();

            System.out.print("Tast nyt fornavn ");
            String firstname = input.next();
            members.get(number).setFirstname(firstname);

            System.out.print("Tast nyt efternavn ");
            String lastname = input.next();
            members.get(number).setLastname(lastname);
            
            System.out.print("Tast ny alder ");
            int age = input.nextInt();
            members.get(number).setAge(age);

            System.out.print("Tast ny email ");
            String email = input.next();
            members.get(number).setEmail(email);

            System.out.print("Tast nyt telefonnummer ");
            int phone = input.nextInt();
            members.get(number).setPhone(phone);

            System.out.print("Ny aktiv medlemsskabsstatus? (true/false) ");
            boolean activemembership = input.nextBoolean();
            members.get(number).setActivemembership(activemembership);

            System.out.print("Ny konkurrencesvømmer status? (true/false) ");
            boolean competition = input.nextBoolean();
            members.get(number).setCompetitionswimmer(competition);

            System.out.print("Ny admin rettigheder status? (true/false) ");
            boolean admin = input.nextBoolean();
            members.get(number).setAdmin(admin);

            // Gemmer oplysningerne i Members.text
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++)
            {
                 file.print(members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() +
                     " " + members.get(i).getPhone() + " " + members.get(i).getActivemembership() + " "  + members.get(i).getCompetitionswimmer() + " " + members.get(i).getAdmin());

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

    // Delete member
    public void deleteMember(){
        try{
            
            File f = new File("Members.txt");


            Scanner scan = new Scanner(f);
            ArrayList<User> members = new ArrayList<User>();

            while(scan.hasNextLine())
            {
                members.add(new User(scan.nextInt(), scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.nextInt(), scan.nextBoolean(), scan.nextBoolean(), scan.nextBoolean()));   
            }

            Scanner inputDelete = new Scanner(System.in);
            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i));  
            }
            System.out.println("Hvilket medlem skal slettes? ");
            int deleteNumb = inputDelete.nextInt();
            members.remove(deleteNumb);			
            System.out.println("Medlem er nu slettet ");
            PrintStream file = new PrintStream(f);
            for(int i = 0; i < members.size(); i++)
            {
                file.print(members.get(i).getUserId() + " " + members.get(i).getFirstname() + " " + members.get(i).getLastname() + " " + members.get(i).getAge() + " " + members.get(i).getEmail() +
                " " + members.get(i).getPhone() + " " + members.get(i).getActivemembership() + " "  + members.get(i).getCompetitionswimmer() + " " + members.get(i).getAdmin());
                
                if(i != members.size() -1)
                {
                    file.println();
                }
            }

            for(int i = 0; i < members.size(); i++)
            {
                System.out.println(i + " " + members.get(i));  
            }

            }catch(Exception e) 
            {
                System.out.println(e);
            }

    }
 
    // Admin login with preset password
    public void isAdmin() {
        System.out.print("Tast kodeord for at logge ind som admin: ");
        String passWordInput = System.console().readLine();
        if (passWordInput.equals("password")) {
            System.out.println("Du har du admin rettigheder");
            admin = true;
        }else {
            System.out.println("Forkert kodeord.");
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

    public void setActivemembership(boolean activemembership) {
        this.activemembership = activemembership;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
    public int getUserId() {
        return userid;
    }

    public boolean getCompetitionswimmer() {
        return competitionswimmer;
    }

    public boolean getActivemembership() {
        return activemembership;
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
        return userid + " " + firstname + " " + lastname + " " + age + " " + email + " " + phone + " " + activemembership + " " + competitionswimmer + " " + admin;
    }

   
}