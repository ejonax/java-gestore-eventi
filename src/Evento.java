
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private String data;
    private int postiTotale;
    private int postiPrenotati;

    //costrutore
    public Evento(String titolo,String data,int postiTotale) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();                                           
        String nowDate = localDate.format(dateFormatter);  
        this.data=data;
        //data
       if(compareDates(this.data,nowDate)){
             System.out.println("La data dell'evento: " + this.data + " è una data passata e l'evento non può crearsi.");
       }else {
              System.out.println("La data dell'evento: " + this.data + " è una data futura, l'evento può avere luogo.");
       }

       //titolo
       if (titolo.trim().isEmpty()){
        System.out.println("Per favore inserisci un titolo per l'evento.");
       }else this.titolo=titolo;
    
       //postiPrenotati
        postiPrenotati=0;

        //postiTotale
        if (postiTotale<=0){
            System.out.println("Per favore scegli un numero maggiore di 0 per il totale dei posti dell'evento.");
        } else this.postiTotale = postiTotale;
        
    
    }

    static Boolean compareDates(String data1, String data2){
    
     Boolean dataPassata= false;
     
     DateTimeFormatter dataObject = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     LocalDate ldData1 = LocalDate.parse(data1, dataObject);
     LocalDate ldData2 = LocalDate.parse(data2, dataObject);
     
    if (ldData1.isEqual(ldData2))
         System.out.println("Le date sono uguali");
    else if (ldData1.isAfter(ldData2))
         System.out.println("La data:" + ldData1 + " viene dopo la data " + ldData2);
    else if (ldData1.isBefore(ldData2)){
         System.out.println("La data:" + ldData1 + " viene prima la data " + ldData2);
         dataPassata=true;
        }
      
    return dataPassata;

}

//getters and setters
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
         
       if(titolo.trim().isEmpty()){
          System.out.println("Per favore inserisci un titolo per l'evento.");
       }else
           this.titolo=titolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
       
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();                                           
        String nowDate = localDate.format(dateFormatter);  
   
        if(compareDates(data,nowDate)){
            System.out.println("La nuova data dell'evento: " + data + " è una data passata e l'evento non può crearsi.");
        }else {
            //solo se la nuova data è una data futura di oggi
            this.data = data;
            System.out.println("La nuova data dell'evento: " + data + " è una data futura, l'evento può avere luogo.");
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

   public void prenota(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();                                           
        String nowDate = localDate.format(dateFormatter);  

        String eventDate=this.getData();

        int postiDisponibili=this.getPostiTotale()-this.getPostiPrenotati();

        if (compareDates(nowDate, eventDate) && postiDisponibili>0 ){
            this.postiPrenotati++;
        }else {
            System.out.println("Non si può aggiungere un nuovo posto di prenotazione.");
        }
   }

   public void disdici(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();                                           
        String nowDate = localDate.format(dateFormatter);  

        String eventDate=this.getData();

        if (compareDates(nowDate, eventDate) && this.getPostiPrenotati()>0 ){
            this.postiPrenotati--;
        }else {
            System.out.println("Non si può disdire nessun posto prenotato");
        }   
    }
    
   
}
