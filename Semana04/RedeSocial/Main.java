import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        List<Sessao> sessoes = new ArrayList<>();
        

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(usuarios, sessoes);
        interfaceUsuario.exibirMenuInicial();
        
    }
}
