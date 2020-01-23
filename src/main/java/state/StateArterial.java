package state;

import burlap.mdp.core.state.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateArterial implements State {

    public Map<Long,Float> link2queue;

    public StateArterial(Map<Long,Float> link2queue) {
        this.link2queue = link2queue;
    }

    @Override
    public List<Object> variableKeys() {
        return new ArrayList<>(link2queue.keySet());
    }

    @Override
    public Object get(Object o) {
        return link2queue.get(o);
    }

    @Override
    public State copy() {
        Map<Long,Float> x = new HashMap<>();
        x.putAll(link2queue);
        return new StateArterial(x);
    }

}
