public class GameResult {

    private final int ball;
    private final int strike;

    private GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static GameResult of(int ball, int strike) {
        return new GameResult(ball, strike);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
