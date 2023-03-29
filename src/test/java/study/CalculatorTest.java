package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CalculatorTest extends IOTest {

    private String actual;
    @BeforeEach
    void setUp() {
        actual = "2 + 3 * 4 / 2";
    }

    @Test
    void setInTest() {
        systemIn(actual);
        calculateV1();
    }

    void calculateV1() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        int item = 0;
        String operator = "";
        for (int i = 0; i < values.length; i++) {
            String itemVal = values[i];
            if (i == 0) {
                item = Integer.parseInt(itemVal);
            } else {
                // 연산자
                if (i % 2 == 1) {
                    operator = itemVal;
                } else {
                    if ("+".equals(operator)) {
                        item = item + Integer.parseInt(itemVal);
                    }
                    else if ("-".equals(operator)) {
                        item = item - Integer.parseInt(itemVal);
                    }
                    else if ("*".equals(operator)) {
                        item = item * Integer.parseInt(itemVal);
                    }
                    else if ("/".equals(operator)) {
                        item = item / Integer.parseInt(itemVal);
                    }
                }
            }
        }
        Assertions.assertThat(item).isEqualTo(10);
    }
}
