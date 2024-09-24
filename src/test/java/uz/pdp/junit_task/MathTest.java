package uz.pdp.junit_task;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Class For Math Class")
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)  // () belgini olib tashlaydi
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)  // _ belgini olib tashlaydi
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
// Methodni nomini qo'shib chiqaradi belgini olib tashlaydi
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Display name bo'yicha tartiblab chiqaradi
class MathTest {
    Math math;
    private static final Logger LOGGER = Logger.getLogger(MathTest.class.getName());

    @BeforeEach
    void setUp() {
//        LOGGER.info("@BeforeEach(setUp method working)");
        math = new Math();
    }

    @AfterEach
    void tearDown() {
//        LOGGER.info("@AfterEach(tearDown method working)");
        math = null;
    }

    @BeforeAll
    static void setUpAll() {
//        LOGGER.info("@BeforeAll(setUpAll method working)");
    }

    @AfterAll
    static void tearDownAll() {
//        LOGGER.info("@AfterAll(tearDownAll method working)");
    }

    @Test
    @DisplayName("TestForSum")
    @Order(9)
    void test_for_sum() throws IllegalAccessException {
        int actual = math.sum(12, 23, 34);
        int expected = 69;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForSubtraction")
    @Order(8)
    void test_for_sub() {
        int actual = math.sub(234, 123);
        int expected = 111;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForSubtractionWithMessage")
    @Order(7)
    void test_for_subWithMessage() {
        int actual = math.sub(234, 123);
        int expected = 1111;
        String message = "Expected Value and Actual Value Did not much [expected : %s, actual : %s]"
                .formatted(expected, actual);
        assertNotEquals(expected, actual, message);
        assertEquals(12, math.sub(24, 12));
    }

    @Test
    @DisplayName("TestForAddition")
    @Order(6)
    void test_for_addNumbers() {
        int actual = math.addNumbers(1234, 2345);
        int expected = 3579;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForDivide")
    @Order(5)
    void test_for_div() {
        int actual = math.div(256, 16);
        int expected = 161;
//        assertEquals(expected, actual);
        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForMultiply")
    @Order(4)
    void test_for_mul() {
        int actual = math.mul(100, 200);
        int expected = 20000;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForPower")
    @Order(3)
    void test_for_pow() {
        int actual = math.pow(2, 10);
        int expected = 1024;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("TestForMethodWhichThrowException")
    @Order(2)
    void test_for_div_method_which_throw_exception() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> math.div(10, 0));
        e.printStackTrace();
    }

    @Test
    @DisplayName("TestForDivideMethodWhichHasTimeout")
    @Order(1)
    void test_for_div_method_which_has_timeout() {
        assertTimeout(Duration.ofMillis(3000), () -> math.div(10, -2));
    }

    @Test
    @Disabled("This Test Method ignored disabled for checking @Disabled annotation")
    void ignored() {
    }

    @Test
    @DisabledIf(value = "testCondition", disabledReason = "Disabled Reason")
    void disabledWithCondition() {
    }

    @Test
    @DisabledIf(value = "testCondition", disabledReason = "Enabled Reason")
    void enabledWithCondition() {
    }

    private boolean testCondition() {
        boolean b = new Random().nextBoolean();
        System.out.println(b);
        return b;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void shouldWorkOnWindowsOnly() {
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void shouldWorkOnLinuxOnly() {
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void shouldWorkWindowsOrOnLinuxOnly() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void shouldNotWorkWindows() {
    }

    @Test
    @DisabledOnOs(OS.LINUX)
    void shouldNotWorkLinux() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.LINUX})
    void shouldNotWorkWindowsOrLinux() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void shouldWorkOnJRE_8_Only() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void shouldNotWorkOnJRE_9_Only() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void shouldWorkOnJRE_17_only() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    void shouldWorkOnJRE_Between_8_and_21() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_12)
    void shouldWorkOnJRE_Between_8_and_12() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    void shouldNotWorkONJRE_Between_8_and_21() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    void shouldNotWorkONJRE_Between_8_and_15() {
    }
}
// nastroykini chap tarafidagi belgini bosib report yaratamiz