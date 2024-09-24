package uz.pdp.junit_task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathParametrizedTest {
    Math math;

    @BeforeEach
    void setUp() {
        math = new Math();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @CsvSource(value = {
            "a, b, addNumbers",
            "2, 1, 3",
            "4, 2, 6"
    }, useHeadersInDisplayName = true)
    void sum(int a, int b, int excepted) {
        assertEquals(excepted, math.addNumbers(a, b));
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @CsvFileSource(resources = "/source.csv", useHeadersInDisplayName = true, numLinesToSkip = 1)
    void sumCSVFile(int a, int b, int excepted) {
        assertEquals(excepted, math.addNumbers(a, b));
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("sumSource")
    void sum(SumArgument sumArgument) throws IllegalAccessException {
        assertEquals(sumArgument.excepted, math.sum(sumArgument.a, sumArgument.b));
    }
    Stream<SumArgument> sumSource() {
        return Stream.of(
                new SumArgument(2, 3, 5),
                new SumArgument(1, -3, -2),
                new SumArgument(15, -30, -15)
        );
    }

    public static class SumArgument {
        int a;
        int b;
        int excepted;

        public SumArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "SumArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("subSource")
    void sub(SubArgument subArgument) {
        assertEquals(subArgument.excepted, math.sub(subArgument.a, subArgument.b));
    }

    Stream<SubArgument> subSource() {
        return Stream.of(
                new SubArgument(20, 3, 17),
                new SubArgument(1, -3, 4),
                new SubArgument(15, -30, 45)
        );
    }

    public static class SubArgument {
        int a;
        int b;
        int excepted;

        public SubArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "SubArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("addNumbersSource")
    void addNumbers(AddNumbersArgument addNumbersArgument) {
        assertEquals(addNumbersArgument.excepted, math.addNumbers(addNumbersArgument.a, addNumbersArgument.b));
    }

    Stream<AddNumbersArgument> addNumbersSource() {
        return Stream.of(
                new AddNumbersArgument(2, 3, 5),
                new AddNumbersArgument(1, -3, -2),
                new AddNumbersArgument(15, -30, -15)
        );
    }

    public static class AddNumbersArgument {
        int a;
        int b;
        int excepted;

        public AddNumbersArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "AddNumbersArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("divSource")
    void div(DivArgument divArgument) {
        assertEquals(divArgument.excepted, math.div(divArgument.a, divArgument.b));
    }

    Stream<DivArgument> divSource() {
        return Stream.of(
                new DivArgument(12, 3, 4),
                new DivArgument(100, 25, 4)
        );
    }

    public static class DivArgument {
        int a;
        int b;
        int excepted;

        public DivArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "DivArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }


    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("mulSource")
    void mul(MulArgument mulArgument) {
        assertEquals(mulArgument.excepted, math.mul(mulArgument.a, mulArgument.b));
    }

    Stream<MulArgument> mulSource() {
        return Stream.of(
                new MulArgument(2, 3, 6),
                new MulArgument(25, 8, 200)
        );
    }

    public static class MulArgument {
        int a;
        int b;
        int excepted;

        public MulArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "MulArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }

    @ParameterizedTest(name = "{displayName} => {index} : [{arguments}]")
    @MethodSource("powSource")
    void pow(PowArgument powArgument) {
        assertEquals(powArgument.excepted, math.pow(powArgument.a, powArgument.b));
    }

    Stream<PowArgument> powSource() {
        return Stream.of(
                new PowArgument(2, 3, 8),
                new PowArgument(1, 3, 1)
        );
    }

    public static class PowArgument {
        int a;
        int b;
        int excepted;

        public PowArgument(int a, int b, int excepted) {
            this.a = a;
            this.b = b;
            this.excepted = excepted;
        }

        @Override
        public String toString() {
            return "PowArgument{" +
                    "a=" + a +
                    ", b=" + b +
                    ", excepted=" + excepted +
                    '}';
        }
    }
}