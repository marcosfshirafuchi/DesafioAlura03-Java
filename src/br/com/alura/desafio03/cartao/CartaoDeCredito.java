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
package br.com.alura.desafio03.cartao;

import br.com.alura.desafio03.compra.Compra;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito  {
    //Propriedades da classe Cartao de Crédito
    private double limiteCartao;
    private double saldoCartao;
    private List<Compra> comprasNoCartão;

    //Método construtor da classe CartaoDeCredito
    public CartaoDeCredito(double limiteCartao) {

        this.limiteCartao = limiteCartao;
        this.saldoCartao = limiteCartao;
        this.comprasNoCartão = new ArrayList<>();

    }


    //Retorna o saldo do cartão
    public double getSaldoCartao() {
        return saldoCartao;
    }

    //Retorna as compras feitas no cartão
    public List<Compra> getComprasNoCartão() {
        return comprasNoCartão;
    }

    //método Lançamento de compras que registra as compras
    public boolean lancamentoDeCompras(double compraValor, Compra compra) {
        //Se o valor da comprar for menor ou igual o saldo do cartão
        if(compraValor<=this.saldoCartao) {
            //Registra as compras e retorna true
            this.saldoCartao -= compraValor;
            this.comprasNoCartão.add(compra);
            return true;
        }else {
            //Senão retornar false
            return false;
        }

    }

    //Verifica o limite do cartão
    public boolean verificaLimite(double compraValor){
        if(compraValor<=this.saldoCartao){
            return true;
        }
        else {
            return false;
        }
    }

}
