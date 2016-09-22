package ExercisePackage;


public class Exercise {

	private static int s_id = 0;
	protected int exersice_id ;
	protected String title;
	
	public Exercise (String title){
		this.exersice_id=s_id++;
		this.title=title;
	} 
	
	public int getExID(){
		return exersice_id;
	}

	public String getTitle(){
		return title;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
