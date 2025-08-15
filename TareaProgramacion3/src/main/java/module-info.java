module cr.ac.una.administradorproyectos {
    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;

    // SOAP / JAXB
    requires jakarta.xml.ws;
    requires jakarta.xml.bind;
    requires java.xml;

    // Necesario porque compilas clases con @Entity, EntityManager, etc.
    requires jakarta.persistence;
    requires java.logging;

    // Exports
    exports cr.ac.una.tareaprogramacion3;
    exports cr.ac.una.tareaprogramacion3.controller;
    exports cr.ac.una.tareaprogramacion3.model;
    exports cr.ac.una.tareaprogramacion3.service;
    exports cr.ac.una.tareaprogramacion3.util;
    exports cr.ac.una.tareaprogramacion3.enums;

    // FXML
    opens cr.ac.una.tareaprogramacion3 to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.controller to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.views to javafx.fxml;

    // *** Importante para las clases generadas por wsimport ***
    opens cr.ac.una.client.soap;

    // (Opcional) si en algún momento usas JPA en este cliente:
    opens cr.ac.una.tareaprogramacion3.model to jakarta.persistence;
}
