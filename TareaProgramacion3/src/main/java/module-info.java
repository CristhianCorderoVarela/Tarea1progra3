module cr.ac.una.administradorproyectos {
    // JavaFX que sí usas
    requires javafx.controls;
    requires javafx.fxml;

    // JPA (Jakarta) + EclipseLink + JDBC
    requires jakarta.persistence;
    requires org.eclipse.persistence.jpa;
    requires org.eclipse.persistence.core;
    requires java.sql;
   

    // Exports (si realmente los necesitas públicos)
    exports cr.ac.una.tareaprogramacion3;
    exports cr.ac.una.tareaprogramacion3.controller;
    exports cr.ac.una.tareaprogramacion3.model;
    exports cr.ac.una.tareaprogramacion3.service;
    exports cr.ac.una.tareaprogramacion3.util;
    exports cr.ac.una.tareaprogramacion3.enums;

    // Abre paquetes para FXML (controladores) y JPA (entidades)
    opens cr.ac.una.tareaprogramacion3 to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.controller to javafx.fxml;

    // MUY IMPORTANTE: abrir las entidades para la reflexión de JPA/EclipseLink
    opens cr.ac.una.tareaprogramacion3.model
        to org.eclipse.persistence.core, org.eclipse.persistence.jpa, jakarta.persistence;

    // Si cargas FXML desde /views, déjalo abierto a FXML
    opens cr.ac.una.tareaprogramacion3.views to javafx.fxml;
}
