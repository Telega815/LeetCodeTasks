public class LongestCommonPrefix {

    public static void main(String[] args) {
        var strs = new String[]{"flower","flow","flight"};

        var longestCommonPrefix = new LongestCommonPrefix();

        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        while (prefCompare(strs, i)) {
            i++;
        }

        return strs[0].substring(0, i);
    }

    public boolean prefCompare(String[] strs, int pos) {
        if (pos >= strs[0].length()) {
            return false;
        }
        char c = strs[0].charAt(pos);

        for (int i = 1; i < strs.length; i++) {
            if (pos >= strs[i].length()){
                return false;
            }else if (strs[i].charAt(pos) != c) {
                return false;
            }
        }

        return true;
    }
}