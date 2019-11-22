package app;

class Solution {
    public int reverse(int x) {
        String number = x + "", reversedNumber = "";
        char sign = '+';

        if (number.charAt(0) == '-') {
            sign = '-';
            number = number.substring(1);
        }

        for (int i = (number.length() - 1); i >= 0; i--) {
            reversedNumber += number.charAt(i);
        }

        if (sign == '-') {
            reversedNumber = sign + reversedNumber;
        }

        try {
            x = Integer.parseInt(reversedNumber);
        } catch (NumberFormatException nFormatException) {
            return 0;
        }
        return x;
    }
}