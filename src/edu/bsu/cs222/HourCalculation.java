package edu.bsu.cs222;

public class HourCalculation {

    public int hourTotal(Revision rev) {
        int totalHours = 0;
        int sleep = rev.sleep;
        int work = rev.work;

        totalHours = sleep + work;
        return totalHours;
    }
}