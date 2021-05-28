package exer3fase1;
import java.util.*;
public class Exer3Fase1 {
    public static final int MAX_ITERACIONS = 100;
    public static void main(String[] args) {
         //Declaració de variables bitllet
        int bitllet5 = 0;
        int bitllet10 = 0;
        int bitllet20 = 0;
        int bitllet50 = 0;
        int bitllet100 = 0;
        int bitllet200 = 0;
        int bitllet500 = 0;
        
        //Variable preu final
        int preuFinal = 0;
        
        //Declaració dels arrays 
        String[] plats;
        int[] preus;
        
        //HashMap per omplir la carta
        HashMap<String, Integer> menu = new HashMap<String, Integer>();
        Scanner lector = new Scanner(System.in);
        
        System.out.print("Quants plats tindrà la carta: ");
        int quants;
        quants = lector.nextInt();
        try {
            if (quants <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.print("Has possat un nombre negatiu o un cero!");
        }
        
        String pla;
        int pre;
        plats = new String[quants];
        preus = new int[quants];
        for (int i = 0; i < plats.length; i++) {
            System.out.print("Escriu el nom del plat " + (i+1) + ": ");
            pla = lector.next();
            try {
                if (pla == " ") {
                    throw new Exception();
                } else {
                    plats[i] = plats[i] + pla;
                }
            } catch (Exception ex) {
                System.out.print("No has escrit el nom d´un plat!");
            }
            System.out.print("Escriu el preu de plat " + (i+1) + ": ");
            pre = lector.nextInt();
            try {
                if (pre <= 0) {
                    throw new Exception();
                } else {
                    preus[i] = preus[i] + pre;
                }
            } catch (Exception ex) {
                System.out.print("S´ha introduit un nombre negaitu o un cero!");
            }
            menu.put(plats[i], preus[i]);
        }
        System.out.println();
        
        //For per mostrar el menu 
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Plat " + key + " - " + value + " Euros");
        }
        System.out.println();
        
        //Llista per demanar i omplir amb els plats del client
        ArrayList<String> menuClient = new ArrayList<String>();
        System.out.print("Quants plats vols menjar: ");
        int quantsPlats = 0;
        quantsPlats = lector.nextInt();
        try {
            if (quantsPlats <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.print("Has introduit un nombre negatiu o un cero!");
        }
        
        int i = 0;
        while (i < quantsPlats) {
            System.out.print("Escriu el nom del plat " + (i+1) + ": ");
            String plat = lector.next();
            try {
                if (!menu.containsKey(plat)) {
                    throw new Exception();
                } else {
                    menuClient.add(plat);
                }
            } catch (Exception ex) {
                System.out.print("Aquest plat no és a la carta!");
            }
            i++;
        } 
        System.out.println();
        
        int menjarMes = -1;
        System.out.print("Vols menjar més (pitja 1:SI o 0:NO): ");
        menjarMes = lector.nextInt();
        try {
        if (menjarMes == 1) {
            System.out.print("Quants plats vols: ");
            quantsPlats = lector.nextInt();
            try {
                if (quantsPlats <= 0){
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.print("Has escrit un nombre negatiu o cero!");
            }   
                
            int j = 0;
            while (j < quantsPlats) {
                System.out.print("Escriu el nom del plat " + (j+1) + ": ");
                String nouPlat = lector.next();
                try {
                    if (!menu.containsKey(nouPlat)) {
                        throw new Exception();
                    } else {
                      menuClient.add(nouPlat);
                    }
                } catch (Exception ex) {
                    System.out.print("Aquest plat avui no es a la carta!");
                }
                j++;
                }
            } else if (menjarMes == 0) {
                System.out.print("----");
            } else if ((menjarMes != 1)||(menjarMes != 0)) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.print("Aquest nombre no és vàlid!");
        }
        System.out.println();
        
        //For per comparar la llista amb l´array de plats i sumar a preu final
        for (String e : menuClient) {
            if (menu.containsKey(e)) {
                preuFinal = preuFinal + menu.get(e);
            }
        }
        System.out.println("El preu del menú són: " + preuFinal + " euros");
        
        //Rutina per dir amb quin tipus de bitllet es pot pagar
        int count = 0;
        while (!(preuFinal < 0)&&(count < MAX_ITERACIONS)) {
            if (preuFinal >= 500) {
                int aux500 = 0;
                aux500 = preuFinal / 500;
                preuFinal = preuFinal % 500;
                bitllet500 = bitllet500 + aux500 ;
            } else if ((preuFinal >= 200)&&(preuFinal < 500)) {
                int aux200 = 0;
                aux200 = preuFinal / 200;
                preuFinal = preuFinal % 200;
                bitllet200 = bitllet200 + aux200;
            } else if ((preuFinal >= 100)&&(preuFinal < 200)) {
                int aux100 = 0;
                aux100 = preuFinal / 100;
                preuFinal = preuFinal % 100;
                bitllet100 = bitllet100 + aux100;
            } else if ((preuFinal >= 50)&&(preuFinal < 100)) {
                int aux50 = 0;
                aux50 = preuFinal / 50;
                preuFinal = preuFinal % 50;
                bitllet50 = bitllet50 + aux50;
            } else if ((preuFinal >= 20)&&(preuFinal < 50)) {
                int aux20 = 0;
                aux20 = preuFinal / 20;
                preuFinal = preuFinal % 20;
                bitllet20 = bitllet20 + aux20;
            } else if ((preuFinal >= 10)&&(preuFinal < 20)) {
                int aux10 = 0;
                aux10 = preuFinal / 10;
                preuFinal = preuFinal % 10;
                bitllet10 = bitllet10 + aux10;
            } else if ((preuFinal >= 5)&&(preuFinal < 10)) {
                int aux5 = 0;
                aux5 = preuFinal / 5;
                preuFinal = preuFinal % 5;
                bitllet5 = bitllet5 + aux5;
            } 
            count = count + 1;
        }
        
        // Mostra per pantalla amb quin tipus de bitllet es pot pagar
        if (bitllet500 != 0) {
            System.out.println("Són " + bitllet500 + " bitllets de 500 euros");
        }
        if (bitllet200 != 0) {
            System.out.println("Són " + bitllet200 + " bitllets de 200 euros");
        }
        if (bitllet100 != 0) {
            System.out.println("Són " + bitllet100 + " bitllets de 100 euros");
        }
        if (bitllet50 != 0) {
            System.out.println("Són " + bitllet50 + " bitllets de 50 euros");
        }
        if (bitllet20 != 0) {
            System.out.println("Són " + bitllet20 + " bitllets de 20 euros");
        }
        if (bitllet10 != 0) {
            System.out.println("Són " + bitllet10 + " bitllets de 10 euros");
        }
        if (bitllet5 != 0) {
            System.out.println("Són " + bitllet5 + " bitllets de 5 euros");
        }
        System.out.println("Gràcies per la seva comanda!");
    }
}




    
    


    
        
    
       
    
    

