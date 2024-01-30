import java.util.concurrent.atomic.AtomicInteger;

public class ZigzagConversion {

    public static void main(String[] args) {
        var zigzagConversion = new ZigzagConversion();

        var str = "PAYPALISHIRING";
        var answer = "PAHNAPLSIIGYIR";
        zigzagConversion.check(str, answer, 3);

        answer = "PINALSIGYAHRPI";
        zigzagConversion.check(str, answer, 4);

        zigzagConversion.check(str, str, 40);

        str = "A";
        answer = "A";
        zigzagConversion.check(str, answer, 4);

        str = "AB";
        answer = "AB";
        zigzagConversion.check(str, answer, 1);
    }

    public void check(String string, String answer, int numRows) {
        var res = this.convert(string, numRows);

        System.out.println("check -------------");
        System.out.println(answer.length() + ":" + res.length());
        System.out.println(res.equals(answer));
        System.out.println(res);
        System.out.println();
    }

    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        StringBuilder[] answer;
        if (numRows >= s.length() || numRows == 1) {
            return s;
        } else {
            answer = new StringBuilder[numRows];
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = new StringBuilder();
        }

        var arr = s.toCharArray();

        int j = 0;
        boolean up = true;
        for (char c : arr) {
            answer[j].append(c);

            if (up) {
                if (j == numRows -1) {
                    up = false;
                    j--;
                } else {
                    j++;
                }
            } else {
                if (j == 0) {
                    up = true;
                    j++;
                }else {
                    j--;
                }
            }
        }

        for (StringBuilder stringBuilder : answer) {
            res.append(stringBuilder);
        }

        return res.toString();
    }
}
