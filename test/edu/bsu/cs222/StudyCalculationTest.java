package edu.bsu.cs222;

import org.junit.Test;
import org.testng.Assert;

public class StudyCalculationTest {

    StudyCalculation calculation = new StudyCalculation();
    ExtracurricularHourTotal extra = new ExtracurricularHourTotal();

    @Test
    public void testTwentyFourSeven() {
        Revision revision = Revision.create()
                .setSleep(0)
                .build();
        Assert.assertEquals(168, calculation.StudyCalculation(extra.extracurricularTotal(revision)));
    }

    @Test
    public void testSixHours() {
        Revision revision = Revision.create()
                .setSleep(6)
                .build();
        Assert.assertEquals(6, calculation.StudyCalculation(extra.extracurricularTotal(revision)));
    }

    @Test
    public void testZero() {
        Revision revision = Revision.create()
                .setSleep(168)
                .build();
        Assert.assertEquals(0, calculation.StudyCalculation(extra.extracurricularTotal(revision)));
    }
}
