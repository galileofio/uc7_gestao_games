package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.data.repository.JogoRepository;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Optional;

public class TelaJogo {

    private TextField tfId = new TextField();
    private TextField tfTitulo =  new TextField();
    private TextField tfValor =  new TextField();
    private ComboBox<String> comboPlataforma =  new ComboBox<>();
    private ComboBox<String> comboEstudio =   new ComboBox<>();
    private DatePicker dpDataLancamento = new DatePicker();
    private CheckBox cbFinalizado =   new CheckBox("Finalizado");

    public TelaJogo(Jogo jogo) {
        tfId.setText(String.valueOf(jogo.getId()));
        tfTitulo.setText(jogo.getTitulo());
        tfValor.setText(String.valueOf(jogo.getPreco()));
        comboPlataforma.setValue(jogo.getPlataforma());
        comboEstudio.setValue(jogo.getEstudio());
        dpDataLancamento.setValue(jogo.getDataLancamento());
        cbFinalizado.setSelected(jogo.isFinalizado());
    }

    public TelaJogo() {}

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
        raiz.setCenter(criarFormulario());
        raiz.setBottom(criarPainelBotoes(stage));

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
        Image image = new Image(getClass().getResourceAsStream("/imagens/JoyStick.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(45);
        imageView.setFitWidth(45);

        // Texto do Titulo
        Label lblTitulo = new Label("Cadastro de Jogos");
        lblTitulo.setStyle("-fx-text-fill: #f4f6f7; -fx-font-size: 22; -fx-font-weight: bold");

        // Adiciona os Componentes no HBox
        painelTitulo.getChildren().addAll(imageView, lblTitulo);

        return painelTitulo;
    }

    private VBox criarFormulario(){

        ObservableList<String> plataformas = FXCollections.observableArrayList(
                "Super Nintendo", "Mega Drive", "PC", "PlayStation", "XBox"
        );

        ObservableList<String> estudio = FXCollections.observableArrayList(
                "Capcom", "Ubisoft", "Electronic Arts", "Nintendo", "RockStar Games"
        );

        VBox formulario = new VBox();
        formulario.setPadding(new Insets(15));
        //formulario.setStyle("-fx-border-width: 4; -fx-border-color: #1f4450");

        GridPane gridFormulario = new GridPane(6,6);
        gridFormulario.setGridLinesVisible(false);
        gridFormulario.setPadding(new Insets(30));
        gridFormulario.setStyle("-fx-border-width: 1; -fx-border-color: #1f4450; -fx-border-radius: 10");

        // Criar Componentes inseridos no Grid
        Label lblId = new Label("ID: ");
        //tfId = new TextField();
        //tfId.setEditable(false);
        tfId.setDisable(true);

        Label lblTitulo = new Label("Titulo: ");
        //tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex. Super Mario World");

        Label lblPlataforma = new Label("Plataforma: ");
        comboPlataforma.setItems(plataformas);

        Label lblEstudio = new Label("Estudio: ");
        comboEstudio.setItems(estudio);

        Label lblValor = new Label("Valor: ");
        //tfValor = new TextField();
        tfValor.setPromptText("Ex. 9,99");

        Label lblDataLancamento = new Label("Data de Lancamento: ");
        //dpDataLancamento = new DatePicker();

        Label lblFinalizado = new Label("");
        //cbFinalizado = new CheckBox("Finalizado");


        // Adicionar os Componentes no Grid
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);

        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        gridFormulario.add(lblEstudio, 0, 3);
        gridFormulario.add(comboEstudio, 1, 3);

        gridFormulario.add(lblValor, 0, 4);
        gridFormulario.add(tfValor, 1, 4);

        gridFormulario.add(lblDataLancamento, 0, 5);
        gridFormulario.add(dpDataLancamento, 1, 5);

        gridFormulario.add(lblFinalizado, 0, 6);
        gridFormulario.add(cbFinalizado, 1, 6);

        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

    private HBox criarPainelBotoes(Stage stage) {
        HBox painelBotoes = new HBox(15);
        painelBotoes.setStyle("-fx-background-color: #538695");
        painelBotoes.setPadding(new Insets(10));
        painelBotoes.setAlignment(Pos.CENTER_RIGHT);

        Button btnSalvar = new Button();
        btnSalvar.setTooltip(new Tooltip("Salvar"));
        Image imgSalvar = new Image(getClass().getResourceAsStream("/imagens/salvar.png"));
        ImageView ivSalvar = new ImageView(imgSalvar);
        ivSalvar.setFitHeight(35);
        ivSalvar.setFitWidth(35);
        btnSalvar.setGraphic(ivSalvar);

        btnSalvar.setOnAction(e -> {

            Jogo jogo = new Jogo();
            jogo.setTitulo(tfTitulo.getText());
            jogo.setPlataforma(comboPlataforma.getValue());
            jogo.setEstudio(comboEstudio.getValue());
            jogo.setDataLancamento(dpDataLancamento.getValue());
            jogo.setCategoria("Jogo");
            jogo.setFinalizado(cbFinalizado.isSelected());

            try {
                jogo.setPreco(Double.parseDouble(tfValor.getText().replace(",", ".")));
            } catch (NumberFormatException erro) {
                Alert valorIncorreto = new Alert(Alert.AlertType.ERROR);
                valorIncorreto.setTitle("Valor Incorreto");
                valorIncorreto.setHeaderText("Digite apenas NÚMERO!\nUtilize PONTO(.) ou VIRGULA(,)");
                valorIncorreto.showAndWait();
                tfValor.requestFocus();
                return;
            }

            // Criar o repositorio para enviar o jogo
            JogoRepository repository = new JogoRepository();

            if(tfId.getText().equals("")) {
                repository.salvar(jogo);

                //mensagem pos salvar
                Alert mensagemSalvar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemSalvar.setTitle("Atualização de Jogo");
                mensagemSalvar.setHeaderText("Jogo Salvo com Sucesso!");
                mensagemSalvar.setContentText("Deseja Salvar Outro Jogo?");

                Optional<ButtonType> escolha = mensagemSalvar.showAndWait();

                if(escolha.get() == ButtonType.OK) {
                    limparCampos();
                } else{
                    stage.close();
                }

            }else{
                jogo.setId(Integer.parseInt(tfId.getText()));
                repository.editar(jogo);

                // mensagem pos editar
                Alert mensagemEditar = new Alert(Alert.AlertType.INFORMATION);
                mensagemEditar.setTitle("Atualização de Jogo");
                mensagemEditar.setHeaderText("Jogo Atualizado com Sucesso!");
                mensagemEditar.showAndWait();
                stage.close();
            }
        });

        Button btnCancelar = new Button();
        btnCancelar.setTooltip(new Tooltip("Cancelar"));
        Image imgCancelar = new Image(getClass().getResourceAsStream("/imagens/Botao-X.png"));
        ImageView ivCancelar = new ImageView(imgCancelar);
        ivCancelar.setFitHeight(35);
        ivCancelar.setFitWidth(35);
        btnCancelar.setGraphic(ivCancelar);

        painelBotoes.getChildren().addAll(btnSalvar, btnCancelar);

        return painelBotoes;
    }

    private void limparCampos() {

        tfTitulo.clear();
        tfId.clear();
        tfValor.clear();
        comboEstudio.setValue("");
        comboPlataforma.setValue("");
        cbFinalizado.setSelected(false);
        dpDataLancamento.setValue(LocalDate.now());
        tfTitulo.requestFocus();

    }
}
