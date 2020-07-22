package strategy;

public class Terrorist extends Player {
    public Terrorist(){
        actionStrategy  = new AttackActionStrategy();
    }

    // Terrorist specific functions
    public void plantBomb(){
        System.out.println("I am planting a bomb");
    }
}
