package JunitTest;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Server.CourseServer;
import UserPackage.Administrator;
import UserPackage.Student;


public class TestStudent {
	
	Administrator admin = new Administrator("akis","adsafs","Admin","akis","tsakas","@gmai");
	
	
	@Before public void SetUp(){
		admin.add_course("leitourgika", "duskolo");
		admin.add_course("vaseis", "eukolo");
		admin.add_course("texnologia logismikou","metrio"); 
		 
	} 
	 
	
	
	
	
	@Test
	public void test() {
		
		
		
		Student kostas = new Student("Destroyer","123456","Student","kostas","pelelis","@gmai.com",2010,"ECE");	
		Student ntina = new Student("rou","12345678","Student","kosntantina","rousia","@gmail.com",2012,"OPA");	
		Student nikos = new Student ("tsinti","1234880","Student","nikos","tsintiris","@gmail.com",2012,"OPA");
		
		kostas.enrollToCourse( "0","leitourgika");
		kostas.enrollToCourse("0","vaseis");
		kostas.enrollToCourse("0","vaseis"); // den to vazei kathws uparxei hdh
		kostas.enrollToCourse("0", "texnologia logismikou");
		ntina.enrollToCourse(  "1","vaseis");
		nikos.enrollToCourse("2", "texnologia logismikou");
		nikos.enrollToCourse("2", "vaseis");
		
		ArrayList<String> kostas_courses = CourseServer.getInstance().getCourses_student(kostas.getAM());
		ArrayList<String> ntina_courses = CourseServer.getInstance().getCourses_student(ntina.getAM());
		ArrayList<String> nikos_courses = CourseServer.getInstance().getCourses_student(nikos.getAM());
		assertEquals(3, kostas_courses.size());
		assertEquals(1,ntina_courses.size());
		assertEquals(2,nikos_courses.size());
		
		
		kostas.abandonCourse( "0","leitourgika");
		kostas.abandonCourse("0", "vaseis");
		kostas.abandonCourse("0", "texnologia logismikou");
		kostas.abandonCourse("0","mathima"); // den kanei tpt kathws o "kostas" den exei grafei se ayto to mathima
		kostas_courses=CourseServer.getInstance().getCourses_student(kostas.getAM());
		
		assertEquals(0, kostas_courses.size());
		
	
		
	}
 
}
