package com.oop.exam.model;
import java.util.ArrayList;
import java.util.List;
import com.oop.exam.model.Movie;

import java.util.LinkedList;

public class MovieManager {
	private Movie head;
	private Movie tail;

	private LinkedList<Movie> movies;

	public MovieManager() {
		this.movies = new LinkedList<>();
	}

	public LinkedList<Movie> getMovies() {
		return movies;
	}

	public Movie findMovie(String movie) {
		for(Movie m: movies){
			if(movie.equals(m)==true){
				return m;
			}
			else {
				return null;
			}
		}
	}

	public void addMovie(Movie avengersEndGame) {

	}


}
