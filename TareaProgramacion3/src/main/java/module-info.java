module cr.ac.una.administradorproyectos {
    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // JPA y Hibernate
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires jakarta.validation;
    requires org.hibernate.validator;

    // Base de datos y conexión
    requires java.sql;
    requires com.zaxxer.hikari;

    // Apache POI para Excel
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    // Email
    requires jakarta.mail;

    // Web Services
    requires jakarta.xml.ws;

    // JSON
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    // Logging
    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires ch.qos.logback.core;

    // Java base
    requires java.base;
    requires java.desktop;
    requires java.prefs;

    // Exportar paquetes
    exports cr.ac.una.tareaprogramacion3;
    exports cr.ac.una.tareaprogramacion3.controller;
    exports cr.ac.una.tareaprogramacion3.model;
    exports cr.ac.una.tareaprogramacion3.service;
    exports cr.ac.una.tareaprogramacion3.util;
    exports cr.ac.una.tareaprogramacion3.enums;

    // Abrir paquetes para reflexión
    opens cr.ac.una.tareaprogramacion3 to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.controller to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.model to org.hibernate.orm.core, jakarta.persistence;
  

    // Acceso a recursos
    opens cr.ac.una.tareaprogramacion3.views to javafx.fxml;
   
}
