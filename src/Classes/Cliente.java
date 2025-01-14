package Classes;

import java.util.Date;

public class Cliente extends Pessoa {
    private String endereco;
    private int fidelidade;

    public Cliente(String nome, String cpf, Date dataNascimento, String endereco) {
        super(nome, cpf, dataNascimento);
        this.endereco = endereco;
        this.fidelidade = 0; // Fidelidade começa em 0
    }

    // Getters e setters para endereco e fidelidade
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getFidelidade() {
        return fidelidade;
    }

    // Método para aumentar a fidelidade do cliente
    public void aumentarFidelidade(int pontos) {
        this.fidelidade += pontos;
    }
}