package at.javatraining.java8.task2;

public class CaesarCipher {
	// the method should encrypt the passed plainText (allowed characters: a-zA-Z) using the Cäsar cipher algorithm.
	public String encrypt(String plainText) {
		// TODO! implement method - USE A STREAM!
		
		int[] codePoints = plainText.codePoints() //returns IntStreams Unicodes(A=65,a=97)
			.map(unicode -> (unicode-97 +3) % 26+65) //returns IntStream
			.toArray();
		
		return new String(codePoints, 0 , codePoints.length);
		
	}
}
