import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    private List<Usuario> usuarios;
    private List<Sessao> sessoes;
    private Sessao sessaoAtual;

    public InterfaceUsuario(List<Usuario> usuarios, List<Sessao> sessoes) {
        this.usuarios = usuarios;
        this.sessoes = sessoes;
    }

    public void exibirMenuInicial() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("================================");
            System.out.println("|          Menu Inicial:        |");
            System.out.println("--------------------------------");
            System.out.println("|          1. Novo Usuário      |");                        
            System.out.println("|          2. Remover Usuário   |");
            System.out.println("|          3. Logar             |");
            System.out.println("|          0. Sair              |");
            System.out.println("================================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    criarNovoUsuario(scanner);
                    break;
                case 2:
                    removerUsuario(scanner);
                    break;
                case 3:
                    logar(scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void criarNovoUsuario(Scanner scanner) {
        System.out.println("Digite o nome do novo usuário:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do novo usuário:");
        String email = scanner.nextLine();

        System.out.println("Digite a senha do novo usuário:");
        String senha = scanner.nextLine();

        try {
            Usuario novoUsuario = new Usuario(nome, email, senha);
            usuarios.add(novoUsuario);
            System.out.println("Novo usuário criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar novo usuário: " + e.getMessage());
        }
    }

    private void removerUsuario(Scanner scanner) {
        System.out.println("Digite o nome do usuário que deseja remover:");
        String nomeUsuario = scanner.nextLine();

        // Procurar e remover o usuário da lista
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                usuarios.remove(usuario);

                // Remover sessões associadas ao usuário removido
                sessoes.removeIf(sessao -> sessao.getUsuarioLogado().equals(usuario));

                System.out.println("Usuário removido com sucesso!");
                return;
            }
        }

        System.out.println("Usuário não encontrado.");
    }

    private void logar(Scanner scanner) {
        System.out.println("Digite o nome de usuário:");
        String nomeUsuario = scanner.nextLine();
    
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();
    
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                try {
                    Sessao sessaoAtual = Sessao.logar(usuario);
                    sessoes.add(sessaoAtual);
                    exibirMenuSessao(sessaoAtual, scanner); // Alteração aqui
                } catch (Exception e) {
                    System.out.println("Erro ao iniciar sessão: " + e.getMessage());
                }
                return;
            }
        }
    
        System.out.println("Usuário ou senha incorretos.");
    }
    

    private void exibirMenuSessao(Sessao sessao, Scanner scanner) {
        while (true) {
            System.out.println("================================");
            System.out.println("|        Menu da Sessão:       |");
            System.out.println("================================");
            System.out.println("|       1. Listar Postagens    |");
            System.out.println("|       2. Criar Postagem      |");
            System.out.println("|       3. Remover Postagem    |");
            System.out.println("|       4. Criar Amizade       |");
            System.out.println("|       5. Remover Amizade     |");
            System.out.println("|       0. Menu Anterior       |");
            System.out.println("================================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    sessao.getUsuarioLogado().listarPostagens();
                    break;
                case 2:
                    criarPostagem(sessao, scanner);
                    break;
                case 3:
                    removerPostagem(sessao, scanner);
                    break;
                case 4:
                    criarAmizade(sessao, scanner);
                    break;
                case 5:
                    removerAmizade(sessao, scanner);
                    break;
                case 0:
                    sessao.deslogar();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void criarPostagem(Sessao sessao, Scanner scanner) {
        System.out.println("Digite o texto da nova postagem:");
        String textoPostagem = scanner.nextLine();
        sessao.getUsuarioLogado().novaPostagem(textoPostagem);
        System.out.println("Postagem criada com sucesso!");
    }
    
    private void removerPostagem(Sessao sessao, Scanner scanner) {
        System.out.println("Digite o número da postagem que deseja remover:");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        sessao.getUsuarioLogado().removerPostagem(indice);
        System.out.println("Postagem removida com sucesso!");
    }
    
    private void criarAmizade(Sessao sessao, Scanner scanner) {
        System.out.println("Digite o nome do usuário que deseja adicionar como amigo:");
        String nomeAmigo = scanner.nextLine();
    
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeAmigo)) {
                try {
                    sessao.getUsuarioLogado().criarAmizade(usuario);
                    System.out.println("Amizade criada com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao criar amizade: " + e.getMessage());
                }
                return;
            }
        }
    
        System.out.println("Usuário não encontrado.");
    }
    
    private void removerAmizade(Sessao sessao, Scanner scanner) {
        System.out.println("Digite o nome do usuário que deseja remover da lista de amigos:");
        String nomeAmigo = scanner.nextLine();
    
        for (Usuario usuario : sessao.getUsuarioLogado().getAmigos()) {
            if (usuario.getNome().equals(nomeAmigo)) {
                try {
                    sessao.getUsuarioLogado().removerAmizade(usuario);
                    System.out.println("Amizade removida com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao remover amizade: " + e.getMessage());
                }
                return;
            }
        }
    
        System.out.println("Amigo não encontrado na lista de amigos.");
    }
    

    public void removerAmizade(Scanner scanner) {
        System.out.println("Digite o nome do usuário que deseja remover da lista de amigos:");
        String nomeAmigo = scanner.nextLine();

        for (Usuario usuario : sessaoAtual.getUsuarioLogado().getAmigos()) {
            if (usuario.getNome().equals(nomeAmigo)) {
                try {
                    sessaoAtual.getUsuarioLogado().removerAmizade(usuario);
                    System.out.println("Amizade removida com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao remover amizade: " + e.getMessage());
                }
                return;
            }
        }

        System.out.println("Amigo não encontrado na lista de amigos.");
    }
}