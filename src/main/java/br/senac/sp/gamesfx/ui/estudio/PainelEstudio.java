package br.senac.sp.gamesfx.ui.estudio;

import br.senac.sp.gamesfx.data.repository.EstudioRepository;
import br.senac.sp.gamesfx.data.repository.PlataformaRepository;
import br.senac.sp.gamesfx.model.Estudio;
import br.senac.sp.gamesfx.model.Plataforma;
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

public class PainelEstudio {

    private Stage stage;

    public PainelEstudio(Stage stage) {
        this.stage = stage;
    }

    public VBox criarPainelEstudio() {

        VBox painelEstudio = new VBox();
        painelEstudio.setPadding(new Insets(5,20,20,20));
        painelEstudio.setStyle("-fx-background-color: #25394e");

        // Titulo do Painel Estudio
        Label lblTitulo = new Label("Listagem de Estudios");
        lblTitulo.setStyle("-fx-font-size: 24; -fx-text-fill: #ffffff;-fx-font-weight: bold");

        //Linha abaixo do label
        Separator linha = new Separator();

        // Tabela com Lista de Plataformas
        TableView<Estudio> tabelaEstudios = new TableView<>();

        // Ajustar tabela para ocupar todo o espaço
        VBox.setVgrow(tabelaEstudios, Priority.ALWAYS);

        // Criar Colunas da Tabela
        TableColumn<Estudio, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(40);

        TableColumn<Estudio, String> colunaNome_Estudio = new TableColumn<>("NOME DO ESTUDIO");
        colunaNome_Estudio.setCellValueFactory(new PropertyValueFactory<>("nome_estudio"));
        colunaNome_Estudio.setPrefWidth(150);

        TableColumn<Estudio, String> colunaNome_Fundador = new TableColumn<>("NOME DO FUNDADOR");
        colunaNome_Fundador.setCellValueFactory(new PropertyValueFactory<>("nome_fundador"));
        colunaNome_Fundador.setPrefWidth(140);

        TableColumn<Estudio, String> colunaAno_Fundacao = new TableColumn<>("ANO DE FUNDACAO");
        colunaAno_Fundacao.setCellValueFactory(new PropertyValueFactory<>("ano_fundacao"));
        colunaAno_Fundacao.setPrefWidth(140);

        TableColumn<Estudio, String> colunaPais_Origem = new TableColumn<>("PAÍS DE ORIGEM");
        colunaPais_Origem.setCellValueFactory(new PropertyValueFactory<>("pais_origem"));
        colunaPais_Origem.setPrefWidth(140);

        // Obter os dados que serao exibidos
        EstudioRepository repository = new EstudioRepository();

        // Adiciona lista de jogos na Tabela
        tabelaEstudios.setItems(repository.getEstudios());

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
            tabelaEstudios.setItems(repository.getEstudios());
        });

        Button btnMostrar = criarBotao("Exibir", "/imagens/mostrar.png");
        btnMostrar.setCursor(Cursor.HAND);
        //btnMostrar.setTooltip(new Tooltip("MOSTRAR"));

        btnMostrar.setOnAction(e -> {

            Estudio estudio = tabelaEstudios.getSelectionModel().getSelectedItem();

            if (estudio == null) {
                Alert alertaPlataformaNSelecionado = new Alert(Alert.AlertType.INFORMATION);
                alertaPlataformaNSelecionado.setTitle("Exibir Estudio");
                alertaPlataformaNSelecionado.setHeaderText("Selecione um Estudio da Lista!");
                alertaPlataformaNSelecionado.showAndWait();
                return;
            }

            //TelaJogo telaJogo = new TelaJogo(plataforma);
            //telaJogo.criarTela(stage);
            tabelaEstudios.setItems(repository.getEstudios());

        });

        Button btnAlterar = criarBotao("Alterar", "/imagens/alterar.png");
        btnAlterar.setCursor(Cursor.HAND);
        //btnAlterar.setTooltip(new Tooltip("ALTERAR"));

        btnAlterar.setOnAction(e -> {

            Estudio estudioAlterar = tabelaEstudios.getSelectionModel().getSelectedItem();

            if (estudioAlterar == null) {
                Alert alertaPlataformaNSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaPlataformaNSelecionado.setTitle("Alterar Estudio");
                alertaPlataformaNSelecionado.setHeaderText("Selecione um Estudio da Lista!");
                alertaPlataformaNSelecionado.showAndWait();
                return;
            }

//            TelaJogo telaJogo = new TelaJogo(plataformaAlterar);
//            telaJogo.criarTela(stage);

            tabelaEstudios.setItems(repository.getEstudios());
        });

        Button btnExcluir = criarBotao("Excluir", "/imagens/excluir.png");
        btnExcluir.setCursor(Cursor.HAND);
        //btnExcluir.setTooltip(new Tooltip("EXCLUIR"));

        btnExcluir.setOnAction(e -> {

            Estudio estudioExcluir = tabelaEstudios.getSelectionModel().getSelectedItem();

            if (estudioExcluir == null) {
                Alert alertaJogoNaoSelecionado = new Alert(Alert.AlertType.WARNING);
                alertaJogoNaoSelecionado.setTitle("Exclusão de Estudio!");
                alertaJogoNaoSelecionado.setHeaderText("Selecione um Estudio da Lista!");
                alertaJogoNaoSelecionado.showAndWait();
                return;
            }

            Alert confirmaExclusao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmaExclusao.setTitle("Exclusão de Estudio!");
            confirmaExclusao.setHeaderText("O Estudio será Excluido!");
            confirmaExclusao.setContentText("Deseja Continuar?");

            Optional<ButtonType> resposta = confirmaExclusao.showAndWait();
            ButtonType botaoSelecionado = resposta.get();

            if(botaoSelecionado == ButtonType.OK) {
                repository.excluir(estudioExcluir.getId());
                tabelaEstudios.setItems(repository.getEstudios());
            }
        });

        painelBotoes.getChildren().addAll(btnAdicionar, btnMostrar, btnAlterar, btnExcluir);

        // Adicionar as colunas na tabela
        tabelaEstudios.getColumns().addAll(
                colunaId,
                colunaNome_Estudio,
                colunaNome_Fundador,
                colunaAno_Fundacao,
                colunaPais_Origem
        );

        // Adicionar o Label no painel
        painelEstudio.getChildren().addAll(lblTitulo, linha, tabelaEstudios, painelBotoes);

        return painelEstudio;
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
