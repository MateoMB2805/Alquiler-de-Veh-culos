module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.poo.app to javafx.fxml;
    exports co.edu.uniquindio.poo.app;
    exports co.edu.uniquindio.poo.controllers;
    exports co.edu.uniquindio.poo.model;
    opens co.edu.uniquindio.poo.controllers to javafx.fxml;
}
