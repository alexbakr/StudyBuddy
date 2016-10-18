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
                .build();
        int totalHours = calculation.hourTotal(revision);
        Assert.assertEquals(0, totalHours);
    }

    @Test
    public void testFourty() {
        Revision revision = Revision.create()
                .setSleep(20)
                .setWork(20)
                .build();
        int totalHours = calculation.hourTotal(revision);
        Assert.assertEquals(40, totalHours);
    }
}
