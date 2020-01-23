package strategy3.homwork;

import strategy3.homwork.inter.*;

public class Person {
	private IJob job;
	private IGet get;
	
	private String name;
	private String id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void job() {
		job.job();
	}
	
	public void get() {
		get.get();
	}
	
	public void print() {
		System.out.println("============================================================");
		System.out.print("ID : "+id + "\t 이   름 : "+ name);
		
	}

	public void setJob(IJob job) {
		this.job = job;
	}

	public void setGet(IGet get) {
		this.get = get;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
