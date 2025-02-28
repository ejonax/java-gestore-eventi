import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private  String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo){
        this.titolo=titolo;
        this.eventi= new ArrayList<>();
    }
    
    
    public void addEvento(Evento e){
        this.eventi.add(e);
    }

    public List<Evento> eventiNellaData(LocalDate date){
        List<Evento> listaEventi=new ArrayList<Evento>();

         for (int i = 0; i < this.eventi.size(); i++) {
            if(this.eventi.get(i).getData().isEqual(date))
            {
                listaEventi.add(eventi.get(i));
            }
             
         }

        return listaEventi;
    }

    public int numeroTotEventi(){
       int  totEventi=this.eventi.size();
       return totEventi;
    }

    public void svuotaListaEventi(){
        this.eventi.clear();
    }


    public static List<Evento> ordineData(List<Evento> eventi) {
        List<Evento> listaOrdinata = new ArrayList<>(eventi);
        listaOrdinata.sort(Comparator.comparing(b -> b.getData()));
        return listaOrdinata;
    }
        
    public String listaProgramma(){
       
        LocalDate  elementoData;
        String elementoTitolo;
       
        List<Evento> nuovaLista;
        nuovaLista=ordineData(eventi);
       
        StringBuilder stringaLunga = new StringBuilder();
        stringaLunga.append("Titolo Programma =[ ").append(getTitolo());
        stringaLunga.append(" ]\n");

        for (int i = 0; i < nuovaLista.size(); i++) {
            stringaLunga.append("Evento{");

            elementoData = nuovaLista.get(i).getData();
            elementoTitolo=nuovaLista.get(i).getTitolo();
              
            stringaLunga.append(" data=").append(elementoData);
            stringaLunga.append(" - titolo=").append(elementoTitolo); 
            stringaLunga.append("}\n");
        }
        return stringaLunga.toString();
    }

    public String getTitolo() {
        return titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }
}
