package at.javatraining.java8.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class MainApp {
	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<>(); // you don't need any sample data to solve the exercises ;-)
		
		// TODO return all titles of action movies with Arnold Schwarzenegger as list.
		
		/*Movie movie = new Movie();
		//contains uses equals 
		movie.getActors().contains("Arnold");
		
		movies.stream()
		.filter(movie->movie.getActors().contains("Arnold") 
		.map(Event::getDescription) //Intermediate => STream<String>
		.forEach(description -> System.out.println(description));*/
		//Variant 1 using List.contains 
		
		List<String> titles = movies.stream()
			.filter(movie -> movie.getCategory() == Category.ACTION)
			.filter(movie -> movie.getActors().contains(new Actor("Arnold","Schwarzenegger",null)))
			.map(movie->movie.getTitle())
			.collect(Collectors.toList());
		
		
		
		//Variant2 Using stream in stream 
		List<String> titles2 = movies.stream()
				.filter(movie -> movie.getCategory() == Category.ACTION)
				.filter(movie -> movie.getActors().stream()
						.anyMatch(
								actor->"Arnold".equalsIgnoreCase(actor.getFirstName()) &&
								"Schwarzenegger".equalsIgnoreCase(actor.getLastName())
								))			
				.map(movie->movie.getTitle())
				.collect(Collectors.toList());
		
		//Variant3 Using stream in stream with Predicate 
		Predicate<Movie> movieContainsActorArnoldSchwarzenegger =
				movie -> movie.getActors().stream()
					.anyMatch(
							actor->"Arnold".equalsIgnoreCase(actor.getFirstName()) &&
							"Schwarzenegger".equalsIgnoreCase(actor.getLastName())
							);
		
		
				List<String> titles3 = movies.stream()
						.filter(movie -> movie.getCategory() == Category.ACTION)
						.filter(movieContainsActorArnoldSchwarzenegger
					    )			
						.map(movie->movie.getTitle())
						.collect(Collectors.toList());
				
				//Variant 4 using stream of stream incl. Predicate creator method
				List<String> titles4 = movies.stream()
						.filter(movie -> movie.getCategory() == Category.ACTION)
						.filter(movieContainsActorArnoldSchwarzenegger("Arnold","Schwarzenegger")
					    )			
						.map(movie->movie.getTitle())
						.collect(Collectors.toList());
		
		
		// TODO return average length of love stories produced in Bollywood.
		OptionalDouble averageDuration= movies.stream() //stream of <Movie>
			.filter(movie->movie.getCategory() == Category.LOVE_STORY && movie.getRegion() == Region.BOLLYWOOD)	//Stream<Movie>
			.mapToInt(movie->movie.getDuration()) // creates IntStream , only map changes Type , primitives provide average , sum etc
			.average(); //Average returns a OptionalDouble Value, container //TERMINAL OPERATION 
		System.out.println(averageDuration.getAsDouble());
		averageDuration.ifPresent(System.out::println); //Prints resut to console only if a result is present

		// TODO does the database contain a drama that lasts shorter than 50 min?
		boolean result2 = movies.stream()
				.filter(movie->movie.getCategory() == Category.DRAMA)
				.anyMatch(movie->movie.getDuration() < 50); //Special Terminalfunction to boolean from stream of movies 

		// TODO how many movies with Christoph Waltz, not produced in hollywood are in the "database"?
		long numberOfMovies = movies.stream()
				.filter(movieContainsActorArnoldSchwarzenegger("Christoph","Waltz"))
				.filter(movie->movie.getRegion() != Region.HOLLYWOOD)
				.count();
		System.out.println(numberOfMovies); //primitve Long doesnt need to be converted (with Long Object == > Autoboxing)

		Long value = null; //<= not possible with primitive Long 
		long value1 = 0;
		
		// TODO return a list containing (title, corresponding actors as comma-separated string) objects for all comedies.
		List<SimpleMovie> simpleMovies = movies.stream()
			.filter(movie->movie.getCategory()==Category.COMEDY)//movies passed to map function
			.map(movie -> new SimpleMovie(movie)) //transforms Stream<Movie> to Stream<SimpleMovie>
			.collect(Collectors.toList());
		
		
		
		// TODO implement a method processMovies(...). it should be possible to pass the movie list,
		// an optional (!) filter, a mapping function and the action to perform. the method should
		// offer a parameter so that the caller can set if the list should be processed sequentially
		// or parallel.
		
		processMovies(
				movies,
				movie->movie.getCategory()==Category.ANIMATION,
				movie -> movie.getTitle(), //Stream of Movies to STream of Strings 
				System.out::println, //corresponding LAMBDA title->System.out.println(title)
				true
				);
		
		//OLD WAY
		List<SimpleMovie> simpleMovies2 = new ArrayList<>();
		for (Movie movie: movies) {
			if(movie.getCategory() == Category.COMEDY) {
				simpleMovies.add(new SimpleMovie(movie));
			}
		}
		
	}
	//alles was iterable ist also collections k�nnen streams drauf angewendet werden 
	// with static Methods you must declare the generic type here 
	private static <T> void processMovies(
			List<Movie> movies,
			Predicate<Movie> filter, //can be NULL
			Function<Movie, T> function,
			Consumer<T> action, //Action - Consumer when you to pass teh Element to teh Action Method always use Consumer
			boolean parallel
			) {
		
		Stream<Movie> stream = (parallel ? movies.parallelStream() : movies.stream()); //?yes:no or for no otherwise
		//if Filter is not null then we want to apply Filter to STream 
		if (filter != null) {
			stream = stream.filter(filter);
		}
		
		stream
			.map(function)
			.forEach(action);

	}
	
	
	
	private static Predicate<Movie> movieContainsActorArnoldSchwarzenegger(String firstName,String lastName) {
		//((firstName,lastNAme must be " effectively" final - compiler will check it 
		return movie -> movie.getActors().stream()
				.anyMatch(
						actor->firstName.equalsIgnoreCase(actor.getFirstName()) &&
						lastName.equalsIgnoreCase(actor.getLastName())
						);
	}
}