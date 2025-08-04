package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleOutputHandlerTest {

    @DisplayName("숫자 입력 요청 메시지를 출력한다")
    @Test
    void display_input_prompt_message() {
        // given
        String expectedMessage = "숫자를 입력해 주세요 : ";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

        // when
        outputHandler.showNumberInputPrompt();

        // then
        assertThat(outputStream.toString()).isEqualTo(expectedMessage);
    }

    @DisplayName("게임에서 승리하면, 종료 메시지를 출력한다")
    @Test
    void display_the_game_end_message_if_win_the_game() {
        // given
        String expectedMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + System.lineSeparator();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

        // when
        outputHandler.showGameWinMessage();

        // then
        assertThat(outputStream.toString()).isEqualTo(expectedMessage);
    }

    @DisplayName("게임 진행 여부 선택지를 출력한다")
    @Test
    void display_whether_to_restart_a_new_game_or_quit_the_game() {
        // given
        String expectedMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + System.lineSeparator();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();

        // when
        outputHandler.showGameRestartOptions();

        // then
        assertThat(outputStream.toString()).isEqualTo(expectedMessage);
    }

}