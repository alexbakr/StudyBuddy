package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class test {
    HourCalculation calculation = new HourCalculation();
    StudyCalculation study = new StudyCalculation();

    @Test
    public void testHourCalculationAndStudyCalculation() {
        Revision rev = Revision.create()
                .setSleep(148)
                .setWork(0)
                .setFood(0)
                .setSchool(0)
                .setExtra(0)
                .build();
        int totalHours = calculation.hourTotal(rev);
        Assert.assertEquals(20, study.StudyCalculation(totalHours));
    }
}
