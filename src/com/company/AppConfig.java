package com.company;

import com.company.page.*;
import com.company.respository.MemoryRespository;

import java.util.Scanner;

public class AppConfig {
    // 설정영역을 보고 app의 flow를 생각할 수 있어야 됨 == 구성요소가 한눈에 보여야됨
    Scanner sc = new Scanner(System.in);

    public BeginPage beginPage()  { return new BeginPage(sc, memberPage(), adminPage()); }

    public MemberPage memberPage() {
        return new MemberPage(sc, memberReservationPage(), memoryRespository());
    }

    public AdminPage adminPage() {
        return new AdminPage();
    }

    public MemoryRespository memoryRespository() {
        return new MemoryRespository();
    }

    public MemberReservationPage memberReservationPage() {
        return new MemberReservationPage();
    }
}
