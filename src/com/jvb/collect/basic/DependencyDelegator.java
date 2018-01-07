package com.jvb.collect.basic;

import org.springframework.stereotype.Component;

import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Component
public class DependencyDelegator {
    private static final Log logger = LogFactory.getLog(DependencyDelegator.class);
    private Map<Integer,DelegatedInterface> recieverCollec;

    public DependencyDelegator(List<DelegatedInterface> autowiredDependencies){
        recieverCollec = new HashMap<Integer, DelegatedInterface>();
        for(DelegatedInterface dep : autowiredDependencies) {
            subscribe(dep);
        }

    }

    public void subscribe(DelegatedInterface s){
        recieverCollec.put(s.getDelegateMarker(),s);
    }

    public List<DelegatedInterface> returnAllWiredDelegated(){
        Set<Map.Entry<Integer,DelegatedInterface>> mapSet = recieverCollec.entrySet();
        List<DelegatedInterface> allWiredDelegate = new ArrayList<DelegatedInterface>();
        mapSet.forEach((s) -> {
            allWiredDelegate.add(s.getValue());
        });

        return allWiredDelegate;
    }

    public void callDelegateEmitMethod(int a){
        DelegatedInterface concernedDelegatedCallee = recieverCollec.get(a);
        if(concernedDelegatedCallee==null){
            logger.error(this,new Throwable("No Callee for the given index"));
            return;
        }
        concernedDelegatedCallee.callDelegateEmitMethod();  //Based on the incoming market key, we can make call to appropriate delegate class's callDelegateEmitMethod method

    }
}
