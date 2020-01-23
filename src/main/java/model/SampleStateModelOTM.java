package model;

import burlap.mdp.core.action.Action;
import burlap.mdp.core.state.State;
import burlap.mdp.singleagent.model.statemodel.SampleStateModel;
import error.OTMException;

public class SampleStateModelOTM implements SampleStateModel {

    public api.OTM otm;

    public SampleStateModelOTM(String configfile) throws OTMException {
        this.otm = new api.OTM();
        this.otm.load(configfile,true,false);
    }

    @Override
    public State sample(State state, Action action) {

        // set the state for OTM

        // perform the action

        // get next state

        // package as state object
        return null;
    }
}
