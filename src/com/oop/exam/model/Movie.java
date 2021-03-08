package com.oop.exam.model;
import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String title;
	private int year;
	private String sipnosis;
	private ArrayList <String> actors;
	private ArrayList <Platform> platforms;
	private ArrayList <Review> reviews;
	private String Director;

	public Movie(String title, int year, String sipnosis){
		platforms=new ArrayList<Platform>();
		reviews=new ArrayList<Review>();
		this.year=year;
		this.title=title;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}
	public String getTitle() {

		return null;
	}
	public int getYear(){

		return year;
	}

	public String getDirector() {

		return Director;
	}

	public List<String> getActors() {
		return actors;
	}

	public List<Platform> getPlatforms() {
		return platforms;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setSynopsis(String sinopsis) {
		sipnosis=sipnosis;
	}

	public void setPlatforms(List<Platform> PlatformList) {
		platforms= (ArrayList<Platform>) PlatformList;
	}

	public void setActors(List<String> actoresList) {
		actors= (ArrayList<String>) actoresList;
	}

}
