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
            int randomNumber = (int)(Math.random() * (max - min + 1) + min);
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

}
