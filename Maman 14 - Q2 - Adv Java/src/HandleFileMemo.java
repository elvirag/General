import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class HandleFileMemo{

	private Scanner _input;
	static Hashtable<Date, String> _hashtable;
	File _file;
	private final String PREFIX = " , $$$";
	private final String SUFFIX = "$$$\n";


	public HandleFileMemo(){
		createFile();
		openFile();
		readMemos();
	}


	private void createFile(){
		_file = new File("memos.txt");
		try
		{
			_file.createNewFile();
		}
		catch (IOException e)
		{
			System.err.println("File already exists. Loading from it...");
		}
	}


	private void openFile(){
		try
		{
			_input = new Scanner( new File("memos.txt"));
		}
		catch (FileNotFoundException fnfe){
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}

	private void readMemos(){
		_hashtable = new Hashtable<>();
		String memotext = "";
		try{
			while (_input.hasNext()){
				String stringDate = _input.next();
				Integer date = Integer.parseInt(stringDate);
				int day = date % 100;
				int month = (date / 100) % 100;
				int year =  (date / 10000) % 10000;
				//System.out.printf("\nThe date will be %d.%d.%d\n", day, month, year); //TODO remove debug
				Date realDate = new Date(day, month, year);

				do {
					memotext += _input.nextLine() + "\n"; //Getting the String of the memo.
					if (memotext.startsWith(PREFIX))
						memotext = memotext.substring(PREFIX.length());

				}while (!memotext.endsWith(SUFFIX));

				memotext = memotext.substring(0, memotext.length() - SUFFIX.length());
				//System.out.println("Memo to be written to hashtable: \"" + memotext + "\""); //TODO: remove debug
				_hashtable.put(realDate, memotext);
				memotext = ""; //Resetting the string, so we can go to the next memo
			}
		}
		catch(NoSuchElementException nsee){
			System.err.println("File improperly formed.");
			_input.close();
			System.exit(1);
		}
		catch(IllegalStateException ise){
			System.err.println("Error reading from file.");
			_input.close();
			System.exit(1);
		}
	}


	public void closeFile() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(_file));
		String str;
		for (Entry<Date, String> entry : _hashtable.entrySet()) {
			str = entry.getKey() + PREFIX + entry.getValue() + SUFFIX;
			try {
				System.out.println("str = " + str);
				bw.flush();
				bw.write(str);
			} catch (IOException e) {
				System.err.println("Nothing to write to file.\n Memo book is empty. Exiting...");
				e.printStackTrace();
				bw.close();
				System.exit(1);
			}
		}
		bw.close();
		if (_input != null){
			_input.close();
		}
	}
}