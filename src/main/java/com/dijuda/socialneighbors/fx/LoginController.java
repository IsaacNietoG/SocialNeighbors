package com.dijuda.socialneighbors.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.dijuda.socialneighbors.api.Packet;
import com.dijuda.socialneighbors.api.PacketFactory;

import javax.swing.JOptionPane;

import com.dijuda.socialneighbors.api.APICommunicator;
import com.dijuda.socialneighbors.api.exceptions.FailedRequestException;
import com.dijuda.socialneighbors.api.exceptions.InvalidCredentialsException;

/**
 *
 */
public class LoginController {

    @FXML
    TextField userField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button loginButton;


    @FXML
    public void initialize(){

    }

    @FXML
    public void onLoginEvent(ActionEvent e){
        String user = userField.getText();
        String password = passwordField.getText();

        Packet logInPacket = new PacketFactory().login(user, password);
        APICommunicator communicator = new APICommunicator(logInPacket);
        if (!communicator.sendPacket()){
            //TODO: Logica por error de conexion
        }
        if (200 != communicator.getResponseCode()){
            //TODO: Logica por credenciales incorrectas
        }
        String token = communicator.get("token");
    }
}
