package GradePackage;
public class Grade {

	private int studentAM;
	private int CourseID;
	private int int_grade;
	
	private Grade(int am, int courseid, int gr)
	{
		this.studentAM = am;
		this.CourseID = courseid;
		this.int_grade = gr;
	}
	
	public static Grade produceGrade(Object caller, int am, int courseid, int gr)
	{
		if(caller.getClass().getName().equals("UserPackage.Professor")){
			return new Grade(am,courseid,gr);
		} 
		
		return null;
	}
	 
	public int getGrade()
	{
		return int_grade;
	}
	
	public int getCourseID()
	{
		return CourseID;
	}
	
	public int getAM()
	{
		return studentAM;
	}
	
}
