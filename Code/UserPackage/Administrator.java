package UserPackage;
import Server.CourseServer;
import Server.ProfServer;
import Server.request_type;


public class Administrator extends User{
	private String firstName;
	private String lastName;
	private String email;
	
	
	public Administrator(String username, String password,String occupation,String firstName,String lastName,String email){
		super(username,password,occupation);
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	
	
	//o admin prosthetei mathimata
	
	public void add_course(String name , String info){
		String [] args = {name,info};
		CourseServer.getInstance().request(this, request_type.ADD_COURSE, args);
	}
	
	
	//o admin diagrafei mathimata
	public void delete_course(String name){
		String[]args={name};
		CourseServer.getInstance().request(this, request_type.DELETE_COURSE, args);
	}
	
	// o admin prosthetei kathigith
	public void add_professor(String username, String password , String occupation, String firstName, String lastName , String expertise, String email){
		String[]args={username,password,occupation,firstName,lastName,expertise,email};
		ProfServer.getInstance().request(this, request_type.ADD_PROF, args);
	}
	
	
	// o admin diagrafei kathigith
	public void delete_professor(String firstName, String lastName){
		String[]args={firstName,lastName};
		ProfServer.getInstance().request(this, request_type.DELETE_PROF, args);
		
	}
	
	
	//o admin antistixei mathima se kathigith
	public void addCourseToProfessor(String courseName, String professorID){
		String[]args={courseName,professorID};
		CourseServer.getInstance().request(this, request_type.ADD_COURSE_TO_PROF, args);
	}
	
	
}
