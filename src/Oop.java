import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;

public class Oop{

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
                   highSchoolMenu(scanner);
                   break;
               case "D":
                   //universityMenu(scanner);
                   break;
               case "E":
                   System.out.println("Terminating the application. Goodbye!");
                   return;
               default:
                   System.out.println(RED + "Invalid option. Please try again." + RESET);
           }
        }
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Displays a colorful ASCII art welcome message.
    public static void displayWelcomeMessage()
    {
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
        clearScreen();
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "                  Main Menu" + RESET);
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(PURPLE + "[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);
        System.out.print(CYAN + "Please select an option: " + RESET);
    }

    public static void primarySchoolMenu(Scanner scanner)
    {
        while (true)
        {
            clearScreen(); // Screen should be cleared
            // Display Primary School submenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "              Primary School Menu " + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. Age and Zodiac Sign Detection");
            System.out.println("2. Reverse the Words");
            System.out.println("3. Return to Main Menu" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);

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
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            // After an operation, allow the user to repeat the selection or return
            System.out.println(RED + "Press Enter to continue..." + RESET);
            scanner.nextLine();
        }
    }

    // Method to determine age and zodiac sign
    public static void ageAndZodiacDetection(Scanner scanner)
    {
        // yaş hesaplama ve int yerine başka bir şey girilmesi durumunda çökmemesi için kod yazılmalı (try catch)
        int day = 0;
        int month = 0;
        int year = 0;
        boolean validYearInput = false;
        boolean validMonthInput = false;
        boolean validDayInput = false;
        boolean leapYear = false;

        clearScreen();
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "       Age and Zodiac Sign Detection ");
        System.out.println(RED + "===============================================" + RESET);


        while(!validYearInput)
        {
            System.out.print(PURPLE + "Please enter the year of your birthday (e. g., 2004): " + RESET);
            try // Attempt to get the numerical input.
            {
                year = scanner.nextInt();
                if (year < 0 || year > 2025) // Is the numerical value in the correct range?
                    System.err.println(RED + "Your birth year must be between 0 and 2025. " + RESET);  // Numerical but out of valid range, print error and loop continues.
                else if(year == -0)
                {
                    System.err.println(RED + "There is noting like -0. " + RESET); // buna minik düzeltme yapcam
                }
                else    // Correct input style and it can be a year so continue
                    validYearInput = true;
            }catch (InputMismatchException e) // User entered text instead of an int.
            {
                System.err.println(RED + "Error! You did not enter a valid integer. Please enter only the year number." + RESET);
                scanner.next();         // If this is not done, it will result in an infinite loop.
            }
        }
        // System.out.println("\nYour birth year has been successfully recorded");     // Exited the loop, valid year is stored. (Gerek var mı idk)
        if(year % 4 == 0)
            leapYear = true;

        // ay doğru mu onu kontrol ediyor
        while(!validMonthInput)
        {
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(PURPLE + "Please enter the month of your birthday (e. g., 9): " + RESET);
            try // Attempt to get the numerical input.
            {
                month = scanner.nextInt();
                if (month < 1 || month > 12) // Is the numerical value in the correct range?
                    System.err.println(RED + "Your birth month must be between 1 and 12. " + RESET);    // Numerical but out of valid range, print error and loop continues.
                else    // Correct input style and it can be a month so continue
                    validMonthInput = true;
            }catch (InputMismatchException e) // User entered text instead of an int.
            {
                System.err.println(RED + "Error! You did not enter a valid integer. Please enter only the month number." + RESET);
                scanner.next();         // If this is not done, it will result in an infinite loop.
            }
        }

        // gün doğru mu onu kontrol ediyor
        while(!validDayInput)
        {
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(PURPLE+ "Please enter the day of your birthday (e. g., 21): " + RESET);
            try // Attempt to get the numerical input.
            {
                day = scanner.nextInt();
                if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day > 0 && day < 32))
                    validDayInput = true;   // Correct input style and it can be a day so continue
                else if((month == 4 || month == 6 || month == 9 || month == 11) && (day > 0 && day < 31))
                    validDayInput = true;   // Correct input style and it can be a day so continue
                else if(month == 2 && (day > 0 && day < 29))
                    validDayInput = true;   // Correct input style and it can be a day so continue
                else if(month == 2 && leapYear && (day > 0 && day < 30))
                    validDayInput = true;   // Correct input style and it can be a day so continue
                else
                    System.err.println(RED + "Your birth day must be in valid day. " + RESET);    // Numerical but out of valid range, print error and loop continues.
            }catch (InputMismatchException e) // User entered text instead of an int.
            {
                System.err.println(RED + "Error! You did not enter a valid integer. Please enter only the day number." + RESET);
                scanner.next();         // If this is not done, it will result in an infinite loop.
            }
        }
        ageCalculator(day, month, year);
        determineZodiacSign(day, month);

        System.out.println(RED + "Press Enter to continue..." + RESET);
        scanner.nextLine();
    }

    // Method to determine age
    public static void ageCalculator(int day, int month, int year)
    {
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();
        int currentMonth = today.getMonthValue();
        int currentDay = today.getDayOfMonth();

        int userYear = currentYear - year;
        int userMonth = currentMonth - month;
        int userDay = currentDay - day;

        int daysInPrevMonth = 0;
        // Adjust for month and day differences
        if (userDay < 0)
        {
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                daysInPrevMonth = 31;
            else if(month == 4 || month == 6 || month == 9 || month == 11)
                daysInPrevMonth = 30;
            else if(month == 2 && (year % 4 == 0))
                daysInPrevMonth = 29;
            else
                daysInPrevMonth = 28;
            userMonth--;
            userDay += daysInPrevMonth;
        }
        if (userMonth < 0)
        {
            userYear--;
            userMonth += 12;
        }
        clearScreen();
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "                  Results ");
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "Your age is: " + userYear + "Year " + userMonth + "Month " + userDay + "Day" + RESET);
        System.out.println(RED + "===============================================" + RESET);
    }

    // Method to determine the zodiac sign
    public static void determineZodiacSign(int day, int month)
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
    }

    public static void highSchoolMenu(Scanner scanner)
{
    // Screen should be cleared
    System.out.print("\033[H\033[2J");
    System.out.flush();

    while (true)
    {
        // Display High School submenu
        System.out.println("\n--- Highschool Menu ---");
        System.out.println("1. Statistical Information About An Array");
        System.out.println("2. Distance Between Two Arrays");
        System.out.println("3. Return to Main Menu");
        System.out.print("Please select an operation: ");

        String choice = scanner.nextLine();
        switch (choice)
        {
            case "1":
                // statisticalInformationAboutAnArray(scanner);
                break;
            case "2":
                distanceBetweenTwoArrays(scanner);
                break;
            case "3":
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option. Please try again.");
                break; // yiğit önceki bodylerde burada break yok, istersen mantıklı mı diye bir bak kullanımı
        } 

    } 
} 



