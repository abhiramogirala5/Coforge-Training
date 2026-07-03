package com.coforge.day3;

public class MovieApp {

	public static void main(String[] args) {
		Movie movie = new Movie();

        movie.setMovieName("RRR");
        movie.setDirector("S. S. Rajamouli");
        movie.setRating(9.2);

        System.out.println(movie);

	}

}
