import java.util.Random;
import java.util.Scanner;

public class BilheteUnico {
    static final double tarifa = 5.20;
    long numero;
    double saldo;
    Usuario usuario;

    public BilheteUnico(Usuario usuario) {
        Random rd = new Random();
        this.numero = rd.nextInt(1000, 10000);
        this.usuario = usuario;

    }

    //metodo para carregar o bilhete
    public void carregarB(double valor) {
        saldo += valor;

    }


    //metodo para consultar o saldo do bilhete
    public double consultarSaldo(){


        return saldo;
    }


    //metodos para simular a passagem na catraca
    public String pagarCatraca(){
        double debito= tarifa/2;
        if(usuario.perfil.equalsIgnoreCase("comum")){
            debito=tarifa;
        }
        if(saldo>=debito){
            saldo-=debito;
            return "passagem liberada";
        }
        return "saldo insuficiente";
    }

}