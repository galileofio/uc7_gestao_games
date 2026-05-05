package br.senac.sp.gamesfx.ui.jogos;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class PainelJogos {

    public VBox criarPainelJogos(){

        VBox painelJogos = new VBox();
        painelJogos.setPadding(new Insets(5,20,20,20));
        painelJogos.setStyle("-fx-background-color: #25394e");

        // Titulo do Painel Jogos
        Label lblTitulo = new Label("Listagem de Jogos");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff;-fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        // Tabela com Lista de Jogos


        // Adicionar o Label no painel
        painelJogos.getChildren().addAll(lblTitulo, linha);


        return painelJogos;
    }

}
