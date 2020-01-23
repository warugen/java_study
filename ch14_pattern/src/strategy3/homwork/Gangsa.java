package strategy3.homwork;

import strategy3.homwork.inter.GetSalary;
import strategy3.homwork.inter.JobLec;

public class Gangsa extends Person{
	private String subject;
	
	public Gangsa(String id, String name, String subject) {
		super(name, id);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t 담당과목 : "+subject);
	}
}
