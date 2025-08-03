import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @DisplayName("문자열 계산기 양식에 맞춰 입력하면, 단일 연산의 예상 값이 출력된다")
    @Test
    void the_expected_valued_of_single_operation_is_output_when_inputting_in_the_string_calculator_format() {
        String input = "2 + 3";

        assertThat(calculator.stringCalculate(input)).isEqualTo(5);
    }

    @DisplayName("문자열 계산기 양식에 맞춰 입력하면, 다중 연산의 예상 값이 출력된다")
    @Test
    void the_expected_valued_of_multiple_operations_is_output_when_inputting_in_the_string_calculator_format() {
        String input = "2 + 3 * 4 / 2";

        assertThat(calculator.stringCalculate(input)).isEqualTo(10);
    }

    @DisplayName("문자열 계산기 양식에 맞춰 입력하면, 음수도 잘 연산된다")
    @Test
    void negative_number_is_calculated_well_when_inputting_in_the_string_calculator_format() {
        String input = "2 + -3 * 4 / 2";

        assertThat(calculator.stringCalculate(input)).isEqualTo(-2);
    }

    @DisplayName("문자열 계산기 양식에 어긋난 입력(1) - 모두 띄어쓰기가 안 된 경우")
    @Test
    void exception_occurs_if_there_is_no_spacing() {
        String input = "2+3*4/2";

        assertThatThrownBy(() -> {
            calculator.stringCalculate(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("문자열 계산기 양식에 어긋난 입력(2) - 하나라도 띄어쓰기가 안 된 경우")
    @Test
    void exception_occurs_if_there_even_one_space_is_missing() {
        String input = "2+ 3 * 4 / 2";

        assertThatThrownBy(() -> {
            calculator.stringCalculate(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("문자열 계산기 양식에 어긋난 입력(3) - 연산자가 이어서 입력된 경우")
    @Test
    void exception_occurs_if_operators_are_entered_consecutively() {
        String input = "2 + * 4";

        assertThatThrownBy(() -> {
            calculator.stringCalculate(input);
        }).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("문자열 계산기 양식에 어긋난 입력(4) - 연산자가 누락된 경우")
    @Test
    void exception_occurs_if_operator_is_missing() {
        String input = "2 + 3 4";

        assertThatThrownBy(() -> {
            calculator.stringCalculate(input);
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

    @DisplayName("문자열 계산기 양식에 어긋난 입력(5) - 특수 문자(유효하지 않은 입력값)가 입력된 경우")
    @Test
    void exception_occurs_when_input_contains_special_character() {
        String input = "2 + 3 * 4 / 2 ?";

        assertThatThrownBy(() -> {
            calculator.stringCalculate(input);
        }).isInstanceOf(ArrayIndexOutOfBoundsException.class);
    }

}