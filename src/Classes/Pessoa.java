package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Carro> carrosVendidos; // Lista de carros vendidos

    public Pessoa(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.carrosVendidos = new ArrayList<>();
    }

    // Getters e setters para nome, cpf e dataNascimento
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para adicionar um carro à lista de carros vendidos da pessoa
    public void adicionarCarroVendido(Carro carro) {
        this.carrosVendidos.add(carro);
    }

    // Método para obter a lista de carros vendidos da pessoa
    public List<Carro> getCarrosVendidos() {
        return carrosVendidos;
    }
}