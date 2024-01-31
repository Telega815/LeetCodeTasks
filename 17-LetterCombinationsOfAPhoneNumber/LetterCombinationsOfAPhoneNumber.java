import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    String[][] chars = { {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}, };

    public static void main(String[] args) {
        var letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();

        var digits = "2";

        List<String> strings = letterCombinationsOfAPhoneNumber.letterCombinations(digits);

        for (String s: strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(strings.size());
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        int[] digitArray = new int[digits.length()];

        var charDigits = digits.toCharArray();

        for (int i = 0; i < charDigits.length; i++) {
            digitArray[i] = charDigits[i] - '2';
        }


        List<String> stringList = new ArrayList<>();

        int[] combination = { 0, 0, 0, 0 };

        switch (digitArray.length) {
            case 1:
                return List.of(chars[digitArray[0]]);
            case 2:
                for (int i = 0; i < chars[digitArray[0]].length; i++) {
                    combination[0] = i;
                    for (int j = 0; j < chars[digitArray[1]].length; j++) {
                        combination[1] = j;
                        stringList.add(getString(digitArray, combination));
                    }
                    combination[1] = 0;
                }
                break;
            case 3:
                for (int i = 0; i < chars[digitArray[0]].length; i++) {
                    combination[0] = i;
                    for (int j = 0; j < chars[digitArray[1]].length; j++) {
                        combination[1] = j;
                        for (int k = 0; k < chars[digitArray[2]].length; k++) {
                            combination[2] = k;
                            stringList.add(getString(digitArray, combination));
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; i < chars[digitArray[0]].length; i++) {
                    combination[0] = i;
                    for (int j = 0; j < chars[digitArray[1]].length; j++) {
                        combination[1] = j;
                        for (int k = 0; k < chars[digitArray[2]].length; k++) {
                            combination[2] = k;
                            for (int l = 0; l < chars[digitArray[3]].length; l++) {
                                combination[3] = l;
                                stringList.add(getString(digitArray, combination));
                            }
                        }
                    }
                }
                break;
        }

        return stringList;
    }



    public String getString(int[] digits, int[] combination) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            builder.append(chars[digits[i]][combination[i]]);
        }

        return builder.toString();
    }
}
