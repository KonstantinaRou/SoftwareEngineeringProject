package Server;

import java.util.ArrayList;

import UserPackage.Professor;

public class ProfServer {

	/*Ta pada leitourgoun me thn methodo request. O Admin dimiourgei Professors kai autoi prosthetontai se mia lista*/
	
	 
	private static ProfServer instance = new ProfServer();
	private ArrayList<Professor> ProfList = new ArrayList<Professor>();
	
	private ProfServer(){
		ProfList=new ArrayList<Professor>();
	}
	
	 
	public static ProfServer getInstance (){
		return instance;
	}
	
	 
	public void request(Object caller,request_type req,String[] args){
		if (caller.getClass().getName().equals("UserPackage.Administrator")&& req==request_type.ADD_PROF){
			String username = args[0];
			String password = args[1];
			String occupation = args[2];
			String firstName = args[3];
			String lastName = args[4];
			String expertise = args[5]; 
			String email = args[6];
			Professor new_Prof =new Professor(username,password,occupation,firstName,lastName,expertise,email);
			
			for(int i = 0; i < ProfList.size(); i++) 
			{
				if(ProfList.get(i).getFirstName().equals(firstName)&&ProfList.get(i).getLastName().equals(lastName)){
					return;
				}
			}
			
			
			ProfList.add(new_Prof);
		}
		
		
		if (caller.getClass().getName().equals("UserPackage.Administrator")&& req==request_type.DELETE_PROF){
			
			String firstName = args[0];
			String lastName = args[1];
			
			Professor temp=null ;
			
			for(Professor i : ProfList){
				if(i.getFirstName().equals(firstName)&&i.getLastName().equals(lastName)){
					temp=i;
					break;
				}				
				temp=null;
				
			}
			ProfList.remove(temp);	
		}
		
	
		
		
	}//end request
	
	
	public Professor getProf_fromID(int ID)
	{
		for(Professor p : ProfList)
		{
			if(p.getProfID() == ID)
				return p;
		}
		return null;
	}
	
	public int getProfSize(){
		return ProfList.size();
	}
	

	
	
	
	
	
	
}
