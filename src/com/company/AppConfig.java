package com.company;

import com.company.page.*;
import com.company.respository.*;

import java.util.Scanner;

public class AppConfig {
    Scanner sc = new Scanner(System.in);

    public MemoryRespository memoryRespository = new MemoryRespository();
    public MemoryMapRespository memoryMapRespository = new MemoryMapRespository();
    public PageHistoryRespository pageHistoryRespository = new PageHistoryRespository();
    public MovieRespository movieRespository = new MovieRespository();
    public ReservationRespository reservationRespository = new ReservationRespository();

    public BeginPage beginPage()  { return new BeginPage(sc, memberPage(), adminPage(), pageHistoryRespository); }

    public MemberPage memberPage() {
        return new MemberPage(sc, memberReservationPage(), memoryMapRespository, pageHistoryRespository);
    }

    public AdminPage adminPage() {
        return new AdminPage(sc, adminReservationPage(),memoryMapRespository, pageHistoryRespository);
    }

    public MemberReservationPage memberReservationPage() {
        return new MemberReservationPage(sc, reservationRespository, movieRespository, pageHistoryRespository);
    }

    public AdminReservationPage adminReservationPage() {
        return new AdminReservationPage(sc, reservationRespository, movieRespository, pageHistoryRespository);
    }

}
