package com.company.respository;

import com.company.member.Member;
import com.company.reservation.Reservation;

import java.util.ArrayList;
import java.util.Date;

public class ReservationRespository {
    MovieRespository movieRespository = MovieRespository.getInstance();

    private static final ReservationRespository instance = new ReservationRespository();
    public static ReservationRespository getInstance() {
        return instance;
    }
    public ReservationRespository() {}

    public static ArrayList<Reservation> store = new ArrayList();

    public String save(Member member, int seatRow, int seatCol, String movieName) {
        try {
            store.add(new Reservation(member.getName(), new Date(), "" + seatRow + "열 " + seatCol + "행", movieName));
            return "success";
        } catch (Exception e) {
            return "존재하지 않는 이름입니다";
        }
    }

    public String findAll() {
        try {
            if (store.size() == 0) {
                System.out.println("예약이 없습니다");
                return "fail";
            }
            for (Reservation reservation : store) {
                System.out.print(reservation);
            }
            System.out.println();
            return "success";
        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<Reservation> findByName(String name) {
        try {
            ArrayList<Reservation> filterArr = new ArrayList<>();
            int i = 0;
            for (Reservation reservation : store) {
                if (reservation.getName().equals(name)) {
                    System.out.println(""+i+". " + reservation.toString());
                    filterArr.add(reservation);
                }
                i++;
            }
            return filterArr;
        } catch (Exception e) {
            return null;
        }
    }

    public String remove(Reservation reservation) {
        try {
            if (movieRespository.undoSeat(reservation.getMovie(), reservation.getSeat()) == "success") {
                store.remove(store.indexOf(reservation));
                return "success";
            }
            return "fail";
        } catch (Exception e) {
            return null;
        }

    }
}
