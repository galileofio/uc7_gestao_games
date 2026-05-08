package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.data.repository.JogoRepository;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PainelJogos {

    private Stage stage;

    public PainelJogos(Stage stage) {
        this.stage = stage;
    }

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

        // Ajustar tabela para ocupar todo o espaço
        VBox.setVgrow(tabelaJogos, Priority.ALWAYS);

        // Criar Colunas da Tabela
        TableColumn<Jogo, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(40);

        TableColumn<Jogo, String> colunaTitulo = new TableColumn<>("TITULO");
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaTitulo.setPrefWidth(150);

        TableColumn<Jogo, String> colunaPlataforma = new TableColumn<>("PLATAFORMA");
        colunaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        colunaPlataforma.setPrefWidth(100);

//        TableColumn<Jogo, String> colunaCategoria = new TableColumn<>("CATEGORIA");
//        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
//        colunaCategoria.setPrefWidth(150);
//        TableColumn<Jogo, String> colunaEstudio = new TableColumn<>("ESTUDIO");
//        colunaEstudio.setCellValueFactory(new PropertyValueFactory<>("estudio"));
//        colunaEstudio.setPrefWidth(150);
//        TableColumn<Jogo, Boolean> colunaPreco = new TableColumn<>("PREÇO");
//        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
//        colunaPreco.setPrefWidth(80);
//        TableColumn<Jogo, LocalDate> colunadataLancamento = new TableColumn<>("DATA_LANÇAMENTO");
//        colunadataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
//        colunadataLancamento.setPrefWidth(140);
//        TableColumn<Jogo, Boolean> colunaFinalizado = new TableColumn<>("FINALIZADO");
//        colunaFinalizado.setCellValueFactory(new PropertyValueFactory<>("finalizado"));
//        colunaFinalizado.setPrefWidth(90);

        // Obter os dados que serao exibidos
        JogoRepository repository = new JogoRepository();

        // Adiciona lista de jogos na Tabela
        tabelaJogos.setItems(repository.getJogos());

        // Criar painel de botoes de acao
        HBox painelBotoes = new HBox(10);
        painelBotoes.setPadding(new Insets(20,0,0,0));
        painelBotoes.setAlignment(Pos.BASELINE_RIGHT);

        // Criar os Botoes
        Button btnAdicionar = criarBotao("Adicionar", "/imagens/adicionar.png");
        btnAdicionar.setOnAction(e -> {
            TelaJogo telaJogo = new TelaJogo();
            telaJogo.criarTela(stage);
        });

        Button btnMostrar = criarBotao("Mostrar", "/imagens/mostrar.png");
        Button btnAlterar = criarBotao("Alterar", "/imagens/alterar.png");
        Button btnExcluir = criarBotao("Excluir", "/imagens/excluir.png");


        painelBotoes.getChildren().addAll(btnAdicionar, btnMostrar, btnAlterar, btnExcluir);


        // Adicionar as colunas na tabela
        tabelaJogos.getColumns().addAll(colunaId, colunaTitulo, colunaPlataforma
//                colunaCategoria,
//                colunaEstudio,
//                colunaPreco,
//                colunadataLancamento,
//                colunaFinalizado
        );

        // Adicionar o Label no painel
        painelJogos.getChildren().addAll(lblTitulo, linha, tabelaJogos, painelBotoes);


        return painelJogos;
    }

    private Button criarBotao(String textoBotao, String urlImagem){

        Image image = new Image(getClass().getResourceAsStream(urlImagem));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(24);
        imageView.setFitWidth(24);

        Button button = new Button();
        button.setText(textoBotao);
        button.setGraphic(imageView);
        button.setPrefWidth(100);
        button.setPrefHeight(50);

        button.setContentDisplay(ContentDisplay.TOP);

        return button;
    }

}
