package com.company.page;

import com.company.respository.MemoryRespository;

import java.util.Scanner;

public class AdminPage implements Page{
    MemoryRespository memoryRespository = MemoryRespository.getInstance();
    Scanner sc = new Scanner(System.in);
    Page adminReservationPage = AdminReservationPage.getInstance();

    private static final Page instance = new AdminPage();
    public static Page getInstance() {
        return instance;
    }
    public AdminPage() {}

    @Override
    public String getOptionName() {
        return "관리자 권한";
    }

    @Override
    public void logic() {
        System.out.println("[ 관리자 권한 콘솔 ]");
        System.out.println("작업을 선택해주세요");
        System.out.println("1.전체 사용자 조회 2.사용자 삭제 3.뒤로가기 4.처음으로 5.영화 예약 관리");
        this.next();
    }

    @Override
    public void next() {
        try {
            switch (Integer.parseInt(sc.next())) {
                case 1:
                    memoryRespository.findAll();
                    this.back();
                    break;
                case 2:
                    try {
                        System.out.println("삭제할 사용자의 인덱스를 입력하세요");
                        int i = Integer.parseInt(sc.next());
                        System.out.println(memoryRespository.remove(i));
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다");
                    }
                    this.back();
                    break;

                case 3:
                case 4:
                    this.reset();
                    break;
                case 5:
                    adminReservationPage.logic();
                    break;
                default:
                    this.exit();
            }
        } catch (Exception e) {
            System.out.println("잘못된 선택지입니다");
            this.back();
        }

    }

    @Override
    public void back() {
        this.logic();
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
}
