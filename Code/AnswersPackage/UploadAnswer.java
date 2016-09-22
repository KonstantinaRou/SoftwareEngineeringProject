package AnswersPackage;

import java.io.File;
 
public class UploadAnswer {
	
	private String type="pdf";
	private String title;
	private File answer_file;
	private static int s_id=0;
	private int answer_id;
	 
	public UploadAnswer(String title){
		this.answer_id=s_id++;
		this.title=title; 
	}
	
	public void setFile(File askhsh){
		 answer_file=askhsh;
	}
	
	public File getUploadFile(){
		return answer_file;
	}
	
	
}
