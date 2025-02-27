import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UsaEvento {
    public static void main(String[] args) throws Exception {
        /* 
        Evento eventoPrimo=new Evento("Matrimonio", "22/12/2025", 250);
        System.out.println(eventoPrimo.toString());

        eventoPrimo.prenota();
        eventoPrimo.prenota();
        eventoPrimo.prenota();
        System.out.println(eventoPrimo.toString());

        eventoPrimo.disdici();
        System.out.println(eventoPrimo.toString());
        eventoPrimo.disdici();
        System.out.println(eventoPrimo.toString());
        eventoPrimo.disdici();
        System.out.println(eventoPrimo.toString());
        eventoPrimo.disdici();
        System.out.println(eventoPrimo.toString());
        eventoPrimo.disdici();
        System.out.println(eventoPrimo.toString());
    */

    /* Step2 - point 1. */
    Scanner scan=new Scanner(System.in);

    System.out.println("Per favore inserisci un titolo per l'evento che vuoi creare");
    String titolo=scan.nextLine();

    System.out.println("Per favore inserisci una data per l'evento che vuoi creare usando il formato dd/mm/yyyy");
    String dataEvento=scan.nextLine();

    LocalDate dataEventoFormatatta;
    dataEventoFormatatta= LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd/MM/yyyy")); 

    System.out.println("Per favore inserisci un totale dei posti per l'evento che vuoi creare");
    int postiTotale=scan.nextInt();

    try {
        Evento eventoPrimo=new Evento(titolo, dataEventoFormatatta,postiTotale);  
        System.out.println(eventoPrimo.toString());
        //Evento eventoPrimo=new Evento("Matrimonio", "22/12/2025", 250);


        eventoPrimo.setTitolo("Battesimo");//cambia
        System.out.println(eventoPrimo.toString());

       // eventoPrimo.setTitolo(" ");//non cambia, throws Exception 
        System.out.println(eventoPrimo.toString());

        
        eventoPrimo.setData(LocalDate.parse("22/11/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(eventoPrimo.toString());//cambia

       //eventoPrimo.setData(LocalDate.parse("22/11/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(eventoPrimo.toString());//non cambia, throws Exception

          /* STEP 2 - points 2., 3. */
    
        System.out.println("Per favore inserisci quanti posti vuoi prenotare per l'evento creato");
        int postiPerPrenotare=scan.nextInt();

        if (postiPerPrenotare<=0){
            System.out.println("Dovete scegliere un numero maggiore di 0 per posti da prenotare");
        }else if (postiPerPrenotare>postiTotale){
            System.out.println("Dovete scegliere un numero minore del totale dei posti dell'evento per prenotare.");
        }else {

            int postiChePossonoEsserePrenotati=eventoPrimo.getPostiTotale()-eventoPrimo.getPostiPrenotati();
            if (postiPerPrenotare<=postiChePossonoEsserePrenotati){
                for (int i = 0; i < postiPerPrenotare; i++) {
                    eventoPrimo.prenota(); 
                    System.out.println(eventoPrimo.postiPrenotatiDisponibili());
                }
                //System.out.println(eventoPrimo.postiPrenotatiDisponibili());
            }
        }

          /* STEP 2 - points 4., 5., 6. */
        System.out.println("Per favore inserisci quanti posti vuoi disdire per l'evento creato");
        int postiPerDisdire=scan.nextInt();

        if (postiPerDisdire<=0){
            System.out.println("Dovete scegliere un numero maggiore di 0 per posti da disdire");
        }else if (postiPerDisdire>postiTotale){
            System.out.println("Dovete scegliere un numero minore del totale dei posti dell'evento per disdire.");
        }else if ((postiPerDisdire>eventoPrimo.getPostiPrenotati())){
            System.out.println("Dovete scegliere un numero minore del totale dei posti già prenotati per disdire.");
        }
        else{
                for (int i = 0; i < postiPerDisdire; i++) {
                    eventoPrimo.disdici(); 
                    System.out.println(eventoPrimo.postiPrenotatiDisponibili());
                }
            }
    
    } catch (Exception e) {
        //stampo l'errore creato dal costrutore, l'oggeto Evento non si è creato
        System.out.println(e.toString());
    }

    scan.close();

    }
}
