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

}