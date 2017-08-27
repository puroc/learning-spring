package com.example.spring.aop.domain;

/**
 * Created by puroc on 2017/8/27.
 */
public class WorkerDelegate {

    private Worker worker;

    public void service(){
        System.out.println("service begin");
        worker.testBeforeAdvice();
        worker.hello();
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
