package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("[요구사항1] 두 개의 문자가 ','로 split 됩니다")
    @Test
    void two_characters_are_split_with_comma() {
        String actual = "1,2";

        String[] result = actual.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).containsExactly("1", "2");

        printActualResult(result);
    }

    @DisplayName("[요구사항1] 한 개의 문자를 ','로 split한 경우, 해당 문자가 그대로 나온다")
    @Test
    void the_character_will_be_displayed_as_is_if_split_a_single_character_with_comma() {
        String actual = "1";

        String[] result = actual.split(",");
        assertThat(result).containsExactly("1");

        printActualResult(result);
    }

    @DisplayName("[요구사항2] String의 substring() 메소드를 활용하여, '(1,2)'의 소괄호를 제거한다")
    @Test
    void remove_parentheses_by_using_substring_method_of_String() {
        String actual = "(1,2)";

        String result = actual.substring(1, actual.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    private void printActualResult(String[] actual) {
        System.out.println("[Actual Results]");
        for (String s : actual) {
            System.out.println(s);
        }
    }
}
