package cr.ac.una.tareaprogramacion3.util;

public class SessionManager {

    private static SessionManager instance;
    private Object currentUser;

    private SessionManager() {
        // constructor privado
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Object getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
        // lógica adicional de cierre de sesión
    }
}
