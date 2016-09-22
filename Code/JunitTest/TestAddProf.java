package JunitTest;
import static org.junit.Assert.*;

import org.junit.Test;

import Server.ProfServer;
import UserPackage.Administrator;


public class TestAddProf {

	Administrator admin = new Administrator("akis","adsafs","Admin","akis","tsakas","@gmai");	
	
	
	@Test  
	public void test1() {   
		
		int i = ProfServer.getInstance().getProfSize(); 
		admin.add_professor("Giwrgos", "Arv", "Professor", "Giwrgos", "Arvanitis", "Mathimatikos", "@arv.gr");
		//hdh uparxontes kathightes den prostithintai
		admin.add_professor("Giwrgos", "Arv", "Professor", "Giwrgos", "Arvanitis", "Mathimatikos", "@arv.gr");  
		admin.add_professor("Kwnstantina", "Thoma", "Professor", "Kwnstantina", "Thoma", "Filologs", "@thoma.gr");
		admin.add_professor("Aggeliki", "Marlou", "Professor", "Aggeliki", "Marlou", "Viologos", "@marlou.gr");
		
		assertEquals(i+3, ProfServer.getInstance().getProfSize());
		admin.delete_professor("Giwrgos", "Arvanitis");
		// kathightes pou den ypparxoyn den diagrafontai
		admin.delete_professor("Giwrgos", "Arvanitis"); 
		admin.delete_professor("Petros", "Kalampokas");
		assertEquals(i+2, ProfServer.getInstance().getProfSize());
	}
	
	

}
