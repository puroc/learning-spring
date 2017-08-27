package com.example.spring.aop.advisor;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class PerformaceMonitor
		extends
			DelegatingIntroductionInterceptor implements Monitorable {

	private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

	public void setMonitorActive(boolean active) {
		MonitorStatusMap.set(active);
	}

	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj = null;
		if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
			System.out.println("monitor begin");
			obj = super.invoke(mi);
			System.out.println("monitor end");
		} else {
			obj = super.invoke(mi);
		}
		return obj;
	}
}
