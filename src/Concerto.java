
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    private LocalTime ora;
    private double prezzo;
    private String dataCompleta;

    public Concerto(LocalTime ora, double prezzo, String titolo, LocalDate data, int postiTotale) throws Exception {
        super(titolo, data, postiTotale);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String dataFormattata(){

        LocalDateTime dataCompleta=LocalDateTime.of(this.getData(), this.ora);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                                                
        String dataCompletaFormatata = dataCompleta.format(dateFormatter);  
        return dataCompletaFormatata;
    }

   public String prezzoFormattato(){
    
    DecimalFormat df = new DecimalFormat("#.00€");
     return df.format(this.getPrezzo());

   }

    @Override
    public String toString() {
        return "Concerto [dataCompleta= " + dataFormattata() 
                + ", titolo= "+ getTitolo()
                + ", prezzo= " + prezzoFormattato() 
                + "]";
    }
   
}


