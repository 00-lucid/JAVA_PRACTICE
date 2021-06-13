package com.company.page;

import com.company.respository.MovieRespository;
import com.company.respository.PageHistoryRespository;
import com.company.respository.ReservationRespository;

import java.util.Scanner;

public class MemberReservationPage implements Page{

    private Scanner sc;
    private MovieRespository movieRespository;
    private ReservationRespository reservationRespository;
    private PageHistoryRespository pageHistoryRespository;

    public MemberReservationPage(Scanner sc, ReservationRespository reservationRespository, MovieRespository movieRespository, PageHistoryRespository pageHistoryRespository) {
        this.sc = sc;
        this.reservationRespository = reservationRespository;
        this.movieRespository = movieRespository;
        this.pageHistoryRespository = pageHistoryRespository;
    }

    @Override
    public void logic() {
        pageHistoryRespository.add(this);
        System.out.println("[ 사용자 영화 콘솔 ]");
        System.out.println("작업을 선택해주세요");
        System.out.println("1.영화 예약 등록 2.영화 예약 취소 3.뒤로가기 4.처음으로 5.영화 예약 확인");
        this.next();
    }

    @Override
    public void next() {
        try {

            switch (Integer.parseInt(sc.next())) {
                case 1:
                    try {
                        System.out.println("관람할 영화 이름을 입력하세요");
                        movieRespository.findAllName();
                        new CreateReservationMoviePage(sc.next(), this).create();
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 영화이름 또는 좌석입니다");
                    }
                    this.logic();
                    break;
                case 2:
                    try {
                        // be stateless
                        System.out.println("예약자 이름을 입력하세요");
                        new GetReservationByNamePage(sc.next(), this).get();
                    } catch (Exception e) {
                        System.out.println("존재하지 않는 예약입니다");
                    }
                    this.logic();
                    break;
                case 3:
                case 4:
                    this.back();
                    break;
                case 5:
                    System.out.println("예약을 등록한 사용자 이름을 입력하세요");
                    if (reservationRespository.findByName(sc.next()).size() == 0) {
                        System.out.println("해당 사용자 이름으로 등록된 예약이 없습니다");
                    }
                    this.logic();
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
        return "영화 예약";
    }
}
