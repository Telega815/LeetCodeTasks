import java.util.HashSet;

public class Atoi {

    public static void main(String[] args) {
        Atoi atoi = new Atoi();

        System.out.println((int) '9');
        System.out.println();

        System.out.println("-42a1234:  " + atoi.myAtoi("    -42a1234"));
        System.out.println("00000-42a1234:  " + atoi.myAtoi("00000-42a1234"));
        System.out.println("21474836460:  " + atoi.myAtoi("21474836460"));
        System.out.println("-+12:   " + atoi.myAtoi("-+12"));
        System.out.println("-91283472332:   " + atoi.myAtoi("-91283472332"));
    }

    public int myAtoi(String s) {
        boolean positive = true;
        boolean set = false;

        boolean started = false;

        int start = -1;
        int end = s.length();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean contains = 48 <= c && 57 >= c;
            if (started && !contains) {
                end = i;
                break;
            }

            if (!started) {
                if (c == '-' && !set) {
                    set = true;
                    positive = false;
                    continue;
                } else if (c == '+' && !set) {
                    set = true;
                    continue;
                } else if (c == ' ' && !set){
                    continue;
                }
            }


            if (contains) {

                if (!started) {
                    started = true;
                    start = i;
                }

                continue;
            }

            end = i;
            break;
        }

        if (start == -1) {
            return 0;
        }

        try {
            int res = Integer.parseInt(s.substring(start, end));
            return positive ? res : -res;
        } catch (NumberFormatException e) {
            if (positive)
                return 2147483647;
            else
                return -2147483648;
        }
    }
}
