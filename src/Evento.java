
import java.time.LocalDate;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotale;
    private int postiPrenotati;

    //costrutore
    public Evento(String titolo,LocalDate data,int postiTotale) throws Exception {

        LocalDate nowDate = LocalDate.now();                                           
      
        //titolo
       if (titolo.trim().isEmpty()){
          //System.out.println("Per favore inserisci un titolo per l'evento.");
           throw new IllegalArgumentException("Per favore inserisci un titolo per l'evento.");
       }else this.titolo=titolo;
    
        //data
       if(dataPassata(nowDate,data)){
             //System.out.println("La data dell'evento: " + this.data + " è una data passata e l'evento non può crearsi.");
             throw new IllegalArgumentException("La data inserita è una data passata e l'evento non può crearsi.");
       }else this.data=data;
       

        //postiTotale
        if (postiTotale<=0){
            //System.out.println("Per favore scegli un numero maggiore di 0 per il totale dei posti dell'evento.");
            throw new IllegalArgumentException("Per favore scegli un numero maggiore di 0 per il totale dei posti dell'evento.");
        } else this.postiTotale = postiTotale;

         //postiPrenotati
         postiPrenotati=0;
        
    
    }

    static Boolean dataPassata(LocalDate firstDate, LocalDate secondDate){
    
        Boolean dataPassata=false;
    
       if (firstDate.isEqual(secondDate))
           // System.out.println("Le date sono uguali");
           dataPassata=false;
       else if (firstDate.isBefore(secondDate))
            //System.out.println("La data:" + ldData1 + " viene dopo la data " + ldData2);
            dataPassata=false;
       else if (firstDate.isAfter(secondDate)){
            dataPassata=true;
           }
       return dataPassata;
    
    }

//getters and setters
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws Exception {
         
       if(titolo.trim().isEmpty()){
          //System.out.println("Per favore inserisci un titolo per l'evento.");
          throw new IllegalArgumentException("Per favore inserisci un titolo per l'evento.");
       }else
           this.titolo=titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws Exception {
       
        LocalDate nowDate = LocalDate.now();                                           
     
        if(dataPassata(nowDate,data)){
            //System.out.println("La nuova data dell'evento: " + data + " è una data passata e l'evento non può crearsi.");
            throw new IllegalArgumentException("La nuova data dell'evento è una data passata, l'evento non si può modificare.");
        }else {
            //solo se la nuova data è una data prossima
            this.data = data;
            //System.out.println("La nuova data dell'evento: " + data + " è una data futura, l'evento può avere luogo.");
        }
    }

    public int getPostiTotale() {
        return postiTotale;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento{");
        sb.append("titolo=").append(titolo);
        sb.append(", data=").append(data);
        sb.append(", postiTotale=").append(postiTotale);
        sb.append(", postiPrenotati=").append(postiPrenotati);
        sb.append('}');
        return sb.toString();
    }

   public void prenota() throws Exception{
        
        LocalDate nowDate = LocalDate.now();                                           
        LocalDate eventDate=this.getData();

        int postiDisponibili=this.getPostiTotale()-this.getPostiPrenotati();

        if (dataPassata(nowDate, eventDate) && postiDisponibili>0 ){
            this.postiPrenotati++;
        }else {
            throw new IllegalArgumentException("Non si può aggiungere un nuovo posto di prenotazione");
        }
   }

   public void disdici() throws  Exception{
       
        LocalDate nowDate = LocalDate.now();             
        LocalDate eventDate=this.getData();

        if (dataPassata(nowDate, eventDate) && this.getPostiPrenotati()>0 ){
            this.postiPrenotati--;
        }else {
            throw new IllegalArgumentException("Non si può disdire nessun posto prenotato");
        }   
    }
    

    public String postiPrenotatiDisponibili() {

        int postiDisponibili=postiTotale-postiPrenotati;

        return "Evento [titolo=" + titolo 
                + ", data=" + data 
                + ", postiTotale=" + postiTotale 
                + ", postiPrenotati="+ postiPrenotati 
                + ", postiDisponibili="+ postiDisponibili 
                + "]";
    }

}
