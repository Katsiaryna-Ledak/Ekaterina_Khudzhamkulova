import static org.testng.AssertJUnit.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumOperationTest {

    @DataProvider(name = "SumOperationTestDataProvider")
    public Object[][] testNumbers() {
        return new Object[][] {
            {5L, -5L},
            {100L, 10L},
            {5L, 10L},
        };
    }

    @Test(dataProvider = "SumOperationTestDataProvider")
    public void shouldSumTwoLongNumbers(Long number1, Long number2) {
        Calculator calculator = new Calculator();

        Long actual = calculator.sum(number1, number2);
        Long expected = number1 + number2;

        assertEquals(expected, actual);
    }
}
