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
                case 3:
                    System.out.println("Укажите координаты клада: ");
                    int answer3 = Treasure(sc);
                    System.out.println("Минимальное число указаний: " + answer3);
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
    public static int Treasure(Scanner sc) {
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int x = 0;
        int y = 0;
        int steps = 0;
        int minSteps = Integer.MAX_VALUE;
        System.out.println("Укажите направление и количество шагов или стоп: ");
        while (true) {
            String direction = sc.next();
            if (direction.equals("стоп")) {
                break;
            }
            int distance = sc.nextInt();
            switch (direction) {
                case "север":
                    y += distance;
                    break;
                case "юг":
                    y -= distance;
                    break;
                case "запад":
                    x -= distance;
                    break;
                case "восток":
                    x += distance;
                    break;
            }
            steps++;
            if (x == X && y == Y) {
                minSteps = Math.min(minSteps, steps);
            }
        }
        return minSteps;
    }
}