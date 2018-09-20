package at.javatraining.java8.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie {
	private String title;
	private int duration;
	private Category category;
	private Region region;
	List<Actor> actors = new ArrayList<>();
	
	public Movie(String title, int duration, Category category, Region region, Actor... actors) {
		this.title = title;
		this.duration = duration;
		this.category = category;
		this.region = region;
		Collections.addAll(this.actors, actors);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Actor> getActors() {
		return actors;
	}
	

	@Override
	public String toString() {
		return "Movie [title=" + title + ", duration=" + duration + ", category=" + category + ", region=" + region
				+ ", actors=" + actors + "]";
	}
}