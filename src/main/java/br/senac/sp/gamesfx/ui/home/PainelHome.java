package br.senac.sp.gamesfx.ui.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        painelTitulo.setStyle("-fx-background-color: transparent");
        Label lblTitulo = new Label("Sejam Bem-vindos!");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff ; -fx-font-weight: bold");

        painelTitulo.getChildren().addAll(lblTitulo,new Separator());

        HBox painelLogo2 = new HBox();
        painelLogo2.setAlignment(Pos.BOTTOM_CENTER);

        HBox.setHgrow(painelLogo2, Priority.ALWAYS);

        //VBox painelLogo = new VBox();
        //painelLogo.setAlignment(Pos.CENTER);

        // Imagem da Aplicação - para 2 imagens tem que usar HBox e criar exclusivo para elas
        Image imgLogo1 = new Image(getClass().getResourceAsStream("/imagens/PacMan.png"));
        ImageView ivLogo1 = new ImageView(imgLogo1);

        Image imgLogo2 = new Image(getClass().getResourceAsStream("/imagens/ghost.png"));
        ImageView ivLogo2 = new ImageView(imgLogo2);

        //ivLogo2.setScaleX(1); codigo para mudar tamanho imagem - horizontal
        //ivLogo2.setScaleX(1); codigo para mudar tamanho imagem - vertical

        //HBox.setHgrow(painelLogo2, Priority.ALWAYS);

        VBox painelLogo = new VBox();
        painelLogo.setAlignment(Pos.CENTER);
        VBox.setVgrow(painelLogo, Priority.ALWAYS);

        // Textos com nome e descrição da aplicação
        Label lblNomeApp = new Label("Game Aleixo Pro");
        lblNomeApp.setStyle("-fx-font-size: 36 ; -fx-text-fill: #ffffff");

        Label lblDescApp = new Label("Software para Gestão de Jogos");
        lblDescApp.setStyle("-fx-font-weight: regular ; -fx-font-size: 25 ; -fx-text-fill: #ffffff");

        // Criar Painel de Contatos
        VBox painelContatos = new VBox(2);
        painelContatos.setStyle("-fx-background-color: #6ad2ee; -fx-border-width: 3; -fx-border-color:blue;-fx-border-radius:16;-fx-background-radius: 16");
        painelContatos.setMaxWidth(600);
        painelContatos.setPadding(new Insets(20));
        VBox.setMargin(painelContatos, new Insets(25,10,40,10));

        Label lblTituloEmail = new Label("E-mail para Suporte:");
        lblTituloEmail.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        Label lblEmail = new Label("suporte@aleixosoft.com");
        lblEmail.setStyle("-fx-font-size: 15");
        Label lblTituloTelefone = new Label("Telefone para Suporte:");
        lblTituloTelefone.setStyle("-fx-font-size: 18; -fx-font-weight: bold");
        Label lblTelefone = new Label("(11)1234-5678");
        lblTelefone.setStyle("-fx-font-size: 15");

        painelContatos.getChildren().addAll(
                lblTituloEmail,
                lblEmail,
                lblTituloTelefone,
                lblTelefone
        );

        Label lblDesenvolvidoPor = new Label("Desenvolvido por AleixoSoft - 2026");
        lblDesenvolvidoPor.setStyle("-fx-font-size: 20;-fx-text-fill: #ffffff; -fx-font-weight: bold");

        painelLogo.getChildren().addAll(ivLogo1, ivLogo2,lblNomeApp,lblDescApp,painelContatos, lblDesenvolvidoPor);

        painelPrincipal.getChildren().addAll(painelTitulo,painelLogo, painelLogo2);
        return painelPrincipal;
    }
}
