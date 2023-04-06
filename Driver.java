import java.io.Console;
import java.util.List;

public class Driver {
    private List<Company> compaies;

    public static void main(String[] args) {
        //load data
        load();

        //display menu
        int choice;
        do {
            choice = menu();

            //run selection
        } while (choice != 4); //program loop
    }

    private static void load(){

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
