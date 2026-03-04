package org.example;

public class LehmanGradeBook {
    public boolean isPassing(int grade) {
        if (grade > 100 || grade < 0) {
            throw new IllegalArgumentException("Score Error");
        }

        return grade >= 70;
    }

    char getLetterGrade(int score) {

        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else
            return 'F';

    }
}
