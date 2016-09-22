package Server;

import AnswersPackage.UploadAnswer;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;




import CoursePackage.Course;
import ExercisePackage.DirectExercise;
import ExercisePackage.ExerciseWithUpload;
import ExercisePackage.FileDemonstration;
import GradePackage.Grade;
import UserPackage.Professor;

/*Ta pada leitourgoun me thn methodo request. O Professor o Student kai o Admin kanoun request(..)etsi v
  na ektelesoun kapoia leitourgia , diaforetikh kathe fora.
  -Ta ArrayList xrisimopoihounte anti mias proswrinhs vashs dedomenwn 
  -Ta Arraylist pou periexoyn alla emfoleymena ArrayList exoun ftiaxtei gia na yparxei antisoixia ena pros
  polla, syskekrimena ena=mathima kai polla=mathites kai askihsheis. 
  Oi methodoi meta athn request exoun ftiaxtei eite gia na mporoyn na ypolopoihthoyn ta Junit eite giati kalounte apo alles klaseis.*/

 

public class CourseServer {
	
	private static CourseServer instance = new CourseServer();
	private ArrayList<Course> CourseList = new ArrayList<Course>();
	private ArrayList<Professor> timetable = new ArrayList<Professor>();
	
	private ArrayList <ArrayList<ExerciseWithUpload>> exercisesU = new ArrayList<ArrayList<ExerciseWithUpload>>();
	private ArrayList <ArrayList<UploadAnswer>> answerU = new ArrayList<ArrayList<UploadAnswer>>();
	private ArrayList <DirectExercise> exercisesD= new ArrayList<DirectExercise>();
	 
	private ArrayList <ArrayList<Integer>> studentTimetable =  new ArrayList<ArrayList<Integer>>(); //lista me summetoxes sto mathima
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	 
	private CourseServer(){
		CourseList=new ArrayList<Course>(); 
	}
	
	public static CourseServer getInstance (){
		return instance;
	} 
	
