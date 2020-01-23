package test;

import domain.DomainArterial;
import error.OTMException;
import org.junit.Test;

public class Tests {

    @Test
    public void create_domain(){
        try {
            DomainArterial domain = new DomainArterial("configs/network_v3.xml");
            System.out.println(domain);
        } catch (OTMException e) {
            e.printStackTrace();
        }
    }

}

