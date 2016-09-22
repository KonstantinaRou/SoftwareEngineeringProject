package JunitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import GradePackage.Grade;
import Server.CourseServer;
import Server.ProfServer;
import UserPackage.Administrator;
import UserPackage.Professor;
import UserPackage.Student;

public class TestGrade {
  
	Administrator admin; 
	
	@Before public void SetUp(){ 
	 	 
		admin = new Administrator("akis","adsafs","Admin","akis","tsakas","@gmai");
		admin.add_course("math", "blah blah");
		admin.add_course("biology", "blah blah");
		admin.add_course("geometry", "blah blah");
		 
		Student ntina = new Student("rou","12345678","Student","kosntantina","rousia","@gmail.com",2012,"OPA");	
		
		admin.add_professor("Giwrgos", "Arv", "Professor", "Giwrgos", "Arvanitis", "Mathimatikos", "@arv.gr");
		admin.add_professor("Kwnstantina", "Thoma", "Professor", "Kwnstantina", "Thoma", "Filologs", "@thoma.gr");
		
		admin.addCourseToProfessor("geometry", "0");
		admin.addCourseToProfessor("math", "0");
		
		ntina.enrollToCourse("0", "biology");
	} 
	
	
	
	
	@Test
	public void test() {
		
		Professor temp=ProfServer.getInstance().getProf_fromID(1);
		
		temp.setGradeToStudent("0", "1", "7");
		temp.setGradeToStudent("4", "1", "8"); // den vazei vathmo se mathith pou den yparxei
		assertEquals(1,CourseServer.getInstance().getGradesSize());
		//temp.setGradeToStudent("0", "0", "10"); // petaei NullPointer kathws to mathima sto opoio thelei na valei vathmo
		//o kathigiths , den yparxei ston sygkekrimeno foithth
		
		
		
		assertEquals(7, CourseServer.getInstance().getGrade(0, 1).getGrade()); 
		
		
	}

}
