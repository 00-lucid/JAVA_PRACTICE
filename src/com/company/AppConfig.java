package com.company;

import com.company.page.*;
import com.company.respository.MemoryRespository;
import com.company.respository.MovieRespository;
import com.company.respository.PageHistoryRespository;
import com.company.respository.ReservationRespository;

import java.util.Scanner;

public class AppConfig {
    Scanner sc = new Scanner(System.in);
    // 잔디 테스트
    public PageHistoryRespository pageHistoryRespository = new PageHistoryRespository();
    public MemoryRespository memoryRespository = new MemoryRespository();
    public MovieRespository movieRespository = new MovieRespository();
    public ReservationRespository reservationRespository = new ReservationRespository();

    public BeginPage beginPage()  { return new BeginPage(sc, memberPage(), adminPage(), pageHistoryRespository); }

    public MemberPage memberPage() {
        return new MemberPage(sc, memberReservationPage(), memoryRespository, pageHistoryRespository);
    }

    public AdminPage adminPage() {
        return new AdminPage(sc, adminReservationPage(),memoryRespository, pageHistoryRespository);
    }

    public MemberReservationPage memberReservationPage() {
        return new MemberReservationPage(sc, reservationRespository, movieRespository, pageHistoryRespository);
    }

    public AdminReservationPage adminReservationPage() {
        return new AdminReservationPage(sc, reservationRespository, movieRespository, pageHistoryRespository);
    }
}
