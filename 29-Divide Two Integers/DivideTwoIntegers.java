public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

        int dividend = 10;
        int divisor = 3;

        System.out.println(divideTwoIntegers.divide(dividend, divisor));
        System.out.println();

        dividend = -1;
        divisor = 1;

        System.out.println(divideTwoIntegers.divide(dividend, divisor));
        System.out.println();

        dividend = -2147483648;
        divisor = -1;

        System.out.println(divideTwoIntegers.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {

        boolean negative;
        if (dividend > 0 && divisor > 0) negative = false;
        else if (dividend < 0 && divisor < 0) negative = false;
        else negative = true;

        long dividendAbs = Math.abs((long) dividend);

        if (divisor != 1 && divisor != -1) {
            long divisorAbs = Math.abs((long) divisor);
            long sum = dividendAbs;
            long multiplier = 0;

            while (sum > 0 && sum - divisorAbs >= 0) {
                sum = sum - divisorAbs;
                multiplier++;
            }

            if (!negative && multiplier > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (negative && -multiplier < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return negative ? (int) -multiplier : (int) multiplier;
            }
        } else {

            if (!negative && dividendAbs > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return negative ? (int) -dividendAbs : (int) dividendAbs;
            }
        }
    }
}
