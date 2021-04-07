package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Date;

/**
 * @author Kuba
 * @date 4/1/2021 1:57 PM
 */
public class RequestController {
    private Date dateL;
    private String subjectL;
    private Date startTL;
    private Date endTL;

    @FXML
    private Label date;
    @FXML
    private  Label subject;
    @FXML
    private  Label startTime;
    @FXML
    private  Label EndTime;

    public void setInfo(Date dateL) {
       date.setText(dateL.toString());
    }

    public void requestChange(ActionEvent actionEvent) {
    }
}
