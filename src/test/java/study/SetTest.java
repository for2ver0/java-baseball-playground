package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @DisplayName("[요구사항1] Set의 size() 메소드를 활용하여, Set 데이터의 크기를 확인한다")
    @Test
    void check_the_size_of_Set_using_size_method_of_Set() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("[요구사항2] 테스트 코드의 중복 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
        assertTrue(numbers.contains(value));
    }

    @DisplayName("[요구사항3] 테스트 코드의 중복 제거")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains3(int value, boolean expected) {
        boolean actualContain = numbers.contains(value);
        assertEquals(expected, actualContain);
    }
}