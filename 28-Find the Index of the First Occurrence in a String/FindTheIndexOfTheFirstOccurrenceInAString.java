public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        var solution = new FindTheIndexOfTheFirstOccurrenceInAString();

        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(solution.strStr(haystack, needle));

        haystack = "leetcode";
        needle = "leeto";

        System.out.println(solution.strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issip";

        System.out.println(solution.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) return -1;

        var charsH = haystack.toCharArray();
        var charsN = needle.toCharArray();

        for (int i = needle.length() - 1; i < charsH.length; i++) {
            int x =  needle.length() - 1; int y = i;
            while (charsH[y] == charsN[x]) {
                x--;
                if (x == -1) {
                    return y;
                } else {
                    y--;
                }
            }
        }

        return -1;
    }

}
