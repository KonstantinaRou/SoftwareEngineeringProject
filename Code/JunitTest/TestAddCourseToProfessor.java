package JunitTest;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Server.CourseServer;
import Server.ProfServer;
import UserPackage.Administrator;
import UserPackage.Professor;


public class TestAddCourseToProfessor {

	
	Administrator admin;
	
	@Before public void SetUp(){
		admin = new Administrator("akis","adsafs","Admin","akis","tsakas","@gmai");
		admin.add_course("math", "blah blah");
		admin.add_course("biology", "blah blah"); 
		admin.add_course("geometry", "blah blah");
		 
		 
		admin.add_professor("Giwrgos", "Arv", "Professor", "Giwrgos", "Arvanitis", "Mathimatikos", "@arv.gr");
		admin.add_professor("Kwnstantina", "Thoma", "Professor", "Kwnstantina", "Thoma", "Filologs", "@thoma.gr");
		admin.add_professor("Aggeliki", "Marlou", "Professor", "Aggeliki", "Marlou", "Viologos", "@marlou.gr");
	}
	 
	
	
	@Test //(expected = NullPointerException.class)
	public void matchProfessorwithCoruseTest() {
		
		
		admin.addCourseToProfessor("geometry", "0");
		admin.addCourseToProfessor("math", "0");
		admin.addCourseToProfessor("science", "0"); // den to prosthetei kathws den uparxei
		
		  
		
		assertEquals(2,CourseServer.getInstance().ProfessorTimetablesize(0));
		
		assertEquals(0,CourseServer.getInstance().ProfessorTimetablesize(2));
		
		Professor temp=ProfServer.getInstance().getProf_fromID(0);
		temp.editCourseInfo("math", "katse kala");
		assertEquals("katse kala",CourseServer.getInstance().getCourse("math").getInfo()); 
		temp.editCourseInfo("science", "hello world");
		//assertEquals("katse kala",CourseServer.getInstance().getCourse("science").getInfo()); // edw petaei exception
	 }
}
