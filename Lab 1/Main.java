import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите задачу 1-5 или введите 0, чтобы выйти: ");
            int task = sc.nextInt();
            if (task == 0) {
                break;
            }
            switch (task) {
                case 1:
                    System.out.println("Введите число: ");
                    int answer1 = Syracuse(sc);
                    System.out.println("Количество шагов: " + answer1);
                    break;
                case 2:
                    System.out.println("Введите количество чисел: ");
                    int answer2 = SumOfSeries(sc);
                    System.out.println("Знакочередующаяся сумма ряда: " + answer2);
                    break;
                default:
                    System.out.println("Неверный номер задачи.");
            }
        }
    }

    public static int Syracuse(Scanner sc) {
        int num = sc.nextInt();
        int steps = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            }
            else {
                num = num * 3 + 1;
            }
            steps++;
        }
        return steps;
    }

    public static int SumOfSeries(Scanner sc) {
        int num = sc.nextInt();
        int sum = 0;
        System.out.println("Введите числа: ");
        for (int i = 0; i < num; i++) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                sum = sum + n;
            }
            else {
                sum = sum - n;
            }
        }
        return sum;
    }
}
