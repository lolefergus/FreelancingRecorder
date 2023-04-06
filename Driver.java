import java.util.ArrayList;
import java.util.List;

public class Driver {
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

                case 2:
                    for (Company company: companies) {
                        System.out.println(company);
                    }

                case 3:
            }

        } while (choice != 4); //program loop
    }

    private static void load(){
        // TODO: 06/04/2023 Create save and load method, remove tempory data
        companies.add(new Company("Paddelsport Coaching", "email@email.provider.com", "123 Street, BB4 123"));
        companies.add(new Company("test"));
    }

    private static int menu(){
        System.out.println("Menu");
        System.out.println("=================");
        System.out.println("1. Add a shift");
        System.out.println("2. View Companies");
        System.out.println("3. Generate Invoice");
        System.out.println("4. Exit");
        System.out.println("=================");
        System.out.print("Enter an option: ");
        int choice = -1;
        boolean invalid = false;
        do{
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e){
                invalid = true;
            }
            if (invalid || choice < 1 || choice > 4) System.out.print("Enter an option between 1 and 4: ");
        } while (choice > 4 || choice < 1);

        return choice;
    }
}
