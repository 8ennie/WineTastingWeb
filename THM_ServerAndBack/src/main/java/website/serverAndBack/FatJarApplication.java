package website.serverAndBack;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class FatJarApplication extends Application {

    public FatJarApplication() {
    }


    @Override
    public Set<Object> getSingletons() {
        HashSet<Object> set = new HashSet<Object>();
        set.add(new MessageResource());
        return set;
    }
}
