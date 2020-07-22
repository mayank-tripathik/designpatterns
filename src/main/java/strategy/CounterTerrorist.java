package strategy;

public class CounterTerrorist extends Player {
    public CounterTerrorist(){
        actionStrategy  = new DefendActionStrategy();
    }

    // Counter terrorist specific functions
    public void secure(){
        System.out.println("I am securing the city");
    }
}
