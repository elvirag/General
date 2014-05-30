import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;


/**
 * The class that handles the file I/O.<br>
 * When window is opened, loads the date from a file.<br>
 * If there is no such file, it creates it, but doesn't fill it for now.<br>
 * When window is closed, saves the data from the hash-table<br>
 * to the file so it can be loaded.
 */
public class HandleFileMemo{

	//scans the data from file (could have used BufferedReader, I know. But I used the writer, wanted to train on both types)
	private Scanner _input;
	//the hash table that retains the data.
	static Hashtable<Date, String> _hashtable; //It needs to be the same one everyone knows, so it's static.
	File _file; //the file entity
	private final String PREFIX = " , $$$"; //prefix before string and after the date, so INFO can be saved with newlines...
	private final String SUFFIX = "$$$\n"; // suffix to know when string of a specific date ends.

	
	/**
	 * The constructor of the class.<br>
	 * It creates the file and opens it. Also reads info from there.<br>
	 * Doesn't have the other function of saving data,<br>
	 * because it is handled when window closes.<br>
	 * and not needed before that.
	 */
	public HandleFileMemo(){
		createFile();
		openFile();
		readMemos();
	}

	
	private void createFile(){// creates a file. Handles exception of not succeeding to create the file.
		_file = new File("memos.txt"); //Creates a file object with the name "memos.txt"
		try{
			_file.createNewFile();  // create file by the name "memos.txt"
		}
		catch (IOException e){
			JOptionPane.showConfirmDialog(null, "Failed to create file.", "Error", JOptionPane.OK_OPTION);//If an exception is throw, handled.
			System.exit(1);
		}
	}


	private void openFile(){ //opens the file created for reading/scanning.
		try{
			_input = new Scanner(_file);//gets the input object so it can be used.
		}
		catch (FileNotFoundException fnfe){
			JOptionPane.showConfirmDialog(null, "Error openinig file. Exitting...", "Error", JOptionPane.OK_OPTION);//If an exception is throw, handled.
			System.exit(1);
		}
	}

	
	private void readMemos(){ //reads the memos from the file using the suffixes and prefixes for successful parsing.
		_hashtable = new Hashtable<>(); //Initialization of out static hashtable.
		String memotext = ""; //Setting memotext to empty.
		try{
			while (_input.hasNext()){ //while the file is not done being read...
				String stringDate = _input.next(); //get the date from the line beginning.
				Integer date = Integer.parseInt(stringDate); //parse it so it can be inputed in the hash table
				int day = date % Date.MONTH_MULT; //the day is the modulo of the date, the last 2 digits, so modulo of a hundred.
				int month = (date / Date.MONTH_MULT) % Date.MONTH_MULT; //The next 2 figures in a date are the month
				int year =  (date / Date.YEAR_MULT) % Date.YEAR_MULT; //the first 4 figures are the year.
				//setting an object from them, so it can check the date, if it's legal at all,
				Date realDate = new Date(day, month, year); //so no illegal data can be set as a date

				do { //staring to read the file from the date.
					memotext += _input.nextLine() + "\n"; //Getting the String of the memo.
					if (memotext.startsWith(PREFIX)) //if the string starts with the prefix...
						memotext = memotext.substring(PREFIX.length()); //the prefix is cut out before adding to the hash table.

				}while (!memotext.endsWith(SUFFIX)); //The memo text ends with the suffix.

				memotext = memotext.substring(0, memotext.length() - SUFFIX.length()); //which is in turn, cut out as well.
				_hashtable.put(realDate, memotext); //the data is inputed into the hash table as a pair.
				memotext = ""; //Resetting the string, so we can go to the next memo
			}
		}
		catch(NoSuchElementException nsee){ //catching different exceptions.
			JOptionPane.showConfirmDialog(null, "Failed to create file.", "Error", JOptionPane.OK_OPTION);//If an exception is throw, handled.
			System.err.println("File improperly formed.");
			_input.close(); //not forgetting to close input so no resources are leaked.
			System.exit(1);
		}
		catch(IllegalStateException ise){ //like problem reading from file.
			JOptionPane.showConfirmDialog(null, "Failed to create file.", "Error", JOptionPane.OK_OPTION);//If an exception is throw, handled.
			System.err.println("Error reading from file.");
			_input.close(); //not forgetting to close input so no resources are leaked.
			System.exit(1);
		}
	}

	/**
	 * The method that handles the hash table data when window is closed.
	 * @throws IOException
	 */
	public void closeFile() throws IOException{ //Throws an exception so it van be handled when it's more relevant.
		BufferedWriter bw = new BufferedWriter(new FileWriter(_file)); //A new buffered writer object is created
		String str;//string to be written
		for (Entry<Date, String> entry : _hashtable.entrySet()) { //going through all pairs of hashtable
			str = entry.getKey() + PREFIX + entry.getValue() + SUFFIX; //reading text from it and appending prefix and suffix so it can be parsed successfully.
			try {//checking if string is not empty because hash table might be empty
				bw.flush(); //buffer is flushed, to be cautious
				bw.write(str); //buffer writes the string created before.
			} catch (IOException e) { //if hash table is empty indeed, exception is handled.
				JOptionPane.showConfirmDialog(null, "Nothing to write to file.\n Memo book is empty. Exiting...", "Error", JOptionPane.OK_OPTION);
				e.printStackTrace();
				bw.close(); //buffer is closed, to prevent from leaked resources.
				System.exit(1);
			}
		}
		bw.close(); //buffer is closed when file is done being written to successfully.
		if (_input != null){ //if input is open...
			_input.close(); //close it.
		}
	}
}