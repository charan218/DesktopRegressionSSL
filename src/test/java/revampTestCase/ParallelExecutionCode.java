package revampTestCase;
import org.testng.annotations.Test;
public class ParallelExecutionCode {
	@Test
	 public  void executSession1() throws Exception{
		Parallel_execution Pe=new Parallel_execution();
		Pe.config();
		Pe.executSession("techoutsqa@gmail.com");
	}
	/*@Test
	 public  void executSession2() throws Exception{
		Parallel_execution Pe=new Parallel_execution();
		Pe.executSession("sravya14@gmail.com");
	}
	@Test
	 public  void executSession3() throws Exception{
		Parallel_execution Pe=new Parallel_execution();
		Pe.executSession("sravya18@gmail.com");
	}*/


}
