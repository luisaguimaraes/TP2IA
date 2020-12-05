/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author luisa
 */
public class BuscaGulosa {
    //declaração de variáveis globais Queue<No> e ArrayList<No>.
    private PriorityQueue<No> fronteira = new PriorityQueue<>();
    private ArrayList<No> noRemovido = new ArrayList<>();
    private final int limite = 2;
    
    //construtor padrão de Busca Gulosa.
    public BuscaGulosa(){
}
    
    public boolean Busca(No noPrimeiro) {

        fronteira.add(noPrimeiro);

        No noBusca;

        while (!fronteira.isEmpty()) {

            //para remover o no da fronteira (primeiro número da fronteira).
            //Tira da fronteira e add em removidos da fronteira.
            noBusca = fronteira.poll();

            noRemovido.add(noBusca);
            //para testar se o no removido é o objetivo. Retorna o valor e sai do loop.
            if (noBusca.getEstado().Objetivo(noBusca.getEstado().getMatriz())) {
                    System.out.println("\nEncontrei: \n");
                    ImprimeCaminho(noBusca);
                     // se verdadeiro, conseguiu ordenar o estado inicial e encontrar o objetivo.
                    return true;
                }
             //para gerar sucessores e, logo após, inserí-los na fronteira.
                fronteira.addAll(noBusca.GeraSucessores(noRemovido.size() - 1));
            

        }
        //não encontrou o objetivo, por erro do dispositivo ou por não existir solução.
        return false;
    }
     //só vai imprimir o caminho se tiver encontrado o objetivo.
    public void ImprimeCaminho(No no){ 
        // Se o nó for o objetivo, mostra todas as trocas de posições.
        if (no.getPai()!=-1){
            ImprimeCaminho(noRemovido.get(no.getPai()));
        }
        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
    }
    
    
    //get busca o valor , set insere.
    public PriorityQueue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(PriorityQueue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getNoRemovido() {
        return noRemovido;
    }

    public void setNoRemovido(ArrayList<No> noRemovido) {
        this.noRemovido = noRemovido;
    }
    
}
