package JunitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import Server.CourseServer;
import UserPackage.Administrator;


public class TestAddingDeletingCourse {

	Administrator admin = new Administrator("akis","adsafs","Admin","akis","tsakas","@gmai");	
	int i=0 ;
	@Test
	public void testaddCourse() {
		int previousSize = CourseServer.getInstance().getCourseSize();
		
		admin.add_course("math", "blah blah");
		admin.add_course("biology", "blah blah");
		admin.add_course("geometry", "blah blah");
		admin.add_course("science", "blah blah");
		admin.add_course("science", "info"); //elegxos diplotupou. Den prosthetei hdh yparxonta mathimata 
 		assertEquals(previousSize + 4, CourseServer.getInstance().getCourseSize());	
		
 		admin.delete_course("math");
		assertEquals(previousSize + 3, CourseServer.getInstance().getCourseSize());	
		
		admin.delete_course("biology");
		admin.delete_course("geometry");    
		admin.delete_course("science");
		assertEquals(previousSize, CourseServer.getInstance().getCourseSize());
		admin.delete_course("math");
		admin.delete_course("ssss");//den kanei tpt efoson to mathima den uparxei.
		assertEquals(previousSize, CourseServer.getInstance().getCourseSize());

	}	
	
	
	
	
	

}
