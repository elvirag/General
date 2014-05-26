import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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


		File file = new File("memos.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("File already exists. Loading from it...");
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
		HashMemo _hashtable = new HashMemo();

		try{
			while (_input.hasNext()){
				int date = _input.nextInt();
				int day = date % 100;
				int month = (date / 100) % 100;
				int year =  (date / 10000) % 10000;
				//System.out.printf("\nThe date will be %d.%d.%d", day, month, year); //TODO remove debug
				Date realDate = new Date(day, month, year);
				_input.findInLine(" , "); //Advancing past the ","
				String memotext = _input.nextLine(); //Getting the String of the memo.
				//System.out.println("The memo for this day is: \"" + memotext + "\""); //TODO: remove debug
				_hashtable.put(realDate, memotext);
				System.out.println(realDate);
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