	public void request(Object caller,request_type req,String[] args){
		if (caller.getClass().getName().equals("UserPackage.Administrator")&& req==request_type.ADD_COURSE){
			String name = args[0];
			String info = args[1];
			for(int i = 0; i < CourseList.size(); i++) 
			{
				if(CourseList.get(i).getCourseName().equals(name)){
					return;
				}
			}
			
			Course new_Course = new Course(name,info); 
			CourseList.add(new_Course);
			timetable.add(null);
			exercisesU.add(null);
			answerU.add(null);
			studentTimetable.add(null);
			exercisesD.add(null);
		}
		if (caller.getClass().getName().equals("UserPackage.Administrator")&& req==request_type.DELETE_COURSE){
			
			String name = args[0];
			int count = 0;
			Iterator<Course> iter = CourseList.iterator();
			
			while(iter.hasNext()){
				Course c1= iter.next();
				if(c1.getCourseName().equals(name)){
					iter.remove();
					timetable.remove(count);
					exercisesU.remove(count);
					answerU.remove(count);
					studentTimetable.remove(count);
					exercisesD.remove(count);
				}
				count++;
			}
		}
		if (caller.getClass().getName().equals("UserPackage.Professor")&& req==request_type.EDIT_COURSE_INFO){
			String CourseName = args[0];
			String CourseInfo = args[1];
			
			for(Course i : CourseList){
				if(i.getCourseName().equals(CourseName)){
					i.setInfo(CourseInfo);
				}
			}
		}
		if(caller.getClass().getName().equals("UserPackage.Administrator") && req==request_type.ADD_COURSE_TO_PROF)
		{
			String CourseName = args[0];
			int profid = Integer.parseInt(args[1]);
			Professor p = ProfServer.getInstance().getProf_fromID(profid);
			for(int i = 0; i < CourseList.size(); i++)
			{
				if(CourseList.get(i).getCourseName().equals(CourseName))
					timetable.set(i, p);
			}
		}
		if (caller.getClass().getName().equals("UserPackage.Professor")&& req==request_type.UPLOAD_EXERCISE){
			String CourseName = args[0];
			String ex_title = args[1];

			for(int i = 0; i < CourseList.size(); i++){
				if(CourseList.get(i).getCourseName().equals(CourseName)){
					if(exercisesU.get(i)==null){
						exercisesU.set(i, new ArrayList<ExerciseWithUpload>());
					}
					
					FileDemonstration ekfwnhsh=new FileDemonstration();
					ekfwnhsh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					ExerciseWithUpload exercise = new ExerciseWithUpload(ex_title);
					exercise.setFile(ekfwnhsh.returnFile());
					exercisesU.get(i).add(exercise);
				}
			}
		}
		
		
		if (caller.getClass().getName().equals("UserPackage.Student")&& req==request_type.UPLOAD_EXERCISE){
			
			
			String CourseName = args[0];
			String ex_title = args[1];

			for(int i = 0; i < CourseList.size(); i++){
				if(CourseList.get(i).getCourseName().equals(CourseName)){
			
					if(exercisesU.get(i)!=null){
						for(int j=0;j<exercisesU.get(i).size();j++){
							if(exercisesU.get(i).get(j).getTitle().equals(ex_title)){
								if(answerU.get(i)==null){
									answerU.set(i, new ArrayList<UploadAnswer>());
								}
								
								FileDemonstration ekfwnhsh=new FileDemonstration();
								ekfwnhsh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								
								UploadAnswer exercise = new UploadAnswer(ex_title);
								exercise.setFile(ekfwnhsh.returnFile());
								answerU.get(i).add(exercise);
							}
						}	
					}		
				}
			}
		}
		

		
		if (caller.getClass().getName().equals("UserPackage.Student")&& req==request_type.ENROLL){
			int AM = Integer.parseInt(args[0]);
			String Course=args[1];
			for(int i =0 ; i< CourseList.size();i++){
				
				
				
				if (CourseList.get(i).getCourseName().equals(Course)){
								
					if(studentTimetable.get(i)==null){
						studentTimetable.set(i, new ArrayList<Integer>());
					}
					
					if(studentTimetable.get(i).contains(AM)){
						return;
					}
					studentTimetable.get(i).add(AM);
				}
			
			} 
			
		}
		if (caller.getClass().getName().equals("UserPackage.Student")&& req==request_type.ABANDON_COURSE){
			int AM = Integer.parseInt(args[0]);
			String Course=args[1];
			for(int i =0 ; i< CourseList.size();i++){
				if (CourseList.get(i).getCourseName().equals(Course)){
					if(studentTimetable.get(i).contains(AM))
						studentTimetable.get(i).remove(AM);
				}
			
			}
		}
		if (caller.getClass().getName().equals("UserPackage.Professor")&& req==request_type.ADD_GRADE){
			int AM = Integer.parseInt(args[0]);
			int courseID = Integer.parseInt(args[1]);
			int grade = Integer.parseInt(args[2]);
			for(int i = 0; i < CourseList.size(); i++)
			{
				if(CourseList.get(i).getCourseID() == courseID&&studentTimetable.get(i).contains(AM)){
					grades.add(Grade.produceGrade(caller, AM, courseID, grade));
				}
			}
			 
		}
	}//end request
	

	
	
	public int ProfessorTimetablesize(int profID){
		int size = 0;
		for(int i=0; i<CourseList.size(); i++){
			Professor p = timetable.get(i);
			if(p!=null && p.getProfID()==profID){
				size++;				
			}
		}
	 return size;
	}
	
	
	
	
	
	public ArrayList<String> getCourses_student(int AM)
	{
		ArrayList<String> temp_courses = new ArrayList<String>();
		for(int i = 0 ; i< studentTimetable.size();i++){
				if(studentTimetable.get(i) != null && studentTimetable.get(i).contains(AM))
					temp_courses.add(CourseList.get(i).getCourseName());
		}
		return temp_courses;
	}
	
	public void createDirectExercise(Object caller,String CourseName,String title,String... questions){
		
		if(caller.getClass().getName().equals("UserPackage.Professor")){

			DirectExercise temp  = new DirectExercise(title);
			temp.addQuestions(questions);
			
			for(int i=0; i<CourseList.size();i++){
				if(CourseList.get(i).getCourseName().equals(CourseName)){
					exercisesD.set(i,temp);
				}
			}
		}
		
		
		
	}
	
	
	
	
	public int getCourseSize(){
		return CourseList.size();
	}
		
	public Course getCourse(String name){
		Course temp=null;
		for(Course i : CourseList){
			if(i.getCourseName().equals(name)){
				temp=i;
			}
		}
		return temp;
	}
	
	public Grade getGrade(int AM,int CourseId){
	
		
		for(int i=0; i<grades.size();i++){
			if(grades!=null&&grades.get(i).getAM()==AM && grades.get(i).getCourseID()==CourseId)
				return grades.get(i);
		}
		
		return null;
	}
	
	public int getGradesSize(){
		return grades.size();
	}
	
	
	
	
}
