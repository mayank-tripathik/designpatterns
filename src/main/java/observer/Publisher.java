package observer;

import java.util.LinkedList;
import java.util.List;

abstract class Publisher {
    private List<Observer> subscribers;

    Publisher(){
        subscribers = new LinkedList<Observer>();
    }

    public void registerObserver(Observer observer){
        subscribers.add(observer);
    }

    public void unregisterObserver(Observer observer){
        subscribers.remove(observer);
    }

    protected void notifySubscribers(String state){
        for(Observer observer: subscribers){
            observer.update(state);
        }
    }
}
