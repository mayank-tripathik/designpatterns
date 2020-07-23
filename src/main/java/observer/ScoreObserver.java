package observer;

public class ScoreObserver implements Observer {
    private static int observerIdCount = 1;
    private int observerId;
    String score;

    public ScoreObserver(){
        this.observerId = observerIdCount++;
    }

    public void showScore(){
        System.out.println("Observer " + observerId + " being notified with score : " + score);
    }
    public void update(String updatedScore) {
        this.score = updatedScore;
        showScore();
    }
}
