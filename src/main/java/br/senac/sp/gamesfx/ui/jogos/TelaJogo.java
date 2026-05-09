package br.senac.sp.gamesfx.ui.jogos;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaJogo {

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
}
