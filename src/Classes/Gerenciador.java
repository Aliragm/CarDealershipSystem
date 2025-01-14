package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerenciador {

    private BancoDAO bancoDeDados = BancoDAO.getInstance();

    public BancoDAO getBancoDeDados() {
        return bancoDeDados;
    }

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

    public ArrayList<String> getChassisShowroom(){
        ArrayList<String> chassis = new ArrayList<>();
        for (Carro c : bancoDeDados.getCarros()) {
            if (c.getIsShowroom()){
                chassis.add(c.getChassi());
            }   
        }
        return chassis;
    }

    public ArrayList<String> getNomesShowroom(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Carro c : bancoDeDados.getCarros()) {
            if(c.getIsShowroom()){
                nomes.add(c.getNome());
            }
        }
        return nomes;
    }

    public ArrayList<String> getChassisReserva(){
        ArrayList<String> chassis = new ArrayList<>();
        for (Carro c : bancoDeDados.getCarros()) {
            if (!c.getIsShowroom()){
                chassis.add(c.getChassi());
            }   
        }
        return chassis;
    }

    public ArrayList<String> getNomesReserva(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Carro c : bancoDeDados.getCarros()) {
            if(!c.getIsShowroom()){
                nomes.add(c.getNome());
            }
        }
        return nomes;
    }

    public ArrayList<String> getNomesClientes(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Pessoa p : bancoDeDados.getPessoas()) {
            if (p instanceof Cliente) {
                nomes.add(p.getNome());
            }
        }
        return nomes;
    }

    public ArrayList<String> getCpfClientes(){
        ArrayList<String> cpfs = new ArrayList<>();
        for (Pessoa p : bancoDeDados.getPessoas()) {
            if (p instanceof Cliente) {
                cpfs.add(p.getCpf());
            }
        }
        return cpfs;
    }

    public ArrayList<String> getNomesFuncionarios(){
        ArrayList<String> nomes = new ArrayList<>();
        for (Pessoa p : bancoDeDados.getPessoas()) {
            if (p instanceof Funcionario) {
                nomes.add(p.getNome());
            }
        }
        return nomes;
    }

    public ArrayList<String> getCpfFuncionarios(){
        ArrayList<String> cpfs = new ArrayList<>();
        for (Pessoa p : bancoDeDados.getPessoas()) {
            if (p instanceof Funcionario) {
                cpfs.add(p.getCpf());
            }
        }
        return cpfs;
    }
}