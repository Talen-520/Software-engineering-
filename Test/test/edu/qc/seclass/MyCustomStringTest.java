package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
    	
        mycustomstring.setString("111111111111111111");
        assertEquals(0, mycustomstring.countNumbers());


    }

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("@@@@@@@@@@@@@@@@@");//check if symbol vaild
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString(""); //check empty string
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("null"); //check if string null regonized as string nor null value
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("010");//count 0 as number
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("   ");		//3 spaces mpty string
    	assertEquals(" ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        //n = 0 check
        mycustomstring.setString("aasdada das");
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);

    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        //functionally
        mycustomstring.setString("test");
        assertTrue("test", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true))


    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("abdsakhjfnqwjk");
    	assertEquals("legit test", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("00");	// length check
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("12345678");	//order check
        assertEquals("87654321", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
        
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString(null);
		mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true);    
    }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("0");	// IllegalArgumentException check
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("test");	// negative value 	
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("test");	// negative value 	
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("87654321");	//order check
        assertEquals("87654321", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("0000");	// length check
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString(null); //null
        mycustomstring.convertDigitsToNamesInSubstring(1, 2);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        //single chara check
        mycustomstring.setString("1");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("One", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("a1a2a3a4"); //check if work
        mycustomstring.convertDigitsToNamesInSubstring(0, 7);
        assertEquals("aOneaTwoaThreeaFour", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        //end > length
        mycustomstring.setString("asdasd");
		mycustomstring.convertDigitsToNamesInSubstring(1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        //start > end
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
  		mycustomstring.convertDigitsToNamesInSubstring(5, 2);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring7() {
     //startPosition > current.length
     mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
     mycustomstring.convertDigitsToNamesInSubstring(60, 61);
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        //endPosition < 1
     mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
     mycustomstring.convertDigitsToNamesInSubstring(0, 0);
    }

}
