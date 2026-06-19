package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.data.ConexaoSQLite;
import br.senac.sp.gamesfx.model.Estudio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstudioRepository {

    public ObservableList<Estudio> getEstudios() {

        String sql = "SELECT * FROM Studio";

        ObservableList<Estudio> listaEstudio = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){

                Estudio estudio = new Estudio();
                int id = rs.getInt("id");
                String nomeEstudio = rs.getString("nome_estudio");
                String nomeFundador = rs.getString("nome_fundador");
                int anoFundacao = rs.getInt("ano_fundacao");
                String paisOrigem = rs.getString("pais_origem");

                // Popular o objeto Estudio com os dados
                estudio.setId(id);
                estudio.setNome_Estudio(nomeEstudio);
                estudio.setNome_fundador(nomeFundador);
                estudio.setAno_fundacao(String.valueOf(anoFundacao));
                estudio.setPais_origem(paisOrigem);

                listaEstudio.add(estudio);

            }

            ConexaoSQLite.fecharConexao();
            return listaEstudio;

        } catch (SQLException e) {
            System.out.println("Erro na Leitura dos Dados!");
            e.printStackTrace();
            return null;
        }
    }

    // BOTAO SALVAR
    public void salvar(Estudio estudio) {


        // Instrução SQL para cadastrar um novo Estudio no banco de dados
        String sql = "INSERT INTO studio (nome_estudio, nome_fundador," +
                "ano_fundacao, pais_origem" +
                "VALUES (?,?,?,?)";

        // Preparar a instrução SQL para ser enviada para o banco atraves de uma conexão
        try {
            PreparedStatement  stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, estudio.getNome_estudio());
            stm.setString(2, estudio.getNome_fundador());
            stm.setInt(3, estudio.getAno_fundacao());
            stm.setString(4, estudio.getPais_origem());

            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();

        } catch (SQLException e) {
            System.out.println("Erro ao Salvar o Jogo");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // aqui vai o codigo para contar total de Estudios

    }
    // BOTAO EXCLUIR
    public int excluir(int id) {

        String sql = "DELETE FROM studio WHERE id = ?";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setInt(1, id);

            int resultado = stm.executeUpdate();

            ConexaoSQLite.fecharConexao();

            return resultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // BOTAO EDITAR
    public void editar(Estudio estudio) {
        String sql = "UPDATE studio SET " +
                "nome_estudio = ?," +
                "nome_fundador = ?," +
                "ano_fundacao = ?," +
                "pais_origem = ?," +
                "WHERE id = ?;";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, estudio.getNome_estudio());
            stm.setString(2, estudio.getNome_fundador());
            stm.setInt(3, estudio.getAno_fundacao());
            stm.setString(4, estudio.getPais_origem());
            stm.setInt(5, estudio.getId());
            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Erro na gravação!");
            e.printStackTrace();
        }
    }
}
