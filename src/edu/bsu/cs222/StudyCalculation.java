package edu.bsu.cs222;

public class StudyCalculation {
    private int hoursAWeek = 168;

    public int StudyCalculation(int extracurricular) {
        int studyHours = hoursAWeek - extracurricular;
        return studyHours;
    }
}
