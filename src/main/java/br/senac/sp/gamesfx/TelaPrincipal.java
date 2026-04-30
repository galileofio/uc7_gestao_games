package br.senac.sp.gamesfx;

import br.senac.sp.gamesfx.ui.home.PainelHome;
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
    //#1b3f00
    private static final String COR_PADRAO = "#1b3f55";
    private static final String COR_HOVER = "#4189BCFF";
    private static final String TEXTO_BRANCO = "-fx-text-fill: #ffffff ";

    @Override
    public void start(Stage stage) throws Exception {

        Image iconeTela = new Image(getClass().getResourceAsStream("/imagens/game.png"));

        BorderPane raiz = new BorderPane();

        VBox painelLateral = new VBox();
        painelLateral.setSpacing(5);
        painelLateral.setPrefWidth(150);
        painelLateral.setStyle("-fx-background-color: #445989");
        painelLateral.setPadding(new Insets(10));

        Button btnJogos = criarBotaoMenu("Jogos");
        Button btnPlataformas =criarBotaoMenu("Plataformas");
        Button btnEstudios = criarBotaoMenu("Estudios");
        Button btnHome = criarBotaoMenu("Home");

        aplicarEfeitoHover(btnJogos, btnHome, btnEstudios, btnPlataformas);

        painelLateral.getChildren().addAll(
                btnHome,
                btnJogos,
                btnPlataformas,
                btnEstudios
        );

        raiz.setLeft(painelLateral);
        //raiz.setStyle("-fx-background-color: #416fbc");

        PainelHome painelHome = new PainelHome();

        raiz.setCenter(painelHome.criarPainelHome());

        Scene cena = new Scene(raiz, 900, 600);
        stage.setScene(cena);
        //stage.setResizable(false);
        stage.setMaximized(true);
        //stage.getIcons().add(new Image(getClass().getResourceAsStream("/Brasil.ico")));
        stage.setTitle("Sistema de Gestão de Jogos V1.0");
        stage.getIcons().add(iconeTela);
        stage.show();
    }

    private Button criarBotaoMenu(String TextoDoBotao){

        Button button = new Button(TextoDoBotao);
        button.setPadding(new Insets(10));
        button.setPrefWidth(Double.MAX_VALUE);
        //button.setStyle("-fx-background-color: #1b3f55; -fx-text-fill: #ffffff; -fx-alignment: center; -fx-cursor: hand");
        return button;
    }

    private void aplicarEfeitoHover(Button... botoes){

        for (Button button : botoes){
            button.setStyle("-fx-background-color: " + COR_PADRAO + ";" + TEXTO_BRANCO);

            // Ao passar no botão
            button.setOnMouseEntered(e -> {
                button.setStyle("-fx-background-color: " + COR_HOVER + ";" + TEXTO_BRANCO +";" + "-fx-alignment: center; -fx-cursor: hand");
            });

            // Ao sair do botão
            button.setOnMouseExited(e -> {
                button.setStyle("-fx-background-color: " + COR_PADRAO + ";" + TEXTO_BRANCO);
            });

        }

    }

}
