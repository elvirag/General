package UIPack;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class UI extends JFrame{

	JComboBox<Integer> _day;
	private Integer[] _days = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	JComboBox<Integer> _month;
	private Integer[] _months = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	JComboBox<Integer> _year;
	private Integer[] _years = {0,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020};
	
	JTextArea _textArea;
	
	JButton _saveText;
	JButton _getText;
	private String text; //just a test
	private int TEXT_WIDTH = 10;
	private int TEXT_LENGHT = 20;
	
	
	
	public UI(){
		super("Memo Application");
		setLayout(new FlowLayout());
		
		_day = new JComboBox<>(_days);
		add(_day);
		_month = new JComboBox<>(_months);
		add(_month);
		_year = new JComboBox<>(_years);
		add(_year);
		
		_getText = new JButton("Get Text");
		add(_getText);
		
		_saveText = new JButton("Save Text");
		add(_saveText);
		
		_textArea =  new JTextArea(text, TEXT_WIDTH, TEXT_LENGHT);
		add(_textArea);
		
		
	}

	private void frameUp() {

	}
}
