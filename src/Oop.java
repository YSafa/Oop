import java.util.Scanner;

public class Oop
{
    public static void main(String[] args)
    {
        // Main application loop
        displayWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
           displayMainMenu();
           String choice = scanner.nextLine().toUpperCase(); //Bunu bizim yapmamız da gerekebilir fonksiyon kullanımında nasıl sınır var bakarız
           switch (choice)
           {
               case "A":
                   primarySchoolMenu(scanner);
                   break;
               case "B":
                   //secondarySchoolMenu();
                   break;
               case "C":
                   //highSchoolMenu();
                   break;
               case "D":
                   //universityMenu();
                   break;
               case "E":
                   System.out.println("Terminating the application. Goodbye!");
                   return;
               default:
                   System.out.println("Invalid option. Please try again.");
           }
        }
    }
    //Displays a colorful ASCII art welcome message.
    public static void displayWelcomeMessage() {
        String RESET = "\033[0m";
        String RED = "\033[31m";
        String GREEN = "\033[32m";
        String YELLOW = "\033[33m";
        String BLUE = "\033[34m";
        String PURPLE = "\033[35m";
        String CYAN = "\033[36m";

        System.out.println("\n" + RED + "                 /           /");
        System.out.println(RED + "                /' .,,,,  ./");
        System.out.println(GREEN + "               /';'     ,/");
        System.out.println(GREEN + "              / /   ,,//,`'`");
        System.out.println(YELLOW + "             ( ,, '_,  ,,,' ``");
        System.out.println(YELLOW + "             |    /@  ,,, ;\" `");
        System.out.println(CYAN + "            /    .   ,''/' `,``");
        System.out.println(BLUE + "           /   .     ./, `,, ` ;");
        System.out.println(PURPLE + "        ,./  .   ,-,',` ,,/''\\,'");
        System.out.println(PURPLE + "       |   /; ./,,'`,,'' |   |");
        System.out.println(CYAN + "       |     /   ','    /    |");
        System.out.println(YELLOW + "        \\___/'   '     |     |");
        System.out.println(RED + "           `,,'  |      /     `\\");
        System.out.println(RED + "                /      |        ~\\");
        System.out.println(RED + "               '       (");
        System.out.println(RED + "              :");
        System.out.println(RESET);
    }
    public static void primarySchoolMenu(Scanner scanner)
    { // Screen should be cleared
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {
            // Display Primary School submenu
            System.out.println("\n--- Primary School Menu ---");
            System.out.println("1. Age and Zodiac Sign Detection");
            System.out.println("2. Reverse the Words");
            System.out.println("3. Return to Main Menu");
            System.out.print("Please select an operation: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    //ageAndZodiacDetection(scanner);
                    break;
                case "2":
                    //reverseWords(scanner);
                    break;
                case "3":
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            // After an operation, allow the user to repeat the selection or return
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }


    //Displays the main menu with options for different school levels.
    public static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
        System.out.print("Please select an option: ");
    }


}