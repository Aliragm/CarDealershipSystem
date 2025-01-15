package Classes;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String endereco;
    private int fidelidade;

    public Cliente(String nome, String cpf, LocalDate dataNascimento, String endereco) {
        super(nome, cpf, dataNascimento);
        this.endereco = endereco;
        this.fidelidade = 0; 
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getFidelidade() {
        return fidelidade;
    }

    public void aumentarFidelidade(int pontos) {
        this.fidelidade += pontos;
    }
}