package Classes;

import java.io.Serializable;
import java.util.ArrayList;

public class BancoDAO implements Serializable{
    static ArrayList<Pessoa> pessoas;
    static ArrayList<Carro> carros;
    
    private static BancoDAO banco;

    private BancoDAO(){
        pessoas = new ArrayList<>();
        carros = new ArrayList<>();
    }

    public static BancoDAO getInstance(){
        if (banco == null) {
            banco = new BancoDAO();
        }
        return banco;
    }

    public ArrayList<Pessoa> getPessoas(){
        return pessoas;
    }

    public ArrayList<Carro> getCarros(){
        return carros;
    }

}