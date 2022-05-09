public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int x = 120;

        System.out.println(palindromeNumber.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        char[] num = String.valueOf(x).toCharArray();

        int min = 0;
        int max = num.length - 1;

        do {
            if (num[max] != num[min]) {
                return false;
            }

            min ++;
            max --;
        }while (min < max);

        return true;
    }
}
