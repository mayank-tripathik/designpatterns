package strategy;

public class Player {
    public ActionStrategy actionStrategy;

    public void run(){
        System.out.println("I can run, as every player can do");
    }

    public void setActionStrategy(ActionStrategy actionStrategy){
        this.actionStrategy = actionStrategy;
    }

    public void performAction(){
        actionStrategy.action();
    }
}
