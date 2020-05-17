package edu.umb.cs680.hw03;

enum StudentStatus {
	INSTATE, OUTSTATE, INTL
}

public class Student{
	
	private float tuition;
	private String name, usAddr, foreignAddr;
	private int i20num, yrsInState;
	private StudentStatus status;
	
	private Student(String name, String usAddr, String foreignAddr, int i20num, int yrsInState, StudentStatus status) {
		this.name = name;
		this.usAddr = usAddr;
		this.foreignAddr = foreignAddr;
		this.i20num = i20num;
		this.yrsInState = yrsInState;
		this.status = status;
	}
	
	public static Student createinStateStudent(String name, String usAddr) {
		return new Student(name, usAddr, null, -1, -1, StudentStatus.INSTATE);
	}

	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, null, -1, yrsInState, StudentStatus.OUTSTATE);
	}

	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, usAddr, foreignAddr, i20num, -1, StudentStatus.INTL);
	}
	
	public float getTuition() {
		if (this.status == StudentStatus.INSTATE) {
			this.tuition = 10000;
			return tuition;
		}
		else if (this.status == StudentStatus.OUTSTATE) {
			this.tuition = 15000;
			return tuition;
		}
		else{
			this.tuition = 20000;
			return tuition;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getUSAddr() {
		return this.usAddr;
	}
	
	public String getForeignAddr() {
		return this.foreignAddr;
	}
	
	public int geti20Num() {
		return this.i20num;
	}
	
	public int getYrsInState() {
		return this.yrsInState;
	}

	public StudentStatus getStatus() {
		return this.status;
	}
	
	public static void main(String[] args) {
		
		Student inStateStudent = createinStateStudent("Ema", "New York");
		System.out.println("Student name : "+ inStateStudent.getName() +"\nUS Addr : "+ inStateStudent.getUSAddr() +"\nStudent tuition is: "
				+ inStateStudent.getTuition());
		
		Student outStateStudent = createOutStateStudent("Jenny", "Colarado", 2);
		System.out.println("\nStudent name : "+ outStateStudent.getName() +"\nUS Addr : "+ outStateStudent.getUSAddr() +"\nYears In State : "+ outStateStudent.getYrsInState() +"\nStudent tuition is: "
				+ outStateStudent.getTuition());

		Student intlStudent = createIntlStudent("Amy", "Boston", 210, "England");
		System.out.println("\nStudent name : "+ intlStudent.getName() +"\nUS Addr : "+ intlStudent.getUSAddr() +"\nI20 Number : "+ intlStudent.geti20Num() +"\nForeign Addr : "+ intlStudent.getForeignAddr() +"\nStudent tuition is: "
				+ intlStudent.getTuition());
	}
}