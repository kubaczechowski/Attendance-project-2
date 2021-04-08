package gui.model;

import be.ChangeRequest;
import be.ScheduleEntity;
import be.Student;
import bll.FacadeBLL;
import bll.SingleDayAbsenceCalculator;
import bll.managers.*;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;

public class TeacherViewModel {

    private final ScheduleEntityManager scheduleEntityManager;
    private final RecordManager recordManager;
    private final ChangeRequestManager changeRequestManager;
    private final TeacherManager teacherManager;
    private ScheduleEntity currentLesson;
    private SingleDayAbsenceCalculator singleDayAbsenceCalculator;

    public TeacherViewModel(){
        scheduleEntityManager = new ScheduleEntityManager();
        recordManager = new RecordManager();
        changeRequestManager = new ChangeRequestManager();
        teacherManager = new TeacherManager();
        singleDayAbsenceCalculator = new SingleDayAbsenceCalculator(currentLesson);
    }

    //returns list of absent students on current lesson
    public List<Student> getAbsentToday() {
        return singleDayAbsenceCalculator.getAbsentToday();
    }

    //returns list of present students on current lesson
    public List<Student> getPresentToday(){
        return singleDayAbsenceCalculator.getPresentToday();
    }

    //returns current lesson
    public ScheduleEntity getCurrentLesson(int courseId) {
        return scheduleEntityManager.getCurrentLesson(courseId);
    }


    //returns list of all students
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>();
    }

    //returns list of change requests
    public ArrayList<ChangeRequest> getAllChanges() {
        return new ArrayList<>();
    }

    //returns number of absent students from current lesson
    public int getNumberOfAbsent(){
        return singleDayAbsenceCalculator.getNumberOfAbsentStudents();

    }

    //returns number of present students from current lesson
    public int getNumberOfPresent(){
        return singleDayAbsenceCalculator.getNumberOfPresentStudents();
    }

}
