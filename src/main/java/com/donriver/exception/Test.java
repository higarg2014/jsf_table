package com.donriver.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
 public static void main(String arg[]){
	ExecutorService executorService=Executors.newFixedThreadPool(10);
	
	for(int i=0;i<100;i++){
		executorService.execute(new Task(i));
	}
 }
}

class Task extends Thread{
	
	int taskId;

	public Task(int taskId) {
		super();
		this.taskId = taskId;
	}
	
	public void run(){
		System.out.println("in in run"+Thread.currentThread().getName());
	}
	
	
}
