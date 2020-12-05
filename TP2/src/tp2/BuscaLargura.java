/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author luisa
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaLargura {
    //declaração de variáveis globais Queue<No> e ArrayList<No>.
    private Queue<No> fronteira = new LinkedList<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    
    //construtor padrão de Busca Largura. É fila, FIFO (First In, First Out
    // (Primeiro que entra, primeiro que sai).
    public BuscaLargura() {

    }

    public boolean Busca(No noPrimeiro) {

       fronteira.add(noPrimeiro);

        No noDeBusca;

        while (!fronteira.isEmpty()) {

            //para remover o no da fronteira (primeiro número da fronteira).
            //Tira da fronteira e add em removidos da fronteira.
            noDeBusca = fronteira.poll();

            removidosFronteira.add(noDeBusca);
            //para testar se o no removido é o objetivo. Retorna o valor e sai do loop.
            if (noDeBusca.getEstado().Objetivo(noDeBusca.getEstado().getMatriz())) {
                    System.out.println("\nEncontrei: \n");
                    ImprimeCaminho(noDeBusca);
                    // se verdadeiro, conseguiu ordenar o estado inicial e encontrar o objetivo.
                    return true;
                }
                           
             
                //para gerar sucessores e, logo após, inserí-los na fronteira.
                fronteira.addAll(noDeBusca.GeraSucessores(removidosFronteira.size() - 1));
         
        }
        //não encontrou o objetivo, por erro do dispositivo ou por não existir solução.
        return false;
    }
    
    //só vai imprimir o caminho se tiver encontrado o objetivo.
    public void ImprimeCaminho(No no){ 
        
        // Se o nó for o objetivo, mostra todas as trocas de posições.
        if (no.getPai()==-1) {
            System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
            return;
            
        }else{
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
        }
        System.out.println(" Nó Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
    }
    
    //get busca o valor , set insere.
    public Queue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Queue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
