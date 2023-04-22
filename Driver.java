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
                    System.out.println("Select the company");
                    System.out.println(div);
                    for(int i = 0; i < companies.size(); i++) {
                        System.out.println(i + ". " + companies.get(i));
                    }
                    companies.get(numInput(0, companies.size())).addSession();

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
        System.out.println(div);
        System.out.println("1. Add a shift");
        System.out.println("2. View Companies");
        System.out.println("3. Generate Invoice");
        System.out.println("4. Exit");
        return numInput(1,4);
    }

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
