import javax.swing.*;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {
    private  BilheteUnico[] bilhete=new BilheteUnico[3];
    private int index=0;
    public  void menuPrincipal() {

        int opcao;
        String menu=" 1-administrador\n2-usuario\n3-finalizar";


        do{
            opcao=parseInt(showInputDialog(menu));
            if(opcao<1|| opcao>3){
                showMessageDialog(null,"opção invalida");
            }else{
                switch (opcao){
                    case 1:
                        menuAdministrador();
                        break;
                    case 2:
                        menuUsuario();
                        break;


                }
            }
        }while (opcao!=3);
    }
    private void menuAdministrador(){
        int opcao;
        String menu="1.emitir Bihete\n 2.listar bilhete\n3.remover bilhete\n4.sair";
        do{
            opcao=Integer.parseInt(showInputDialog(menu));
            if(opcao<1 || opcao>4){
                showMessageDialog(null,"opcao invalida");
            }else {
                switch (opcao){
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        listarBilhete();
                        break;
                }
            }
        }while (opcao!=4);
    }
    private void emitirBilhete() {
        String nome, perfil;
        long cpf;

        if (index < bilhete.length) {
            nome = showInputDialog("Nome do usuario:" );
            cpf = parseInt(showInputDialog("cpf:" ));
            perfil = showInputDialog("perfil-->professor/estudante ou comum:" );
            bilhete[index]=new BilheteUnico(new Usuario(nome,cpf,perfil));
            index++;


        }else{
            showMessageDialog(null, "entre em contato com a adm");
        }

}
    private void listarBilhete() {
        DecimalFormat df=new DecimalFormat("0.00");
        String aux="";
     for (int i=0;i<index;i++){
         aux+="numero do bilhete:"+bilhete[i].numero+"\n";
         aux+="nome do usuario:"+bilhete[i].usuario.nome+"\n";
         aux+="Perfil(tipo de tarifa)-"+bilhete[i].usuario.perfil+"\n";
         aux+="saldo R$"+df.format(bilhete[i].saldo)+"\n";
         aux+="--------------------------------\n";
     }
     showMessageDialog(null,aux);
    }
    private void menuUsuario(){
        int opcao;
        String menu="1.saldo\n2.carregar bilhete\n3.passar na catraca\n4.sair";
        do{
            opcao=parseInt(showInputDialog(menu));

            if(opcao<1||opcao>4){
                showMessageDialog(null,"opcao invalida"); }
            else{
                switch (opcao){
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultarSaldo();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;
                }
            }
        } while(opcao!=4);
    }
    private void carregarBilhete(){
       int posicao=pesquisar();
       double valor;
       if(posicao!=-1){
           valor=parseDouble(showInputDialog("valor da recarga"));
           bilhete[posicao].carregarB(valor);
       }
    }
    private void consultarSaldo(){
        int posicao=pesquisar();
        if(posicao!=-1){
            showMessageDialog(null,"saldo R$"+bilhete[posicao].consultarSaldo());
        }
    }
    private void passarNaCatraca(){
        int posicao=pesquisar();
        if(posicao!=-1){
           bilhete[posicao].pagarCatraca();
        }
    }
    private int pesquisar(){
        int posicao=-1;
        long cpf=parseLong(showInputDialog("CPF:"));
        for(int i=0;i<index;i++){
            if(bilhete[i].usuario.cpf==cpf){
                posicao=i;
                return posicao;
            }
        }
        showMessageDialog(null,"cpf nao encontrado");
        return posicao;
    }

}


