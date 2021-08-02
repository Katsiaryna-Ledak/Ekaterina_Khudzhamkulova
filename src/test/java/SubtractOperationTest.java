import static org.testng.AssertJUnit.assertEquals;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SubtractOperationTest {
    @DataProvider(name = "SubtractOperationTestDataProvider")
    public Object[][] testNumbers() {
        return new Long[][] {
            {5L, 4L},
            {10L, 7L},
            {100L, 90L},
        };
    }

    @Test(dataProvider = "SubtractOperationTestDataProvider")
    public void shouldSubtractTwoLongNumbers(Long number1, Long number2) {
        Calculator calculator = new Calculator();

        Long actual = calculator.sub(number1, number2);
        Long expected = number1 - number2;

        assertEquals(expected, actual);
    }
}
