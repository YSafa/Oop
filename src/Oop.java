import java.util.Scanner;
import java.time.LocalDate;

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
                   //secondarySchoolMenu(scanner);
                   break;
               case "C":
                   //highSchoolMenu(scanner);
                   break;
               case "D":
                   //universityMenu(scanner);
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
    public static void displayWelcomeMessage()
    {
        // ANSI color codes
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


    //Displays the main menu with options for different school levels.
    public static void displayMainMenu()
    {
        System.out.println("\n--- Main Menu ---");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
        System.out.print("Please select an option: ");
    }

    public static void primarySchoolMenu(Scanner scanner)
    { // Screen should be cleared
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true)
        {
            // Display Primary School submenu
            System.out.println("\n--- Primary School Menu ---");
            System.out.println("1. Age and Zodiac Sign Detection");
            System.out.println("2. Reverse the Words");
            System.out.println("3. Return to Main Menu");
            System.out.print("Please select an operation: ");

            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    ageAndZodiacDetection(scanner);
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

    // Method to determine age and zodiac sign
    public static void ageAndZodiacDetection(Scanner scanner)
    {
        // yaş hesaplama ve int yerine başka bir şey girilmesi durumunda çökmemesi için kod yazılmalı (try catch)
        int day, month, year;
        //ageCalculator(day, month, year);
        //determineZodiacSign(day, month);
    }

    // Method to determine age
    //ageCalculator(int day, int month, int year){}

    // Method to determine the zodiac sign (şimdilik kapalı, ageAndZodiacDetection() fonksiyonuna scanner ekleyince açarız)
    /*public static void determineZodiacSign(int day, int month)
    {
        String zodiacSign = "";
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            zodiacSign = "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            zodiacSign = "Pisces";
        } else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            zodiacSign = "Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            zodiacSign = "Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            zodiacSign = "Gemini";
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            zodiacSign = "Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            zodiacSign = "Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            zodiacSign = "Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            zodiacSign = "Libra";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            zodiacSign = "Scorpio";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            zodiacSign = "Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            zodiacSign = "Capricorn";
        } else {
            zodiacSign = "Invalid date";
        }
        System.out.println("Your zodiac sign is: " + zodiacSign);
    }*/


}