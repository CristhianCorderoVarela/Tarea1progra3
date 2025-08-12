package cr.ac.una.tareaprogramacion3.controller;

import cr.ac.una.tareaprogramacion3.service.AdministradorService;
import cr.ac.una.tareaprogramacion3.util.Controller;
import cr.ac.una.tareaprogramacion3.util.FlowController;
import cr.ac.una.tareaprogramacion3.util.UserSession;
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
private final AdministradorService adminService = new AdministradorService();
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
        String contrasenna = txtContraseña.getText().trim();

        lblErrorLogin.setText("");

        try {
            var opt = adminService.login(usuario, contrasenna);
            if (opt.isPresent()) {
                // Guardamos el admin en sesión
                UserSession.get().setAdmin(opt.get());
FlowController.getInstance().goMain();   // abre la principal en mainStage
Stage loginStage = (Stage) btnInicioSesion.getScene().getWindow();
loginStage.close();                      // cierra la del login

            } else {
                lblErrorLogin.setText("Usuario o contraseña incorrectos, o usuario INACTIVO.");
            }
        } catch (Exception ex) {
            lblErrorLogin.setText("Error al validar credenciales. Revise la conexión a la base de datos.");
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
