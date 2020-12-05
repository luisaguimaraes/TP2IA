/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author Luisa
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main (String[] args) {
        
        //int estadoInicio[][] = {{3, 2, 8}, 
        //                        {1, 6, 0}, 
        //                        {4, 7, 5}}; 
        
        int estadoInicio[][] = {{4, 0, 2}, 
                                {7, 1, 3}, 
                                {8, 5, 6}}; 
        
        
        // 2+1+1+1+1+1+1+1+3 = 12
        
               
        
        Estado e = new Estado(estadoInicio);
        No noPrimeiro = new No(e, 0, -1);
        BuscaProfundidade buscaProfundidade = new BuscaProfundidade();
        BuscaLargura buscaLargura = new BuscaLargura();
        AEstrela buscaAEstrela = new AEstrela ();
        BuscaGulosa buscaGulosa = new BuscaGulosa();

        //1 - Busca em Profundidade
        //2 - Busca Largura
        //3 - Busca A*
        //4 - Busca Gulosa
        int escolherBusca = 4;
        boolean fim = false;

        if (escolherBusca == 1) {
            fim = buscaProfundidade.Busca(noPrimeiro);
            System.out.print("\n=> Busca em Profundidade Limitada");
        }else if (escolherBusca == 2) {
           fim = buscaLargura.Busca(noPrimeiro);
            System.out.print("\n=> Busca Largura");
        }else if (escolherBusca == 3) {
            fim = buscaAEstrela.Busca(noPrimeiro);
            System.out.print("\n=> Busca A*");
            System.out.print ("\n Número de peças fora do lugar:" + noPrimeiro.FuncaoHeuristicaPecas());
        }else if (escolherBusca == 4){
            fim = buscaGulosa.Busca(noPrimeiro);
            System.out.print ("\n Busca Gulosa");
            System.out.print ("\n Distância de Manhattan é:" + noPrimeiro.FuncaoHeuristicaDistManhattan());
                 
        }
        
        if (fim) {
            System.out.println("\n=> Solucionado \n");
        }else{
            System.out.println("\n=> Não Solucionado \n");
        }
        
    }
}      


