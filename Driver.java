import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private static String div = "=================";

    public static List<Company> companies = new ArrayList<>();

    public static void main(String[] args) {
        //load data
        load();

        //display menu
        int choice;
        do {
            choice = menu();

            //run selection
            switch (choice){
                case 1:
                    System.out.println("Select the company\n"+div);
                    for(int i = 0; i < companies.size(); i++) {
                        System.out.println(i + ". " + companies.get(i));
                    }
                    int compNum = numInput(0, companies.size());

                    //set date
                    System.out.println("Enter session date\n"+div);
                    String date = System.console().readLine(); //@todo add date and description validation

                    // set session type
                    System.out.println("Select the session type\n"+div);
                    for(int i = 0; i < companies.get(compNum).getSessions().length; i++) {
                        System.out.println(i + ". " + companies.get(compNum).getSessions()[i]);
                    }
                    SessionType sessionType = companies.get(compNum).getSessions()[numInput(0, companies.size())].getType();

                    // get description
                    System.out.println("Enter a description\n"+div);
                    String desc = System.console().readLine();

                    // save session
                    companies.get(compNum).addSession(sessionType, date, desc);

                case 2:
                    for (Company company: companies) {
                        System.out.println(company);
                    }

                case 3:
            }

        } while (choice != 4); //program loop
    }

    /**
     * Loads save data
     * 
     * @todo add save and load system
     */
    private static void load(){
        companies.add(new Company("Paddelsport Coaching", "email@email.provider.com", "123 Street, BB4 123"));
        companies.add(new Company("test"));
    }

    private static int menu(){
        System.out.println("Menu");
        System.out.println(div);
        System.out.println("1. Add a shift");
        System.out.println("2. View Companies");
        System.out.println("3. Generate Invoice");
        System.out.println("4. Exit");
        return numInput(1,4);
    }

    /**
     * Gets user input for console menus
     * @param min Minimum input value
     * @param max Maximum input value
     * @return Users number choice
     */
    private static int numInput(int min, int max){
        System.out.println(div);

        String prompt = "Enter an option between " + min + " and " + max + ": ";
        System.out.print(prompt);

        int choice = -1;
        boolean invalid = false;
        do{
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e){
                invalid = true;
            }
            if (invalid || choice < min || choice > max) System.out.print(prompt);
        } while (choice > 4 || choice < 1);

        return choice;
    }
}
