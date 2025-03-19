
import java.time.LocalDate;

public class UsaProgrammaEventi {
    
    public static void main(String[] args) throws Exception {
        ProgrammaEventi programma1=new ProgrammaEventi("Eventi Familiari");

        LocalDate date1 = LocalDate.of(2025, 4, 10);
        Evento evento1=new Evento("Matrimonio", date1, 250);

        LocalDate date2 = LocalDate.of(2025, 4, 8);
        Evento evento2=new Evento("Battesimo", date2, 120);

        LocalDate date3 = LocalDate.of(2025, 4, 30);
        Evento evento3=new Evento("Compleanno", date3, 120);

        LocalDate date4 = LocalDate.of(2025, 4, 30);
        Evento evento4=new Evento("Matrimonio", date4, 120);

        LocalDate date5 = LocalDate.of(2025, 4, 30);
        Evento evento5=new Evento("Battesimo", date5, 120);

        

        programma1.addEvento(evento1);
        programma1.addEvento(evento2);
        System.out.println(programma1.numeroTotEventi());
        programma1.addEvento(evento3);
        programma1.addEvento(evento4);
        programma1.addEvento(evento5);
        System.out.println(programma1.numeroTotEventi());

        System.out.println(programma1.listaProgramma());

        ProgrammaEventi programma2=new ProgrammaEventi("Eventi Lavorativi");
        //metodo che aggiunge alla lista un Evento, passato come parametro
        programma2.addEvento(evento5);
        programma2.addEvento(evento5);
        programma2.addEvento(evento5);
        System.out.println(programma2.numeroTotEventi());
        programma2.addEvento(evento3);
        programma2.addEvento(evento4);
        programma2.addEvento(evento5);
        //metodo che restituisce quanti eventi sono presenti nel programma
        System.out.println(programma2.numeroTotEventi());
        //metodo che restituisce una stringa che mostra il titolo del programma e tutti gli eventi ordinati per data nella forma: 
        System.out.println(programma2.listaProgramma());
    

        //metodo che restituisce una lista con tutti gli eventi presenti in una certa data
        LocalDate dateControllo = LocalDate.of(2025, 4, 30);
        programma1.eventiNellaData(dateControllo);
        System.out.println(programma1.eventiNellaData(dateControllo).toString());
        System.out.println("");

       
        programma2.eventiNellaData(dateControllo);
        System.out.println(programma2.eventiNellaData(dateControllo).toString());

        //metodo che svuota la lista di eventi
        programma1.svuotaListaEventi();
        System.err.println(programma1.numeroTotEventi());
        System.out.println(programma1.listaProgramma());
    }
}
