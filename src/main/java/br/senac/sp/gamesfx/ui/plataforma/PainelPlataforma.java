package br.senac.sp.gamesfx.ui.plataforma;

import br.senac.sp.gamesfx.data.repository.PlataformaRepository;
import br.senac.sp.gamesfx.model.Jogo;
import br.senac.sp.gamesfx.model.Plataforma;
import br.senac.sp.gamesfx.ui.jogos.TelaJogo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class PainelPlataforma {

    private Stage stage;

    public PainelPlataforma(Stage stage) {
        this.stage = stage;
    }

    public VBox criarPainelPlataforma() {

        VBox painelPlataforma = new VBox();
        painelPlataforma.setPadding(new Insets(5,20,20,20));
        painelPlataforma.setStyle("-fx-background-color: #25394e");

        // Titulo do Painel Plataforma
        Label lblTitulo = new Label("Listagem de Plataformas");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff;-fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        // Tabela com Lista de Plataformas
        TableView<Plataforma> tabelaPlataformas = new TableView<>();

        // Ajustar tabela para ocupar todo o espaço
        VBox.setVgrow(tabelaPlataformas, Priority.ALWAYS);

        // Criar Colunas da Tabela
        TableColumn<Plataforma, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(40);

        TableColumn<Plataforma, String> colunaNome = new TableColumn<>("NOME DA PLATAFORMA");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaNome.setPrefWidth(150);

        TableColumn<Plataforma, String> colunaFabricante = new TableColumn<>("FABRICANTE");
        colunaFabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        colunaFabricante.setPrefWidth(140);

        TableColumn<Plataforma, String> colunaDataLancamento = new TableColumn<>("DATA DE LANÇAMENTO");
        colunaDataLancamento.setCellValueFactory(new PropertyValueFactory<>("dataLancamento"));
        colunaDataLancamento.setPrefWidth(150);

        TableColumn<Plataforma, Double> colunaPreco = new TableColumn<>("PREÇO");
        colunaPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaPreco.setPrefWidth(150);


        // Obter os dados que serao exibidos
        PlataformaRepository repository = new PlataformaRepository();

        // Adiciona lista de jogos na Tabela
        tabelaPlataformas.setItems(repository.getPlataformas());

        // Criar painel de botoes de acao
        HBox painelBotoes = new HBox(10);
        painelBotoes.setPadding(new Insets(20,0,0,0));
        painelBotoes.setAlignment(Pos.BASELINE_RIGHT);

        // Criar os Botoes
        Button btnAdicionar = criarBotao("Cadastrar", "/imagens/adicionar.png");
        btnAdicionar.setCursor(Cursor.HAND);
        //btnAdicionar.setTooltip(new Tooltip("ADICIONAR"));
        btnAdicionar.setOnAction(e -> {
            //TelaJogo telaJogo = new TelaJogo();
            //telaJogo.criarTela(stage);
            tabelaPlataformas.setItems(repository.getPlataformas());
        });

        Button btnMostrar = criarBotao("Exibir", "/imagens/mostrar.png");
        btnMostrar.setCursor(Cursor.HAND);
        //btnMostrar.setTooltip(new Tooltip("MOSTRAR"));

        btnMostrar.setOnAction(e -> {

            Plataforma plataforma = tabelaPlataformas.getSelectionModel().getSelectedItem();

            if (plataforma == null) {
                Alert alertaPlataformaNSelecionado = new Alert(Alert.AlertType.INFORMATION);
                alertaPlataformaNSelecionado.setTitle("Exibir Plataforma");
                alertaPlataformaNSelecionado.setHeaderText("Selecione um Item da Lista!");
                alertaPlataformaNSelecionado.showAndWait();
                return;
            }

            //TelaJogo telaJogo = new TelaJogo(plataforma);
            //telaJogo.criarTela(stage);
            tabelaPlataformas.setItems(repository.getPlataformas());

        });

        Button btnAlterar = criarBotao("Alterar", "/imagens/alterar.png");
        btnAlterar.setCursor(Cursor.HAND);
        //btnAlterar.setTooltip(new Tooltip("ALTERAR"));

        btnAlterar.setOnAction(e -> {

            Plataforma plataformaAlterar = tabelaPlataformas.getSelectionModel().getSelectedItem();

            if (plataformaAlterar == null) {
                Alert alertaPlataformaNSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaPlataformaNSelecionado.setTitle("Alterar Plataforma");
                alertaPlataformaNSelecionado.setHeaderText("Selecione um Item da Lista!");
                alertaPlataformaNSelecionado.showAndWait();
                return;
            }

//            TelaJogo telaJogo = new TelaJogo(plataformaAlterar);
//            telaJogo.criarTela(stage);
            tabelaPlataformas.setItems(repository.getPlataformas());
        });

        Button btnExcluir = criarBotao("Excluir", "/imagens/excluir.png");
        btnExcluir.setCursor(Cursor.HAND);
        //btnExcluir.setTooltip(new Tooltip("EXCLUIR"));

        btnExcluir.setOnAction(e -> {

            Plataforma plataformaExcluir = tabelaPlataformas.getSelectionModel().getSelectedItem();

            if (plataformaExcluir == null) {
                Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaJogoNaoSelecionado.setTitle("Exclusão de Plataforma!");
                alertaJogoNaoSelecionado.setHeaderText("Selecione uma Plataforma da Lista!");
                alertaJogoNaoSelecionado.showAndWait();
                return;
            }

            Alert confirmaExclusao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmaExclusao.setTitle("Exclusão de Plataforma!");
            confirmaExclusao.setHeaderText("A Plataforma será Excluida!");
            confirmaExclusao.setContentText("Deseja Continuar?");

            Optional<ButtonType> resposta = confirmaExclusao.showAndWait();
            ButtonType botaoSelecionado = resposta.get();

            if(botaoSelecionado == ButtonType.OK) {
                repository.excluir(plataformaExcluir.getId());
                tabelaPlataformas.setItems(repository.getPlataformas());
            }
        });

        painelBotoes.getChildren().addAll(btnAdicionar, btnMostrar, btnAlterar, btnExcluir);

        // Adicionar as colunas na tabela
        tabelaPlataformas.getColumns().addAll(
                colunaId,
                colunaNome,
                colunaFabricante,
                colunaDataLancamento,
                colunaPreco
        );

        // Adicionar o Label no painel
        painelPlataforma.getChildren().addAll(lblTitulo, linha, tabelaPlataformas, painelBotoes);

        return painelPlataforma;
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
