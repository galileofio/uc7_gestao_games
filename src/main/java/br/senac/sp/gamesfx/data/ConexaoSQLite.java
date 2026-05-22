package br.senac.sp.gamesfx.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQLite {

    private static Connection conexao;

    public static Connection getConexao() {

        // String de conexão - URL do banco de dados -
        //String url = "jdbc:sqlite:/C:\Users\edvaldo.asilva4\Documents\EdvaldoAleixo\Banco_de_Dados\BD_UC7\BD_UC7.db";
       String url = "jdbc:sqlite:/c:\\Users\\edvaldo.asilva4\\banco_de_dados\\db_games.db";

        try {
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão efetuada com sucesso");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar o Banco de Dados");
            e.printStackTrace();
            return null;
        }
    }

    public static void fecharConexao(){

        try {
            if (!conexao.isClosed()){
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
