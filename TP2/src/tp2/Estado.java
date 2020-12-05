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
public class Estado {

    private int matriz[][];
    private int linhaVazia;
    private int colunaVazia;

    public Estado(int mat[][]) {
        this.matriz = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matriz[i][j] = mat[i][j];
                if (this.matriz[i][j] == 0) {
                    this.linhaVazia = i;
                    this.colunaVazia = j;
                }
            }
        }
    }

    public Estado() {
    }

    
    
    

    public boolean Objetivo(int mat[][]) {
        int matrizObjetivo[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.matriz[i][j] != matrizObjetivo[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public Estado GeraSucessor(char mov){
        Estado novoEstado = new Estado(this.matriz);
        int x, y;
        
        switch(mov){
            case 'd':
                
                x = novoEstado.getLinhaVazia();
                y = novoEstado.getColunaVazia()-1;
                if(y<0) return  null;
                
                novoEstado.matriz[x][y+1] = novoEstado.getMatriz()[x][y];
                novoEstado.matriz[x][y] = 0;
                novoEstado.colunaVazia = y;
                return novoEstado;
                
            case 'e':
                
                x = novoEstado.getLinhaVazia();
                y = novoEstado.getColunaVazia()+1;
                if(y>2) return  null;
                
                novoEstado.matriz[x][y-1] = novoEstado.getMatriz()[x][y];
                novoEstado.matriz[x][y] = 0;
                novoEstado.colunaVazia = y;
                return novoEstado;
                
            case 'c':
                
                x = novoEstado.getLinhaVazia()+1;
                y = novoEstado.getColunaVazia();
                if(x>2) return  null;
                
                novoEstado.matriz[x-1][y] = novoEstado.getMatriz()[x][y];
                novoEstado.matriz[x][y] = 0;
                novoEstado.linhaVazia = x;
                
                return novoEstado;
                
            case 'b':
                
                x = novoEstado.getLinhaVazia()-1;
                y = novoEstado.getColunaVazia();
                if(x<0) return  null;
                
                novoEstado.matriz[x+1][y] = novoEstado.getMatriz()[x][y];
                novoEstado.matriz[x][y] = 0;
                novoEstado.linhaVazia = x;
                
                return novoEstado;
        }
        return null;
        
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLinhaVazia() {
        return linhaVazia;
    }

    public void setLinhaVazia(int linhaVazia) {
        this.linhaVazia = linhaVazia;
    }

    public int getColunaVazia() {
        return colunaVazia;
    }

    public void setColunaVazia(int colunaVazia) {
        this.colunaVazia = colunaVazia;
    }

    public void ImprimirEstado(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(this.matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Linha sem nenhum valor:" + this.getLinhaVazia());
        System.out.println("Coluna sem nenhum valor:" + this.getColunaVazia());
        
    }
    

}
