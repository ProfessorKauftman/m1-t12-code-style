import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundYear(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundYear(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundYear(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculationMenu() {
        int period;
        int action;
        Scanner abcdef = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = abcdef.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = abcdef.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = abcdef.nextInt();
        double outDoubleVar = 0;
        if (action == 1)
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculationMenu();
    }
}
