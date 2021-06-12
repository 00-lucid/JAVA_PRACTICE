package com.company.page;

import com.company.member.Member;
import com.company.respository.MemoryRespository;

import java.util.Scanner;

public class MemberPage implements Page{
    MemoryRespository memoryRespository = MemoryRespository.getInstance();
    Scanner sc = new Scanner(System.in);

    Page memberReservationPage = MemberReservationPage.getInstance();

    private static final Page instance = new MemberPage();
    public static Page getInstance() {
        return instance;
    }
    public MemberPage() {}


    @Override
    public void logic() {
        System.out.println("[ 사용자 권한 콘솔 ]");
        System.out.println("작업을 선택해주세요");
        System.out.println("1.사용자 가입 2.사용자 정보 수정 3.뒤로가기 4.처음으로 5.영화 예약");
        this.next();
    }

    @Override
    public void next() {
        try {
            switch (Integer.parseInt(sc.next())) {
                case 1:
                    try {
                        Member newMember = new Member();
                        System.out.println("생성할 사용자의 이름을 입력하세요");
                        newMember.setName(sc.next());
                        System.out.println("생성할 사용자의 나이를 입력하세요");
                        newMember.setAge(Integer.parseInt(sc.next()));
                        System.out.println("생성할 사용자의 이메일을 입력하세요");
                        newMember.setEmail(sc.next());
                        System.out.println(memoryRespository.save(newMember));
                    } catch (Exception e) {
                        System.out.println("잘못된 나이입니다");
                    }
                    this.back(instance);
                    break;
                case 2:
                    System.out.println("수정할 사용자의 이름을 입력하세요");
                    new ConfigMemberPage(memoryRespository.findByName(sc.next()), instance).config();
                    break;
                case 3:
                case 4:
                    this.reset();
                    break;
                case 5:
                    memberReservationPage.logic();
                    break;
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
