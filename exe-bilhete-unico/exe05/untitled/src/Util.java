import javax.swing.*;

import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class Util {
    private  BilheteUnico[] bilhete=new BilheteUnico[2];
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

}


