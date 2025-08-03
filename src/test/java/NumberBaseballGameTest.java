import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberBaseballGameTest {

    @DisplayName("상대방(컴퓨터)이 3자리의 임의의 수를 선택한다")
    @Test
    void generate_3_digit_random_number () {
        // given
        NumberBaseballGame game = new NumberBaseballGame();

        // when
        int[] randomNumber = game.generateRandomNumber();

        // then
        assertThat(randomNumber.length).isEqualTo(3);
    }

    @DisplayName("상대방(컴퓨터)이 1에서 9까지 임의의 수 3개를 선택한다")
    @Test
    void generate_3_random_numbers_from_1_to_9 () {
        // given
        NumberBaseballGame game = new NumberBaseballGame();

        // when
        int[] randomNumbers = game.generateRandomNumber();

        // then
        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
    
    @DisplayName("상대방(컴퓨터)이 서로 다른 임의의 수를 선택한다")
    @Test
    void generate_different_random_numbers() {
        // given
        NumberBaseballGame game = new NumberBaseballGame();
        
        // when
        int[] randomNumbers = game.generateRandomNumber();

        // then
        Set<Integer> numbers = new HashSet<>();
        for (int randomNumber : randomNumbers) {
            numbers.add(randomNumber);
        }

        assertThat(numbers.size()).isEqualTo(3);
    }

}