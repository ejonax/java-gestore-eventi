
import java.util.ArrayList;
import java.util.List;

public class esercizio {
    /*method che prende in ingresso due liste di interi, deve ritornare una sola lista con gli elementi in comune tra le due liste */

    public static void main(String[] args) {
            
            List<Integer> lista1 = new ArrayList<Integer>();
            lista1.add(1);
            lista1.add(2);
            lista1.add(45);
            lista1.add(67);

            List<Integer> lista2 = new ArrayList<Integer>();
            lista2.add(1);
            lista2.add(2);
            lista2.add(98);
            lista2.add(345);
            lista2.add(5);


           elementiInComune(lista1,lista2);
           System.out.println(elementiInComune(lista1,lista2));
    }

    public static List<Integer> elementiInComune(List<Integer> listaA, List<Integer> listaB){
        List<Integer> listaC = new ArrayList<Integer>() ;
    
        /*
          ListaA [1,2,45,67] 
          ListaB [1,2,98,345,5]
          ListaC [1,2]
        */

        for(int i=0;i<listaA.size();i++){
            for (int j=0;j<listaB.size();j++)
            {
               if(listaA.get(i).equals(listaB.get(j)))
               {
                listaC.add(listaA.get(i));
               }
            }
        }
        return listaC;
    }
}
