


public class UsaEvento {
    public static void main(String[] args) {
        Evento eventoPrimo=new Evento("Matrimonio", "22/12/2025", 250);
        System.out.println(eventoPrimo.toString());

        eventoPrimo.setTitolo("Battesimo");//cambia
        System.out.println(eventoPrimo.toString());

        eventoPrimo.setTitolo("");//non cambia
        System.out.println(eventoPrimo.toString());

        eventoPrimo.setData("22/11/2025");
        System.out.println(eventoPrimo.toString());//cambia

        eventoPrimo.setData("22/11/2024");//non cambia
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

    }
}
