

package ProjetoCRUD;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Aluno
 */
class InserirLivro {
    
    public void inserir(String titulo, String genero){
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        if(conexao != null){
            String sql = "insert into Livros (titulo, genero) values (?,?)";
            try(PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setString(1, titulo);
                ps.setString(2, genero);
                ps.executeUpdate();
                System.out.println("Livro inserido com sucesso!");
            }catch(SQLException e){
                System.out.println("Erro ao inserir o Livro!");
                e.printStackTrace();
            }finally{
                try{
                    conexao.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        
        
    }
    
    
    
}
