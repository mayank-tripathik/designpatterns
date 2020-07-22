package strategy;

/*
 We have a counter strike game where we have two players :  terrorist and a counter terrorist
 Both have one common functionality like run()
 Suppose we need to implement a functionality called action()
 By default at the start of Game, A Terrorist action is attack while counter-terrorist action is defend
 When the bomb is planted, both have reverse action.
 So if we put action() as method in common superclass we have to implement in both, but this will cause a code redundancy as if other player
 type comes, say mafia and has same action as terrorist it will have to duplicate the action implementation of terrorist
 Strategy pattern is perfect here as it allows to inject the strategy at runtime.
 */
public class StrategyPattern {
    public static void main(String[] args){
        CounterTerrorist counterTerrorist =  new CounterTerrorist();
        Terrorist terrorist = new Terrorist();
        // common behaviour of players
        counterTerrorist.run();
        terrorist.run();

        // default strategy of players as set in their constructors
        counterTerrorist.performAction();
        terrorist.performAction();

        // bomb is planted
        terrorist.plantBomb();

        // change the strategy
        counterTerrorist.setActionStrategy(new AttackActionStrategy());
        terrorist.setActionStrategy(new DefendActionStrategy());

        // changed strategy of players after bomb
        counterTerrorist.performAction();
        terrorist.performAction();

    }
}
