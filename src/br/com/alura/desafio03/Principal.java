/*
    Desafio 03 da Alura na linguagem Java.
    Desenvolvido por Marcos Ferreira Shirafuchi
    Desafio:

    Vamos implementar uma aplicação para registrar compras em um cartão de crédito.

    🔨 Objetivos do projeto

    - Criar uma classe que represente uma compra (descrição e valor);
    - Criar uma classe que represente um cartão de crédito (limite, saldo e lista de compras), sendo que ela deve
    possuir um método para registrar uma compra;
    - Criar uma classe com o método main, seguindo os seguintes objetivos:
        1 - Solicitar que o usuário informe o limite do cartão de crédito;
        2 - Criar um objeto cartão de crédito com o limite informado;
        3 -Solicitar que o usuário informe a descrição e o valor da compra;
        4 - Criar um objeto compra com a descrição e valor informados;
        5 - Registrar a compra no cartão de crédito e imprimir na tela se ela foi realizada ou não (de acordo com
        o saldo remanescente);
        6 - Perguntar se o usuário deseja registrar uma nova compra ou finalizar;
        7- Caso ele deseje continuar, repetir os passos de 3 a 6, caso não, imprimir na tela o saldo final do
        cartão e a lista de compras realizadas, ordenadas pelo valor.

    Observações:

    - Utilize a classe Scanner para fazer a leitura das informações do usuário;
    - Utilize construtores nas classes para passar as informações ao instanciar um objeto.
* */
package br.com.alura.desafio03;

import br.com.alura.desafio03.cartao.CartaoDeCredito;
import br.com.alura.desafio03.compra.Compra;


import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao=0;
        double limiteCartao=0;
        List<Compra> listaCompra = new ArrayList<>();
        boolean verificaCompra = false;

        //Do while faz o usuário digitar o valor do limite do cartão maior do que zero
        do {
            System.out.print("Digite o limite do cartão: ");
            limiteCartao = entrada.nextDouble();
            //Se o usuário digitar o valor do limite menor ou igual a zero, uma mensagem é emitida
            if(limiteCartao<=0){
                System.out.println("O valor do limite do cartão tem que ser maior do que zero!");
            }
        }while(limiteCartao<=0);
        //Coloca o limite no cartão de crédito
        CartaoDeCredito cartao = new CartaoDeCredito(limiteCartao);
        //Nesse do while só continua executando, quando o usuário continuar digitando 1 para comprar os items da compra
        do {
                    //O usuário digita o nome da compra
                    System.out.print("Digite a descrição da compra: ");
                    String descricaoDaCompra = entrada.next();
                    //Colocar a primeira letra maiuscula
                    descricaoDaCompra = descricaoDaCompra.substring(0, 1).toUpperCase() + descricaoDaCompra.substring(1);
                    double valorCompra = 0;
                    //Do while obriga o usuário a digitar o valor da compra maior do que zero
                    //O usuário só vai continuar no do while enquando digitar o valor da comprar menor ou igual a zero
                    do {
                        System.out.print("Digite o valor da compra: ");
                        valorCompra = entrada.nextDouble();
                        //Se o valor da compra for menor ou igual zero
                        if (valorCompra <=0) {
                            System.out.println("O valor da compra tem que maior do zero!");
                        }
                    }while (valorCompra <=0);
                    //Depois de digitar os dados da compra
                    Compra compra1 = new Compra(descricaoDaCompra,valorCompra);

                    //Se o cartão tiver limite, a compra é registrada e variavel verificaCompra recebe true
                    if(cartao.verificaLimite(valorCompra)){

                        verificaCompra =  cartao.lancamentoDeCompras(valorCompra,compra1);
                        System.out.println("Compra realizada!");
                        System.out.print("Digite 0 para sair ou 1 para continuar: ");
                        opcao = entrada.nextInt();
                    }else {
                        //Senão a variavel verificaCompra continua com false e a opção recebe zero
                        System.out.println("Saldo insuficiente!");
                        opcao = 0;
                    }

        }while (opcao==1);
        //Impressão da compra
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        if(verificaCompra == false) {
            System.out.println("Não há compras no cartão");
            System.out.println("\n***********************");
        }else{

            Collections.sort(cartao.getComprasNoCartão());
            for (Compra c : cartao.getComprasNoCartão()) {
                System.out.println(c.getDescricao() + " - R$ " +c.getValor());
            }
            System.out.println("\n***********************");

        }
        //Mostra o limite do cartão
        System.out.printf("\nSaldo do cartão: R$ %.2f", cartao.getSaldoCartao());

    }
}
