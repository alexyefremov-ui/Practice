package Practice2;

public class Pratice2 {
    public static void main(String[] args) {
        System.out.println("Завдання 1");
        int age = 18;
        double height = 1.78;
        String firstLetter = "O";
        boolean isStudent = true;
        System.out.println(age);
        System.out.println(height);
        System.out.println(firstLetter);
        System.out.println(isStudent);

        System.out.println("Завдання 2");
        byte temperature = -15;
        short currentYear = 2026;
        int cityPopulation = 1200000;
        long worldPopulation = 8100000000L;
        System.out.println(temperature);
        System.out.println(currentYear);
        System.out.println(cityPopulation);
        System.out.println(worldPopulation);

        System.out.println("Завдання 3");
        float floatValue = 1.1234567f;
        double doubleValue = 1.123456789012345;
        System.out.println(floatValue);
        System.out.println(doubleValue);

        System.out.println("Завдання 4");
        char symbol1 = 'J';
        char symbol2 = 74;
        char symbol3 = '\u004A';
        System.out.println(symbol1);
        System.out.println(symbol2);
        System.out.println(symbol3);

        System.out.println("Завдання 5");
        boolean isJavaFun = true;
        boolean isFishFly = false;
        boolean isSkyBlue = true;
        System.out.println(isJavaFun);
        System.out.println(isFishFly);
        System.out.println(isSkyBlue);

        System.out.println("Завдання 6");
        final double GRAVITY = 9.81;
        final int DAYS_IN_WEEK = 7;
        final String UNIVERSITY_NAME = "Львівська Політехніка";
        System.out.println(GRAVITY);
        System.out.println(DAYS_IN_WEEK);
        System.out.println(UNIVERSITY_NAME);
        // GRAVITY = 10;

        System.out.println("Завдання 7");
        int intVal = 250;
        double doubleVal = intVal;
        System.out.println("int:" + intVal);
        System.out.println("double:" + doubleVal);

        System.out.println("Завдання 8");
        double priceWithPennies = 49.99;
        int roundedPrice = (int) priceWithPennies;
        System.out.println(roundedPrice);

        System.out.println("Завдання 9");
        int firstNumber = 5;
        double userWeight = 72.5;
        String userCity = "Kyiv";
        boolean isValidUser = true;
        System.out.println(firstNumber + ", " + userWeight + ", " + userCity + ", " + isValidUser);

        System.out.println("Завдання 10");
        String firstName = "Тарас";
        String lastName = "Шевченко";
        int ageTwo = 47;
        System.out.println("Мене звати " + firstName + " " + lastName + ", " + "мені " + ageTwo + " років.");

        System.out.println("Завдання 11");
        int a = 10;
        int b = 20;
        System.out.println("Сума без дужок: " + a + b); // тут ми додаемо рядки змінних
        System.out.println("Сума з дужками: " + (a + b)); // Тут ми додаєио саме числа

        System.out.println("Завдання 12");
        String login = "ivan.petrenko";
        String domain = "gmail.com";
        String role = "student";
        System.out.println("Користувач " + login + " (роль: " + role + ") має пошту: " + login + "@" + domain);

        System.out.println("Завдання 13");
        String productName = "Ноутбук";
        int quantity = 2;
        double pricePerUnit = 24500.50;
        System.out.println("ЧЕК:" + "\nТовар: " + productName + "\nКількість: " + quantity + " шт. \nЦіна: " + pricePerUnit + " грн");

        System.out.println("Завдання 14");
        String currency = "UAH";
        int hryvnias = 1500;
        int kopecks = 75;
        System.out.println("Поточний баланс: " + hryvnias + "." + kopecks + " " + currency);

        System.out.println("Завдання 15");
        String protocol = "https://";
        String host = "api.example.com";
        String endpoint = "/users";
        int userId = 42;
        System.out.println("Запит відправлено на: " + protocol + host + endpoint + userId);

        System.out.println("Завдання 16");
        String language = "Java";
        int level = 1;
        boolean isReady = true;
        System.out.println("Мова: " + language + " | Рівень: " + level + " | Готовність до практики: " + isReady);

        System.out.println("Завдання 17");
        int number = 19;
        int remainder = number % 2;
        System.out.println("Число " + number + " при діленні на 2 дає остачу: " + remainder);

        System.out.println("Завдання 18");
        int totalSeconds = 385;
        System.out.println(totalSeconds + " секунд = " + totalSeconds/60 + " хв " + totalSeconds % 60 + " сек");

        System.out.println("Завдання 19");
        int n = 47;
        System.out.println("Число: " + n + ". Десятки: " + n / 10 + ", Одиниці: " + n % 10 + ". Сума цифр: " + ((n / 10)+(n % 10)));

        System.out.println("Завдання 20");
        int score = 100;
        System.out.println(score += 50);
        System.out.println(score -= 20);
        System.out.println(score *= 2);
        System.out.println(score /= 4);

        System.out.println("Завдання 21");
        int counter = 5;
        System.out.println(counter++);
        System.out.println(counter); //Тому що ми спочатку виводимо, а потім додаємо 1 и ще раз виводимо

        System.out.println("Завдання 22");
        int counterTwo = 5;
        System.out.println(++counterTwo); //Спочатку ми додаємо, а потім вже виводимо змінно

        System.out.println("Завдання 23");
        int grade1 = 4;
        int grade2 = 5;
        int grade3 = 4;
        System.out.println("Середній бал: " + (grade1 + grade2 + grade3) / 3.0);

        System.out.println("Завдання 24");
        double celsius = 25.0;
        System.out.println(celsius + "°C = " + (celsius * 1.8 + 32) + "°F");
        System.out.println(celsius + "°C = " + (celsius + 273.15) + " K");

        System.out.println("Завдання 25");
        int userAge = 17;
        boolean isAdult = userAge >= 18;
        System.out.println("Вік: " + userAge + ". Чи є повнолітнім: " + isAdult);

        System.out.println("Завдання 26");
        int x = 15;
        int y = 20;
        System.out.println("x == y: " + (x == y));
        System.out.println("x != y: " + (x != y));
        System.out.println("x > y: " + (x > y));

        System.out.println("Завдання 27");
        int speed = 75;
        boolean isSafeSpeed = (speed >= 20) && (speed <= 80);
        System.out.println(isSafeSpeed);

        System.out.println("Завдання 28");
        int personAge = 70;
        boolean hasFreePass = (personAge < 7) || (personAge >= 65);
        System.out.println("Вік: " + personAge + ". Право на безкоштовний проїзд: " + hasFreePass);

        System.out.println("Завдання 29");
        boolean isDoorLocked = true;
        boolean canEnter = !isDoorLocked;
        System.out.println("Двері зачинені: " + isDoorLocked);
        System.out.println("Чи можна увійти: " + canEnter);

        System.out.println("Завдання 30");
        int numberThree = 30;
        boolean isDivisibleByBoth = (numberThree % 3 == 0) && (numberThree % 5 == 0);
        System.out.println("Для 30: " + isDivisibleByBoth);
        System.out.println("Для 25: " + !isDivisibleByBoth);

        System.out.println("Завдання 31");
        boolean hasPassword = true;
        boolean hasSmsCode = true;
        boolean isAccountBlocked = false;
        boolean canLogin = hasPassword && hasSmsCode && !isAccountBlocked;
        System.out.println("Статус деступу: " + canLogin);

        System.out.println("Завдання 32");
        int year = 2024;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeapYear);

