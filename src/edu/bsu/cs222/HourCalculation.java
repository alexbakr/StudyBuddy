package edu.bsu.cs222;

public class HourCalculation {

    public int hourTotal(Revision rev) {
        int totalHours;
        int sleep = rev.sleep;
        int work = rev.work;
        int food = rev.food;
        int school = rev.school;
        int extra = rev.extra;

        totalHours = sleep + work + food + school + extra;
        return totalHours;
    }
}