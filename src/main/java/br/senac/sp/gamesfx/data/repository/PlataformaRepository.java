package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.data.ConexaoSQLite;
import br.senac.sp.gamesfx.model.Estudio;
import br.senac.sp.gamesfx.model.Plataforma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlataformaRepository {

    public ObservableList<Plataforma> getPlataformas() {

        String sql = "SELECT * FROM plataforma";

        ObservableList<Plataforma> listaPlataforma = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){

                Plataforma plataforma = new Plataforma();
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String fabricante = rs.getString("fabricante");
                LocalDate dataLancamento = LocalDate.parse(rs.getString("data_lancamento"));
                double valor = rs.getDouble("valor");

                // Popular o objeto plataforma com os dados
                plataforma.setId(id);
                plataforma.setNome(nome);
                plataforma.setFabricante(fabricante);
                plataforma.setValor(valor);
                plataforma.setDataLancamento(dataLancamento);

                listaPlataforma.add(plataforma);

            }

            ConexaoSQLite.fecharConexao();
            return listaPlataforma;

        } catch (SQLException e) {
            System.out.println("Erro na Leitura dos Dados!");
            e.printStackTrace();
            return null;
        }
    }

    // BOTAO SALVAR
    public void salvar(Plataforma plataforma) {


        // Instrução SQL para cadastrar um nova plataforma no banco de dados
        String sql = "INSERT INTO plataforma (nome, fabricante," +
                "data_lancamento, valor" +
                "VALUES (?,?,?,?)";

        //System.out.println(sql);

        // Preparar a instrução SQL para ser enviada para o banco atraves de uma conexão
        try {
            PreparedStatement  stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, plataforma.getNome());
            stm.setString(2, plataforma.getFabricante());
            stm.setString(6, plataforma.getDataLancamento().toString());
            stm.setDouble(5, plataforma.getValor());
            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();

        } catch (SQLException e) {
            System.out.println("Erro ao Salvar o Jogo");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // aqui vai o codigo para contar total de jogos

    }
    // BOTAO EXCLUIR
    public int excluir(int id) {

        String sql = "DELETE FROM plataforma WHERE id = ?";

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
    public void editar(Plataforma plataforma) {
        String sql = "UPDATE plataforma SET " +
                "nome = ?," +
                "fabricante = ?," +
                "data_lancamento = ?," +
                "valor = ?," +
                "WHERE id = ?;";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, plataforma.getNome());
            stm.setString(2, plataforma.getFabricante());
            stm.setString(3, plataforma.getDataLancamento().toString());
            stm.setDouble(4, plataforma.getValor());
            stm.setInt(5, plataforma.getId());
            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Erro na gravação!");
            e.printStackTrace();
        }
    }
}
