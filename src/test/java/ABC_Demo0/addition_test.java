package ABC_Demo0;

import org.testng.annotations.Test;

public class addition_test {
	
	int a,b,c;
	
  @Test
  public void addition() {
	  
	  a=10;
	  b=20;
	  c=a+b;
	  
	  System.out.println("c value is"+c);
  }
}
