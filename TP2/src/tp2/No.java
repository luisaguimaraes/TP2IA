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

//Comparar se os números estão em suas posições objetivo.
public class No implements Comparable<No>{

    private Estado estado;
    private int profundidade;
    private int pai;
    private int heuristica; //retorno das funções de busca gulosa e A*.
    private int funcaoAvaliacao; //retorno da profundidade do nó e o das funções.
   

    public No(Estado estado, int profundidade, int pai) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        FuncaoHeuristicaPecas();
        FuncaoHeuristicaDistManhattan();
        this.funcaoAvaliacao = this.profundidade + this.heuristica;
             
        
    }

    public No() {
    }

    public ArrayList<No> GeraSucessores(int indexPai) {
        ArrayList<No> sucessores = new ArrayList<>();
        Estado direita;
        Estado esquerda;
        Estado cima;
        Estado baixo;

        
        direita = this.estado.GeraSucessor('d'); 
        if (direita != null) {
            No noSucessor1 = new No(direita, this.profundidade+1, indexPai);
            sucessores.add(noSucessor1);
                   }

        
        esquerda = this.estado.GeraSucessor('e');
        if (esquerda != null) {
            No noSucessor2 = new No(esquerda, this.profundidade+1, indexPai);
            sucessores.add(noSucessor2);
        }

       
        cima = this.estado.GeraSucessor('c');
        if (cima != null) {
            No noSucessor3 = new No(cima, this.profundidade+1, indexPai);
            sucessores.add(noSucessor3);
        }

        
        baixo = this.estado.GeraSucessor('b');
        if (baixo != null) {
            No noSucessor4 = new No(baixo, this.profundidade+1, indexPai);
            sucessores.add(noSucessor4);
        }
        
        return sucessores;
    }
    //Busca A* percorre a função heurística de peças e retorna o número de peças que
    //estão fora do seu lugar objetivo e é utilizada em busca de uma solução mais 
    //eficiente.
    public int FuncaoHeuristicaPecas(){
        heuristica = 0;
        int matrizObjetivo[][] = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};
        for(int i=0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                if (matrizObjetivo[i][j] != this.estado.getMatriz()[i][j]) {
                    heuristica++;
                }
            }
        }  
        return heuristica;
    }
    //Busca Gulosa percorre a função heurística de Manhanttan e soma quantas posições
    //cada valor precisa "andar" para chegar ao seu lugar objetivo um a um.
    public int FuncaoHeuristicaDistManhattan(){
        heuristica = 0;
        int matrizObjetivo[][] = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};
        for(int i=0; i < 3; i++){
            for (int j=0; j < 3; j++) {
                if (matrizObjetivo[i][j] != this.estado.getMatriz()[i][j]) {
                    for(int k=0; k < 3; k++){
                        for (int l=0; l < 3; l++) {
                            if (this.estado.getMatriz()[i][j] == matrizObjetivo[k][l]){
                                heuristica += Math.abs(i - k) + Math.abs(j - l);
                                break;
                            }
                        }
                    }
                }
            }
        }
      return heuristica;   
    }
        
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }
public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public int getFuncaoAvaliacao() {
        return funcaoAvaliacao;
    }

    public void setFuncaoAvaliacao(int funcaoAvaliacao) {
        this.funcaoAvaliacao = funcaoAvaliacao;
    }
    
    //Decisão da posição embasado em seu valor.
    @Override
    public int compareTo(No no) {
        if (this.funcaoAvaliacao > no.funcaoAvaliacao) {
            return 1;
        }else if(this.funcaoAvaliacao < no.funcaoAvaliacao){
            return -1;
        }else{
            return 0;
        }
    }

}
