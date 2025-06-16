

package ProjetoCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
class CriarTabelaLivros {
    public void criar(){
        
        ConexaoBD conexaoBD = new ConexaoBD();
        Connection conexao = conexaoBD.conectar();
        
        if(conexao != null){
            String sql = "create table if not exists Livros ("
                    + "id int not null auto_increment,"
                    + "titulo varchar(50),"
                    + "genero varchar (50),"
                    + "primary key (id)"
                    + ");";
            
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.executeUpdate();
                System.out.println("Tabela 'Livros' criada com sucesso!");
            }catch(SQLException e){
                System.out.println("Erro ao criar a tabela 'Livros'.");
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
