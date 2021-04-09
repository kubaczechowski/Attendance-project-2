package gui.controller;

import be.Course;
import be.Student;
import be.Subject;
import be.Teacher;
import bll.exception.BLLexception;
import com.jfoenix.controls.JFXTextField;
import dal.dataAccessObjects.CourseDAO;
import gui.model.AdminModel;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.awt.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminViewController implements Initializable {


    private CourseDAO courseDAO;
    private AdminModel adminModel;

    //TeachersTableView
    @FXML private TableView<Teacher> teacherTable;
    @FXML private TableColumn<Teacher, Integer> columnTeachersID;
    @FXML private TableColumn<Teacher, String> columnName;
    @FXML private TableColumn<Teacher, String> columnEmail;
    @FXML private TableColumn<Teacher, String> columnDepartment;
    @FXML private TableColumn<Teacher, ImageView> photopath;


    @FXML private JFXTextField nameFieldTeacher;
    @FXML private JFXTextField emailFieldTeacher;
    @FXML private JFXTextField departmenFieldTeacher;
    @FXML private JFXTextField photopathFieldTeacher;

    //StudentsTableView
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, Integer> columnStudentID;
    @FXML private TableColumn<Student, String> columnStudentName;
    @FXML private TableColumn<Student, String> columnStudentEmail;
    @FXML private TableColumn<Student, Integer> columnCourseID;
    @FXML private TableColumn<Student, Integer> columnSemester;
    @FXML private TableColumn<Student, ImageView> Studentphotopath;


    @FXML private JFXTextField nameFieldStudent;
    @FXML private JFXTextField EmailFieldStudent;
    @FXML private JFXTextField coursIDFieldStudent;
    @FXML private JFXTextField semesterFieldStudent;
    @FXML private JFXTextField photoPathFieldStudent;


    //SubjectsTableView
    @FXML private TableView<Subject> subjectTable;
    @FXML private TableColumn<Subject, Integer> columnSubjectID;
    @FXML private TableColumn<Subject, String> columnSubjectName;
    @FXML private TableColumn<Subject, Integer> columnTeacherID;
    @FXML private TableColumn<Subject, Integer> SubjectColumnCourseID;

    @FXML private JFXTextField nameFieldSubject;
    @FXML private JFXTextField teacherIDFieldSubject;
    @FXML private JFXTextField courseIDFieldSubject;



    //CoursesTableView
    @FXML private TableView<Course> courseTableView;
    @FXML private TableColumn<Course, Integer> columnID;
    @FXML private TableColumn<Course, String> columnCourseName;

    @FXML private JFXTextField nameFieldCourse;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initTeacherTableView();
        } catch (BLLexception blLexception) {
            blLexception.printStackTrace();
        }
        try {
            initStudentTableView();
        } catch (BLLexception blLexception) {
            blLexception.printStackTrace();
        }
        try {
            initSubjectTableView();
        } catch (BLLexception blLexception) {
            blLexception.printStackTrace();
        }
        try {
            initCourseTableView();
        } catch (BLLexception blLexception) {
            blLexception.printStackTrace();
        }
    }

    private void initTeacherTableView() throws BLLexception {
        columnTeachersID.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("ID"));
        columnName.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Email"));
        columnDepartment.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Department"));
        photopath.setCellValueFactory(new PropertyValueFactory<Teacher, ImageView>("PhotoPath"));


        adminModel.loadTeachers();
        teacherTable.setItems(adminModel.getAllTeachers());
    }

    private void initStudentTableView() throws BLLexception {
        columnStudentID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("ID"));
        columnStudentName.setCellValueFactory(new PropertyValueFactory<Student, String>("Name"));
        columnStudentEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));
        columnCourseID.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Course ID"));
        columnSemester.setCellValueFactory(new PropertyValueFactory<Student, Integer>("Semester"));
        Studentphotopath.setCellValueFactory(new PropertyValueFactory<Student,ImageView>("PhotoPath"));


        adminModel.loadStudents();
        studentTable.setItems(adminModel.getAllStudents());
    }

    private void initSubjectTableView() throws BLLexception {
        columnSubjectID.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("ID"));
        columnSubjectName.setCellValueFactory(new PropertyValueFactory<Subject,String>("Name"));
        columnTeacherID.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("Teacher ID"));
        SubjectColumnCourseID.setCellValueFactory(new PropertyValueFactory<Subject,Integer>("Course ID"));

        adminModel.loadSubjects();
        subjectTable.setItems(adminModel.getAllSubjects());

    }


    private void initCourseTableView() throws BLLexception {
        columnID.setCellValueFactory(new PropertyValueFactory<Course,Integer>("ID"));
        columnCourseName.setCellValueFactory(new PropertyValueFactory<Course,String>("Name"));

        adminModel.loadCourses();
        courseTableView.setItems(adminModel.getAllCourses());


    }
    //TeacherBtn-----
    public void btnTeacherAdd(ActionEvent event) throws BLLexception {
        Teacher newTeacher = new Teacher(-1,
                                      nameFieldTeacher.getText(),
                                      emailFieldTeacher.getText(),
                                      departmenFieldTeacher.getText(),
                                      photopathFieldTeacher.getText());


        adminModel.save(newTeacher);
    }


    public void btnTeacherDelete(ActionEvent event) throws BLLexception {
        Teacher selectedTeacher = teacherTable.getSelectionModel().getSelectedItem();
        adminModel.delete(selectedTeacher);
        adminModel.loadTeachers();
    }
    public void btnTeacherEdit(ActionEvent event) throws BLLexception {
        Teacher newTeacher = teacherTable.getSelectionModel().getSelectedItem();
        newTeacher.setName(nameFieldTeacher.getText());
        newTeacher.setEmail(emailFieldTeacher.getText());
        newTeacher.setDepartment(departmenFieldTeacher.getText());
        newTeacher.setPhotoPath(photopathFieldTeacher.getText());
        adminModel.updateTeacher(teacherTable.getSelectionModel().getSelectedItem(),newTeacher);
    }

    //StudentBtn-----
    public void btnStudentAdd(ActionEvent event) throws BLLexception {

        Student newStudent = new Student(-1,
                nameFieldStudent.getText(),
                EmailFieldStudent.getText(),
                photoPathFieldStudent.getText(),
                Integer.parseInt(coursIDFieldStudent.getText()),
                Integer.parseInt(semesterFieldStudent.getText()));


        adminModel.save(newStudent);
    }

    public void btnStudentDelete(ActionEvent event) throws BLLexception {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        adminModel.delete(selectedStudent);
        adminModel.loadStudents();
    }

    public void btnStudentEdit(ActionEvent event) throws BLLexception {
        Student newStudent = studentTable.getSelectionModel().getSelectedItem();
        newStudent.setName(nameFieldTeacher.getText());
        newStudent.setEmail(emailFieldTeacher.getText());
        newStudent.setPhotoPath(photoPathFieldStudent.getText());
        newStudent.setCourseID(Integer.parseInt(coursIDFieldStudent.getText()));
        newStudent.setSemester(Integer.parseInt(semesterFieldStudent.getText()));
        adminModel.updateStudent(studentTable.getSelectionModel().getSelectedItem(),newStudent);
    }

    //SubjectBtn---------
    public void btnSubjectAdd(ActionEvent event) throws BLLexception {
        Subject newSubject = new Subject(-1,
                                         nameFieldSubject.getText(),
                                         Integer.parseInt(teacherIDFieldSubject.getText()),
                                          Integer.parseInt(courseIDFieldSubject.getText()));

        adminModel.save(newSubject);
    }

    public void btnSubjectDelete(ActionEvent event) throws BLLexception {
        Subject selectedSubject = subjectTable.getSelectionModel().getSelectedItem();
        adminModel.delete(selectedSubject);
        adminModel.loadStudents();
    }

    public void btnSubjectEdit(ActionEvent event) throws BLLexception {
        Subject newSubject = subjectTable.getSelectionModel().getSelectedItem();
        newSubject.setName(nameFieldSubject.getText());
        newSubject.setTeacherId(Integer.parseInt(teacherIDFieldSubject.getText()));
        newSubject.setCourseId(Integer.parseInt(courseIDFieldSubject.getText()));
        adminModel.updateSubject(subjectTable.getSelectionModel().getSelectedItem(),newSubject);
    }


    //CourseBtn---------
    public void btnCourseAdd(ActionEvent event) throws BLLexception {
        Course newCourse = new Course(-1,
                                      nameFieldCourse.getText());
        adminModel.save(newCourse);

    }

    public void btnCourseDelete(ActionEvent event) throws BLLexception {
        Course selectedCourse = courseTableView.getSelectionModel().getSelectedItem();
        adminModel.delete(selectedCourse);
        adminModel.loadCourses();
    }

    public void btnCourseEdit(ActionEvent event) throws BLLexception {
        Course newCourse = courseTableView.getSelectionModel().getSelectedItem();
        newCourse.setName(nameFieldCourse.getText());

        adminModel.updateCourse(courseTableView.getSelectionModel().getSelectedItem(),newCourse);
    }




    public void readTeacher(MouseEvent mouseEvent) {
        nameFieldTeacher.setText(teacherTable.getSelectionModel().getSelectedItem().getName());
        emailFieldTeacher.setText(teacherTable.getSelectionModel().getSelectedItem().getEmail());
        departmenFieldTeacher.setText(teacherTable.getSelectionModel().getSelectedItem().getDepartment());
        photopathFieldTeacher.setText(teacherTable.getSelectionModel().getSelectedItem().getPhotoPath());
    }

    public void readStudent(MouseEvent mouseEvent) {
        nameFieldStudent.setText(studentTable.getSelectionModel().getSelectedItem().getName());
        EmailFieldStudent.setText(studentTable.getSelectionModel().getSelectedItem().getEmail());
        photoPathFieldStudent.setText(studentTable.getSelectionModel().getSelectedItem().getPhotoPath());
        coursIDFieldStudent.setText(String.valueOf(studentTable.getSelectionModel().getSelectedItem().getCourseID()));
        semesterFieldStudent.setText(String.valueOf(studentTable.getSelectionModel().getSelectedItem().getSemester()));

    }

    public void readSubject(MouseEvent mouseEvent) {
        nameFieldSubject.setText(subjectTable.getSelectionModel().getSelectedItem().getName());
        teacherIDFieldSubject.setText(String.valueOf(subjectTable.getSelectionModel().getSelectedItem().getTeacherId()));
        coursIDFieldStudent.setText(String.valueOf(subjectTable.getSelectionModel().getSelectedItem().getCourseId()));
    }

    public void readCourse(MouseEvent mouseEvent) {
        nameFieldCourse.setText(courseTableView.getSelectionModel().getSelectedItem().getName());
    }


    public void btnLogout(ActionEvent event) {
        System.exit(0);
    }
}
