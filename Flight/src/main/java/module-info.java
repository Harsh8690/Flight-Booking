module com.booking.flight {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.booking.flight to javafx.fxml;
    exports com.booking.flight;
}