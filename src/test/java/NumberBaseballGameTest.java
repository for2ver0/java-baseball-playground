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
    
    @DisplayName("스트라이크 계산(1) - 0스트라이크")
    @Test
    void calculate_0_strike() {
        // given
        NumberBaseballGame game = new NumberBaseballGame();
        int[] randomNumbers = {4, 2, 5};
        int[] testInputs = {7, 8, 9};
        
        // when
        int strike = game.calculateStrike(randomNumbers, testInputs);
        
        // then
        assertThat(strike).isEqualTo(0);
    }

    @DisplayName("스트라이크 계산(2) - 1스트라이크")
    @Test
    void calculate_1_strike() {
        // given
        NumberBaseballGame game = new NumberBaseballGame();
        int[] randomNumbers = {4, 2, 5};
        int[] testInputs = {1, 2, 3};

        // when
        int strike = game.calculateStrike(randomNumbers, testInputs);

        // then
        assertThat(strike).isEqualTo(1);
    }

    @DisplayName("스트라이크 계산(3) - 2스트라이크")
    @Test
    void calculate_2_strike() {
        // given
        NumberBaseballGame game = new NumberBaseballGame();
        int[] randomNumbers = {4, 2, 5};
        int[] testInputs = {1, 2, 5};

        // when
        int strike = game.calculateStrike(randomNumbers, testInputs);

        // then
        assertThat(strike).isEqualTo(2);
    }

    @DisplayName("스트라이크 계산(4) - 3스트라이크")
    @Test
    void calculate_3_strike() {
        // given
        NumberBaseballGame game = new NumberBaseballGame();
        int[] randomNumbers = {4, 2, 5};
        int[] testInputs = {4, 2, 5};

        // when
        int strike = game.calculateStrike(randomNumbers, testInputs);

        // then
        assertThat(strike).isEqualTo(3);
    }

}