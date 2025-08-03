import java.util.HashSet;
import java.util.Set;

public class NumberBaseballGame {

    public int[] generateRandomNumber() {
        // 1부터 9사이의 서로 다른 3개의 난수
        int min = 1;
        int max = 9;
        int count = 3;

        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < count) {
            int randomNumber = (int) (Math.random() * (max - min + 1) + min);
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public int calculateStrike(int[] randomNumbers, int[] userInputs) {
        int strike = 0;

        int count = randomNumbers.length;
        for (int i = 0; i < count; i++) {
            strike += getStrikeValue(randomNumbers[i], userInputs[i]);
        }
        return strike;
    }

    public int getStrikeValue(int number1, int number2) {
        if (number1 == number2) {
            return 1;
        }
        return 0;
    }

    public int calculateBall(int[] randomNumbers, int[] userInputs) {
        int ball = 0;

        int count = randomNumbers.length;
        for (int i = 0; i < count; i++) {
            ball += getBallPoint(randomNumbers, userInputs, i, count);
        }
        return ball;
    }

    public int getBallPoint(int[] number1, int[] number2, int index, int count) {
        int point = 0;

        for (int i = 0; i < count; i++) {
            point += getBallValue(number1[index], number2[i], (index == i));
        }
        return point;
    }

    public int getBallValue(int number1, int number2, boolean strikePosition) {
        if (!strikePosition && (number1 == number2)) {
            return 1;
        }
        return 0;
    }

}
