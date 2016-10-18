package edu.bsu.cs222;

public class StudyCalculation {
    private int hoursAWeek = 168;

    public int StudyCalculation(int extracurricular) {
        int studyHours = hoursAWeek - extracurricular;
        if (studyHours <= 0) {
            return 0;
        } else {
            return studyHours;
        }
    }
}