public static void distanceBetweenTwoArrays(Scanner scanner){
    System.out.print("\033[H\033[2J");
    System.out.flush();

    int n = 0;
    // step1 : get array dimension
    while (true){
        System.out.print("Enter the dimension of the arrays: ");
        if(scanner.hasNextInt()){
            n = scanner.nextInt();
            if(n > 0) {
                break;
            }
            else {
                System.out.println("Dimension must be positive.");
        }
            
    }
    else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
    }
    }

    int [] A = new int [n];
    int [] B = new int [n];

    //step2 get valid inputs

    System.out.println("Enter elements for Array A (integers between 0-9):");
    for(int i = 0; i < n; i++){
        A[i] = getValidElement(scanner, i , "A");
    }

    System.out.println("Enter elements for Array B (integer between 0-9):");
    for(int i = 0; i < n; i++){
        B[i] = getValidElement(scanner, i, "B");
    }

    // step3 computing

    double manhattan = 0;
    double euclideanSum = 0;
    double dotProduct = 0, magA = 0, magB = 0;

    for(int i = 0; i < n; i++){
        manhattan  += Math.abs(A[i] - B[i]);
        euclideanSum += Math.pow(A[i] - B[i], 2);
        dotProduct += A[i] * B[i];
        magA += Math.pow(A[i], 2);
        magB += Math.pow(B[i], 2);
    }

    double euclidean = Math.sqrt(euclideanSum);
    double cosineSimilarity = dotProduct / (Math.sqrt(magA)* Math.sqrt(magB));

    System.out.printf("\n--- Results ---\n");
    System.out.printf("Manhattan Distance: %.3f\n", manhattan);
    System.out.printf("Euclidean Distance: %.3f\n", euclidean);
    System.out.printf("Cosine Similarity: %.3f\n", cosineSimilarity);

    scanner.nextLine(); // clear newline before returning
    System.out.println("\nPress Enter to return to the menu...");
    scanner.nextLine();
}

private static int getValidElement(Scanner scanner, int index, String arrayName)
{
    int value;
    while (true) {
        System.out.print(arrayName + "[" + index + "] = ");
        if (scanner.hasNextInt()) {
            value = scanner.nextInt();
            if (value >= 0 && value <= 9)
                return value;
            else
                System.out.println("Invalid entry! Value must be between 0 and 9.");
        } else {
            System.out.println("Invalid input! Please enter an integer.");
            scanner.next(); // clear invalid input
        }
    }
}
    













}

    