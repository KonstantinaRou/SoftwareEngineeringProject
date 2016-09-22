package ExercisePackage;

import java.util.ArrayList;

public class DirectExercise extends Exercise {

	private String type;
	private static int s_id = 0;
	private int ex_id;
	private ArrayList<String> QuestionsList;
	
	public DirectExercise(String title) {
		super(title);
		this.ex_id=s_id++;
		this.QuestionsList=new ArrayList<String>();
	} 
	
	public void addQuestions(String[] questions){
		for(String i : questions){
			QuestionsList.add(i);
		}
	}
	
	public ArrayList<String> getQuestions(){
		
		ArrayList<String> temp = new ArrayList<String>();
		for(int i=0; i<QuestionsList.size(); i++){
			temp.set(i,QuestionsList.get(i));
		}
		
		return temp;
	}
	

	
	
	
	
	
	
}
