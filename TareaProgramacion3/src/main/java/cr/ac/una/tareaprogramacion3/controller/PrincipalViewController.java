package cr.ac.una.tareaprogramacion3.controller;

import cr.ac.una.tareaprogramacion3.util.Controller;
import cr.ac.una.tareaprogramacion3.util.FlowController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrincipalViewController extends Controller {

    // ==== SOLO ADMIN (ids exactamente como en el FXML) ====
    @FXML private VBox VBoxMenuAdmin;

    @FXML private Button BtnHome;
    @FXML private Button BtnEditarPiso;
    @FXML private Button btnEditarUsuario;
    @FXML private Button btnRegisterAdminAccount;
    @FXML private Button btnGestionReservas;
    @FXML private Button btnStatistics;
    @FXML private Button btnMiniJuego;    // existe en tu FXML (visible="false")
    @FXML private Button btnSalir;

    @Override
    public void initialize() {
        // Solo vista admin
        if (VBoxMenuAdmin != null) {
            VBoxMenuAdmin.setVisible(true);
            VBoxMenuAdmin.setManaged(true);
        }

        // Carga vista de inicio por defecto
        Platform.runLater(() -> {
            FlowController.getInstance().limpiarLoader("WelcomeView");
            FlowController.getInstance().goView("WelcomeView");
        });
    }

    // ==== Handlers ====
    @FXML private void onActionBtnHome(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("WelcomeView");
        FlowController.getInstance().goView("WelcomeView");
    }

    @FXML private void onActionBtnEditarPiso(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("EditFloorAdmin");
        FlowController.getInstance().goView("EditFloorAdmin");
    }

    @FXML private void onActionBtnEditarUsuario(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("EditDeleteUser");
        FlowController.getInstance().goView("EditDeleteUser");
    }

    @FXML private void onRegisterAdminAccount(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("RegisterNewAdmin");
        FlowController.getInstance().goView("RegisterNewAdmin");
    }

    @FXML private void onGestionReservas(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("ReservationManagement");
        FlowController.getInstance().goView("ReservationManagement");
    }

    @FXML private void onStatistics(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("Reports");
        FlowController.getInstance().goView("Reports");
    }

    @FXML private void onActionMiniJuego(ActionEvent e) {
        FlowController.getInstance().limpiarLoader("MiniGame");
        Stage owner = (Stage) btnMiniJuego.getScene().getWindow();
        FlowController.getInstance().goViewInWindowModal("MiniGame", owner, false);
    }

    @FXML private void onActionBtnSalir(ActionEvent e) {
        Stage ventanaActual = (Stage) btnSalir.getScene().getWindow();
        ventanaActual.close();
        FlowController.getInstance().limpiarLoader("Primary");
        FlowController.getInstance().goViewInWindow("Primary");
    }
}
