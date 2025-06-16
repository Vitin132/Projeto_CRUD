

package ProjetoCRUD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
class DeletarLivro {
    
    public void deletar(String titulo){
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        
        if(conexao != null){
            String sql = "delete from Livros where titulo = ?";
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, titulo);
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    public void deletarGenero(String genero){
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        
        if(conexao != null){
            String sql = "delete from Livros where genero = ?";
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, genero);
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    
}
