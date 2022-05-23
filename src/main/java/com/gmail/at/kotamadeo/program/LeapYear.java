package com.gmail.at.kotamadeo.program;

public class LeapYear {
    private int year, days;
    private int score = 0;

    public int getDays() {
        return days;
    }

    public int getYear() {
        return year;
    }

    public int getScore() {
        return score;
    }

    public void yearAndDaysCorrect(int year, int days) {
        if (year % 400 == 0) {
            this.year = year;
            this.days = 366;
        } else if (year % 100 == 0) {
            this.year = year;
            this.days = 365;
        } else if (year % 4 == 0) {
            this.year = year;
            this.days = 366;
        } else {
            this.year = year;
            this.days = 365;
        }
        if (days == this.days) {
            score++;
        }
    }
}
