

package ProjetoCRUD;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class main {
    public static void main(String[] args) {
        
        InserirLivro inserir = new InserirLivro();
        //InserirAutor inserirA = new InserirAutor();
        AtualizarLivro atualizar = new AtualizarLivro();
        DeletarLivro deletar = new DeletarLivro();
        ConsultarLivros consultar = new ConsultarLivros();
        CriarTabelaLivros tabela = new CriarTabelaLivros();
        //CriarTabelaAutores tabelaA = new CriarTabelaAutores();
        
        Truncate truncate = new Truncate();
        Ordenar ordenar = new Ordenar();
        
        
        
        Scanner sc = new Scanner(System.in);
        
        tabela.criar();
        
        int op = -1;

        while (op != 0) {
            System.out.println("\n ## MENU PROJETO LIVROS ##");
            System.out.println("1. Inserir livro");
            System.out.println("2. Atualizar livro");
            System.out.println("3. Deletar livro");
            System.out.println("4. Consultar livro");
            System.out.println("5. Limpar tabela");
            System.out.println("6. Consultar os livros em ordem alfabética");
            System.out.println("7. Deletar livro por gênero");
            System.out.println("8. Selecionar livro por gênero");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Título: ");
                    String tituloInserir = sc.nextLine();
                    System.out.println("Gênero: ");
                    String generoInserir = sc.nextLine();
                    inserir.inserir(tituloInserir, generoInserir);
                    break;
                case 2:
                    System.out.println("Título do livro para atualizar o gênero:  ");
                    String tituloAtualizar = sc.nextLine();
                    System.out.println("Novo Gênero: ");
                    String novoGenero = sc.nextLine();
                    atualizar.atualizarGenero(tituloAtualizar, novoGenero);
                    break;
                case 3:
                    System.out.println("Título do Livro para deletar: ");
                    String tituloDeletar = sc.nextLine();
                    deletar.deletar(tituloDeletar);
                    break;
                case 4:
                    consultar.consultar();
                    break;
                case 5:
                    truncate.truncate();
                    break;
                case 6:
                    ordenar.consultar();
                    break;
                case 7:
                    System.out.println("Gênero dos livros para deletar: ");
                    String deletarGenero = sc.nextLine();
                    deletar.deletarGenero(deletarGenero);
                    break;
                case 8:
                    System.out.println("Digite o gênero dos livros: ");
                    String nGenero = sc.nextLine();
                    consultar.consultarPorGenero(nGenero);
                    break;
                case 0:
                    System.out.println("Encerrando o programa: ");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        }
        sc.close();
        
    }
}
