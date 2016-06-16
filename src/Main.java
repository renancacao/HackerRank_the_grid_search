import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

    static String[] G;
    static String[] P;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            
            G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            
            int r = in.nextInt();
            int c = in.nextInt();
            P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
            int linG = 0;
            int linP = 0;
            //int apartir = 0;
            
            boolean achou = true;
            while(achaPadrao(linG,linP,0,C,-1)==false){
                
            	//nao tem ocorrencia ate agora, começo a procurar na proxima linha
                linG++;
                linP=0;
                
                if (linG+r>R){
                	//nao tem mais nao, pode acreditar amigao
                	achou = false;
                	break;
                }
                
            }
            
            if(achou)
            {System.out.println("YES");}
            else
            {System.out.println("NO");}
            
            
        }
        
        
    }
    
    static boolean achaPadrao(int linG, int linP, int apartir, int max, int idCerto)
    {
        
        if (linG>=G.length|| linP>=P.length){return false;}
        
        int id = G[linG].indexOf(P[linP],apartir);
        //verifico o id certo se é o caso
        if(idCerto!=-1 && idCerto!=id){return false;}
        if (id>=0 && id<max ){
            //achou
            
            //se achou a ultima P entao blz!
            if(linP == P.length-1){
            	return true;
            	}
            
            //se nao eu procuro o proximo P na proxima linha dentro da posicao que deve estar
            if( achaPadrao(linG+1,linP+1,id,id+P[linP].length(),id)==false)
            {
            	//nao achou na linah de baixo, verifico se nessa linha existe outra ocorrencia
            	return achaPadrao(linG,linP, id+1, max,-1);
            }
            
            return true;
            
        }
        else return false;
    }
    
}
