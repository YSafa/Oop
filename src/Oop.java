import java.util.Scanner;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class Oop
{
    // ANSI color codes
    public static final String RESET = "\033[0m";
    public static final String YELLOW = "\033[33m";
    public static final String RED = "\033[31m";
    public static final String PURPLE = "\033[35m";
    public static final String BLUE = "\033[34m";
    public static final String GREEN = "\033[32m";
    public static final String CYAN = "\033[36m";


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
                   universityMenu(scanner);
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
        System.out.println(YELLOW + "Your zodiac sign is: " + zodiacSign + RESET);
        System.out.println(RED + "===============================================" + RESET);
    }




    // Uygulamaların fonksiyonlarını yaparken A-B-C-D diye gidelim, Fonksiyon sırası ona göre olsun sonradan kafa karıştırmasın





    public static void universityMenu(Scanner scanner)
    {
        clearScreen(); // Screen should be cleared
        while(true)
        {
            clearScreen();
            // Display University submenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "               University Menu" + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. Connect Four");
            System.out.println("2. Return to Main Menu" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);
            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    connectFour(scanner);
                    break;
                case "2":
                    return; // Go back to the main menu
                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            // After an operation, allow the user to repeat the selection or return
            System.out.println(RED + "Press Enter to continue..." + RESET);
            scanner.nextLine();
        }
    }

    public static void connectFour(Scanner scanner)
    {
        int sizeOfBoard = boardSize(scanner);
        if(sizeOfBoard == 4)
            return;

        // board size a göre row ve colu ayarlıyor
        int rows = 0, cols = 0;
        if(sizeOfBoard == 1) { cols = 5; rows = 4; }
        else if(sizeOfBoard == 2) { cols = 6; rows = 5; }
        else if(sizeOfBoard == 3) { cols = 7; rows = 6; }

        int modeOfGame = gameMode(scanner);
        if(modeOfGame == 3)
                return;

        // boolean vsComputer = (modeOfGame == 2);

        char[][] board = new char[rows][cols]; // Creating board
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                board[r][c] = ' ';

        char currentPlayer = 'X';

        // Random random = new Random(); // random legal mi bakarız

        printBoard(board, rows, cols);


        // While loop for players to place discs
        while (true)
        {
            System.out.println(CYAN + "Player " + currentPlayer + ", choose a column (1-" + cols + "), or 0 to quit:" + RESET);
            String input = scanner.nextLine();

            if (input.equals("0"))
            {
                System.out.println(RED + "Player " + currentPlayer + " forfeited the game." + RESET);
                break;
            }

            int col;
            try
            {
                col = Integer.parseInt(input) - 1; // User enters 1-7 but the index of array is 0-6
            } catch (NumberFormatException e)
            {
                System.out.println(RED + "Invalid input. Please enter a number." + RESET);
                continue;
            }

            if (col < 0 || col >= cols)
            {
                System.out.println(RED + "Column out of range. Try again." + RESET);
                continue;
            }

            // Checks if the colm is full
            if (board[0][col] != ' ')
            {
                System.out.println(RED + "That column is full. Try another one." + RESET);
                continue;
            }

            // Droping disc animation
            int dropRow = -1;
            for (int r = 0; r < rows; r++)
            {
                if (r == rows - 1 || board[r + 1][col] != ' ')
                {
                    dropRow = r;
                    break;
                }
            }

            // Disc falling effect
            for (int fallingRow = 0; fallingRow <= dropRow; fallingRow++)
            {
                if (fallingRow > 0) board[fallingRow - 1][col] = ' '; // önceki konumu temizle
                board[fallingRow][col] = currentPlayer; // geçici konum

                printBoard(board, rows, cols);

                try {
                    Thread.sleep(120); // milisaniye (animasyon hızı)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // Final position of the disc
            board[dropRow][col] = currentPlayer;

            // Clean the screen and show the board
            printBoard(board, rows, cols);

            // Function for checking for win
            if (checkWinner(board, currentPlayer))
            {
                System.out.println(GREEN + "Player " + currentPlayer + " wins!" + RESET);
                break;
            }

            // Function for checking for ties
            if (isBoardFull(board))
            {
                System.out.println(YELLOW + "The board is full! It's a draw." + RESET);
                break;
            }

            // To change the player
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

    }

    // Selecting the board size
    public static int boardSize(Scanner scanner)
    {
        while(true)
        {
            clearScreen();
            // Display connect four subsubmenu / board selection
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW  + "                 Connect Four " + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW  + "             Select The Board Size " + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. 5x4");
            System.out.println("2. 6x5");
            System.out.println("3. 7x6");
            System.out.println("4. Return to University Menu" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);
            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4; // Go back to the main menu
                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            // After an operation, allow the user to repeat the selection or return
            System.out.println(RED + "Press Enter to continue..." + RESET);
            scanner.nextLine();
        }
    }

    // Choose the game mode
    public static int gameMode(Scanner scanner)
    {
        while(true)
        {
            clearScreen();
            // Display connect four subsubmenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "                 Game Mode" + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Return to University Menu");
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3; // Go back to the main menu
                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            // After an operation, allow the user to repeat the selection or return
            System.out.println(RED + "Press Enter to continue..." + RESET);
            scanner.nextLine();
        }
    }

    // Prints board
    public static void printBoard(char[][] board, int rows, int cols)
    {
        clearScreen();
        System.out.print("   ");
        for (int c = 0; c < cols; c++) System.out.print(" " + (c + 1) + "  ");
        System.out.println();

        System.out.print("  ┌");
        for (int c = 0; c < cols; c++)
        {
            System.out.print("───");
            if (c == cols - 1) System.out.print("┐");
            else System.out.print("┬");
        }
        System.out.println();

        for (int r = 0; r < rows; r++)
        {
            System.out.print((r + 1) + " │");
            for (int c = 0; c < cols; c++)
            {
                char symbol = board[r][c];
                String coloredSymbol = (symbol == 'X') ? RED + "X" + RESET :
                        (symbol == 'O') ? YELLOW + "O" + RESET : " ";
                System.out.print(" " + coloredSymbol + " │");
            }
            System.out.println();

            if (r < rows - 1)
            {
                System.out.print("  ├");
                for (int c = 0; c < cols; c++) {
                    System.out.print("───");
                    if (c == cols - 1) System.out.print("┤");
                    else System.out.print("┼");
                }
            }
            else
            {
                System.out.print("  └");
                for (int c = 0; c < cols; c++)
                {
                    System.out.print("───");
                    if (c == cols - 1) System.out.print("┘");
                    else System.out.print("┴");
                }
            }
            System.out.println();
        }
    }



    // Cheks the winner
    public static boolean checkWinner(char[][] board, char player)
    {
        int rows = board.length;
        int cols = board[0].length;

        // Checks the rows
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols - 3; c++)
            {
                if (board[r][c] == player && board[r][c+1] == player &&
                        board[r][c+2] == player && board[r][c+3] == player)
                    return true;
            }
        }

        // Checks the cols
        for (int c = 0; c < cols; c++)
        {
            for (int r = 0; r < rows - 3; r++)
            {
                if (board[r][c] == player && board[r+1][c] == player &&
                        board[r+2][c] == player && board[r+3][c] == player)
                    return true;
            }
        }

        // Checks bottom-right diagonal
        for (int r = 0; r < rows - 3; r++)
        {
            for (int c = 0; c < cols - 3; c++)
            {
                if (board[r][c] == player && board[r+1][c+1] == player &&
                        board[r+2][c+2] == player && board[r+3][c+3] == player)
                    return true;
            }
        }

        // Checks bottom-left diagonal
        for (int r = 0; r < rows - 3; r++)
        {
            for (int c = 3; c < cols; c++)
            {
                if (board[r][c] == player && board[r+1][c-1] == player &&
                        board[r+2][c-2] == player && board[r+3][c-3] == player)
                    return true;
            }
        }

        return false;
    }

    // Boards is full or not
    public static boolean isBoardFull(char[][] board)
    {
        for (int c = 0; c < board[0].length; c++)
        {
            if (board[0][c] == ' ')
                return false;
        }
        return true;
    }


}