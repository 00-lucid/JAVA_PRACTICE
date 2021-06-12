package com.company.respository;

import com.company.movie.Movie;

import java.util.ArrayList;

public class MovieRespository implements Respository{

    private static final MovieRespository instance = new MovieRespository();
    public static MovieRespository getInstance() {
        return instance;
    }
    public MovieRespository() {}

    public static ArrayList<Movie> store = new ArrayList();

    public String save(Movie movie) {
        try {
            store.add(movie);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @Override
    public String findAll() {
        try {
            for (Movie movie : store) {
                System.out.println(movie.toString());
            }
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    public void findAllName() {
        try {
            int i = 0;
            for (Movie movie : store) {
                System.out.println("" + i + ". " + movie.getMovieName() + " (" + movie.getGenre() + ")");
                i++;
            }
        } catch (Exception e) {
            System.out.println("fail");
        }
    }

    public void isSeat(String name, int row, int col) {
        try {
            for (Movie movie : store) {
                if (movie.getMovieName().equals(name)) {
                    if (movie.seatArr[col][row] == 0) {
                        movie.seatArr[col][row] = 1;
                        System.out.println("예약 성공");
                    } else {
                        System.out.println("이미 예약된 좌석입니다");
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public String undoSeat(String name, String seat) {
        try {
            String regx = seat.replaceAll("[^\\d]", "");
            int col = regx.charAt(1) - '0';
            int row = regx.charAt(0) - '0';
            for (Movie movie : store) {
                if (movie.getMovieName().equals(name)) {
                    if (movie.seatArr[col][row] == 1) {
                        movie.seatArr[col][row] = 0;
                        System.out.println("예약 취소 성공");
                        return "success";
                    } else {
                        System.out.println("이미 비어있는 좌석입니다");
                    }
                }
            }
            return "fail";
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Movie findByName(String movieName) {
        try {
            for (Movie movie : store) {
                if (movie.getMovieName().equals(movieName)) {
                    return movie;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public String remove(int idx) {
        try {
            store.remove(idx);
            return "succes";
        } catch (Exception e) {
            return null;
        }
    }
}
