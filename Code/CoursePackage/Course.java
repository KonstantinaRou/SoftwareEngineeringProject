package CoursePackage;


public class Course { 
	
	private String courseName;
	private  static  int s_id = 0;
	private int courseID;
	private String information;
	
	public Course(String courseName,String information){
		this.courseName=courseName;
		this.courseID=s_id++;
		this.information=information;
	}
	
	public String getCourseName (){
		return courseName;
	}
	
	public int getCourseID (){
		return courseID;
	}
	
	public String getInfo(){
		return information;
	}
	
	public void setInfo (String info){
		this.information=info;
	}
	
}
