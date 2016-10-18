package edu.bsu.cs222;

import org.junit.Test;
import org.testng.Assert;

public class StudyCalculationTest {

    StudyCalculation study = new StudyCalculation();

    @Test
    public void testTwentyFourSeven() { Assert.assertEquals(168, study.StudyCalculation(0)); }

    @Test
    public void testSixHours() {
        Assert.assertEquals(6, study.StudyCalculation(162));
    }

    @Test
    public void testZero() {
        Assert.assertEquals(0, study.StudyCalculation(168));
    }

    @Test
    public void testBelowZero() { Assert.assertEquals(0, study.StudyCalculation(169)); }
}
