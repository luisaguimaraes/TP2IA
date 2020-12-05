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
import java.util.Stack;

public class BuscaProfundidade {
    
    //Stack: pilha. LIFO - Last In , First OuT (Último que entra, primeiro que sai).
    //criando uma fronteira do tipo pilha.
    private Stack<No> fronteira = new Stack<>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    private final int limite = 5;
    //Limite da profundidade de resolução do problema.

    public BuscaProfundidade() {

    }

    public boolean Busca(No noPrimeiro) {
        
        //para remover o no da fronteira (último número da fronteira).
        //Tira da fronteira e add em removidos da fronteira.
       fronteira.push(noPrimeiro);

        No noDeBusca;

        while (!fronteira.isEmpty()) {

            //para remover o no da fronteira.
            noDeBusca = fronteira.pop();

            removidosFronteira.add(noDeBusca);
            //para testar se o no removido é objetivo. Retorna e sai do loop.
            if (noDeBusca.getEstado().Objetivo(noDeBusca.getEstado().getMatriz())) {
                    System.out.println("\nEncontrei: \n");
                    ImprimeCaminho(noDeBusca);
                    return true;
                    // se verdadeiro, conseguiu ordenar o estado inicial e encontrar o objetivo.
                }
            
            //para testar se o valor é menor que o limite.
            if (noDeBusca.getProfundidade() < limite) {
                
                //gera sucessores e depois insere na fronteira
                fronteira.addAll(noDeBusca.GeraSucessores(removidosFronteira.size() - 1));
                               
            }

        }
        return false;
    }
    
    public void ImprimeCaminho(No no){ 
        
           
        if (no.getPai()!=-1){
            ImprimeCaminho(removidosFronteira.get(no.getPai()));
        }
        System.out.println("Pai: " + no.getPai());
            no.getEstado().ImprimirEstado();
       
    }

    public Stack<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Stack<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }

}