        System.out.println("Завдання 33");
        double aa = 3.0;
        double bb = 4.0;
        double c = Math.sqrt(Math.pow(aa, 2) + Math.pow(bb, 2));
        System.out.println("Катети: " + aa + " та " + bb + ". Гіпотенуза: " + c);

        System.out.println("Завдання 34");
        double radius = 5.0;
        System.out.println("Довжину кола: " + 2*Math.PI*radius);
        System.out.println("Площа круга: " + Math.PI*Math.pow(radius, 2));

        System.out.println("Завдання 35");
        double dayTemp = 18.5;
        double nightTemp = -3.2;
        System.out.println(Math.abs(dayTemp - nightTemp));
        System.out.println(Math.max(dayTemp, nightTemp));
        System.out.println(Math.min(dayTemp, nightTemp));

        System.out.println("Завдання 36");
        double num = 5.67;
        System.out.println(Math.round(num));
        System.out.println(Math.ceil(num));
        System.out.println(Math.floor(num));
        double negNum = -5.67;
        System.out.println(Math.round(negNum));
        System.out.println(Math.ceil(negNum));
        System.out.println(Math.floor(negNum));

        System.out.println("Завдання 37");
        double aaa = 1.0;
        double bbb = -7.0;
        double ccc = 10.0;
        double d = Math.pow(bbb, 2) - 4 * aaa * ccc;
        System.out.println("Дискримінант D = " + d);
        System.out.println("Корінь x1 = " + ((-bbb)+Math.sqrt(d))/2);
        System.out.println("Корінь x2 = " + ((-bbb)-Math.sqrt(d))/2);

        System.out.println("Завдання 38");
        int dice = (int) (Math.random() * 6) + 1;
        System.out.println("Випало на кубику: " + dice);

        System.out.println("Завдання 39");
        int min = -10;
        int max = 35;
        int randomTemp = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Погода на завтра: " + randomTemp + "°C");

        System.out.println("Завдання 40");
        double p=10000;
        double r=12;
        int t=3;
        double s=p*Math.pow((1+r/100), t);
        System.out.println("+------------------------------------+");
        System.out.println("|     ДЕПОЗИТНИЙ КАЛЬКУЛЬАТОР        |");
        System.out.println("+------------------------------------+");
        System.out.println("Початкова сума: " + p + " грн");
        System.out.println("Термін: " + t + " роки під " + r + "% річних");
        System.out.println("Підсумкова сума: " + (float)(p+s) + " грн");
        System.out.println("Чистий прибуток: " + (float)(s-p) + " грн");
        System.out.println("+------------------------------------+");


    }
}
