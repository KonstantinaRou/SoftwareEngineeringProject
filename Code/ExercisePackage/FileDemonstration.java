/*********Xreiazetai jdk 1.7 !!!*******************/


package ExercisePackage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDemonstration extends JFrame{
	private File name;
	
	public FileDemonstration(){
		analyzePath();
	}
	
	private File getFileOrDirectory(){
		JFileChooser fileChooser= new JFileChooser();
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".pdf","pdf");
		fileChooser.setFileFilter(filter);
		
		int result=fileChooser.showOpenDialog(this);
		
		if(result==JFileChooser.CANCEL_OPTION){
			System.exit(1);
		}
		File fileName=fileChooser.getSelectedFile();
		if((fileName==null)||fileName.getName().equals("")){
			JOptionPane.showMessageDialog(this, "Invalid File Name","Invalid Name",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return fileName;
	}
	
	private void analyzePath(){
		name=getFileOrDirectory();
		
		if(!name.exists()){
			JOptionPane.showMessageDialog(this, "Invalid File Name","Invalid Name",JOptionPane.ERROR_MESSAGE);	
		}
	}
	
	public File returnFile(){
		return name;
	}
	
	
	
}
	
	
