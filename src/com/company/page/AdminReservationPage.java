package com.company.page;

import com.company.respository.MovieRespository;
import com.company.respository.PageHistoryRespository;
import com.company.respository.ReservationRespository;

import java.util.Scanner;

public class AdminReservationPage implements Page{

    private Scanner sc;
    private MovieRespository movieRespository;
    private ReservationRespository reservationRespository;
    private PageHistoryRespository pageHistoryRespository;

    public AdminReservationPage(Scanner sc, ReservationRespository reservationRespository, MovieRespository movieRespository, PageHistoryRespository pageHistoryRespository) {
        this.sc = sc;
        this.reservationRespository = reservationRespository;
        this.movieRespository = movieRespository;
        this.pageHistoryRespository = pageHistoryRespository;
    }

    @Override
    public void logic() {
        pageHistoryRespository.add(this);
        System.out.println("[ 관리자 예약 콘솔 ]");
        System.out.println("작업을 선택하세요");
        System.out.println("1.영화 예약 전체 조회 2.뒤로가기 3.처음으로");
        this.next();
    }

    @Override
    public void next() {
        try {

            switch (Integer.parseInt(sc.next())) {
                case 1:
                    reservationRespository.findAll();
                    this.logic();
                    break;
                case 2:
                    this.back();
                    break;
                case 3:
                    this.reset();
                    break;
                default:
                    this.exit();
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            this.logic();
        }
    }

    @Override
    public void back() {
        pageHistoryRespository.get().logic();
    }
    @Override
    public void reset() {
//        Page beginPage = BeginPage.getInstance();
//        beginPage.logic();
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public String getOptionName() {
        return "영화 예약 관리";
    }
}
