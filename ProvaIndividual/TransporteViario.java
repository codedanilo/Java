import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class TransporteViario {
    private List<Veiculo> veiculos;
    private List<Motorista> motoristas;
    private List<Cobrador> cobradores;
    private List<Passageiro> passageiros;
    private List<PontoParada> pontosDeParada;
    private List<Trajeto> trajetos;
    private List<Jornada> jornadas;
    private List<Checkpoint> checkpoints;
        

    // Getters, setters e métodos específicos aqui

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public void setCobradores(List<Cobrador> cobradores) {
        this.cobradores = cobradores;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public void setPontosDeParada(List<PontoParada> pontosDeParada) {
        this.pontosDeParada = pontosDeParada;
    }

    public void setTrajetos(List<Trajeto> trajetos) {
        this.trajetos = trajetos;
    }

    public void setJornadas(List<Jornada> jornadas) {
        this.jornadas = jornadas;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public List<Cobrador> getCobradores() {
        return cobradores;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public List<PontoParada> getPontosDeParada() {
        return pontosDeParada;
    }

    public List<Trajeto> getTrajetos() {
        return trajetos;
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    // Classe Veiculo (Destinada para cadastro dos veículos)
    public class Veiculo {
        private String placa;


        //Método para cadastro dos veículos

        public void cadastrarVeiculo(Veiculo novoVeiculo) {
            if (veiculos == null) {
                veiculos = new ArrayList<>();
            }
            veiculos.add(novoVeiculo);
        }

        // Getters e Setters
        public String getPlaca() {
            return placa;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        
    }

    // Classe Motorista (Destinada para cadastro dos motoristas)
    public class Motorista {
        private String nome;
        private String cnh;

        // Métodos para cadastrar motorista
        public void cadastrarMotorista(Motorista novoMotorista) {
            if (motoristas == null) {
                motoristas = new ArrayList<>();
            }
            motoristas.add(novoMotorista);
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }
        public String getCnh() {
            return cnh;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setCnh(String cnh) {
            this.cnh = cnh;
        }

        
    }

    // Classe Cobrador (Destinada para cadastro do cobrador)
    public class Cobrador {
        private String nome;
        private String cpf;

        //Método para cadastrar cobrador
        public void cadastrarCobrador(Cobrador novoCobrador) {
            if (cobradores == null) {
                cobradores = new ArrayList<>();
            }
            cobradores.add(novoCobrador);
        }

        // Getters e Setters
        public String getNome() {
            return nome;
        }
        public String getCpf() {
            return cpf;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        
    }

    // Classe Passageiro (Destinada para cadastro do passageiro)
    public class Passageiro {
        private String tipoCartao;

        // Método para cadastrar passageiros
        public void cadastrarPassageiro(Passageiro novoPassageiro) {
            if (passageiros == null) {
                passageiros = new ArrayList<>();
            }
            passageiros.add(novoPassageiro);
        }


        // Getters e Setters
        public String getTipoCartao() {
            return tipoCartao;
        }

        public void setTipoCartao(String tipoCartao) {
            this.tipoCartao = tipoCartao;
        }
        
                
    }

    // Classe PontoParada (Destinada para cadastro do Ponto de Parada)
    public class PontoParada {
        private String nome;
        private String localizacao;
        // Outros atributos e métodos


        // Getters e Setters
        public String getNome() {
            return nome;
        }
        public String getLocalizacao() {
            return localizacao;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public void setLocalizacao(String localizacao) {
            this.localizacao = localizacao;
        }

        
    }

    // Classe Trajeto (Destinada para cadastro e controle do trajeto)
    public class Trajeto {
        private List<Trecho> trechos;
        private List<PontoParada> pontosDeParada;
        private int intervaloEstimado;
        private Date dataInicio; // Adicionando data de início ao Trajeto
        private Date dataFim; // Adicionando data de fim ao Trajeto

        // Getters e Setters para os novos atributos
        public Date getDataInicio() {
            return dataInicio;
        }

        public void setDataInicio(Date dataInicio) {
            this.dataInicio = dataInicio;
        }

        public Date getDataFim() {
            return dataFim;
        }

        public void setDataFim(Date dataFim) {
            this.dataFim = dataFim;
        }

        public List<Trecho> getTrechos() {
            return trechos;
        }

        public List<PontoParada> getPontosDeParada() {
            return pontosDeParada;
        }

        public int getIntervaloEstimado() {
            return intervaloEstimado;
        }

        public void setTrechos(List<Trecho> trechos) {
            this.trechos = trechos;
        }

        public void setPontosDeParada(List<PontoParada> pontosDeParada) {
            this.pontosDeParada = pontosDeParada;
        }

        public void setIntervaloEstimado(int intervaloEstimado) {
            this.intervaloEstimado = intervaloEstimado;
        }
        
        
    }


    // Classe Trecho (Destinado para obter a origem e destino do trecho)
    public class Trecho {
        private PontoParada origem;
        private PontoParada destino;
        // Outros atributos e métodos


        // Getters e Setters
        public PontoParada getOrigem() {
            return origem;
        }
        public PontoParada getDestino() {
            return destino;
        }
        public void setOrigem(PontoParada origem) {
            this.origem = origem;
        }
        public void setDestino(PontoParada destino) {
            this.destino = destino;
        }

    }

    // Classe Jornada (Destinada para cadastro e controle da jornada)
    public class Jornada {
        private Trajeto trajeto;
        private Motorista motorista;
        private Cobrador cobrador; // Pode ser null se não houver cobrador
        private Veiculo veiculo;
        private Date inicioJornada;
        // Outros atributos e métodos

        // Getters e Setters
        public Trajeto getTrajeto() {
            return trajeto;
        }
        public Motorista getMotorista() {
            return motorista;
        }
        public Cobrador getCobrador() {
            return cobrador;
        }
        public Veiculo getVeiculo() {
            return veiculo;
        }
        public Date getInicioJornada() {
            return inicioJornada;
        }
        public void setTrajeto(Trajeto trajeto) {
            this.trajeto = trajeto;
        }
        public void setMotorista(Motorista motorista) {
            this.motorista = motorista;
        }
        public void setCobrador(Cobrador cobrador) {
            this.cobrador = cobrador;
        }
        public void setVeiculo(Veiculo veiculo) {
            this.veiculo = veiculo;
        }
        public void setInicioJornada(Date inicioJornada) {
            this.inicioJornada = inicioJornada;
        }

        
    }

    // Classe Checkpoint (Destinada para obter a hora de registro do Checkpoint)
    public class Checkpoint {
        private Date horaRegistro;
        // Outros atributos e métodos


        // Getters e Setters
        public Date getHoraRegistro() {
            return horaRegistro;
        }

        public void setHoraRegistro(Date horaRegistro) {
            this.horaRegistro = horaRegistro;
        }

       
    }
}

