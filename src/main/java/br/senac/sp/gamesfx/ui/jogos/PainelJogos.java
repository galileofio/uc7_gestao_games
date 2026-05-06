package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.model.Jogo;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

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
        TableView<Jogo> tabelaJogos = new TableView<>();

        // Criar Colunas da Tabela
        TableColumn<Jogo, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(50);
        TableColumn<Jogo, String> colunaTitulo = new TableColumn<>("TITULO");
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaTitulo.setPrefWidth(200);
        TableColumn<Jogo, String> colunaPlataforma = new TableColumn<>("PLATAFORMA");
        colunaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        colunaPlataforma.setPrefWidth(200);
        TableColumn<Jogo, String> colunaCategoria = new TableColumn<>("CATEGORIA");
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaCategoria.setPrefWidth(150);
        TableColumn<Jogo, String> colunaEstudio = new TableColumn<>("ESTUDIO");
        colunaEstudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
        colunaEstudio.setPrefWidth(150);
        TableColumn<Jogo, Boolean> colunaPreco = new TableColumn<>("PREÇO");
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colunaPreco.setPrefWidth(80);
        TableColumn<Jogo, LocalDate> colunadataLancamento = new TableColumn<>("DATA_LANÇAMENTO");
        colunadataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colunadataLancamento.setPrefWidth(140);
        TableColumn<Jogo, Boolean> colunaFinalizado = new TableColumn<>("FINALIZADO");
        colunaFinalizado.setCellValueFactory(new PropertyValueFactory<>("finalizado"));
        colunaFinalizado.setPrefWidth(90);

        // Adicionar as colunas na tabela
        tabelaJogos.getColumns().addAll(
                colunaId,
                colunaTitulo,
                colunaPlataforma,
                colunaCategoria,
                colunaEstudio,
                colunaPreco,
                colunadataLancamento,
                colunaFinalizado
        );

        // Adicionar o Label no painel
        painelJogos.getChildren().addAll(lblTitulo, linha, tabelaJogos);


        return painelJogos;
    }

}
