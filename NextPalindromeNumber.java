
public class NextPalindromeNumber {
	
	public static void main(String[] args) {
		System.out.println("Program for palindrome");
		String inputNumber = "175";
		System.out.println("Input number is: " + inputNumber);
		int nextPalinNum = getNextPalindrome(inputNumber);
		System.out.println("Next nearenst palindrome is:" + nextPalinNum);
	}
	
	public static int getNextPalindrome(String input) {
		boolean isOddLengthInput = false;
		int increment = 0;
		int lengthOfInputNumber = input.length();
		String nextPalindromeNumber = "";
		int inputNumber = Integer.parseInt(input);
		if(lengthOfInputNumber%2 != 0) {
			isOddLengthInput = true;
		}
		String inputLeftPart = getLeftSide(input);
		String midOfInput = getMiddleNum(input);
		StringBuilder sbInputLeftPart = new StringBuilder(inputLeftPart);
		
		if(isOddLengthInput) {
			increment = (int) Math.pow(10, (lengthOfInputNumber/2) );
			nextPalindromeNumber = inputLeftPart + midOfInput + sbInputLeftPart.reverse().toString();
		}else {
			increment = (int)((1.1)*Math.pow(10, (lengthOfInputNumber/2)));
			 nextPalindromeNumber = inputLeftPart + sbInputLeftPart.reverse().toString();
		}
		
		if(Integer.parseInt(nextPalindromeNumber) > inputNumber ) {
			return Integer.parseInt(nextPalindromeNumber);
		}
		
		if(!"9".equals(midOfInput)) {
			return Integer.parseInt(nextPalindromeNumber) + increment;
		}else {
			String roundedUpInput = roundValue(input);
			return getNextPalindrome(roundedUpInput);
		}
	}
	
	public static String getLeftSide(String input) {
		String leftHalfOfString = "";
		leftHalfOfString = input.substring(0, input.length()/2);
		return leftHalfOfString;
	}
	
	public static String getMiddleNum(String input) {
		String middleNumOfInput = "";
		 middleNumOfInput = String.valueOf(input.charAt((input.length()-1)/2));
		return middleNumOfInput;
	}
	
	public static String roundValue(String input) {
		int inputLength = input.length();
		int inc = (int) Math.pow(10, ((inputLength/2)+1) );
		return Integer.toString((((Integer.parseInt(input)/inc)+1)*inc));
	}
}
