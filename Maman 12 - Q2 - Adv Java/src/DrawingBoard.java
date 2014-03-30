import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class DrawingBoard extends JPanel {

	private ArrayList<Integer> _arrlist = new ArrayList<Integer>();
	private Integer _distance = 20;
	private Integer _totalDistance = 200;

	public void set_totalDistance(Integer totalDistance) {
		totalDistance = _totalDistance;
	}

	public DrawingBoard(){}

	public DrawingBoard(Integer distance, Integer totalDistance)
	{
		super();
		distance = _distance;
		totalDistance = _totalDistance;
	}
	public void paintComponent(Graphics2D g){
		super.paintComponents(g);

		for(int i=0; i<_totalDistance ;i+=_distance) //printing out the dots
			for(int j=0; j<_totalDistance ;j+=_distance)
				g.drawOval(i, j, 0, 0);

		if(_arrlist.size()>1)
			for (int i=1; i<_arrlist.size(); i++) //re-drawing every time a coordinate is added
				g.drawLine((_arrlist.get(i-1)%10)*_distance, (_arrlist.get(i-1)/10)*_distance, (_arrlist.get(i)%10)*_distance, (_arrlist.get(i)/10)*_distance);
	}// end of paintComponent


	public void addLine(Integer nextNumber){
		_arrlist.add(nextNumber);
		repaint();
	}

	/**
	 * @return the _arrlist
	 */
	public ArrayList<Integer> getArrlist() {
		return _arrlist;
	}

	/**
	 * @param _arrlist the _arrlist to set
	 */
	public void setArrlist(ArrayList<Integer> arrlist) {
		_arrlist = arrlist;
	}

	public int get_totalDistance() {
		return _totalDistance;
	}
}