package com.jvb.collect.basic;

import com.jvb.collect.basic.impl.SpringConfigClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DelegatorMain {

    public static void main(String[] a){
        //To showcase usage of delegator pattern fused with Spring constructor based autowired dependency injection
        int processingClassMarker = 1;
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigClass.class);
        DependencyDelegator beanHoldingDep = context.getAutowireCapableBeanFactory().getBean(DependencyDelegator.class);
        List<DelegatedInterface> deletagedObj= beanHoldingDep.returnAllWiredDelegated();
        for(DelegatedInterface eachDelegate : deletagedObj){
            System.out.println(eachDelegate.getDelegateMarker());
        }

        beanHoldingDep.callDelegateEmitMethod(processingClassMarker);
    }
}
