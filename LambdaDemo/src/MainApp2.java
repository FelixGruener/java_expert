import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainApp2 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Max","Moritz","Susi");
		
		for (String name:names) {
			System.out.println(name);
		}
		
		
		//Consumer is functional Interface only has accept <-- default , only one abstarct method 
		
		/*** new Consumer<String>(){

			@Override
			public void accept***/
		//remove closing braces , remove semicolon 
		//only one Parameter remove round brackets 
		names.forEach(name -> System.out.println(name));
		//for each of Elements give me te name and do system.out.println 
		//Internally takes care of import 
		//-> Arrow means Lambda Expression 
		
		//Zugriff works because content can be modified 
		//Stringbuilder is Wrapper of String 
		// We have Object (for compiler its final) 
		StringBuilder allNames = new StringBuilder();
		names.forEach(name-> allNames.append(name));
		System.out.println(allNames.toString());
		
		//Kein Zugriff 
		/*String allNames = "";
		names.forEach(name-> allNames +=name);
		System.out.println(allNames);*/
		
		
		AtomicInteger ai = new AtomicInteger(0);
		names.forEach(name->System.out.println(ai.incrementAndGet()+"."+name));
		//1.Max
		//2.Moritz
		//3.Susi
		
		Consumer<String> consumer = name -> System.out.println(name);
		Consumer<String> consumer2 = name -> System.err.println(name);
		Consumer<String> consumer3 = name -> System.err.println(name);
		//How can we apply both Consumers , first printout then system error 
		//expects one consumer but you can input more mit andThen 
		//creates new Consumer and adds 
		names.forEach(consumer.andThen(consumer2).andThen(consumer3));
		
		//<? super T> T  or Super type of T 
		
		Function<String, Integer> mapNameToLength = text -> text.length();
		Function<Integer, Integer> doubleValue = value -> 2*value;
		Function<String, Integer> mapNameToLengthAndDoubleLength = mapNameToLength.andThen(doubleValue);
		
		int doubleLength = mapNameToLengthAndDoubleLength.apply("abc");
		System.out.println(doubleLength);
		
		
		Predicate<String> isEmpty = text -> text.isEmpty();
		Predicate<String> isLessThan10Characters = text -> text.length() <10;
		
		Predicate<String> isEmptyAndLessThan10Characters = isEmpty.negate().and(isLessThan10Characters);
		
		
		System.out.println(isEmptyAndLessThan10Characters.test("abc")); //true
		
		
		
		
		
		
		
		
		
		
		
		

	}
}