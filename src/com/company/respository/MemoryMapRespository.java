package com.company.respository;

import com.company.member.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemoryMapRespository implements Respository{

    public MemoryMapRespository() {}

    public static HashMap<UUID, Member> store = new HashMap<>();

    @Override
    public String save(Member member) {
        try {
            if (this.findByName(member.getName()) != null) {
                System.out.println("중복된 이름입니다");
                return "fail";
            } else {
                store.put(UUID.randomUUID(), member);
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
            for(Map.Entry entry : store.entrySet()) {
                System.out.println("식별번호 " + entry.getKey());
                System.out.println(entry.getValue());
                System.out.println();
            }
            System.out.println();
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @Override
    public Member findByName(String name) {
        try {
            for (Map.Entry entry : store.entrySet()) {
                Member member = store.get(entry.getKey());
                if (member.getName() == name) {
                    return member;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public String remove(int idx) {
        // Map repo의 경우 Idx 자리에 key 값이 들어와야 함
        try {
            store.remove(idx);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
