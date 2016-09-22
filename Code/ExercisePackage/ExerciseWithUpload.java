package ExercisePackage;
import java.io.File;


//ka8hghtes
public class ExerciseWithUpload extends Exercise{

	int deadline ;
	String type;
	File ekfwnhsh;//ekfwnhsh ergasias se pdf
	private static int s_id = 0;
	int ex_id;
	
	
	public ExerciseWithUpload(String title ){
		super(title);
		this.ex_id=s_id++;
		type="pdf"; 
		
	}
	
	public void setFile(File askhsh){
		ekfwnhsh=askhsh;
	}
	
	public File getUploadFile(){
		return ekfwnhsh;
	}
	
	public void setDeadline(int deadline){
		this.deadline=deadline;
	}
	
	public int getDeadline(){
		return deadline;
	}
	
	public String getTitle(){
		return title;
	}
	 
	
}


