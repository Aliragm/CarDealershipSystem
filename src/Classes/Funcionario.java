package Classes;

import java.util.Date;

public class Funcionario extends Pessoa {
    private double salario;
    private Date dataIngresso;

    public Funcionario(String nome, String cpf, Date dataNascimento, double salario, Date dataIngresso) {
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

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
}