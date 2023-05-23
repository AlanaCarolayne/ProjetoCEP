package principal;

import classes.Cep;
import classes.GeradorArquivo;
import classes.Requisicao;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        var cep = "";


        while (!cep.equalsIgnoreCase("sair")){
            System.out.println("Digite um cep");
                 cep = sc.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            Requisicao requisicao = new Requisicao();

                try{
                    Cep meuCep = requisicao.consultacep(cep);
                    System.out.println("Informações do cep digitado: \n" + meuCep);
                    GeradorArquivo arquivo = new GeradorArquivo();
                    arquivo.GeraArquivo(meuCep);

                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                    System.out.println("Finalizando o programa");
                }

        }

        sc.close();
    }
}
