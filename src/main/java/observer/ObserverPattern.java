package observer;

/*
 We are going to design a system having a scoreboard whose score changes will be pushed to the subscribers
 */
public class ObserverPattern {
    public static void main(String[] args){
        // This is our subject whose state updates needs to be notified
        ScorePublisher publisher = new ScorePublisher();
        // Observers which needs to listen to the updates of subject
        Observer observer1 = new ScoreObserver();
        Observer observer2 = new ScoreObserver();
        // Registering the observers with the subject
        publisher.registerObserver(observer1);
        publisher.registerObserver(observer2);
        // For each updates, observers will be notified.
        publisher.setScore("0/0");
        publisher.setScore("12/0");
        publisher.setScore("98/1");
        // observer2 is unsubscribed;
        publisher.unregisterObserver(observer2);
        publisher.setScore("102/2");
    }
}
