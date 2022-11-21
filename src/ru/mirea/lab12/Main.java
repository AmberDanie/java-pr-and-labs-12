package ru.mirea.lab12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.print("Task number = ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            default -> {
            }
        }
    }

    public static void task4() {
        /* Task 3.3:
         * Написать регулярное выражение, определяющее является ли данная строчка датой в формате
         * dd/mm/yyyy. Начиная с 1900 года до 9999 года.
         * – пример правильных выражений: 29/02/2000, 30/04/2003, 01/01/2003.
         * – пример неправильных выражений: 29/02/2001, 30-04-2003, 1/1/1899
         */
        Scanner scanner = new Scanner(System.in);
        Pattern regexForDateValidation = Pattern.compile
                ("^(?:(?:31([\\/])(?:0?[13578]|1[02]))\\1|(?:(?:29|30)" +
                        "([\\/])(?:0?[13-9]|1[0-2])\\2))(?:(?:19|[2-9]\\d)\\d{2})" +
                        "$|^(?:29([\\/])0?2\\3(?:(?:(?:19|[2-9]\\d)(?:0[48]|[2468][048]|[13579][26])|" +
                        "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])([\\/])(?:(?:0?[1-9])|" +
                        "(?:1[0-2]))\\4(?:(?:19|[2-9]\\d)\\d{2})$");

        System.out.println("Task 3.3: input date (one whole line):");
        String yourDate = scanner.nextLine();

        boolean matches = regexForDateValidation.matcher(yourDate).matches();

        System.out.println(matches ? "Matches" : "Does not match dd/mm/yyyy format (years 1900 to 9999)");
    }

    public static void task3() {
        /* Task 3.1:
         * Дан текст со списками цен. Извлечь из него цены в USD, RUВ, EU.
         *  – пример правильных выражений: 25.98 USD.
         *  – пример неправильных выражений: 44 ERR, 0.004 EU.
         */

        String PRESET_TEXT_WITH_PRICES =
                """
                Some string
                Another one
                486.91 EUR
                302.34 EUR
                383. USD (<- THAT'S WRONG)
                500000 RUB
                499999RUB
                472.84USD
                426.04 RUB
                hi there
                158.61 USD
                363.98 ERR (<- THAT'S WRONG)
                210.91 EUR
                        """;

        Pattern regex = Pattern.compile("\\d+(\\.\\d+)?\\s(USD|EUR|RUB)");
        Matcher matcher = regex.matcher(PRESET_TEXT_WITH_PRICES);

        System.out.println("Task 3.1: found correct prices: ");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void task2() {
        /* Task 2:
         * Написать регулярное выражение, определяющее является ли данная строка строкой
         * "abcdefghijklmnopqrstuv18340" или нет.
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task 2: input string to test it (one whole line):");
        String stringToTest = scanner.nextLine();
        Pattern regex = Pattern.compile("^abcdefghijklmnopqrstuv18340$");

        System.out.println("Your string DOES" + (regex.matcher(stringToTest).matches() ? "" : " NOT") + " match with preset regex");
    }

    public static void task1() {
        /* Task 1: Splitting string */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task 1: Input string to split (one whole line) " +
                "and then delimiter to be used as splitter (one whole line):");
        String stringToSplit = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.println("Splitted:");
        Arrays.stream(stringToSplit.split(delimiter)).forEach(System.out::println);
    }
}