package tecnicas;

public class FizzBuzz {

    public String fizzBuzz(final int value) {

        final var isBuzz = isBuzz(value);
        final var isFizz = isFizz(value);

        if (isFizz) {
            if (isBuzz) {
                return "fizzbuzz!";
            }
            return "fizz!";
        }
        if (isBuzz) {
            return "buzz!";
        }
        return value+"!";
    }

    private boolean isBuzz(final int value) {
        return value % 5 == 0;
    }

    private boolean isFizz(final int value) {
        return value % 3 == 0;
    }
}
