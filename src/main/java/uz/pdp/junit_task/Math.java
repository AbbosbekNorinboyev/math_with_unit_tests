package uz.pdp.junit_task;

import java.util.Arrays;

public class Math {
    public int sum(int... args) throws IllegalAccessException {
        if (args == null) {
            throw new IllegalAccessException("Arguments can not be null");
        }
        return Arrays.stream(args)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public int div(int a, int b) {
        if (b < 0) {
            try {
                Thread.sleep(100); // thread ni vaqti ko'p bo'lsa timeout dan exception tashlaydi
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return a / b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int pow(int number, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result = result * number;
        }
        return result;
    }
}
