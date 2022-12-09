/**
 * 
 */
package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {

    public String current;

    @Override
    public String getString() {
        if (current == null) {
            return null;
        }
        return current;
    }

    @Override
    public void setString(String string) {
        this.current = string;
        // 'this'eliminate the confusion between class attributes and parameters
    }

    @Override
    // https://stackoverflow.com/questions/39823137/java-count-the-number-of-integers-in-a-string
    public int countNumbers() {
        if (current == null) {
            throw NullPointerException;
        }
        int count = 0;
        boolean isPreviousDigit = false;

        for (int i = 0; i < current.length(); i++) {
            if (Character.isDigit(current.charAt(i))) {
                if (!isPreviousDigit) {
                    count++;
                    isPreviousDigit = true;
                }
            } else {
                isPreviousDigit = false;
            }
        }
        return count;

    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (current == null) {
            throw new NullPointerException();
        }
        String string = "";
        if (startFromEnd == false) {
            for (int i = 1; i < current.length() + 1; i++) {
                if (i * n > current.length()) {
                    break;
                } 
                else {
                    string += current.charAt(i * n - 1);
                } 
            } 
        } 
          
        else {
            for (int i = 0; i < current.length(); i++) {
                if ((i + 1) * n > current.length()) {
                    break;
                } 
                else {
                    string = current.charAt(current.length() - (i + 1) * n) + string;
                } 
            } 
        }

        return string;

    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if(startPosition > endPosition) {throw new IllegalArgumentException();}
        if(startPosition <= endPosition ||startPosition > current.length || endPosition < 1 ){throw new MyIndexOutOfBoundsException("Out of bound");}
        if(startPosition <= endPosition && endPosition >0 && startPosition>0 && current == null){throw new NullPointerException();}
        String temp = "";
		for(int i = startPosition - 1; i < endPosition; ++i){
			if(current.charAt(i) >= '0' && current.charAt(i) <= '9'){
				switch(current.charAt(i)){
				case '0': temp = "Zero";
					break;
				case '1': temp = "One";
					break;
				case '2': temp = "Two";
					break;
				case '3': temp = "Three";
					break;
				case '4': temp = "Four";
					break;
				case '5': temp = "Five";
					break;
				case '6': temp = "Six";
					break;
				case '7': temp = "Seven";
					break;
				case '8': temp = "Eight";
					break;
				case '9': temp = "Nine";
					break;
				}
                //start + middle + end
				endPosition += temp.length() - 1;
				current = current.substring(0, i) + temp + current.substring(i + 1, s.length());//add string in order to current
				
			}
		}


    }
}
