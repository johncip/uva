/*
 * 10114 - Loansome Car Buyer
 */

import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        for (int mos = in.nextInt(); mos > 0; mos = in.nextInt()) {
            CarLoan loan = readLoan(mos);

            int until = loan.monthsUntil();
            String suffix = until == 1 ? "" : "s";
            System.out.println(until + " month" + suffix);
        }
    }

    static CarLoan readLoan(int months) {
        double downpay = in.nextDouble();
        double amount = in.nextDouble();
        int numrecs = in.nextInt();

        CarLoan loan = new CarLoan(months, downpay, amount, numrecs);
        for (int i = 0; i < numrecs; i++)
            loan.add(in.nextInt(), in.nextDouble());

        return loan;
    }
}

/**
 * Simulation of a car loan.
 */
class CarLoan {
    double downpay, loan;
    int duration, n;

    int[] months;
    double[] deps;

    public CarLoan(int duration, double downpay, double loan, int sz) {
        this.duration = duration;
        this.downpay = downpay;
        this.loan = loan;
        months = new int[sz];
        deps = new double[sz];
    }

    public void add(int month, double dep) {
        months[n] = month;
        deps[n++] = dep;
    }

    /**
     * Simulates depreciation of the car and payment of the loan until the month
     * when the borrower owes less than the car is worth, and prints that month.
     */
    public int monthsUntil() {
        double carValue = loan + downpay;
        double owed = loan; // amount owed

        int idx = 0;
        int i = 0;
        
        // TODO: factor this garbage into one loop
        
        // off the lot
        carValue = depreciate(carValue, idx);
        boolean lastIndex = idx >= months.length - 1;
        if (!lastIndex && i + 1 == months[idx + 1])
            idx++;
        if (owed < carValue)
            return 0;
        i++;

        // following months
        do {
            carValue = depreciate(carValue, idx);
            lastIndex = idx >= months.length - 1;
            if (!lastIndex && i + 1 == months[idx + 1])
                idx++;
            owed = makePaymentOn(owed);
            if (owed < carValue)
                return i;
            i++;
        } while (owed >= carValue);

        return i;
    }

    private double makePaymentOn(double owed) {
        return owed - loan / duration;
    }

    double depreciate(double value, int idx) {
        return value * (1 - deps[idx]);
    }

}
