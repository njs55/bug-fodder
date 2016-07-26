import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class testSieve {
  //used to assert that a certain exception has been thrown
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  //ensure calculateMax still returns the int of entered argument
  @Test
  public void testCalculateMax() {
    Sieve sieve = new Sieve();
    String[] testStringArr = {"20"};
    assertEquals( 20 ,sieve.calculateMax(testStringArr));
  }
  
  //ensure calculateMax throws an exception when it is not passed an argument
  @Test
  public void testCalculateMaxException() {
    Sieve sieve = new Sieve();
    String[] testStringArr = new String[0];
    //the exception we want thrown
    exception.expect(IllegalArgumentException.class);
    sieve.calculateMax(testStringArr);
  }
  
  //ensure calculateMax throws an exception when it is passed "0"
  @Test
  public void testCalculateMaxExceptionZero() {
    Sieve sieve = new Sieve();
    String[] testStringArr = {"0"};
    //the exception we want thrown
    exception.expect(IllegalArgumentException.class);
    sieve.calculateMax(testStringArr);
  }
  
  //ensure calculateMax still returns the int of entered argument
  //when more than 1 argument is entered
  @Test
  public void testCalculateMaxManyArgs() {
    Sieve sieve = new Sieve();
    String[] testStringArr = {"13","25","100"};
    assertEquals( 13 ,sieve.calculateMax(testStringArr));
  }

}
