package Practice2;

public class Homework2_1 {
    public static void main(String[] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5;
        double sum = usdAmount*EXCHANGE_RATE;
        double commission = sum*COMMISSION_PERCENT/100;
        double sumWithCommission = sum - commission;
        double finalSum = Math.round(sumWithCommission);

        System.out.println("================ КВИТАНЦІЯ ОБМІНУ ================");
        System.out.println("Сума до обміну:             " + usdAmount + " USD");
        System.out.println("Курс валют:                 " + EXCHANGE_RATE + " UAH/USD");
        System.out.println("Нараховано до комісії:      " + sum + " UAH");
        System.out.println("Комісія банку (1.5%):       " + commission + " UAH");
        System.out.println("--------------------------------------------------");
        System.out.println("Чиста сума до видачі:       " + sumWithCommission + " UAH");
        System.out.println("До видачі готівкою:         " + (int)finalSum + " UAH");
        System.out.println("==================================================");

    }
}
