package br.senac.sp.gamesfx.ui.estudio;

import br.senac.sp.gamesfx.data.repository.EstudioRepository;
import br.senac.sp.gamesfx.data.repository.JogoRepository;
import br.senac.sp.gamesfx.model.Estudio;
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

import java.time.LocalDate;
import java.util.Optional;

public class TelaEstudio {

    private TextField tfId = new TextField();
    private TextField tfEstudio =  new TextField();
    private TextField tfFundador =  new TextField();
    private TextField tfAno =  new TextField();
    private TextField tfPais =  new TextField();

    public TelaEstudio(Estudio estudio) {
        tfId.setText(String.valueOf(estudio.getId()));
        tfEstudio.setText(estudio.getNome_estudio());
        tfFundador.setText(String.valueOf(estudio.getNome_fundador()));
        tfAno.setText(String.valueOf(estudio.getAno_fundacao()));
        tfPais.setText(String.valueOf(estudio.getPais_origem()));

    }

    public TelaEstudio() {}

    public void criarTela(Stage stagePai) {

        Image iconeTela = new Image(getClass().getResourceAsStream("/imagens/game.png"));

        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.getIcons().add(iconeTela);
        stage.setTitle("Estudios");

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

        Label lblEstudio = new Label("nome_estudio: ");
        //tfTitulo = new TextField();
        //tfEstudio.setPromptText();

        Label lblFundador = new Label("nome_fundador: ");
        //comboPlataforma.setItems(plataformas);

        Label lblAno = new Label("ano_fundacao: ");
        //comboEstudio.setItems(estudio);

        Label lblPais = new Label("pais_origem: ");
        //tfValor = new TextField();
        //tfValor.setPromptText("Ex. 9,99");


        // Adicionar os Componentes no Grid
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);

        gridFormulario.add(lblEstudio, 0, 1);
        gridFormulario.add(tfEstudio, 1, 1);

        gridFormulario.add(lblFundador, 0, 2);
        gridFormulario.add(tfFundador, 1, 2);

        gridFormulario.add(lblAno, 0, 3);
        gridFormulario.add(tfAno, 1, 3);

        gridFormulario.add(lblPais, 0, 4);
        gridFormulario.add(tfPais, 1, 4);

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

            Estudio estudio = new Estudio();
            estudio.setNome_Estudio(tfEstudio.getText());
            estudio.setNome_fundador(tfFundador.getText());
            estudio.setAno_fundacao(tfAno.getText());
            estudio.setPais_origem(tfPais.getText());


//            try {
//                estudio.setAno_fundacao(Double.parseDouble(tfAno.getText().replace(",", ".")));
//            } catch (NumberFormatException erro) {
//                Alert valorIncorreto = new Alert(Alert.AlertType.ERROR);
//                valorIncorreto.setTitle("Valor Incorreto");
//                valorIncorreto.setHeaderText("Digite apenas NÚMERO!");
//                valorIncorreto.showAndWait();
//                tfAno.requestFocus();
//                return;
//            }

            // Criar o repositorio para enviar o estudio
            EstudioRepository repository = new EstudioRepository();

            if(tfId.getText().equals("")) {
                repository.salvar(estudio);

                //mensagem pos salvar
                Alert mensagemSalvar = new Alert(Alert.AlertType.CONFIRMATION);
                mensagemSalvar.setTitle("Atualização de Estudio");
                mensagemSalvar.setHeaderText("Estudio Salvo com Sucesso!");
                mensagemSalvar.setContentText("Deseja Salvar Outro Estudio?");

                Optional<ButtonType> escolha = mensagemSalvar.showAndWait();

                if(escolha.get() == ButtonType.OK) {
                    limparCampos();
                } else{
                    stage.close();
                }

            }else{
                estudio.setId(Integer.parseInt(tfId.getText()));
                repository.editar(estudio);

                // mensagem pos editar
                Alert mensagemEditar = new Alert(Alert.AlertType.INFORMATION);
                mensagemEditar.setTitle("Atualização de Estudio");
                mensagemEditar.setHeaderText("Estudio Atualizado com Sucesso!");
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

        tfEstudio.clear();
        tfId.clear();
        tfAno.clear();
        tfEstudio.requestFocus();

    }
}
