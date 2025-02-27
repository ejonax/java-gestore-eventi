import java.time.LocalDate;
import java.time.LocalTime;

public class UsaConcerto {
    public static void main(String[] args) throws Exception {
        
        LocalDate localDate = LocalDate.now();  
        LocalTime localTime = LocalTime.now(); 
        Concerto concerto1=new Concerto(localTime, 150.34, "Matrimonio", localDate, 250);
        System.out.println(concerto1.toString());

        /* 
        LocalDate date2 = LocalDate.of(2020, 1, 8);// la data inserita è una data passata
        LocalTime time2 = LocalTime.of(20, 01, 8);
        Concerto concerto2=new Concerto(time2, 50, "Battesimo", date2, 85);//non si crea come aggetto
        System.out.println(concerto2.toString());//stampa exception generato
        */

        LocalDate date3 = LocalDate.of(2025, 4, 24);//creamo la data usando le variable
        LocalTime time3 = LocalTime.of(20, 30, 0);//creamo l'ora usando le variable
        Concerto concerto3=new Concerto(time3, 97, "Paolo Nutini", date3, 450);
        System.out.println(concerto3.toString());



    }
}
