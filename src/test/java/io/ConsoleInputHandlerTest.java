package io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleInputHandlerTest {

    @DisplayName("엔터 입력 전까지의 모든 문자를 하나의 입력으로 받아들인다")
    @Test
    void receive_all_characters_until_enter() {
        // given
        String expectedInput = "123";

        String actualInput = "123\n";
        System.setIn(new ByteArrayInputStream(actualInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();

        // when & then
        assertThat(inputHandler.getUserInput()).isEqualTo(expectedInput);
    }

}