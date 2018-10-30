package corejava;

import java.util.HashMap;
import java.util.Map;

public class MapClass {

	public static void main(String[] args) {
		
     Map<String, String> map=new 
    		 HashMap<String, String>();
     map.put("one", "one");
     map.put("one", "two");
     System.out.println(map);
     
     
	}

}
