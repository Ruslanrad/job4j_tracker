package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInvalidInputInputThree() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenInvalidInputInputOneTwoThree() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenInvalidInputInputMinusFive() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-5);
    }
}