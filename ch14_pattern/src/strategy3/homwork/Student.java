package strategy3.homwork;

import strategy3.homwork.inter.GetStudyPay;
import strategy3.homwork.inter.JobStudy;

public class Student extends Person {

	private String ban;
	
	public Student(String id, String name, String ban) {
		super(name, id);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudyPay());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t 반 : "+ban);
	}
}
