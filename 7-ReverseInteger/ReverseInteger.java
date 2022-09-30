import java.util.ArrayList;
import java.util.List;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();

        int x = 2147483647;

        System.out.println(reverseInteger.reverse(x));
    }

    public int reverse(int x) {
        if (x == -2147483648) return 0;
        boolean neg = x < 0;
        if (neg) x = -x;

        String s = String.valueOf(x);
        var rev = new StringBuilder(s).reverse();
        if (neg) rev.insert(0, "-");

        try {
            return Integer.parseInt(rev.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        if (x == -2147483648) return 0;

        boolean neg = x < 0;

        if (neg) x = -x;

        List<Integer> list = new ArrayList<>(10);

        while (x >= 10) {
            list.add(x % 10);

            x = x / 10;
        }

        list.add(x);

        int y = 0;

        if (checkArr(list, neg)) return 0;

        for (int i = 0; i < list.size(); i++) {
            int j = list.size() - i -1;

            y = y + list.get(i) * (int)Math.pow(10, j);
        }

        return neg ? -y : y;
    }

    public boolean checkArr(List<Integer> x, boolean neg) {
        if (x.size() != 10) return false;

        if (x.get(0) < 2) return false;
        if (x.get(0) > 2) return true;

        if (x.get(1) < 1) return false;
        if (x.get(1) > 1) return true;

        if (x.get(2) < 4) return false;
        if (x.get(2) > 4) return true;

        if (x.get(3) < 7) return false;
        if (x.get(3) > 7) return true;

        if (x.get(4) < 4) return false;
        if (x.get(4) > 4) return true;

        if (x.get(5) < 8) return false;
        if (x.get(5) > 8) return true;

        if (x.get(6) < 3) return false;
        if (x.get(6) > 3) return true;

        if (x.get(7) < 6) return false;
        if (x.get(7) > 6) return true;

        if (x.get(8) < 4) return false;
        if (x.get(8) > 4) return true;

        if (neg) {
            if (x.get(9) < 8) return false;
            if (x.get(9) > 8) return true;
        } else {
            if (x.get(9) < 7) return false;
            if (x.get(9) > 7) return true;
        }

        return false;
    }
}
