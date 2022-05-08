import java.util.HashSet;

public class LongestSubstringWRC {

    public static void main(String[] args) {
        LongestSubstringWRC longestSubstringWRC = new LongestSubstringWRC();

        String s = "ohvhjdml";

        System.out.println(longestSubstringWRC.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }

        Substr substr = new Substr();


        char[] arr = s.toCharArray();
        substr.putChar(arr[0]);
        int longest = 1;

        for (int i = 1; i < arr.length; i++) {
            if (!substr.contains(arr[i])) {
                substr.putChar(arr[i]);
                if (substr.size() > longest) {
                    longest = substr.size();
                }
            } else {
                substr.removeAndAdd(arr[i]);
            }

            if (substr.size() > longest) {
                longest = substr.size();
            }
        }

        return longest;
    }

    static class Substr {
        HashSet<Character> substringSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();


        public void putChar(char c) {
            substringSet.add(c);
            stringBuilder.append(c);
        }

        public boolean contains(char c) {
            return substringSet.contains(c);
        }

        public void removeAndAdd(char c) {

            while(true) {
                char curChar = stringBuilder.charAt(0);
                substringSet.remove(curChar);
                stringBuilder.deleteCharAt(0);

                if (curChar == c) {
                    stringBuilder.append(c);
                    substringSet.add(c);
                    break;
                }
            }
        }

        public int size() {
            return substringSet.size();
        }
    }
}
