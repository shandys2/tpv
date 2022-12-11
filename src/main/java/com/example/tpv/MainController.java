package com.example.tpv;

import com.example.tpv.modelos.Producto;
import com.example.tpv.modelos.RowPedido;
import com.example.tpv.modelos.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.persistence.Query;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public AnchorPane  raiz;
    @FXML
    public Button btnUsuarios;
    @FXML
    public Button btnInventario;
    @FXML
    public  Button btnCobrar;
    @FXML
    public Label lblUsuario;

    @FXML
    public ScrollPane scrollPane;
    @FXML
    public AnchorPane scrollAnchorPane;
    @FXML
    public ListView<String> listCategorias;
    List<String> categorias;

    @FXML
    TableView<RowPedido> tableProductos;
    @FXML
    TableColumn colNombre;
    @FXML
    TableColumn colPrecio;
    @FXML
    TableColumn colCantidad;

    private ObservableList<RowPedido> pedidos;

    public MainController() { }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Stage stage= TPVApplication.stagePrimary;

        //CONFIGURACION DE LA TABLA PRODUCTOS

        pedidos= FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colCantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));


        //COMPROBACION DE USUARIO
        Usuario usuario= (Usuario) stage.getUserData();

        if(usuario.getAdmin()==true){
            lblUsuario.setText("MODO ADMIN , bienvenido ->" + usuario.getUser() );

        }
        if(usuario.getAdmin()==false) {
            lblUsuario.setText("MODO USUARIO, bienvenido ->" + usuario.getUser());
            btnUsuarios.setVisible(false);
        }

        List<String> imagenes= new ArrayList<>();
        imagenes.add("agregar");
        imagenes.add("borrar");
        imagenes.add("editar");
        imagenes.add("cliente");
        imagenes.add("nuevo");
        imagenes.add("agregar-usuario");


        //CONFIGURACION DE PRODUCTOS
        Query q =TPVApplication.manager.createQuery("FROM PRODUCTOS");
        List<Producto> productos=q.getResultList();
        categorias= new ArrayList<>();

        for (Producto p:productos) {
            System.out.println(p.getNombre());
            if(categorias.indexOf(p.getCategoria())==-1)
              categorias.add(p.getCategoria());
        }
       listCategorias.getItems().addAll(categorias);
       listCategorias.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
              String current=listCategorias.getSelectionModel().getSelectedItem();
              System.out.println("seleccion -> " +current);
              scrollAnchorPane.getChildren().clear();
              int vertical=0;
              int i=0;

        for (String imagen:imagenes) {
            Image imgTest = new Image(getClass().getResourceAsStream("/img/"+imagen+".png"));
            ImageView viewTest = new ImageView(imgTest);
            viewTest.setFitHeight(80);
            viewTest.setPreserveRatio(true);
            Button button = new Button();
            //controlamos si ha llegado al final de la linea
            if(i==500){ // 5 elementos, 100 px por cada uno
                System.out.println("fin linea");
                i=0;
                vertical=100;
            }
            button.setLayoutX(i);
            button.setLayoutY(vertical);
            button.setPrefSize(96, 100);
            button.setGraphic(viewTest);
            button.setTooltip(new Tooltip(imagen));
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(button.getTooltip().getText());
                    RowPedido pedido= new RowPedido(button.getTooltip().getText(),"1.20","1");

                    Boolean existeProducto=false;
                    int nuevaCantidad=0;
                    int indice=0;
                    int i=0;
                    for (RowPedido p:pedidos) {
                        System.out.println(p.getNombre() + " ** "+ p.getCantidad());

                        if(p.getNombre().equals(button.getTooltip().getText())){
                            nuevaCantidad= Integer.valueOf(p.getCantidad())+1;
                            System.out.println("nueva cantidad:  "+nuevaCantidad);
                            existeProducto=true;
                            indice=i;

                        }else {
                            System.out.println("no esta");
                            existeProducto=false;
                        }
                        i++;
                    }

                    if(existeProducto){
                        System.out.println("EXISTE");

                            pedidos.remove(indice);
                            RowPedido nuevoPedido= new RowPedido(pedido.getNombre(), pedido.getPrecio(), String.valueOf(nuevaCantidad));
                            pedidos.add(nuevoPedido);

                          // tableProductos.getItems().clear();
                    }else {
                        System.out.println("NO EXISTE");
                        pedidos.add(pedido);
                    }

                    tableProductos.setItems(pedidos);
                }
            });
            scrollAnchorPane.getChildren().add(button);
            //controlamos el ancho
           i=i+100;
        }
          }
      });

        //Creating a graphic (image)

        Image imgCombrar = new Image(getClass().getResourceAsStream("/img/cobrar.png"));
        ImageView viewCobrar = new ImageView(imgCombrar);
        viewCobrar.setFitHeight(80);
        viewCobrar.setPreserveRatio(true);

        Image imgInventario = new Image(getClass().getResourceAsStream("/img/inventario.png"));
        ImageView viewInventario = new ImageView(imgInventario);
        viewInventario.setFitHeight(80);
        viewInventario.setPreserveRatio(true);

        Image imgUsuarios = new Image(getClass().getResourceAsStream("/img/cliente.png"));
        ImageView viewUsuarios = new ImageView(imgUsuarios);
        viewUsuarios.setFitHeight(80);
        viewUsuarios.setPreserveRatio(true);


        //Creating a Button

        btnCobrar.setGraphic(viewCobrar);
        btnInventario.setGraphic(viewInventario);
        btnUsuarios.setGraphic(viewUsuarios);


      Image imgTest = new Image(getClass().getResourceAsStream("/img/"+productos.get(4).getNombre()+".png"));
        ImageView viewTest = new ImageView(imgTest);
        viewTest.setFitHeight(80);
        viewTest.setPreserveRatio(true);
        Button button = new Button();


        button.setLayoutX(0);
        button.setLayoutY(0);
        button.setPrefSize(96, 100);
        button.setGraphic(viewTest);
        button.setTooltip(new Tooltip(productos.get(4).getNombre()));
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(button.getTooltip().getText());

            }
        });
        scrollAnchorPane.getChildren().add(button);
        //controlamos el ancho


        int vertical=0;
        int i=0;

   /*     for (String imagen:imagenes) {
            Image imgTest = new Image(getClass().getResourceAsStream("/img/"+imagen+".png"));
            ImageView viewTest = new ImageView(imgTest);
            viewTest.setFitHeight(80);
            viewTest.setPreserveRatio(true);
            Button button = new Button();
            //controlamos si ha llegado al final de la linea
            if(i==500){ // 5 elementos, 100 px por cada uno
                System.out.println("fin linea");
                i=0;
                vertical=100;
            }
            button.setLayoutX(i);
            button.setLayoutY(vertical);
            button.setPrefSize(96, 100);
            button.setGraphic(viewTest);
            button.setTooltip(new Tooltip(imagen));
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    System.out.println(button.getTooltip().getText());
                }
            });
            scrollAnchorPane.getChildren().add(button);
            //controlamos el ancho
           i=i+100;
        }
        */
        //CONFIGURACION DE LA TABLA PRODUCTOS


    }
}
