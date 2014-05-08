import java.util.HashMap;
import java.util.Map;


public class KeyBoardHash {

	Map<Integer, String> _keyhash = new HashMap<Integer, String>();

	public KeyBoardHash() {
		_keyhash.put(192,"~");
		_keyhash.put(49,"1");
		_keyhash.put(50,"2");
		_keyhash.put(51,"3");
		_keyhash.put(52,"4");
		_keyhash.put(53,"5");
		_keyhash.put(54,"6");
		_keyhash.put(55,"7");
		_keyhash.put(56,"8");
		_keyhash.put(57,"9");
		_keyhash.put(48,"0");
		_keyhash.put(45,"-");
		_keyhash.put(61,"+");
		_keyhash.put(8,"Backspace");
		
		_keyhash.put(9,"Tab");
		_keyhash.put(81,"Q");
		_keyhash.put(87,"W");
		_keyhash.put(69,"E");
		_keyhash.put(82,"R");
		_keyhash.put(84,"T");
		_keyhash.put(89,"Y");
		_keyhash.put(85,"U");
		_keyhash.put(73,"I");
		_keyhash.put(79,"O");
		_keyhash.put(80,"P");
		_keyhash.put(91,"[");
		_keyhash.put(93,"]");
		_keyhash.put(92,"\\");
		
		_keyhash.put(20,"Caps");
		_keyhash.put(65,"A");
		_keyhash.put(83,"S");
		_keyhash.put(68,"D");
		_keyhash.put(70,"F");
		_keyhash.put(71,"G");
		_keyhash.put(72,"H");
		_keyhash.put(74,"J");
		_keyhash.put(75,"K");
		_keyhash.put(76,"L");
		_keyhash.put(59,":");
		_keyhash.put(222,"'");
		_keyhash.put(10,"Enter");
		
		_keyhash.put(16,"Shift");
		_keyhash.put(90,"Z");
		_keyhash.put(88,"X");
		_keyhash.put(67,"C");
		_keyhash.put(86,"V");
		_keyhash.put(66,"B");
		_keyhash.put(78,"N");
		_keyhash.put(77,"M");
		_keyhash.put(44,",");
		_keyhash.put(46,".");
		_keyhash.put(47,"?");
		_keyhash.put(38,"^");
		
		_keyhash.put(32,"                                      ");
		_keyhash.put(37,",");
		_keyhash.put(40,"<");
		_keyhash.put(39,"v");
		_keyhash.put(86,">");
	}
	
	public int getsize(){
		return _keyhash.size();
	}
	
	
}
