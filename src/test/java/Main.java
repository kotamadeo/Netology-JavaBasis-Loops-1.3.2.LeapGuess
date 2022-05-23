

import java.util.Scanner;

public class Main {
    private static Utils utils = new Utils();
    private static int year, days;
    private static int score = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) {
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                String[] yearAndDays = input.split(" ");
                int inputYear = Integer.parseInt(yearAndDays[0]);
                int inputDays = Integer.parseInt(yearAndDays[1]);
                yearAndDaysCorrect(inputYear, inputDays);
                if (inputDays != days) {
                    System.out.println(utils.getAnsiRed() + "Ошибка! Ваш счет: " + score + utils.getAnsiReset());
                    scanner.close();
                    break;
                } else {
                    System.out.printf("%sВерно! В %s годе %s дней.%n%s", utils.getAnsiGreen(), year,
                            days, utils.getAnsiReset());
                }
            } catch (NumberFormatException e) {
                System.out.println(utils.getAnsiRed() + "Ошибка ввода!" + utils.getAnsiReset());
            }
        }
    }

    public static void yearAndDaysCorrect(int yearInput, int daysInput) {
        if (year % 400 == 0) {
            year = yearInput;
            days = 366;
        } else if (year % 100 == 0) {
            year = yearInput;
            days = 365;
        } else if (year % 4 == 0) {
            year = yearInput;
            days = 366;
        } else {
            year = yearInput;
            days = 365;
        }
        if (daysInput == days) {
            score++;
        }
    }

    static void printMenu() {
        System.out.println(utils.getAnsiYellow() + "В этой игре необходимо угадывать количество дней в году!"
                + utils.getAnsiReset());
        System.out.println("Введите год в формате 'yyyy' и количество дней в формате 'ddd' через пробел.");
        System.out.print(">>>>>>>");
    }
}