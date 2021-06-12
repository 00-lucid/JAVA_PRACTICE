package com.company.reservation;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    // 예약번호
    private UUID uuid = UUID.randomUUID();
    // 예몌자
    private String name;
    // 시간
    private Date date;
    // 좌석
    private String seat;
    // 영화
    private String movie;

    public Reservation(String name, Date date, String seat, String movie) {
        this.name = name;
        this.date = date;
        this.seat = seat;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", seat='" + seat + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }
}
