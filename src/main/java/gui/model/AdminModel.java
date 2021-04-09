package gui.model;

import be.Course;
import be.Student;
import be.Subject;
import be.Teacher;
import bll.IFacadeBLL;
import bll.exception.BLLexception;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminModel {

    IFacadeBLL iFacadeBLL;

    private ObservableList<Teacher> obsTeacher;
    private ObservableList<Student> obsStudent;
    private ObservableList<Subject> obsSubject;
    private ObservableList<Course> obsCourse;


    private AdminModel() {
        obsTeacher = FXCollections.observableArrayList();
        obsStudent= FXCollections.observableArrayList();
        obsSubject = FXCollections.observableArrayList();
        obsCourse = FXCollections.observableArrayList();

    }

    //Teachers----------
    public ObservableList<Teacher> getAllTeachers() {

        return obsTeacher;
    }

    public void loadTeachers() throws BLLexception {
        iFacadeBLL.getAllTeacher();

    }

    public void delete(Teacher selectedTeacher) throws BLLexception{
        iFacadeBLL.deleteTeacher(selectedTeacher);
    }

    public void save(Teacher teacher) throws BLLexception {
        iFacadeBLL.createTeacher(teacher);
    }

    public void updateTeacher(Teacher oldTeacher, Teacher newTeacher) throws BLLexception {
        iFacadeBLL.updateTeacher(oldTeacher,newTeacher);

    }


    //Students---------------------
    public ObservableList<Student> getAllStudents() {

        return obsStudent;
    }

    public void loadStudents() throws BLLexception {
        iFacadeBLL.getAllStudent();
    }

    public void delete(Student selectedStudent) throws BLLexception{
        iFacadeBLL.deleteStudent(selectedStudent);
    }

    public void save(Student student) throws BLLexception {
        iFacadeBLL.createStudent(student);
    }

    public void updateStudent(Student oldStudent, Student newStudent) throws BLLexception {
        iFacadeBLL.updateStudent(oldStudent,newStudent);
    }



    //Subjects---------------
    public ObservableList<Subject> getAllSubjects() {

        return obsSubject;
    }
    public void loadSubjects() throws BLLexception {
        iFacadeBLL.getAllSubject();
    }
    public void delete(Subject selectedSubject) throws BLLexception {
        iFacadeBLL.deleteSubject(selectedSubject);
    }
    public void save(Subject subject) throws BLLexception {
        iFacadeBLL.createSubject(subject);
    }
    public void updateSubject(Subject oldSubject, Subject newSubject) throws BLLexception {
        iFacadeBLL.updateSubject(oldSubject,newSubject);
    }



    //Courses------------
    public ObservableList<Course> getAllCourses() {

        return obsCourse;
    }

    public void loadCourses() throws BLLexception {
        iFacadeBLL.getAllCourse();
    }

    public void delete(Course selectedCourse) throws BLLexception{
        iFacadeBLL.deleteCourse(selectedCourse);

    }

    public void save(Course course) throws BLLexception {
        iFacadeBLL.createCourse(course);
    }

    public void updateCourse(Course oldCourse, Course newCourse) throws BLLexception {
        iFacadeBLL.updateCourse(oldCourse,newCourse);
    }
}
