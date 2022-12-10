module com.example.tpv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires lombok;
    requires java.sql;
    requires org.hibernate.orm.core;
    opens com.example.tpv to javafx.fxml;

    exports com.example.tpv;
    exports com.example.tpv.modelos;
    opens com.example.tpv.modelos to javafx.fxml;
    //  opens com.example.tpv.modelos.Producto;
}