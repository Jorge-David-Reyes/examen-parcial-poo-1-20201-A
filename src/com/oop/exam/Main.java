package com.oop.exam;

import com.oop.exam.model.Movie;
import com.oop.exam.model.MovieScore;
import com.oop.exam.model.Platform;
import com.oop.exam.model.Review;
import com.oop.exam.model.User;

import com.oop.exam.service.MovieManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final MovieManager movieManager = new MovieManager();

    public static void main(String[] args) {

        User lupita = new User("Guadalupe", "lupita@gmail.com");
        User panchito = new User("Francisco", "panchito@gmail.com");

        prepareMovies();

        Movie harryPotter = movieManager.findMovie("Harry Potter y la piedra filosofal");

        harryPotter.addReview(new Review(panchito, MovieScore.GOOD, "El review de Panchito"));
        harryPotter.addReview(new Review(lupita, MovieScore.EXCELLENT, "El review de Lupita"));

        Movie avengers = movieManager.findMovie("Avengers: Endgame");

        avengers.addReview(new Review(panchito, MovieScore.EXCELLENT, "El review de Panchito para Avengers"));

        Movie piratas = movieManager.findMovie("Piratas del Caribe: la maldición del Perla Negra");

        piratas.addReview(new Review(panchito, MovieScore.EXCELLENT, "El review de Lupita para Piratas del Caribe"));

        LinkedList<Movie> movies = movieManager.getMovies();

        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - " + movie.getYear());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Reparto: " + getCommaSeparatedString(movie.getActors()));
            System.out.println("Plataformas: " + getCommaSeparatedPlatforms(movie.getPlatforms()));
            System.out.println("Reviews:");
            if (movie.getReviews().isEmpty()) {
                System.out.println("  Sin reviews");
            } else {
                for (Review review : movie.getReviews()) {
                   // System.out.println("> Usuario: " + review.getUser().getUsername() + "  -   " + review.getScore());
                    System.out.println(review.getReview());
                }
            }
            System.out.println("============================================================================");
        }

    }

    private static String getCommaSeparatedPlatforms(List<Platform> platforms) {
        boolean commaNeeded = false;
        StringBuilder commaSeparatedString = new StringBuilder();

        for (Platform platform : platforms) {
            if (commaNeeded)
                commaSeparatedString.append(",");
            commaSeparatedString.append(platform.getName());
            commaNeeded = true;

        }

        return commaSeparatedString.toString();
    }

    private static String getCommaSeparatedString(List<String> input) {
        boolean commaNeeded = false;
        StringBuilder commaSeparatedString = new StringBuilder();

        for (String str : input) {
            if (commaNeeded)
                commaSeparatedString.append(",");
            commaSeparatedString.append(str);
            commaNeeded = true;

        }

        return commaSeparatedString.toString();
    }

    private static void prepareMovies() {
        Platform netflix = new Platform("Netflix", "www.neflix.com");
        Platform disneyPlus = new Platform("Disney+", "www.disneyplus.com");
        Platform primeVideo = new Platform("Prime Video", "primevideo.com");

        Movie lordOfTheRings1 = new Movie("El señor de los anillos  - La comunidad del anillo", 2001, "Peter Jackson");

        lordOfTheRings1.setActors(Arrays.asList("Ian McKellen", "Elijah Wood", "Orlando Bloom", "Sean Astin", "Viggo Mortensen"));
        lordOfTheRings1.setPlatforms(Collections.singletonList(netflix));
        lordOfTheRings1.setSynopsis("A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.");

        movieManager.addMovie(lordOfTheRings1);

        Movie harryPotter1 = new Movie("Harry Potter y la piedra filosofal", 2001, "Chris Columbus");

        harryPotter1.setActors(Arrays.asList("Daniel Radcliffe", "Emma Watson", "Rupert Grint", "Richard Harris", "Tom Felton"));
        harryPotter1.setPlatforms(Arrays.asList(netflix, primeVideo));
        harryPotter1.setSynopsis("An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.");

        movieManager.addMovie(harryPotter1);

        Movie piratasDelCaribe = new Movie("Piratas del Caribe: la maldición del Perla Negra", 2003, "Gore Verbinski");

        piratasDelCaribe.setActors(Arrays.asList("Johnny Depp", "Keira Knightley", "Orlando Bloom", "Geoffrey Rush", "Kevin McNally"));
        piratasDelCaribe.setPlatforms(Collections.singletonList(disneyPlus));
        piratasDelCaribe.setSynopsis("Blacksmith Will Turner teams up with eccentric pirate \"Captain\" Jack Sparrow to save his love, the governor's daughter, from Jack's former pirate allies, who are now undead.");

        movieManager.addMovie(piratasDelCaribe);

        Movie avengersEndGame = new Movie("Avengers: Endgame", 2019, "Anthony Russo, Joe Russo");

        avengersEndGame.setActors(Arrays.asList("Chris Evans", "Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "Elizabeth Olsen"));
        avengersEndGame.setPlatforms(Collections.singletonList(disneyPlus));
        avengersEndGame.setSynopsis("After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");

        movieManager.addMovie(avengersEndGame);

    }
}
