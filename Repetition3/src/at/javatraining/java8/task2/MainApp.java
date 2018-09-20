package at.javatraining.java8.task2;

public class MainApp {
	public static void main(String[] args) {
		CaesarCipher cipher = new CaesarCipher();
		
		String cipherText = cipher.encrypt("abc");
		System.out.println(cipherText); // DEF
	}
}