

package ProjetoCRUD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
class AtualizarLivro {
    
    public static void atualizarGenero(String titulo, String novoGenero){
        
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        if (conexao != null) {
            String sql = "update Livros set genero = ? where titulo = ?;";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, novoGenero);
                ps.setString(2, titulo);
               
                ps.executeUpdate();
                System.out.println("Livro autalizado com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o livro!");
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
