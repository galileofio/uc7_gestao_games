package br.senac.sp.gamesfx.ui.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class PainelHome {

    public VBox criarPainelHome() {

        // Painel Principal: representa a tela toda
        VBox painelPrincipal = new VBox();
        painelPrincipal.setAlignment(Pos.TOP_CENTER);
        painelPrincipal.setStyle("-fx-background-color: #25394e;");
        painelPrincipal.setPadding(new Insets(5,20,20,20));

        // Painel de Titulo
        VBox painelTitulo = new VBox();
        painelTitulo.setStyle("-fx-background-color: #84d1b9;");
        Label lblTitulo = new Label("Seja Bem-vindo!");
        lblTitulo.setStyle("-fx-font-size: 24;-fx-font-weight: bold");

        painelTitulo.getChildren().addAll(lblTitulo,new Separator());

        // Imagem da Aplicação
        Image imgLogo = new Image(getClass().getResourceAsStream("/imagens/pikaxu.png"));
        ImageView ivLogo = new ImageView(imgLogo);

        // Textos com nome e descrição da aplicação
        Label lblNomeApp = new Label("Game Aleixo Pro");
        lblNomeApp.setStyle("-fx-font-size: 36 ; -fx-text-fill: #ffffff");

        Label lblDescApp = new Label("Software para Gestão de Jogos");
        lblDescApp.setStyle("-fx-font-weight: regular ; -fx-font-size: 25 ; -fx-text-fill: #ffffff");

        painelPrincipal.getChildren().addAll(
                painelTitulo,
                ivLogo,
                lblNomeApp,
                lblDescApp
        );

        return painelPrincipal;
    }
}
