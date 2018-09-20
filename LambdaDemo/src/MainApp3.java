import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MainApp3 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Max","Moritz","Susi");
		
		//TODO! list should be sorted DESC - hint: use Comparator
	//Before	
	/*	names.sort(new Comparator<String>() {

			@Override
			public int compare(String name1, String name2) {
				// TODO Auto-generated method stub
				return name2.compareTo(name1); //DESC
			}
			
		});
		
		names.forEach(name-> System.out.println(name));	*/
		//return can be removed when its one liner and no braces , no semicolons 
		// if two liner need braces and return and semicolons 
		
		//AFTER with one Line , sort by names DESC
		//names.sort((name1, name2) -> name2.compareTo(name1));
		
		//AFTER with two lines 
		names.sort( (name1, name2) -> {
				System.out.println(name1 + " / " + name2);
				return name2.compareTo(name1); //DESC	
		});
		
		names.forEach(name-> System.out.println(name));	
		
		names.sort((name1, name2) -> printAndCompare(name1,name2));
		
		private static int printAndCompare(String name1, String name2){
			
			System.out.println(name1 + " / " + name2);
			return name2.compareTo(name1);
			
		}
		
		names.sort(createComparatorOrderByNameLength());
		
		//SORT BY LENGTH OF NAMES 
		names.sort(
				(name1,name2) -> Integer.compare(name1.length(), name2.length())
				);
		
		private static Comparator<String> createComparatorOrderByNameLength() {
			return (name1,name2) -> {
				System.out.println(name1 + " / " + name2);
				name2.compareTo(name1);
			};
		}
		
	}
}