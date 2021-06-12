package com.company.page;

import com.company.reservation.Reservation;
import com.company.respository.ReservationRespository;

import java.util.ArrayList;
import java.util.Scanner;

public class GetReservationByNamePage implements Page {
    Scanner sc = new Scanner(System.in);
    ReservationRespository reservationRespository = ReservationRespository.getInstance();

    private String reservationName;
    private Page prePage;

    public GetReservationByNamePage(String reservationName, Page prePage) {
        this.reservationName = reservationName;
        this.prePage = prePage;
    }

    public void get() {
        try {
            ArrayList<Reservation> reservationArrayList = reservationRespository.findByName(this.reservationName);
            if (reservationArrayList.size() == 0) {
                System.out.println("해당 사용자 이름으로 등록한 예약이 없습니다");
                this.back(prePage);
            }
            System.out.println("삭제할 예약 인덱스를 입력하세요");
            System.out.println(reservationRespository.remove(reservationArrayList.get(sc.nextInt())));
            this.back(prePage);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Override
    public void logic() {

    }

    @Override
    public void next() {

    }

    @Override
    public void back(Page page) {
        page.logic();
    }

    @Override
    public void reset() {

    }

    @Override
    public void exit() {

    }
}
