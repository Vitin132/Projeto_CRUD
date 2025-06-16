

package ProjetoCRUD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class Truncate {
    
    public void truncate(){
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        
        if(conexao != null){
            String sql = "truncate table livros;";
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    
}
