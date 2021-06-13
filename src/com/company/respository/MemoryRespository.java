package com.company.respository;

import com.company.member.Member;

import java.util.ArrayList;

public class MemoryRespository implements Respository{
    private static final MemoryRespository instance = new MemoryRespository();
    public static MemoryRespository getInstance() {
        return instance;
    }
    public MemoryRespository() {}

    public static ArrayList<Member> store = new ArrayList();

    public String save(Member member) {
        try {
            if (this.findByName(member.getName()) != null) {
                System.out.println("중복된 이름입니다");
                return "fail";
            } else {
                store.add(member);
                return "success";
            }
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    public String findAll() {
        System.out.println();
        try {
            for(Member member : store) {
                System.out.print("이름: " + member.getName() + " 나이: " + member.getAge() + " 이메일 " + member.getEmail() + "\n");
            }
            System.out.println();
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    public Member findByName(String name) {
        try {
            for (Member member : store) {
                if (member.getName().equals(name)) {
                    return member;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public String remove(int idx) {
        try {
            store.remove(idx);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
