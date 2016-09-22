package UserPackage;
import Server.CourseServer;
import Server.request_type;




public class Professor extends User{
	
	private String firstName;
	private String lastName;
	private String expertise;
	private String email;
	private static int p_id=0;
	private int prof_id;
	
	
	
	public Professor (String username, String password , String occupation, String firstName, String lastName , String expertise, String email){
		super(username,password,occupation);
		this.firstName=firstName;
		this.lastName=lastName;
		this.expertise=expertise;
		this.email=email;
		this.prof_id=p_id++;
	}
	
	
	
	public int getProfID(){
		return prof_id;
	}
	
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	
	
	
	public void editCourseInfo(String name,String info){
		String [] args={name,info};
		CourseServer.getInstance().request(this, request_type.EDIT_COURSE_INFO, args);
	}
	
	public void uploadExercise(String Course,String title){
		String[] args={Course,title};
		CourseServer.getInstance().request(this, request_type.UPLOAD_EXERCISE, args);
	}
	 
	public void createDirectExercise(String CourseName,String title,String... Questions){
		CourseServer.getInstance().createDirectExercise(this,CourseName,title,Questions);
	}
	 
	public void setGradeToStudent(String AM,String CourseId,String grade){
		String[] args={AM,CourseId,grade};
		CourseServer.getInstance().request(this, request_type.ADD_GRADE, args);
	}
}
