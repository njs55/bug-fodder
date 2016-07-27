import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class testSieve {
  //for capturing System.out.print() statements
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  
  //used to assert that a certain exception has been thrown
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  //to capture the PrintStream going out
  @Before
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
  }

  //to reset the PrintStream 
  @After
  public void cleanUpStreams() {
      System.setOut(null);
  }

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
  
  //ensure the array passed to printSieve prints indeces 1-.length
  @Test
  public void testPrintSieve() {
    Sieve sieve = new Sieve();
    int[] testIntArr = {1,2,5,7};
    sieve.printSieve(testIntArr);    
    assertEquals( "> 2 5 7 " ,outContent.toString());
  }
  
  //ensure that if no primes are listed "BLANK" is outputted
  @Test
  public void testPrintSieveBlank() {
    Sieve sieve = new Sieve();
    //the way the code is written 1 will always been in the array
    int[] testIntArr = {1};
    sieve.printSieve(testIntArr);    
    assertEquals( "BLANK" ,outContent.toString().trim());
  }

}
