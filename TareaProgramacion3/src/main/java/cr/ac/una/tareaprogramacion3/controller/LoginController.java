package cr.ac.una.tareaprogramacion3.controller;

import cr.ac.una.tareaprogramacion3.util.Controller;
import cr.ac.una.tareaprogramacion3.util.FlowController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController extends Controller {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private Label lblErrorLogin;

    @FXML
    private Button btnInicioSesion;

    @FXML
    private Button BtnRegistrarUsuario;

    @FXML
    private Button btnAcercaDe;

    private Stage stage;

    @Override
    public void initialize() {
        // Listener para habilitar el botón solo si ambos campos tienen texto
        txtUsuario.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        txtContraseña.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());

        lblErrorLogin.setText("");
    }

    private void validarCampos() {
        boolean habilitar = !txtUsuario.getText().isBlank() && !txtContraseña.getText().isBlank();
        btnInicioSesion.setDisable(!habilitar);
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Stage getStage() {
        return this.stage;
    }

    @Override
    public void setAccion(String accion) {
        // No se requiere por ahora
    }

    @FXML
    public void onActionBtnInicioSesion(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String contraseña = txtContraseña.getText().trim();

        // Aquí puedes validar contra una base de datos o usuario fijo por ahora
        if (usuario.equals("admin") && contraseña.equals("1234")) {
            lblErrorLogin.setText("");
            FlowController.getInstance().goMain();  // Cambia a vista principal
        } else {
            lblErrorLogin.setText("Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    public void onActionBtnRegistrarUsuario(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("RegisterNewAccount");
    }

    @FXML
    public void onActionBtnAcercaDe(ActionEvent event) {
        FlowController.getInstance().goViewInWindow("About");
    }
}
