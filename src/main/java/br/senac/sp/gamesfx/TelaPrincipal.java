package br.senac.sp.gamesfx;

import br.senac.sp.gamesfx.ui.home.PainelHome;
import br.senac.sp.gamesfx.ui.jogos.PainelJogos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaPrincipal extends Application {

    private static final String COR_PADRAO = "-fx-background-color: #1b3f55 ; -fx-text-fill: #ffffff ; -fx-alignment: center; -fx-cursor: hand";
    private static final String COR_HOVER  = "-fx-background-color: #4189BCFF ; -fx-text-fill: #ffffff ; -fx-alignment: center; -fx-cursor: hand";

    @Override
    public void start(Stage stage) throws Exception {

        Image iconeTela = new Image(getClass().getResourceAsStream("/imagens/brazil.png"));

        BorderPane raiz = new BorderPane();

        VBox painelLateral = new VBox();
        painelLateral.setSpacing(5);
        painelLateral.setPrefWidth(150);
        painelLateral.setStyle("-fx-background-color: #445989");
        painelLateral.setPadding(new Insets(10));

        Button btnJogos = criarBotaoMenu("Jogos");
        btnJogos.setOnAction(clique -> {
            PainelJogos painelJogos = new PainelJogos();
            raiz.setCenter(painelJogos.criarPainelJogos());
        });

        Button btnPlataformas =criarBotaoMenu("Plataformas");
        Button btnEstudios = criarBotaoMenu("Estudios");
        Button btnHome = criarBotaoMenu("Home");
        btnHome.setOnAction(clique -> {
            PainelHome painelHome = new PainelHome();
            raiz.setCenter(painelHome.criarPainelHome());
        });

        aplicarEfeitoHover(btnJogos, btnHome, btnEstudios, btnPlataformas);

        painelLateral.getChildren().addAll(
                btnHome,
                btnJogos,
                btnPlataformas,
                btnEstudios
        );

        raiz.setLeft(painelLateral);

        PainelHome painelHome = new PainelHome();

        raiz.setCenter(painelHome.criarPainelHome());

        Scene cena = new Scene(raiz, 900, 600);
        stage.setScene(cena);
        stage.setMaximized(true);
        stage.setTitle("Sistema de Gestão de Jogos V1.0");
        stage.getIcons().add(iconeTela);
        stage.show();
    }

    private Button criarBotaoMenu(String TextoDoBotao){

        Button button = new Button(TextoDoBotao);
        button.setPadding(new Insets(10));
        button.setPrefWidth(Double.MAX_VALUE);
        return button;
    }

    private void aplicarEfeitoHover(Button... botoes){

        for (Button button : botoes){
            button.setStyle( COR_PADRAO);

            // Ao passar no botão
            button.setOnMouseEntered(e -> {
                button.setStyle(COR_HOVER);
            });

            // Ao sair do botão
            button.setOnMouseExited(e -> {
                button.setStyle(COR_PADRAO);
            });
        }
    }
}
