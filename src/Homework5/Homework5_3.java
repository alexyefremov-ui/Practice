package Homework5;

import java.util.Scanner;

public class Homework5_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] hall = new char[5][6];

        for (int i = 0; i < hall.length; i++){
            for (int j = 0; j < hall[i].length; j++){
                hall[i][j] = 'O';
            }
        }

        System.out.println("=== ТЕРМІНАЛ КІНОТЕАТРУ: ЗАЛ №1 ===");
        System.out.println("1 - Показати схему залу\n" +
                "2 - Забронювати квиток\n" +
                "3 - Фінансова каса залу\n" +
                "0 - Завершити роботу");

        int comand = 6;
        while (comand != 0) {
            System.out.print("Ваш вибір: ");
            comand = scanner.nextInt();
            System.out.println();
            if (comand == 1){
                System.out.println("      1  2  3  4  5  6");
                for (int i = 0; i < hall.length; i++) {
                    System.out.print("Р" + (i + 1) + ":  ");
                    for (int j = 0; j < hall[i].length; j++) {
                        System.out.print("[" + hall[i][j] + "]");
                    }
                    System.out.println();
                }
                System.out.println();
            }


            if (comand == 2){
                System.out.print("Введіть номер ряду (1-5): ");
                int row = scanner.nextInt();
                System.out.print("Введіть номер місця (1-6): ");
                int column = scanner.nextInt();

                if (row < 1 || row > 5 || column < 1 || column > 6) {
                    System.out.println("❌ Неправильно введено номер ряду або місця!");

                } else {

                    if (hall[row - 1][column - 1] == 'X'){
                        System.out.println("❌ Це місце вже куплене!");

                    } else {
                        hall[row - 1][column - 1] = 'X';
                        System.out.println("✅ Місце [Ряд " + row + ", Місце " + column + "] успішно заброньовано!");
                    }
                }
                System.out.println();


            }


            if (comand == 3){
                int sold = 0;
                int free = 0;
                for (int i = 0; i < hall.length; i++){
                    for (int j = 0; j < hall[i].length; j++){
                        if (hall[i][j] == 'X'){
                            sold ++;
                        }
                        if (hall[i][j] == 'O'){
                            free ++;
                        }
                    }
                }
                int total = sold + free;
                double percent = (double) sold / total * 100;
                double money = sold * 180;
                System.out.println("--- СТАТИСТИКА ЗАЛУ ---");
                System.out.println("Усього місць:       " + total);
                System.out.println("Зайнятих місць:     " + sold);
                System.out.println("Вільних місць:      " + free);
                System.out.printf("Заповненість залу:  %.2f%%%n", percent);
                System.out.printf("Загальна виручка:   %.2f грн%n", money);
                System.out.println("=======================");
                System.out.println();






            }
        }
    }
}