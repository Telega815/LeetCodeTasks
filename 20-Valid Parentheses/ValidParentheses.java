public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        String s = "()[]}{";

        System.out.println(validParentheses.isValid(s));
    }

    public boolean isValid(String s) {

        int pos = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        while (pos < stringBuilder.length() - 1) {
            if (!findOpposite(stringBuilder, pos)) {
                pos++;
            } else {
                if (pos != 0) {
                    pos--;
                }
            }
        }

        return stringBuilder.length() == 0;
    }

    private boolean findOpposite(StringBuilder s, int pos) {
        if (giveOpposite(s.charAt(pos)) == s.charAt(pos + 1)) {
            s.delete(pos, pos + 2);

            return true;
        }

        return false;
    }

    private char giveOpposite(char c) {
        switch (c) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
        }

        return 'x';
    }
}
