# **Задача №2 Угадываем високосность**

## **Цель**:

1. Написать программу-игру, в которой можно будет угадывать количество дней в году.

### *Пример*:

``` Пример 1
Ваш прошлый лучший результат: 5
В этой игре необходимо угадывать количество дней в году!
Введите год в формате 'yyyy' и количество дней в формате 'ddd' через пробел.
>>>>>>>2020 366
Верно! В 2020 годе 366 дней.
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов:

* **Program** - отвечающий за запуск программы, путем инициирования метода *start()* (с инициированием внутри себя
  вспомогательного метода *printMenu()*);

#### Класс **Program**:
``` java
    public class Program {
    private final Scanner scanner = new Scanner(System.in);
    private final LeapYear leapYear = new LeapYear();
    private static final String FILE = "score.txt";
    private String maxScore;

    public void start() {
        String input;
        readScore();
        while (true) {
            try {
                printMenu();
                input = scanner.nextLine();
                String[] yearAndDays = input.split(" ");
                var inputYear = Integer.parseInt(yearAndDays[0]);
                var inputDays = Integer.parseInt(yearAndDays[1]);
                leapYear.yearAndDaysCorrect(inputYear, inputDays);
                if (inputDays != leapYear.getDays()) {
                    System.out.println(Utils.ANSI_RED + "Ошибка! Ваш счет: " + leapYear.getScore() + Utils.ANSI_RESET);
                    scanner.close();
                    break;
                } else {
                    writeScore();
                    System.out.printf("%sВерно! В %s годе %s дней.%n%s", Utils.ANSI_GREEN, leapYear.getYear(),
                            leapYear.getDays(), Utils.ANSI_RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(Utils.ANSI_RED + "Ошибка ввода!" + Utils.ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "В этой игре необходимо угадывать количество дней в году!"
                + Utils.ANSI_RESET);
        System.out.println("Введите год в формате 'yyyy' и количество дней в формате 'ddd' через пробел.");
        System.out.print(">>>>>>>");
    }

    private void writeScore() {
        maxScore = Integer.toString(leapYear.getScore());
        try (var writer = new BufferedWriter(new FileWriter(FILE))) {
            writer.write(maxScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readScore() {
        maxScore = Integer.toString(leapYear.getScore());
        var parse = Integer.parseInt(maxScore);
        try (var reader = new BufferedReader(new FileReader(FILE))) {
            while ((parse = reader.read()) != -1) {
                //System.out.println("ASCII: " + parse);
                System.out.println("Ваш прошлый лучший результат: " + (char) parse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

* **LeapYear** - задающий логику расчета количества дней через ```void``` метод *yearAndDaysCorrect()*.

#### Метод *yearAndDaysCorrect()* в классе **LeapYear**:
``` java   
 public void yearAndDaysCorrect(int year, int days) {
        if (year % 400 == 0) {
            this.year = year;
            this.days = 366;
        } else if (year % 100 == 0) {
            this.year = year;
            this.days = 365;
        } else if (year % 4 == 0) {
            this.year = year;
            this.days = 366;
        } else {
            this.year = year;
            this.days = 365;
        }
        if (days == this.days) {
            score++;
        }
    }
```

2. Использовал кодирование цвета текста (ANSI).

#### Класс **Utils**:
``` java
public class Utils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void printDelim() {
        System.out.println(ANSI_GREEN + "*********************************************" + ANSI_RESET);
    }
}
```

3. Использовал ```try-catch```, чтобы избежать падение программы в исключения.
4. Дополнительно осуществил работу с файлами (запись и чтение рекорда), установленного в прошлый запуск программы через использование 
методов *readScore()* и *writeScore()*, реализующих ```BufferedReader``` и ```BufferedWriter```.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* меню:
``` 
В этой игре необходимо угадывать количество дней в году!
Введите год в формате 'yyyy' и количество дней в формате 'ddd' через пробел.
>>>>>>>
```