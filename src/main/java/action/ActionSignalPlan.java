package action;

import burlap.mdp.core.action.Action;

import java.util.Arrays;

public class ActionSignalPlan implements Action {

    public static final String ACTION_SIGNALPLAN = "signalplan";

    public int[] plan_id;

    public ActionSignalPlan(int [] plan_id){
        this.plan_id = plan_id;
    }

    @Override
    public String actionName() {
        String str = ACTION_SIGNALPLAN;
        for(int i=0;i<plan_id.length;i++)
            str += "_" + plan_id[i];
        return str;
    }

    @Override
    public Action copy() {
        return new ActionSignalPlan(plan_id.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionSignalPlan that = (ActionSignalPlan) o;
        return Arrays.equals(plan_id, that.plan_id);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(plan_id);
    }

    @Override
    public String toString() {
        return actionName();
    }

}
