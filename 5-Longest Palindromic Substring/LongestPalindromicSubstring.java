import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        var s = "babad";

        var A = new LongestPalindromicSubstring();

        System.out.println(A.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {

        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            var res = help(s, i);
            if (res.length() > longest.length()) {
                longest = res;
            }
        }

        return longest;
    }

    public String help(String s, int index) {
        char c = s.charAt(index);

        int left = index -1;
        int right = index +1 ;

        var a = center(s, index);
        String b = "";

        if (right < s.length() && s.charAt(right) == c) {
            b = notCenter(s, index, index + 1);
        }

        if (a.length() > b.length()) {
            return a;
        } else {
            return b;
        }
    }

    public String notCenter(String s, int index, int index2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(index));
        stringBuilder.append(s.charAt(index2));

        int i = 1;
        while (true) {
            int left = index - i;
            int right = index2 + i;
            if (left < 0) {
                break;
            }
            if (right >= s.length()) {
                break;
            }

            if (!eq(s, left, right)) {
                break;
            }

            stringBuilder.insert(0, s.charAt(left));
            stringBuilder.append(s.charAt(right));

            i++;
        }

        return stringBuilder.toString();
    }

    public String center(String s, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(index));

        int i = 1;
        while (true) {
            int left = index - i;
            int right = index + i;
            if (left < 0) {
                break;
            }
            if (right >= s.length()) {
                break;
            }

            if (!eq(s, left, right)) {
                break;
            }

            stringBuilder.insert(0, s.charAt(left));
            stringBuilder.append(s.charAt(right));

            i++;
        }

        return stringBuilder.toString();
    }

    public boolean eq(String s, int i, int j) {
        return s.charAt(i) == s.charAt(j);
    }

//    public boolean isPalindrome(String s) {
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            char a = s.charAt(left);
//            char b = s.charAt(right);
//
//            if (a != b) {
//                return false;
//            }
//
//            left++;
//            right--;
//        }
//
//        return true;
//    }
}
