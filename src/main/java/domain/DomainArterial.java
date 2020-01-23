package domain;

import burlap.mdp.singleagent.SADomain;
import error.OTMException;
import model.SampleModelOTM;

public class DomainArterial extends SADomain {

    public DomainArterial(String configfile) throws OTMException {
        SampleModelOTM model = new SampleModelOTM(configfile);
        this.setModel(model);
    }

}
