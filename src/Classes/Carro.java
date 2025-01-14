package Classes;


public class Carro {
    private String marca;
    private String cor;
    private int cavalos;
    private int ano;
    private String tipo;
    private String nome;
    private boolean isUsado;
    private boolean isShowroom; 
    private String chassi;
    

    public Carro(String marca, String cor, int cavalos, int ano, String tipo, String nome, boolean isUsado, boolean isShowroom, String chassi) {
        this.marca = marca;
        this.cor = cor;
        this.cavalos = cavalos;
        this.ano = ano;
        this.tipo = tipo;
        this.nome = nome;
        this.isUsado = isUsado;
        this.isShowroom = isShowroom;
        this.chassi = chassi;
    }

    public String getChassi() {
        return chassi;
    }


    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isUsado() {
        return isUsado;
    }

    public void setIsUsado(boolean isUsado) {
        this.isUsado = isUsado;
    }

    public boolean getIsShowroom() {
        return isShowroom;
    }

    public void setIsShowroom(boolean isShowroom) {
        this.isShowroom = isShowroom;
    }

}