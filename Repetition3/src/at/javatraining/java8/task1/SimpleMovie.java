package at.javatraining.java8.task1;

public class SimpleMovie {
	
	private String title;
	private String mainActor;
	
	public SimpleMovie(String title, String mainActor) {
		super();
		this.title = title;
		this.mainActor = mainActor;
	}
	
	public SimpleMovie(Movie movie) {

		this.title = movie.getTitle();
		if (!movie.getActors().isEmpty()) {
			this.mainActor = movie.getActors().get(0).getName(); //returns List with Actors //get0 returns first Actor
		} //otherwise mainActor = null
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}

	@Override
	public String toString() {
		return "SimpleMovie [title=" + title + ", mainActor=" + mainActor + "]";
	}
	
	

}
