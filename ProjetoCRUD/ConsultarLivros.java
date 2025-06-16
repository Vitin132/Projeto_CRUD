package ProjetoCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
class ConsultarLivros {

    public void consultar() {

        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();

        if (conexao != null) {
            String sql = "select * from Livros;";
            try (PreparedStatement ps = conexao.prepareStatement(sql); ResultSet resultado = ps.executeQuery()) {

                System.out.println("Lista de Livros: ");
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String titulo = resultado.getString("titulo");
                    String genero = resultado.getString("genero");
                    System.out.println("ID: " + id + "\nTítulo: " + titulo + "\nGênero: " + genero);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao consultar a tabela Livros!");
                e.printStackTrace();
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void consultarPorGenero(String genero) {

        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();

        if (conexao != null) {
            String sql = "select * from Livros where genero = ?;";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, genero);
                
                try(ResultSet resultado = ps.executeQuery()){
                System.out.println("Lista de Livros por gênero: ");
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String titulo = resultado.getString("titulo");
                    genero = resultado.getString("genero");
                    System.out.println("ID: " + id + "\nTítulo: " + titulo + "\nGênero: " + genero);
                }
                }

            } catch (SQLException e) {
                System.out.println("Erro ao consultar a tabela Livros!");
                e.printStackTrace();
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
