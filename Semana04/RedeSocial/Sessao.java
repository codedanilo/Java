
import java.time.Duration;
import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sessao {
    public static Sessao logar(Usuario usuario) {
        return new Sessao(usuario);
    }
    public static Sessao autenticar(List<Usuario> usuarios) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite seu nome de usuário: ");
            String nomeUsuario = scanner.nextLine();
    
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
    
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                    return logar(usuario);
                }
            }
    
            throw new Exception("Usuário ou senha incorretos.");
        }
    }
    private LocalDateTime inicio;

    private LocalDateTime fim;

    private Usuario usuarioLogado;

    

    public Sessao(Usuario usuario) {
        this.usuarioLogado = usuario;
        this.inicio = LocalDateTime.now();
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void deslogar() {
        this.fim = LocalDateTime.now();
        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Duração da sessão: " + duracao.getSeconds() + " segundos");
    }
    

    public void criarAmizade(String nomeDoAmigo) throws Exception {
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getNome().equals(nomeDoAmigo)) {
                usuarioLogado.criarAmizade(usuario);
                return;
            }
        }
        throw new Exception("Usuário não encontrado para criar amizade.");
    }

    public void desfazerAmizade(String nomeDoExAmigo) throws Exception {
        for (Usuario usuario : Usuario.getUsuarios()) {
            if (usuario.getNome().equals(nomeDoExAmigo)) {
                usuarioLogado.removerAmizade(usuario);
                return;
            }
        }
        throw new Exception("Usuário não encontrado para desfazer amizade.");
    }

    public void incluirPostagem(String postagem) {
        usuarioLogado.novaPostagem(postagem);
    }

    public void listarPostagens() {
        usuarioLogado.listarPostagens();
    }
    
}
