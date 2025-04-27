module JavaProje {
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.xml.crypto;
    requires java.desktop;

    opens Scenes;
    opens model;
}