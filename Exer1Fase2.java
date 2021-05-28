package exer1fase2;
import java.util.*;
public class Exer1Fase2 {
    public static void main(String[] args) {
        //Declaració de variables
        int bitllet5 = 0;
        int bitllat10 = 0;
        int bitllet20 = 0;
        int bitllet50 = 0;
        int bitllet100 = 0;
        int bitllet200 = 0;
        int bitllet500 = 0;
        
        //Declaració variable preu final
        float preuFinal = 0;
        
        //Declaració de arrays
        String[] plats;
        float[] preus;
        
        //HashMap on es guarden les dades del menu
        HashMap<String, Float> menu = new HashMap<String, Float>();
        Scanner lector = new Scanner(System.in);
        
        //Rutina per omplir els dos arrays
        System.out.print("Quants plats tindrà la carta: ");
        int quants;
        quants = lector.nextInt();
        plats = new String[quants];
        preus = new float[quants];
        for (int i = 0; i < plats.length; i++) {
            System.out.print("Escriu el nom del plat " + (i+1) + ": ");
            plats[i] = lector.next();
            System.out.print("Escriu el preu de plat " + (i+1) + ": ");
            preus[i] = lector.nextFloat();
            menu.put(plats[i], preus[i]);
        }
        System.out.println();
        
        //For per mostrar el contingut dels arrays
        for (Map.Entry<String, Float> entry : menu.entrySet()) {
            String key = entry.getKey();
            Float value = entry.getValue();
            System.out.println("Plat " + key + " - " + value + " Euros");
        }
        System.out.println();
        
        //Llista per demanar i guardar els plats que vol el client
        ArrayList<String> menuClient = new ArrayList<String>();
        int quantsPlats = 0;
        System.out.print("Quants plats vols: ");
        quantsPlats = lector.nextInt();
        
        int i = 0;
        while (i < quantsPlats) {
            System.out.print("Escriu el nom del plat " + (i+1) + ": ");
            String plat = lector.next();
            menuClient.add(plat);
            i++;
        }
        System.out.println();
        
        //Rutina on el client diu si vol menjar més o no
        int menjarMes = -1;
        System.out.print("Vols menjar més (pitja 1:SI o 0:NO): ");
        menjarMes = lector.nextInt();
        if (menjarMes == 1) {
            System.out.print("Quants plats vols: ");
            quantsPlats = lector.nextInt();
            int j = 0;
            while (j < quantsPlats) {
                System.out.print("Escriu el nom del plat " + (i+1) + ": ");
                String nouPlat = lector.next();
                menuClient.add(nouPlat);
                i++;
                j++;
                }
            } else if (menjarMes == 0) {
            System.out.println("Gràcies!");
        }
    }
}


