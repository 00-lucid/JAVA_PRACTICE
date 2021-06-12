package com.company.page;

import com.company.respository.MemoryRespository;
import com.company.respository.MovieRespository;
import com.company.respository.ReservationRespository;

import java.util.Scanner;

public class CreateReservationMoviePage implements Page{
    Scanner sc = new Scanner(System.in);
    MovieRespository movieRespository = MovieRespository.getInstance();
    ReservationRespository reservationRespository = ReservationRespository.getInstance();
    MemoryRespository memoryRespository = MemoryRespository.getInstance();

    private String selectMovieName;
    private Page prePage;

    public CreateReservationMoviePage(String selectMovieName, Page prePage) {
        this.selectMovieName = selectMovieName;
        this.prePage = prePage;
    }

    public void create() {
        try {
            System.out.println(movieRespository.findByName(selectMovieName).toString());
            System.out.println("관람할 영화 좌석열을 입력하세요");
            int selectRow = Integer.parseInt(sc.next());
            System.out.println("관람할 영화 좌석행을 입력하세요");
            int selectCol = Integer.parseInt(sc.next());

            System.out.println("예약할 사용자 이름을 입력하세요");
            if (reservationRespository.save(memoryRespository.findByName(sc.next()), selectCol, selectRow, selectMovieName) == "success") {
                // 실제 영화 repo에 좌석 반영
                movieRespository.isSeat(selectMovieName, selectRow, selectCol);
            } else {
                System.out.println("존재하지 않는 이름입니다");
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        this.back();

    }

    @Override
    public void logic() {

    }

    @Override
    public void next() {

    }

    @Override
    public void back() {
        this.logic();
    }
    @Override
    public void reset() {

    }

    @Override
    public void exit() {

    }

    @Override
    public String getOptionName() {
        return null;
    }
}
