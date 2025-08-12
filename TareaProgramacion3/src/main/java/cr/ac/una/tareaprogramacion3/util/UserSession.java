package cr.ac.una.tareaprogramacion3.util;

import cr.ac.una.tareaprogramacion3.model.Administrador;

public final class UserSession {
    private static UserSession INSTANCE;
    private Administrador admin;

    private UserSession() {}

    public static UserSession get() {
        if (INSTANCE == null) INSTANCE = new UserSession();
        return INSTANCE;
    }

    public Administrador getAdmin() { return admin; }
    public void setAdmin(Administrador admin) { this.admin = admin; }
    public void clear() { this.admin = null; }
}
