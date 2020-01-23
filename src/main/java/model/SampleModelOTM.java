package model;

import burlap.mdp.core.action.Action;
import burlap.mdp.core.state.State;
import burlap.mdp.singleagent.environment.EnvironmentOutcome;
import burlap.mdp.singleagent.model.RewardFunction;
import burlap.mdp.singleagent.model.SampleModel;
import burlap.mdp.singleagent.model.statemodel.SampleStateModel;
import error.OTMException;
import state.StateArterial;

public class SampleModelOTM implements SampleModel {

    public SampleStateModel stateModel;
    public RewardFunction rf;

    public SampleModelOTM(String configfile) throws OTMException {

        // OTM
        stateModel = new SampleStateModelOTM(configfile);

        // reward minimize sum of queues
        this.rf = new RewardFunction() {
            @Override
            public double reward(State state, Action action, State state1) {
                return -((StateArterial) state).link2queue.values().stream().mapToDouble(x->x).sum();
            }
        };

    }

    @Override
    public EnvironmentOutcome sample(State s, Action a) {
        State sprime = this.stateModel.sample(s, a);
        double r = this.rf.reward(s, a, sprime);
        boolean t = false;
        EnvironmentOutcome eo = new EnvironmentOutcome(s, a, sprime, r, t);
        return eo;
    }

    @Override
    public boolean terminal(State state) {
        return false;
    }

}
