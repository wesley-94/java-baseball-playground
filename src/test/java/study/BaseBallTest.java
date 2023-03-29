package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class BaseBallTest extends IOTest {

    private String answer;
    private String number;
    private int size;
    private int strike;
    private int ball;
    private String judge;

    @BeforeEach
    void setUp() {
        answer = "425";
        number = "456";
        size = 3;
        strike = 0;
        ball = 0;
    }

    @Test
    void setInTest() {
        systemIn(number);
        baseBallV1();
    }

    void baseBallV1() {
        Scanner scanner = new Scanner(System.in);
        checkNumber(answer, number);
        String judgeVal = judgeBall();
        Assertions.assertThat(judgeVal).isEqualTo("1볼 1스트라이크");
    }

    void checkNumber(String answer, String number) {
        for (int i = 0; i < size; i++) {
            char numberIndi = number.charAt(i);
            int answerIdx = answer.indexOf(numberIndi);
            if (answerIdx == i) {
                strike++;
            }
            else if (answerIdx != i && answerIdx >= 0 && answerIdx <= size) {
                ball++;
            }
        }
    }

    public String judgeBall() {
        if (ball > 0) {
            if (strike > 0) {
                judge = Integer.toString(ball) + "볼 " + Integer.toString(strike) + "스트라이크";
            }
            else {
                judge = Integer.toString(ball) + "볼";
            }
        }
        else if (ball == 0 && strike > 0) {
            judge = Integer.toString(strike) + "스트라이크";
        }
        else if (ball == 0 && strike == 0) {
            judge = "낫싱";
        }

        if (strike == 3) {
            judge += "\n";
            judge += "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
            judge += "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        return judge;
    }

}
