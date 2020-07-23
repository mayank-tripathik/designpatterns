package observer;

public class ScorePublisher extends Publisher  {
    private String score;

    public void setScore(String score) {
        System.out.println("New score has been updated on Board to " + score);
        this.score = score;
        notifySubscribers(score);
    }
}
