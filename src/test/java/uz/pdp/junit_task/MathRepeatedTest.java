package uz.pdp.junit_task;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MathRepeatedTest {
    Math math;
    Random random;

    @BeforeEach
    void setUp() {
        math = new Math();
        random = new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for sum")
    void sum() throws IllegalAccessException {
        int a = random.nextInt(10, 20);
        int b = random.nextInt(20, 30);
        int c = random.nextInt(30, 40);
        int expected = a + b + c;
        assertEquals(expected, math.sum(a, b, c));
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for sub")
    void sub() {
        int a = random.nextInt(100, 800);
        int b = random.nextInt(30, 200);
        int expected = a - b;
        assertEquals(expected, math.sub(a, b));
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for add")
    void addNumbers() {
        int a = random.nextInt(100, 800);
        int b = random.nextInt(30, 200);
        int expected = a + b;
        assertEquals(expected, math.addNumbers(a, b));
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for divide")
    void div() {
        int a = random.nextInt(100, 300);
        int b = random.nextInt(10, 50);
        int expected = a / b;
        assertEquals(expected, math.div(a, b));

    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for mul")
    void mul() {
        int a = random.nextInt(100, 800);
        int b = random.nextInt(30, 200);
        int expected = a * b;
        assertEquals(expected, math.mul(a, b));
    }

    @RepeatedTest(value = 10, name = "Repetition {currentRepetition} For ({displayName}) : Repetitions : {totalRepetitions}")
    @DisplayName("Test method for pow")
    void pow() {
        int a = random.nextInt(2, 10);
        int b = random.nextInt(2, 5);
        int expected = (int) java.lang.Math.pow(a, b);
        assertEquals(expected, math.pow(a, b));
    }
}