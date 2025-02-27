import java.time.LocalDate;
import java.time.LocalTime;

public class UsaConcerto {
    public static void main(String[] args) throws Exception {
        
        try {
            
       
        LocalDate localDate = LocalDate.now();  
        LocalTime localTime = LocalTime.now(); 
        Concerto concerto1=new Concerto(localTime, 150.34, "Matrimonio", localDate, 250);
        System.out.println(concerto1.toString());

        
        LocalDate date2 = LocalDate.of(2020, 1, 8);// la data inserita è una data passata
        LocalTime time2 = LocalTime.of(20, 01, 8);
        Concerto concerto2=new Concerto(time2, 50, "Battesimo", date2, 85);//non si crea come aggetto
        System.out.println(concerto2.toString());//stampa exception generato
        
        
        LocalDate date3 = LocalDate.of(2025, 4, 24);//creamo la data usando le variable
        LocalTime time3 = LocalTime.of(20, 30, 0);//creamo l'ora usando le variable
        Concerto concerto3=new Concerto(time3, 97, "Paolo Nutini", date3, 450);
        System.out.println(concerto3.toString());

        LocalDate date4 = LocalDate.of(2025, 12, 24);
        concerto3.setData(date4);
        System.out.println(concerto3.toString());//si modifica chimando il setter della data implementato nella Classe Evento

        LocalDate date5 = LocalDate.of(2025, 1, 24);
        concerto3.setData(date5);
        System.out.println(concerto3.toString());//non si modifica siccome abbiamo creato una data in passato


        concerto3.setPrezzo(67.5);
        System.out.println(concerto3.toString());

        concerto3.setPrezzo(-67.5);//non cambia , genera exception
        System.out.println(concerto3.toString());

        concerto3.setPrezzo(0);//non cambia , genera exception
        System.out.println(concerto3.toString());


    } catch (Exception e) {
        //stampo l'errore creato dal costrutore, l'oggeto Evento non si è creato
        System.out.println(e.toString());
    }
    }
}
