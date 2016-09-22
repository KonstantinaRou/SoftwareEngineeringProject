package UserPackage;


import Server.CourseServer;
import Server.request_type;



public class Student extends User {

	private String firstName ;
	private String lastName ;
	private String email;
	private String department;
	private int AM ;
	private static int st_AM=0;
	private  int attendance;
	
	public Student (String username, String password,String occupation,String firstName , String lastName , String email  , int attendance , String department) {
		super(username , password, occupation);
		this.firstName = firstName;
		this.lastName = lastName; 
		this.email = email;
		this.department =department;
		
		this.AM=st_AM++;
		this.attendance =attendance;
	}
	
	public int getAM (){
		return AM;
	}
	
	public void enrollToCourse(String AM,String courseName){
		String[] args={AM,courseName};
		CourseServer.getInstance().request(this, request_type.ENROLL, args);
	}
	
	public void abandonCourse(String AM,String courseName){
		String[] args={AM,courseName};
		CourseServer.getInstance().request(this, request_type.ABANDON_COURSE, args);
	}
	
	public void uploadExercise(String Course,String title){
		String[] args={Course,title};
		CourseServer.getInstance().request(this, request_type.UPLOAD_EXERCISE, args);
	}
	
}
