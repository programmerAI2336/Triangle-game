public class Test {
    private static final int num = 12345;

    private static int getValueOfDigit(int digit) {
        int number = num;
        for (int i = 0; i <= digit; i++) {
            number -= number % Math.pow(10, i);
        }
        return (int) ((number / Math.pow(10, digit)) % 10);
    }

    public static void main(String[] args) {
        System.out.println(getValueOfDigit(1));
    }
}
