package org.learning.designPattern.state;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GumballMachine extends State {

    public State noQuarterState = new SoldOutState(this);
    public State hasQuarterState = new HasQuarterState(this);
    public State soldState = new SoldState(this);
    public State soldOutState = new SoldOutState(this);

    private State state;


    private int candyCount = 0;


    public GumballMachine(int count) {
        this.candyCount = count;
        if(count > 0)
            setState(noQuarterState);
    }

    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
    }

    @Override
    public void dispense() {
        state.dispense();
    }
}
