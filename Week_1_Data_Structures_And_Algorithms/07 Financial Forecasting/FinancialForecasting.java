import java.util.*;

public class FinancialForecasting {

    private static Map<Integer, Double> hisaab = new HashMap<>();

    public static double calculateFutureValueMemoized(double rashi, double dar, int saal) {
        if (hisaab.containsKey(saal)) {
            return hisaab.get(saal);
        }

        if (saal == 0) {
            return rashi;
        }

        double ans = calculateFutureValueMemoized(rashi * (1 + dar), dar, saal - 1);
        hisaab.put(saal, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the initial amount: ");
        double rashi = in.nextDouble();

        System.out.print("Enter the annual growth rate (as a decimal): ");
        double dar = in.nextDouble();

        System.out.print("Enter the number of years: ");
        int saal = in.nextInt();

        double ans = calculateFutureValueMemoized(rashi, dar, saal);

        System.out.printf("Future Value : %.2f%n", ans);
        in.close();
    }
}