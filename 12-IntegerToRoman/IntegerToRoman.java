import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();

        System.out.println(integerToRoman.intToRoman(58));
    }

    public String intToRoman(int num) {
        List<Integer> list = new ArrayList<>(10);

        while (num > 10) {
            list.add(num % 10);

            num = num / 10;
        }

        list.add(num);

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = list.size()-1; i >= 0; i--) {
            stringBuilder.append(convert(list.get(i), i));
        }

        return stringBuilder.toString();
    }

    public String convert(int x, int i) {
        switch (i) {
            case 0:
                return convert1(x);
            case 1:
                return convert2(x);
            case 2:
                return convert3(x);
            case 3:
                return convert4(x);
        }

        throw new RuntimeException();
    }

    private String convert4(int x) {
        switch (x) {
            case 0:
                return "";
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
        }

        throw new RuntimeException();
    }

    private String convert3(int x) {
        switch (x) {
            case 0:
                return "";
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
            case 10:
                return "M";
        }

        throw new RuntimeException();
    }

    private String convert2(int x) {
        switch (x) {
            case 0:
                return "";
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            case 10:
                return "C";
        }

        throw new RuntimeException();
    }

    public String convert1(int x) {
        switch (x) {
            case 0:
                return "";
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
        }

        throw new RuntimeException();
    }
}
