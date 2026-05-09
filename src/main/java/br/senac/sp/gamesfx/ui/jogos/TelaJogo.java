package br.senac.sp.gamesfx.ui.jogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaJogo {

    private TextField tfId;
    private TextField tfTitulo;
    private TextField tfValor;
    private ComboBox<String> comboPlataforma;
    private ComboBox<String> comboEstudio;
    private DatePicker dpDataLancamento;
    private CheckBox cbFinalizado;

    public void criarTela(Stage stagePai) {

        Image iconeTela = new Image(getClass().getResourceAsStream("/imagens/game.png"));

        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.getIcons().add(iconeTela);
        stage.setTitle("Jogos");

        // Criar um BorderPane
        BorderPane raiz = new BorderPane();

        raiz.setTop(criarPainelTitulo());
        raiz.setCenter(criarFormulario());

        Scene cena = new Scene(raiz, 500,500);

        stage.setScene(cena);
        stage.showAndWait();
    }

    public HBox criarPainelTitulo(){

        HBox painelTitulo = new HBox(10);
        painelTitulo.setPadding(new Insets(20, 20, 20, 20));
        painelTitulo.setStyle("-fx-background-color: #1f4450");
        painelTitulo.setAlignment(Pos.CENTER_LEFT);

        // Imagem do Titulo
        Image image = new Image(getClass().getResourceAsStream("/imagens/adicionar.png"));
        ImageView imageView = new ImageView(image);

        // Texto do Titulo
        Label lblTitulo = new Label("Cadastro de Jogos");
        lblTitulo.setStyle("-fx-text-fill: #f4f6f7; -fx-font-size: 22; -fx-font-weight: bold");

        // Adiciona os Componentes no HBox
        painelTitulo.getChildren().addAll(imageView, lblTitulo);

        return painelTitulo;
    }

    private VBox criarFormulario(){

        ObservableList<String> plataformas = FXCollections.observableArrayList(
                "Super Nintendo", "Mega Drive", "PC", "PlayStation", "XBox"
        );

        ObservableList<String> estudio = FXCollections.observableArrayList(
                "Capcom", "Ubisoft", "Electronic Arts", "Nintendo", "RockStar Games"
        );

        VBox formulario = new VBox();

        GridPane gridFormulario = new GridPane();

        // Criar Componentes inseridos no Grid
        Label lblId = new Label("ID: ");
        tfId = new TextField();
        tfId.setEditable(false);

        Label lblTitulo = new Label("Titulo: ");
        tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex. Super Mario World");

        Label lblPlataforma = new Label("Plataforma: ");
        comboPlataforma = new ComboBox<>(plataformas);

        Label lblEstudio = new Label("Estudio: ");
        comboEstudio = new ComboBox<>(estudio);


        // Adicionar os Componentes no Grid
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);

        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        gridFormulario.add(lblEstudio, 0, 3);
        gridFormulario.add(comboEstudio, 1, 3);


        formulario.getChildren().add(gridFormulario);

        return formulario;
    }
}
