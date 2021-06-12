package com.company.page;

import com.company.respository.MemoryRespository;
import com.company.respository.ReservationRespository;

import java.util.Scanner;

public class AdminReservationPage implements Page{
    Scanner sc = new Scanner(System.in);
    MemoryRespository memoryRespository = MemoryRespository.getInstance();
    ReservationRespository reservationRespository = ReservationRespository.getInstance();

    private static final Page instance = new AdminReservationPage();
    public static Page getInstance() {
        return instance;
    }
    public AdminReservationPage() {}

    @Override
    public void logic() {
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
                    this.back(instance);
                    break;
                case 2:
                    this.back(instance);
                    break;
                case 3:
                    this.reset();
                    break;
                default:
                    this.exit();
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            this.back(instance);
        }
    }

    @Override
    public void back(Page page) {
        page.logic();
    }

    @Override
    public void reset() {
        Page beginPage = BeginPage.getInstance();
        beginPage.logic();
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
