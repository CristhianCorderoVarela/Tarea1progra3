module cr.ac.una.tareaprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens cr.ac.una.tareaprogramacion3 to javafx.fxml;
    exports cr.ac.una.tareaprogramacion3;
}



module cr.ac.una.tareaprogramacion3 {
    
    // Módulos de JavaFX requeridos
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    
    // Módulos de JPA y Hibernate
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires jakarta.validation;
    requires org.hibernate.validator;
    
    // Módulos de base de datos
    requires java.sql;
    requires com.zaxxer.hikari;
    
    // Módulos de Apache POI para Excel
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    
    // Módulos de Email
    requires jakarta.mail;
    
    // Módulos de Web Services
    requires jakarta.xml.ws;
    requires java.xml.ws;
    
    // Módulos de JSON
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    
    // Módulos de Logging
    requires org.slf4j;
    requires ch.qos.logback.classic;
    requires ch.qos.logback.core;
    
    // Módulos de Java base
    requires java.base;
    requires java.desktop;
    requires java.prefs;
    
    // Exportar paquetes para que sean accesibles
    exports cr.ac.una.tareaprogramacion3;
    exports cr.ac.una.tareaprogramacion3.controller;
    exports cr.ac.una.tareaprogramacion3.entity;
    exports cr.ac.una.tareaprogramacion3.service;
    exports cr.ac.una.tareaprogramacion3.util;
    exports cr.ac.una.tareaprogramacion3.enums;
    
    // Abrir paquetes para reflexión (necesario para JavaFX FXML y JPA)
    opens cr.ac.una.tareaprogramacion3 to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.controller to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.entity to org.hibernate.orm.core, jakarta.persistence;
    opens cr.ac.una.tareaprogramacion3.dto to com.fasterxml.jackson.databind;
    
    // Permitir acceso a recursos
    opens cr.ac.una.tareaprogramacion3.views to javafx.fxml;
    opens cr.ac.una.tareaprogramacion3.css to javafx.fxml;
}