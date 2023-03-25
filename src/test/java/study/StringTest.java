package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void splitV1() {
        String temp = "1,2";
        List<String> splitList = Arrays.asList(temp.split(","));
        assertThat(splitList).containsExactly("1", "2");
    }

    @Test
    public void splitV2() {
        String temp = "1";
        List<String> splitList = Arrays.asList(temp.split(","));
        assertThat(splitList).containsExactly("1");
    }

    @Test
    public void splitV3() {
        String temp = "(1,2)";
        temp = temp.replace("(", "");
        temp = temp.replace(")", "");
        List<String> splitList = Arrays.asList(temp.split(","));
        assertThat(splitList).containsExactly("1", "2");
    }

    @DisplayName("charAt 메서드 테스트")
    @Test
    public void charAtV1() {
        // given
        String actual = "abc";

        // when, then
        assertThatThrownBy(() -> actual.charAt(actual.length())).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: ")
                .hasMessageContaining(String.valueOf(actual.length()));
    }
}
