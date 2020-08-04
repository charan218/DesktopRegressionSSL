package revampTestCase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		
	    String strDate= new SimpleDateFormat("ddMMyyyyssHHmmss").format(new Date());  
	    System.out.println(strDate);  
		
	}

}
