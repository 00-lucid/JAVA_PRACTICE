package com.company;

import com.company.member.Member;
import com.company.movie.Genre;
import com.company.movie.Movie;
import com.company.respository.MemoryMapRespository;
import com.company.respository.MovieRespository;
import com.company.page.BeginPage;
import com.company.page.Page;
import com.company.respository.ReservationRespository;
import com.company.respository.MemoryRespository;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AppConfig appConfig = new AppConfig();
        BeginPage beginPage = appConfig.beginPage();

        // 영화 더미 데이터
        MovieRespository movieRespository = MovieRespository.getInstance();
        movieRespository.save(new Movie("어벤져스", Genre.Action));
        movieRespository.save(new Movie("인시디어스", Genre.Horror));
        movieRespository.save(new Movie("인셉션", Genre.SF));

        beginPage.logic();
    }
}
