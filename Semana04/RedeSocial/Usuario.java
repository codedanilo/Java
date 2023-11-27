import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<String> listaPostagens;
    private List<Usuario> amigos;
    private static List<Usuario> usuarios = new ArrayList<>();

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.listaPostagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    // Getters e Setters

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }


    public List<Usuario> getAmigos() {
        return amigos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para adicionar uma nova postagem à lista
    public void novaPostagem(String postagem) {
        listaPostagens.add(postagem);
    }

    public void removerPostagem(int indice) {
        if (indice >= 0 && indice < listaPostagens.size()) {
            listaPostagens.remove(indice);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void listarPostagens() {
        if (listaPostagens.isEmpty()) {
            System.out.println("O usuário não possui postagens.");
        } else {
            System.out.println("Postagens do usuário " + nome + ":");
            for (int i = 0; i < listaPostagens.size(); i++) {
                System.out.println(i + ". " + listaPostagens.get(i));
            }
        }
    }

     // Métodos de interação com amizades
    public void criarAmizade(Usuario amigo) throws Exception {
        if (this.equals(amigo)) {
            throw new Exception("Não é possível adicionar a si mesmo como amigo.");
        }

        
        if (this.amigos.contains(amigo)) {
            throw new Exception("Esta amizade já existe.");
        }

        this.amigos.add(amigo);
        amigo.amigos.add(this); // Criando a amizade inversa
    }

    public void removerAmizade(Usuario amigo) throws Exception {
        if (!this.amigos.contains(amigo)) {
            throw new Exception("Esta amizade não existe.");
        }

        this.amigos.remove(amigo);
        amigo.amigos.remove(this); // Removendo a amizade inversa
    }
}

    
