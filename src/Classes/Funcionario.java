package Classes;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private double salario;
    private LocalDate dataIngresso;

    public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salario, LocalDate dataIngresso) {
        super(nome, cpf, dataNascimento);
        this.salario = salario;
        this.dataIngresso = dataIngresso;
    }

    // Getters e setters para salario e dataIngresso
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
}