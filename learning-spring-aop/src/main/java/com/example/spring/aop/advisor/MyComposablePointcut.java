package com.example.spring.aop.advisor;

import com.example.spring.aop.domain.WorkerDelegate;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created by puroc on 2017/8/27.
 */
public class MyComposablePointcut {

    public Pointcut intersectionPointcut() {
        ComposablePointcut cp = new ComposablePointcut();
        Pointcut pt1 = new ControlFlowPointcut(WorkerDelegate.class, "service");
        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("hello");
        return cp.intersection(pt1).intersection((Pointcut) pt2);
    }

}
