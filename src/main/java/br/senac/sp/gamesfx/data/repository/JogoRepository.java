package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.data.ConexaoSQLite;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JogoRepository {

    public ObservableList<Jogo> getJogos() {

        String sql = "SELECT * FROM tb_games";

        ObservableList<Jogo> listaJogos = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){

                Jogo jogo = new Jogo();
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String plataforma = rs.getString("plataforma");
                String categoria = rs.getString("categoria");
                String estudio = rs.getString("estudio");
                double preco = rs.getDouble("preco");
                LocalDate dataLancamento = LocalDate.parse(rs.getString("data_lancamento"));
                boolean isFinalizado = rs.getInt("finalizado") == 1 ? true : false;

                // Popular o objeto jogo com os dados
                jogo.setId(id);
                jogo.setTitulo(titulo);
                jogo.setPlataforma(plataforma);
                jogo.setCategoria(categoria);
                jogo.setEstudio(estudio);
                jogo.setPreco(preco);
                jogo.setDataLancamento(dataLancamento);
                jogo.setFinalizado(isFinalizado);

                listaJogos.add(jogo);

            }

            ConexaoSQLite.fecharConexao();
            return listaJogos;

        } catch (SQLException e) {
            System.out.println("Erro na Leitura dos Dados!");
            e.printStackTrace();
            return null;
        }
    }

    // BOTAO SALVAR
    public void salvar(Jogo jogo) {

        //System.out.println(jogo);

        // Instrução SQL para cadastrar um novo jogo no banco de dados
        String sql = "INSERT INTO tb_games (titulo, plataforma," +
                "estudio, categoria, preco, data_lancamento," +
                "finalizado)" +
                "VALUES (?,?,?,?,?,?,?)";

        System.out.println(sql);

        // Preparar a instrução SQL para ser enviada para o banco atraves de uma conexão
        try {
            PreparedStatement  stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, jogo.getTitulo());
            stm.setString(2, jogo.getPlataforma());
            stm.setString(3, jogo.getEstudio());
            stm.setString(4, jogo.getCategoria());
            stm.setDouble(5, jogo.getPreco());
            stm.setString(6, jogo.getDataLancamento().toString());
            stm.setInt(7, jogo.isFinalizado() ? 1 : 0);
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

        String sql = "DELETE FROM tb_games WHERE id = ?";

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
    public void editar(Jogo jogo) {
        String sql = "UPDATE tb_games SET " +
                "titulo = ?," +
                "plataforma = ?," +
                "estudio = ?," +
                "categoria = ?," +
                "preco = ?," +
                "data_lancamento = ?," +
                "finalizado = ? " +
                "WHERE id = ?;";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, jogo.getTitulo());
            stm.setString(2, jogo.getPlataforma());
            stm.setString(3, jogo.getEstudio());
            stm.setString(4, jogo.getCategoria());
            stm.setDouble(5, jogo.getPreco());
            stm.setString(6, jogo.getDataLancamento().toString());
            stm.setInt(7, jogo.isFinalizado() ? 1 : 0);
            stm.setInt(8, jogo.getId());
            stm.executeUpdate();
            ConexaoSQLite.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Erro na gravação!");
            e.printStackTrace();
        }
    }
}
