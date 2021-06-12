package com.company.movie;

import java.util.Arrays;

public class Movie {
    private String movieName;
    private Genre genre;
    // 좌석은 9*9로 가정
    public int[][] seatArr = new int[9][9];

    public Movie(String movieName, Genre genre) {
        this.movieName = movieName;
        this.genre = genre;
    }

    @Override
    public String toString() {
        for(int i = 0; i < seatArr.length; i++) {
            System.out.println(Arrays.toString(seatArr[i]));
        }
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", genre=" + genre +
                '}';
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int[][] getSeatArr() {
        return seatArr;
    }

    public void setSeatArr(int[][] seatArr) {
        this.seatArr = seatArr;
    }
}
