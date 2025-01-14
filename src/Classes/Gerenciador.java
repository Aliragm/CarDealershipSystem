package Classes;

import java.time.LocalDate;

public class Gerenciador {

    BancoDAO bancoDeDados = BancoDAO.getInstance();

    public void cadastroCarro( String marca,  String cor, int cavalos, int ano, String tipo,
     String nome, boolean isUsado, boolean isShowroom, String chassi){
        Carro carro = new Carro(marca, cor, cavalos, ano, tipo, nome, isUsado, isShowroom, chassi);
        bancoDeDados.getCarros().add(carro);
    }

    public void cadastroCliente(String nome, String cpf, LocalDate dataNascimento, String endereco){
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
        bancoDeDados.getPessoas().add(cliente);
    }

    public void cadastroFunc(String nome, String cpf, LocalDate dataNascimento, double salario,
     LocalDate dataIngresso){
        Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, salario, dataIngresso);
        bancoDeDados.getPessoas().add(funcionario);
    }

    public void removerCarro(String chassi){
        Carro excluido = null;
        for (Carro c : bancoDeDados.getCarros()) {
            if (c.getChassi().equals(chassi)) {
                excluido = c;
                break;
            }
        }
        if (bancoDeDados.getCarros().remove(excluido)) {
            System.out.println("excluido");
        }
        else{
            System.out.println("nao havia nada a ser excluido");
        }
    }

    public void removerCliente(String cpf){
        Cliente excluido = null;
        for (Pessoa p : bancoDeDados.getPessoas()){
            if (p instanceof Cliente) {
                if (p.getCpf().equals(cpf)) {
                    excluido = (Cliente)p;
                }
            }
            else{
                continue;
            }
        }
        if (bancoDeDados.getPessoas().remove(excluido)) {
            System.out.println("excluido com sucesso");
        }else{
            System.out.println("nao havia nada a ser excluido");
        }
    }

    public void removerFunc(String cpf){
        Funcionario excluido = null;
        for (Pessoa p : bancoDeDados.getPessoas()){
            if (p instanceof Funcionario) {
                if (p.getCpf().equals(cpf)) {
                    excluido = (Funcionario)p;
                }
            }
            else{
                continue;
            }
        }
        if (bancoDeDados.getPessoas().remove(excluido)) {
            System.out.println("excluido com sucesso");
        }else{
            System.out.println("nao havia nada a ser excluido");
        }
    }

    
}