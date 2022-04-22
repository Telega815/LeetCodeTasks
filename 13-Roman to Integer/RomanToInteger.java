public class RomanToInteger {

    public static void main(String[] args) {
        var romanToInteger = new RomanToInteger();

        var s = "MCMXCIV";

        System.out.println(romanToInteger.romanToInt(s));
    }

    public int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length() -1; i++) {
            sum += rTiSub(s.charAt(i), s.charAt(i+1));
        }

        sum += convertChar(s.charAt(s.length()-1));

        return sum;
    }

    public int rTiSub(char first, char second) {

        int f = convertChar(first);
        int s = convertChar(second);

        switch (f) {
            case 1:
                if (s == 5 || s == 10) {
                    return -1;
                }else {
                    return 1;
                }
            case 10:
                if (s == 50 || s == 100) {
                    return -10;
                }else {
                    return 10;
                }
            case 100:
                if (s == 500 || s == 1000) {
                    return -100;
                }else {
                    return 100;
                }
            default:
                return f;
        }
    }

    public int convertChar(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        throw new IllegalArgumentException("NOT ROMANIAN LETTER!");
    }
}
