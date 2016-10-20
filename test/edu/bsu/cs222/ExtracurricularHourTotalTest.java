package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class ExtracurricularHourTotalTest {
    HourCalculation calculation = new HourCalculation();

    @Test
    public void testZero() {
        Revision revision = Revision.create()
                .setSleep(0)
                .setWork(0)
                .setFood(0)
                .setSchool(0)
                .setExtra(0)
                .build();
        int totalHours = calculation.hourTotal(revision);
        Assert.assertEquals(0, totalHours);
    }

    @Test
    public void testFourty() {
        Revision revision = Revision.create()
                .setSleep(8)
                .setWork(8)
                .setFood(8)
                .setSchool(8)
                .setExtra(8)
                .build();
        int totalHours = calculation.hourTotal(revision);
        Assert.assertEquals(40, totalHours);
    }
}
