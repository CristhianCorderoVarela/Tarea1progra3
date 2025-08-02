package cr.ac.una.tareaprogramacion3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.una.programatres.config.DatabaseConfig;
import com.una.programatres.util.SessionManager;

/**
 * Clase principal de la aplicación Administrador de Proyectos
 * 
 * @author Estudiantes Programación III
 * @version 1.0
 */
public class App extends Application {
    
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static Stage primaryStage;
    
    /**
     * Método de inicio de la aplicación JavaFX
     */
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        
        try {
            // Inicializar configuración de base de datos
            DatabaseConfig.initialize();
            
            // Configurar la ventana principal
            setupPrimaryStage(stage);
            
            // Cargar la pantalla de login
            loadLoginScreen();
            
            logger.info("Aplicación iniciada correctamente");
            
        } catch (Exception e) {
            logger.error("Error al iniciar la aplicación", e);
            throw new RuntimeException("Error crítico al iniciar la aplicación", e);
        }
    }
    
    /**
     * Configura la ventana principal de la aplicación
     */
    private void setupPrimaryStage(Stage stage) {
        stage.setTitle("Administrador de Proyectos - UNA");
        stage.setResizable(true);
        stage.setMaximized(false);
        
        // Configurar icono de la aplicación
        try {
            Image icon = new Image(
                Objects.requireNonNull(
                    getClass().getResourceAsStream("/images/logo.png")
                )
            );
            stage.getIcons().add(icon);
        } catch (Exception e) {
            logger.warn("No se pudo cargar el icono de la aplicación", e);
        }
        
        // Configurar cierre de aplicación
        stage.setOnCloseRequest(event -> {
            handleApplicationClose();
        });
    }
    
    /**
     * Carga la pantalla de login
     */
    private void loadLoginScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            getClass().getResource("/fxml/login.fxml")
        );
        
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        
        // Aplicar CSS
        scene.getStylesheets().add(
            Objects.requireNonNull(
                getClass().getResource("/css/login-style.css")
            ).toExternalForm()
        );
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Centrar la ventana
        primaryStage.centerOnScreen();
    }
    
    /**
     * Maneja el cierre de la aplicación
     */
    private void handleApplicationClose() {
        try {
            // Cerrar sesión si existe
            if (SessionManager.getInstance().getCurrentUser() != null) {
                SessionManager.getInstance().logout();
            }
            
            // Cerrar conexiones de base de datos
            DatabaseConfig.shutdown();
            
            logger.info("Aplicación cerrada correctamente");
            
        } catch (Exception e) {
            logger.error("Error al cerrar la aplicación", e);
        }
    }
    
    /**
     * Cambia la escena actual
     */
    public static void changeScene(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource(fxmlFile)
            );
            
            Scene scene = new Scene(fxmlLoader.load());
            
            // Aplicar CSS principal
            scene.getStylesheets().add(
                Objects.requireNonNull(
                    App.class.getResource("/css/main-style.css")
                ).toExternalForm()
            );
            
            primaryStage.setScene(scene);
            primaryStage.setTitle(title);
            
            // Maximizar si no es login
            if (!fxmlFile.contains("login")) {
                primaryStage.setMaximized(true);
            } else {
                primaryStage.setMaximized(false);
                primaryStage.centerOnScreen();
            }
            
        } catch (IOException e) {
            logger.error("Error al cambiar escena: " + fxmlFile, e);
            throw new RuntimeException("Error al cargar la pantalla", e);
        }
    }
    
    /**
     * Obtiene la ventana principal
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * Método principal para ejecutar la aplicación
     */
    public static void main(String[] args) {
        logger.info("Iniciando aplicación Administrador de Proyectos");
        launch(args);
    }
    
    /**
     * Método de parada de la aplicación
     */
    @Override
    public void stop() throws Exception {
        handleApplicationClose();
        super.stop();
    }
}