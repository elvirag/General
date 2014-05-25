import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class HandleFileMemo{
	
	private Scanner _input;
	
	public HandleFileMemo(){
		createFile();
		openFile();
		readMemos();
	}
	
	public void createFile(){
		try {
			if (File.createTempFile("memos", "txt", null) != null){
				System.out.println("File already exists. Wasn't created...");
			}
		} catch (IOException e) {
			System.err.println("Something weird happened");
			e.printStackTrace();
		}
	}
	public void openFile(){
		try
		{
			_input = new Scanner( new File("memos.txt"));
		}
		catch (FileNotFoundException fnfe){
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}
	
	public void readMemos(){
		Hashtable<Date, String> _hashtable = new Hashtable<>();
		
		System.out.print("Let's print the file!!!");
		try{
			while (_input.hasNext()){
				
			}
		}
		catch(NoSuchElementException nsee){
			System.err.println("File improperly formed.");
			_input.close();
			System.exit(1);
		}
		catch(IllegalStateException ise){
			System.err.println("Error reading from file.");
			System.exit(1);
		}
	}
	
	public void closeFile(){
		{
			if (_input != null){
				_input.close();
			}
		}
	}
}
