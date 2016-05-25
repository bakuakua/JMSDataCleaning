package preprocess;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSplit {
	
	@Test
	public void test(){
		String test1 = "\"DPD NUTRITION CONSULTANTS, INC\",USD";
		String x1 = "\"DPD NUTRITION CONSULTANTS, INC\"";
		String x2 = "USD";
		assertEquals(x1, preprocessUtils.parseLine(test1).get(0));
		assertEquals(x2, preprocessUtils.parseLine(test1).get(1));
	}
		
	@Test 
	public void test2(){
		String test2 = "retard,moron,idiot";
		String[] x2 = {"retard", "moron", "idiot"};
		ArrayList<String> n2 = preprocessUtils.parseLine(test2);
		//System.out.println(n2.toString());
		for (int i = 0; i<x2.length;i++){
		assertEquals(x2[i], n2.get(i));
	}
	}
	@Test
	public void test3(){
		String test3 = "USA,\"DPD NUTRITION CONSULTANTS, INC\",CHN,\"DPD NUTRITION CONSULTANTS, INC\"";
		String[] x3 = {"USA", "\"DPD NUTRITION CONSULTANTS, INC\"", "CHN","\"DPD NUTRITION CONSULTANTS, INC\""};
		ArrayList<String> n3 = preprocessUtils.parseLine(test3);
		for (int i = 0; i<x3.length;i++){
			assertEquals(x3[i], n3.get(i));
		}
	}
	@Test
	public void test4(){
		String test4 = "test,,";
		String[] x4 = {"test","",""};
		ArrayList<String>n4 = preprocessUtils .parseLine(test4);
		for (int i = 0; i<x4.length;i++){
			assertEquals(x4[i], n4.get(i));
		}
	}
   @Test	public void test5(){
		String test5 = ",,,";
		String[] x5 = {"","","",""};
		ArrayList<String>n5 = preprocessUtils.parseLine(test5);
		assertEquals(4, n5.size());
		for (int i = 0; i<x5.length;i++){
			assertEquals(x5[i], n5.get(i));
		}
		
	}
  @Test
  public void test6(){
	   String test6 = null;
	   ArrayList<String>n6 = preprocessUtils.parseLine(test6);
	   assertEquals(0,n6.size());
	   
  }
  @Test
  public void test7(){
		String test5 = ",,test,";
		String[] x5 = {"","","test",""};
		ArrayList<String>n5 = preprocessUtils.parseLine(test5);
		assertEquals(4, n5.size());
		for (int i = 0; i<x5.length;i++){
			assertEquals(x5[i], n5.get(i));
		}
		
	}
  @Test
  public void test8(){
		String test5 = ",,,test";
		String[] x5 = {"","","","test"};
		ArrayList<String>n5 = preprocessUtils.parseLine(test5);
		assertEquals(4, n5.size());
		for (int i = 0; i<x5.length;i++){
			assertEquals(x5[i], n5.get(i));
		}
		
	}
  @Test
  public void test9(){
		String test5 = ",,,\"\"";
		String[] x5 = {"","","","\"\""};
		ArrayList<String>n5 = preprocessUtils.parseLine(test5);
		assertEquals(4, n5.size());
		for (int i = 0; i<x5.length;i++){
			assertEquals(x5[i], n5.get(i));
		}
		
	}
   @Test
   public void test10(){
		String test5 = ",,,\"DPD NUTRITION CONSULTANTS, INC\"";
		String[] x5 = {"","","","\"DPD NUTRITION CONSULTANTS, INC\""};
		ArrayList<String>n5 = preprocessUtils.parseLine(test5);
		assertEquals(4, n5.size());
		for (int i = 0; i<x5.length;i++){
			assertEquals(x5[i], n5.get(i));
		}
		
	}
}