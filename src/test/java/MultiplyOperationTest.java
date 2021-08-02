import static org.testng.AssertJUnit.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyOperationTest {

    @DataProvider(name = "MultiplyOperationTestDataProvider")
    public Object[][] testNumbers() {
        return new Long[][] {
            {5L, -5L},
            {100L, 10L},
            {5L, 10L},
        };
    }

    @Test(dataProvider = "MultiplyOperationTestDataProvider")
    public void shouldMultiplyTwoLongNumbers(Long number1, Long number2) {
        Calculator calculator = new Calculator();

        Long actual = calculator.mult(number1, number2);
        Long expected = number1 * number2;

        assertEquals(expected, actual);
    }
}
