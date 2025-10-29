import javax.xml.stream.events.EntityReference;
import java.util.*;
import java.time.LocalDate;

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
                    secondarySchoolMenu(scanner);
                    break;
                case "C":
                    highSchoolMenu(scanner);
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
        System.out.println(GREEN + "              / /   ,,//,'");
        System.out.println(YELLOW + "             ( ,, '_,  ,,,' ``");
        System.out.println(YELLOW + "             |    /@  ,,, ;\" `");
        System.out.println(CYAN + "            /    .   ,''/' ,`");
        System.out.println(BLUE + "           /   .     ./, `,, ` ;");
        System.out.println(PURPLE + "        ,./  .   ,-,',` ,,/''\\,'");
        System.out.println(PURPLE + "       |   /; ./,,'`,,'' |   |");
        System.out.println(CYAN + "       |     /   ','    /    |");
        System.out.println(YELLOW + "        \\_/'   '     |     |");
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
        System.out.println(YELLOW + "                   Main Menu" + RESET);
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(PURPLE + "[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);
        System.out.print(CYAN + "Please select an option: " + RESET);
    }

    //  -------------------------  A PRIMARY SCHOOL  -------------------------

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
                    reverseWords(scanner);
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

    //  ------------------------- A-1 AGE AND ZODIAC  -------------------------

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

        clearScreen();  // Screen should be cleared
        // Display Age and Zodiac submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "         Age and Zodiac Sign Detection ");
        System.out.println(RED + "===============================================" + RESET);


        while(!validYearInput)
        {
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please enter the year of your birthday (e. g., 2004): " + RESET);
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
            System.out.print(CYAN + "Please enter the month of your birthday (e. g., 9): " + RESET);
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
            System.out.print(CYAN + "Please enter the day of your birthday (e. g., 21): " + RESET);
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
        System.out.println(PURPLE + "Your age is: " + RESET + YELLOW + userYear + "Year " + userMonth + "Month " + userDay + "Day" + RESET);
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
        System.out.println(PURPLE + "Your zodiac sign is: " + RESET + YELLOW + zodiacSign + RESET);
        System.out.println(RED + "===============================================" + RESET);
    }

    //  ------------------------- A-2 REVERSE WORDS  -------------------------

    public static void reverseWords(Scanner scanner)
    {
        clearScreen();  // Screen should be cleared
        // Display Reverse Words submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "                 Reverse Words ");
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);

        System.out.print(PURPLE + "Enter a text: " + RESET);
        String str = scanner.nextLine();
        System.out.println(YELLOW + reverseWord(str,false) + RESET);

    }

    public static String reverseWord(String str, boolean isWord){

        if(str.length() <= 1) //kelime değilse direkt döndürecek
            return str;

        if(isWord)//kelimeyse ilk harf hariç geri kalanı döndür, ilk harfi sona ekle
            return reverseWord(str.substring(1),true) + str.charAt(0);

        StringBuilder answer = new StringBuilder();

        int i = 0;

        while(i < str.length() && !Character.isLetter(str.charAt(i))){ //harf olmayanları stringe ekle
            answer.append(str.charAt(i));
            i++;
        }

        int j = i;
        while(j < str.length() && Character.isLetter(str.charAt(j))) //kelimenin sonunu bulacak
            j++;

        String word = str.substring(i,j);
        String rest = str.substring(j);

        if(!word.isEmpty()) //kelimeyse, kelimeyi recursive olarak döndürecek
            answer.append(reverseWord(word, true));
        if(!rest.isEmpty()) //kalanı recursive olarak döndürecek
            answer.append(reverseWord(rest, false));

        return answer.toString();

    }



    //  ------------------------- B SECONDARY SCHOOL  -------------------------

    public static void secondarySchoolMenu(Scanner scanner)
    {
        while (true)
        {
            clearScreen(); // Screen should be cleared
            // Display Secondary School submenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "             Secondary School Menu " + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. Prime Numbers");
            System.out.println("2. Step-by-step Evaluation of Expression");
            System.out.println("3. Return to Main Menu" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);

            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    primeNumbers(scanner);
                    break;
                case "2":
                    stepByStepEvaluationOfExpression(scanner);
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

    //  ------------------------- B-1 PRIME NUMBERS  -------------------------

    public static void primeNumbers(Scanner input)
    {
        clearScreen();  // Screen should be cleared
        // Display Prime Numbers submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "                 Prime Numbers ");
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);

        int number = 0;
        boolean valid = false;

        while (!valid)
        {
            System.out.print(CYAN + "Enter your number(≥12): " + RESET);

            if (input.hasNextInt() == true) // checking if its number
            {
                number = input.nextInt(); // take the number
                if (number >= 12)
                {
                    valid = true;
                }
                else
                {
                    System.out.println(RED + "Number must be ≥ 12 . Try again!" + RESET);
                }
            }
            else    // if it's not a number
            {
                System.out.println(RED + "Invalid input. You should enter a number!" + RESET);
                input.next();  // clear the wrong input
            }
        }

        clearScreen();

        sieveEratosthenes(number);
        sieveSundaram(number);
        sieveAtkin(number);

        input.nextLine();

    }

    public static void sieveEratosthenes(int n)
    {

        // Sieve of Eratosthenes ALGORITMASI //
        long startTime = System.nanoTime(); // zaman için başlangıç

        boolean[] isPrime = new boolean[n + 1]; // n+1, çünkü kullanıcı 10 girerse kontrol etmemiz gereken 11 sayı var

        for (int i = 0; i <= n; i++)
        {
            isPrime[i] = true;  // tüm sayılar asal olarak işaretleniyor
        }

        isPrime[0] = false;  // 0 ve 1 asal sayı olmadığı için false
        isPrime[1] = false;

        // asal olmayan sayıları eleme kısmı
        for (int i = 2; i * i <= n; i++)
        {
            if (isPrime[i] == true) // bu algoritma sayıların katlarını silip
            {                     // kalan sayıları prime olarak işaretler
                for (int j = i * i; j <= n; j = j + i)
                {
                    isPrime[j] = false;
                }
            }
        }
        long endTime = System.nanoTime(); // bitiş zamanı
        double elapsedTime = (endTime - startTime);

        // asal sayıları yeni arraye aktarma
        int[] primes = new int[n];
        int count = 0;

        for (int i = 2; i <= n; i++)
        {
            if (isPrime[i] == true)
            {
                primes[count] = i; // sayıyı diziye atama
                count++;  // kaç tane asal var, onu sayma
            }
        }
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "            Sieve of Eratosthenes" + RESET);
        System.out.println(RED + "===============================================" + RESET);
        if (count >= 5)
        {
            System.out.print(PURPLE + "First 3 primes : " + RESET);
            for (int i = 0; i < 3; i++)
            {
                System.out.print(YELLOW + primes[i] + " " + RESET);
            }
            System.out.println();
            System.out.print(PURPLE + "Last 2 primes : " + RESET);
            System.out.print(YELLOW + primes[count - 2] + " " + RESET);
            System.out.print(YELLOW + primes[count - 1] + RESET);
        }
        System.out.println();
        System.out.println(PURPLE + "Execution time is : " + RESET + YELLOW + elapsedTime + " nanoseconds." + RESET);
        System.out.println();
    }


    public static void sieveSundaram(int n)
    {
        // Sieve of Sundaram ALGORITMASI //


        long startTime = System.nanoTime();
        int limit = (n - 2) / 2; // sadece tek sayılarla çalışılacağı için limit değer belirliyoruz

        boolean[] marked = new boolean[limit+1];

        for(int i = 1 ; i <= limit ; i++)
        {
            for(int j=i ; j <= (limit - i ) / (2 * i + 1) ; j++)  // i ve j çiftleriyle asal olmayan sayıları belirle: i + j + 2*i*j <= limit
            {
                marked[i + j + 2 * i * j ] = true;
            }
        }
        long endTime = System.nanoTime();
        double elapsedTime = (endTime-startTime);

        int[] primes = new int[n];
        int count=0;

        primes[count]=2; // 2 sayısı tek olmadığı için formülde çıkmaz
        count++; // o yüzden biz ekliyoruz.

        for(int i = 1 ; i <= limit ; i++)
        {
            if( marked[i] == false ) // eğer false ise, sayı elenmemiştir. yani asal olabilir.
            {
                int prime = 2 * i + 1; // elenmeyen i değerleri için asal sayı üretiliyor

                if( prime <= n ) // oluşturulan asal sayı kullanıcıdan alınan sayıdan büyük olmamalı
                {
                    primes[count]=prime;
                    count++;
                }
            }
        }
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "              Sieve of Sundaram" + RESET);
        System.out.println(RED + "===============================================" + RESET);

        System.out.print(PURPLE + "First 3 primes : " + RESET);
        for(int i = 0 ; i < 3 ; i++)
        {
            System.out.print(YELLOW + primes[i] + " " + RESET);
        }
        System.out.println();

        System.out.print(PURPLE + "Last 2 primes : " + RESET);
        System.out.print(YELLOW + primes[count - 2] + " " + RESET);
        System.out.print(YELLOW + primes[count - 1] + RESET);
        System.out.println();
        System.out.println(PURPLE + "Execution time is : " + RESET+ YELLOW + elapsedTime + " nanoseconds." + RESET);
        System.out.println();
    }

    public static void sieveAtkin(int n)
    {
        long startTime = System.nanoTime();

        boolean[] isPrime = new boolean[n+1];


        if ( n>2 )
        {
            isPrime[2] = true;
        }
        if ( n>3 )
        {
            isPrime[3] = true;
        }

        for(int x = 1 ; x * x <= n ; x++)
        {
            for(int y = 1 ; y*y <=n ; y++)
            {
                // n = 4x^2 + y^2
                int num = 4 * x * x + y * y;
                if(num <= n && (num %12 == 1 || num % 12 == 5))
                {
                    isPrime[num] = !isPrime[num];
                }
                // n = 3x^2 + y^2
                num = 3 * x * x + y * y;
                if(num <= n && (num % 12 == 7))
                {
                    isPrime[num] = !isPrime[num];
                }

                // n = 3x^2 - y^2
                num = 3 * x * x - y * y;
                if(x > y && num <= n && (num % 12 == 11))
                {
                    isPrime[num] = !isPrime[num];
                }
            }
        }

        for(int i = 5 ; i * i <= n ; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i ; j <= n ; j = j + i * i)
                {
                    isPrime[j] = false;
                }
            }
        }
        long endTime = System.nanoTime();
        double elapsedTime = (endTime-startTime);

        int[] primes = new int[n];
        int count = 0 ;


        // asalları diziye aktarma
        for ( int i = 2 ; i <= n ; i++)
        {
            if(isPrime[i] == true )
            {
                primes[count] = i ;
                count++;
            }
        }
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "                Sieve of Atkin" + RESET);
        System.out.println(RED + "===============================================" + RESET);

        System.out.print(PURPLE + "First 3 primes : " + RESET);
        for(int i = 0 ; i < 3 ; i++)
        {
            System.out.print(YELLOW + primes[i] + " " + RESET);
        }
        System.out.println();

        System.out.print(PURPLE + "Last 2 primes : " + RESET);
        System.out.print(YELLOW + primes[count - 2] + " " + RESET);
        System.out.print(YELLOW + primes[count - 1] + RESET);
        System.out.println();
        System.out.println(PURPLE + "Execution time is : " + RESET + YELLOW + elapsedTime + " nanoseconds." + RESET);
        System.out.println();

    }






    //  ------------------------- B-2 STEP-BY-STEP EVALUATION OF EXPRESSION  -------------------------

    public static void stepByStepEvaluationOfExpression(Scanner scanner) {
        clearScreen();  // Screen should be cleared
        // Display Step-by-step Evaluation of Expression submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "     Step-by-step Evaluation of Expression ");
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);



        boolean valid = false;
        String expr = "";
        while(!valid){
            System.out.println("Enter the expression: ");
            expr = scanner.nextLine();
            if(checkEmpty(expr) || !checkParanthesis(expr)
                    || !checkValidChars(expr)
                    || !checkValidOperators(expr)){
                System.out.println("Invalid expression. Please try again...");
            }
            else{
                valid = true;
            }

        }

        expression(expr);




    }

    public static boolean checkEmpty(String expr){
        if(expr.trim().isEmpty())
            return true;
        return false;
    }

    public static boolean checkValidChars(String expr){
        for(int i = 0;i < expr.length();i++){
            char c = expr.charAt(i);
            if(!(Character.isDigit(c) ||
                    c == 'x' || c == '*' || c == '+' || c == '-' || c == '/' ||
                    c == ':' || c == '(' || c == ')')){
                System.out.println("Invalid character found: " + c);
                return false;
            }
        }
        return true;
    }

    public static boolean checkParanthesis(String expr){

        int balance = 0;

        for(int i = 0;i < expr.length();i++){
            if (expr.charAt(i) == '(') balance++;
            else if (expr.charAt(i) == ')') balance--;
            if (balance < 0) return false;
        }

        return balance == 0;
    }

    public static boolean checkValidOperators(String expr){

        String operators = "+*/:-";

        //operatör ile başlama kontrolü '-' hariç
        if(operators.indexOf(expr.charAt(0)) != -1 && expr.charAt(0) != '-'){
            System.out.println("Expression cannot start with an operator.");
            return false;
        }

        //operatör ile bitme kontrolü
        if(operators.indexOf(expr.charAt(expr.length() - 1)) != -1){
            System.out.println("Expression cannot end with an operator.");
            return false;
        }

        for(int i = 0;i < expr.length()-1;i++){
            char c1 = expr.charAt(i);
            char c2 = expr.charAt(i+1);

            if(operators.indexOf(c1) != -1 && operators.indexOf(c2) != -1){
                //eğer c2 negatif işaretse ve baştaysa, geçerli olacak
                if(!(c2 == '-' && (i == 0 || expr.charAt(i-1) == '('))){
                    System.out.println("Two consecutive operators found: " +c1 + c2);
                    return false;
                }
            }
        }

        return true;

    }

    public static int expression(String expr){

        expr = expr.replaceAll(" ", "");

        if(!expr.contains("(") && !expr.contains(")"))
            return evaluateSimple(expr);

        int lastParanthesis = 0;
        for(int i = 0;i < expr.length();i++){
            if(expr.charAt(i) == '(')
                lastParanthesis = i;
        }

        int paranthesis = lastParanthesis;
        for(int i = paranthesis;i < expr.length();i++){
            if(expr.charAt(i) == ')') {
                paranthesis = i;
                break;
            }
        }

        String inner =  expr.substring(lastParanthesis +1 ,paranthesis);
        int innerResult = evaluateSimple(inner);

        String newExpr = expr.substring(0, lastParanthesis) + innerResult + expr.substring(paranthesis + 1);

        System.out.println("= " + newExpr);

        // Eğer artık hiç parantez yoksa direkt sonucu hesapla
        if (!newExpr.contains("(") && !newExpr.contains(")")) {
            int finalResult = (int) evaluateSimple(newExpr);
            System.out.println("= " + finalResult);
            return finalResult;
        }

        // Aksi halde recursion’a devam et
        return expression(newExpr);



    }

    public static int evaluateSimple(String expr){
        //tüm boşlukları kaldırmak için
        expr = expr.replaceAll(" ", "");


        if (expr.startsWith("(-")) expr = "0" + expr;

        // sayıları ve operatörleri tutacak
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();

        String num = "";
        for(int i = 0;i< expr.length();i++){
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                num += c;
            }
            else if (c == '-' && (i == 0 || expr.charAt(i - 1) == '(' || "+-*/x:".indexOf(expr.charAt(i - 1)) != -1)) {
                // Negatif sayı durumu
                num = "-";
            }
            else {
                // Eğer elimizde geçerli bir sayı varsa ekle
                if (!num.isEmpty() && !num.equals("-")) {
                    numbers.add(Integer.parseInt(num));
                    num = "";
                }
                // Operatörü ekle
                operators.add(c);
            }

        }
        if (!num.isEmpty() && !num.equals("-")) {
            numbers.add(Integer.parseInt(num));
        }


        for(int i = 0;i < operators.size();i++){
            char op = operators.get(i);
            if(op == '*' || op == '/' || op == 'x' || op == ':'){
                int a  = numbers.get(i);
                int b = numbers.get(i+1);

                int result;

                if (op == '*' || op == 'x') {
                    result = a * b;
                } else { // op == '/' veya op == ':'
                    // Sıfıra bölümü engellemek için
                    if (b == 0) {
                        System.out.println("Division by zero is not allowed!");
                        return 0;
                    }
                    result = a / b; // Tam sayı bölmesi
                }

                numbers.set(i, result);
                numbers.remove(i+1);
                operators.remove(i);
                i--;
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            int b = numbers.get(i + 1);
            if (op == '+')
                result += b;
            else if (op == '-')
                result -= b;
        }
        return result;

    }










    //  ------------------------- C HIGH SCHOOL  -------------------------

    public static void highSchoolMenu(Scanner scanner)
    {
        clearScreen(); // Screen should be cleared
        while(true)
        {
            clearScreen();  // Screen should be cleared
            // Display High School submenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "                High School Menu" + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(PURPLE + "1. Statistical Information about an Array");
            System.out.println("2. Distance between Two Arrays");
            System.out.println("3. Return to Main Menu" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Please select an operation: " + RESET);

            String choice = scanner.nextLine();
            switch (choice)
            {
                case "1":
                    statisticalInformationAboutAnArray(scanner);
                    break;
                case "2":
                    distanceBetweenTwoArrays(scanner);
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

    //  ------------------------- C-1 STATISTICAL INFORMATION ABOUT AN ARRAY  -------------------------

    public static void statisticalInformationAboutAnArray(Scanner scanner)
    {
        clearScreen();  // Screen should be cleared
        // Display Statistical Information about an Array submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "    Statistical Information about an Array ");
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(BLUE + "-----------------------------------------------" + RESET);

        int n = 0;
        boolean valid = false;
        while(!valid){
            try{
                System.out.print(PURPLE + "Enter array size: " + RESET);
                n = scanner.nextInt();

                if(n <= 0){
                    System.out.println(RED + "Array size must be positive. " + RESET);
                }
                else{
                    valid = true;
                }
            }
            catch(InputMismatchException e){
                System.out.println(RED + "Please try again: " + RESET);
                scanner.nextLine();
            }
        }

        double[] arr = new double[n];

        for(int i = 0;i < n;i++){
            boolean input = false;
            while(!input){
                try{
                    System.out.print(CYAN + (i+1) + ". element: " + RESET);
                    arr[i] = scanner.nextDouble();
                    input = true;
                }catch(InputMismatchException e){
                    System.out.println(RED + "Incorrect entry! Please enter a value in numeric format." + RESET);
                    scanner.nextLine();
                }
            }
        }


        System.out.println(PURPLE + "The arithmetic mean of array is: " + RESET + YELLOW + arithmeticMean(arr,n) + RESET);
        System.out.println(PURPLE + "The geometric mean of array is: " + RESET + YELLOW + geometricMean(arr,n) + RESET);
        System.out.println(PURPLE + "The harmonic mean of array is: " + RESET + YELLOW + n / harmonicSum(arr,0) + RESET);
        System.out.println(PURPLE + "The median of array is: " + RESET + YELLOW +median(arr,n) + RESET);

        scanner.nextLine();
    }

    public static double arithmeticMean(double[] arr, int n){
        double sum = 0.0;
        for(int i = 0;i < n;i++)
            sum += arr[i];

        return sum / n;
    }

    public static double geometricMean(double[] arr, int n){
        double product = 1.0;
        for(int i = 0;i < n;i++){
            product *= arr[i];
        }
        return Math.pow(product, 1.0 /n);
    }

    public static double median(double[] arr, int n){
        double median = 0.0;
        Arrays.sort(arr);
        if (n % 2 == 1)
            median = arr[n / 2];
        else
            median = (arr[n/2 - 1] + arr[n/2]) / 2.0;
        return median;
    }

    public static double harmonicSum(double[] arr, int index){
        if(index == arr.length) // arrayin sonuysa toplama 0 döndür
            return 0;
        if(arr[index] == 0){ //eğer eleman 0 ise 0'a bölüm hatasından kaçınır
            System.out.println(RED + "Warning: 0 value found at array" + RESET);
            return harmonicSum(arr,index+1);
        }
        return (1.0/arr[index]) + harmonicSum(arr, index +1); //recursive olarak, 1/sayı + kalan şeklinde devam edecek
    }




    //  ------------------------- C-2 DISTANCE BETWEEN TWO ARRAYS  -------------------------

    public static void distanceBetweenTwoArrays(Scanner scanner)
    {
        clearScreen();  // Screen should be cleared
        // Display Distance between Two Arrays submenu
        System.out.println(RED + "===============================================" + RESET);
        System.out.println(YELLOW + "          Distance between Two Arrays ");
        System.out.println(RED + "===============================================" + RESET);

    
        
    clearScreen();

    int n = 0;
    // step1 : get array dimension
    while (true){
        System.out.println(BLUE + "-----------------------------------------------" + RESET);
        System.out.println(CYAN + "Enter the dimension of the arrays: " + RESET);
        if(scanner.hasNextInt()){
            n = scanner.nextInt();
            if(n > 0) {
                break;
            }
            else {
                System.out.println(RED + "Dimension must be positive." + RESET);
        }
            
    }
    else {
                System.out.println(RED + "Invalid input! Please enter an integer." + RESET);
                scanner.next();
    }
    }

    int [] A = new int [n];
    int [] B = new int [n];

    //step2 get valid inputs

    System.out.println(CYAN + "Enter elements for Array A (integers between 0-9): " + RESET);
    for(int i = 0; i < n; i++){
        A[i] = getValidElement(scanner, i , "A");
    }

    System.out.println(CYAN + "Enter elements for Array B (integer between 0-9): " + RESET);
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

    clearScreen();
    System.out.println(RED + "===============================================" + RESET);
    System.out.println(YELLOW + "                  Results ");
    System.out.println(RED + "===============================================" + RESET);
    System.out.printf("%sManhattan Distance: %.3f\n%s",PURPLE, manhattan, RESET);
    System.out.printf("%sEuclidean Distance: %.3f\n%s",PURPLE, euclidean, RESET);
    System.out.printf("%sCosine Similarity: %.3f\n%s",PURPLE, cosineSimilarity, RESET);
    System.out.println(BLUE + "-----------------------------------------------" + RESET);

    scanner.nextLine(); // clear newline before returning
    System.out.println(RED + "Press Enter to return to the menu..." + RESET);
    scanner.nextLine();
}

private static int getValidElement(Scanner scanner, int index, String arrayName)
{
    int value;
    while (true) {
        System.out.print(PURPLE + arrayName + "[" + index + "] = " + RESET);
        if (scanner.hasNextInt()) {
            value = scanner.nextInt();
            if (value >= 0 && value <= 9)
                return value;
            else
                System.out.println(RED + "Invalid entry! Value must be between 0 and 9." + RESET);
        } else {
            System.out.println(RED + "Invalid input! Please enter an integer." + RESET);
            scanner.next(); // clear invalid input
        }
    }
}

    







    //  ------------------------- D UNIVERSITY  -------------------------

    public static void universityMenu(Scanner scanner)
    {
        clearScreen(); // Screen should be cleared
        while(true)
        {
            clearScreen();  // Screen should be cleaned
            // Display University submenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "                University Menu" + RESET);
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


    //  ------------------------- D-1 CONNECT FOUR  -------------------------

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

        char[][] board = new char[rows][cols]; // Creating board
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                board[r][c] = ' ';

        int modeOfGame = gameMode(scanner);

        if (modeOfGame == 1)
            playPvP(scanner, board, rows, cols); // PvP
        else if (modeOfGame == 2)
            playPvC(scanner, board, rows, cols); // PvC
        else
            return;

    }

    // Selecting the board size
    public static int boardSize(Scanner scanner)
    {
        while(true)
        {
            clearScreen();  // Screeen should be cleaned
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
            clearScreen();  // Screen should be cleaned
            // Display connect four subsubmenu
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "                   Game Mode" + RESET);
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


    public static void playPvP(Scanner scanner, char[][] board, int rows, int cols)
    {
        char currentPlayer = 'X';
        printBoard(board, rows, cols);

        while (true)
        {
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
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
                col = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Invalid input. Please enter a number." + RESET);
                continue;
            }

            if (col < 0 || col >= cols)
            {
                System.out.println(RED + "Column out of range. Try again." + RESET);
                continue;
            }

            if (board[0][col] != ' ')
            {
                System.out.println(RED + "That column is full. Try another one." + RESET);
                continue;
            }

            // Disc dropping effect
            dropDiscWithAnimation(board, rows, col, currentPlayer);
            printBoard(board, rows, cols);

            // Checks win
            if (checkWinner(board, currentPlayer))
            {
                System.out.println(GREEN + "Player " + currentPlayer + " wins! 🎉" + RESET);
                break;
            }

            // Checks tie
            if (isBoardFull(board))
            {
                System.out.println(YELLOW + "It's a draw!" + RESET);
                break;
            }

            // Change the disc
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }


    public static void playPvC(Scanner scanner, char[][] board, int rows, int cols) // Player vs computer
    {
        Random random = new Random();

        // Player chooses the disc
        char playerSymbol = 'X';
        char computerSymbol = 'O';

        while (true)
        {
            clearScreen();  // Screen should be cleared
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(YELLOW + "          Player vs Computer Setup" + RESET);
            System.out.println(RED + "===============================================" + RESET);
            System.out.println(BLUE + "-----------------------------------------------" + RESET);
            System.out.print(CYAN + "Do you want to be X (first) or O (second)? Enter X or O: " + RESET);
            String choice = scanner.nextLine().trim().toUpperCase(); // .trim() removes all leading and trailing whitespace characters
            if (choice.equals("X"))
            {
                playerSymbol = 'X';
                computerSymbol = 'O';
                break;
            }
            else if (choice.equals("O"))
            {
                playerSymbol = 'O';
                computerSymbol = 'X';
                break;
            }
            else
            {
                System.out.println(RED + "Invalid choice. Please type X or O.");
                System.out.println("Press Enter to continue..." + RESET);
                scanner.nextLine();
            }
        }

        char currentPlayer = 'X'; // X starts first
        printBoard(board, rows, cols);

        while (true)
        {
            if (currentPlayer == playerSymbol)
            {
                // Player turn
                int col;
                System.out.println(BLUE + "-----------------------------------------------" + RESET);
                System.out.println(CYAN + "Your turn (" + playerSymbol + "). Choose a column (1-" + cols + "), or 0 to quit:" + RESET);
                String input = scanner.nextLine();

                if (input.equals("0"))
                {
                    System.out.println(RED + "You forfeited the game." + RESET);
                    break;
                }

                try
                {
                    col = Integer.parseInt(input) - 1;
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Invalid input. Please enter a number." + RESET);
                    continue;
                }

                if (col < 0 || col >= cols)
                {
                    System.out.println(RED + "Column out of range. Try again." + RESET);
                    continue;
                }

                if (board[0][col] != ' ')
                {
                    System.out.println(RED + "That column is full. Try another one." + RESET);
                    continue;
                }

                dropDiscWithAnimation(board, rows, col, playerSymbol);
                printBoard(board, rows, cols);

                if (checkWinner(board, playerSymbol))
                {
                    System.out.println(GREEN + "You win! 🎉" + RESET);
                    break;
                }

                if (isBoardFull(board))
                {
                    System.out.println(YELLOW + "It's a draw!" + RESET);
                    break;
                }

                currentPlayer = computerSymbol; // Computer turn
            }
            else
            {
                // Computer turn
                System.out.println(YELLOW + "Computer (" + computerSymbol + ") is thinking..." + RESET);
                try
                {
                    Thread.sleep(600);
                }catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }

                int computerCol;
                do
                {
                    computerCol = random.nextInt(cols);
                } while (board[0][computerCol] != ' ');

                dropDiscWithAnimation(board, rows, computerCol, computerSymbol);
                printBoard(board, rows, cols);

                if (checkWinner(board, computerSymbol))
                {
                    System.out.println(RED + "Computer wins! 💻" + RESET);
                    break;
                }

                if (isBoardFull(board))
                {
                    System.out.println(YELLOW + "It's a draw!" + RESET);
                    break;
                }

                currentPlayer = playerSymbol; // Turn for player
            }
        }
    }


    public static void dropDiscWithAnimation(char[][] board, int rows, int col, char player)
    {
        int dropRow = -1;
        for (int r = 0; r < rows; r++)
        {
            if (r == rows - 1 || board[r + 1][col] != ' ')
            {
                dropRow = r;
                break;
            }
        }

        // Disk dropping effect
        for (int fallingRow = 0; fallingRow <= dropRow; fallingRow++)
        {
            if (fallingRow > 0) board[fallingRow - 1][col] = ' ';
            board[fallingRow][col] = player;

            printBoard(board, rows, board[0].length);
            try
            {
                Thread.sleep(120);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        board[dropRow][col] = player;
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