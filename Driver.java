import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static String div = "=================";

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
                    displayList(companies);
                    int compNum = numInput(0, companies.size()-1);

                    //set date
                    System.out.println("Enter session date\n"+div);
                    String date = System.console().readLine(); //@todo add date and description validation

                    // set session type
                    System.out.println("Select the session type\n"+div);
                    displayList(companies.get(compNum).getSessions());
                    SessionType sessionType = companies.get(compNum).getSessions().get(numInput(0, companies.size()-1)).getType();

                    // get description
                    System.out.println("Enter a description\n"+div);
                    String desc = System.console().readLine();

                    // save session
                    companies.get(compNum).addSession(sessionType, date, desc);

                case 2:
                    System.out.println("Companies\n"+div);
                    displayList(companies);
                    System.out.println(companies.size() +". Return to menu");
                    choice = numInput(0, companies.size());

                    //displays info for selected company
                    if (choice!=companies.size()){
                        companies.get(choice).display();
                        System.out.println(div+"\n0. Manage contact details");
                        System.out.println("1. Manage session types");
                        System.out.println("2. Manage sessions");
                        choice = numInput(0,2);
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
        try{
            companies.add(new Company("Paddlesport Coaching", "email@email.provider.com", "123 Street, BB4 123"));
            companies.add(new Company("test"));
        } catch (CompanyException e){

        }

    }

    private static int menu(){
        System.out.println(div+"\nMenu\n"+div);
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
        } while (choice > max || choice < min);

        System.out.println(div);
        return choice;
    }

    /**
     * Outputs an indexed list
     * @param data list to output
     */
    private static void displayList(List<?> data){
        for(int i = 0; i < companies.size(); i++) {
            System.out.println(i + ". " + companies.get(i));
        }
    }
}
