package ziga.novak.sg.sckr.si.sportniki;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.*;
import java.nio.charset.StandardCharsets;


public class Vhod {
    public static void main(String[] args) {

        
        ArrayList<Modeli> igralci = new ArrayList<>();
        
        
        if(args[0].equals("zdruzi")){


            Path pot1 = Paths.get(args[1]);
            Path pot2 = Paths.get(args[2]);
            ArrayList<String> vse = new ArrayList<>();


            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pot1.toFile()), StandardCharsets.UTF_8.toString()))){
                String vrstica = null;
                if (br.ready()){
                    while ((vrstica = br.readLine()) != null){
                        vse.add(vrstica);
                    }
                }
            }
            catch(IOException e){

            }


            try(Writer w = Files.newBufferedWriter(pot2, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
                PrintWriter pw = new PrintWriter(w);

                for(int i = 0; i<vse.size(); i++){
                    pw.println(vse.get(i));
                }
            }
            catch(IOException e){

            }

        }

        else if(args[0].equals("izpis")){

            Path pot = Paths.get(args[1]);

            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pot.toFile()), StandardCharsets.UTF_8.toString()))){
                String vrstica = null;

                //ArrayList<String> podatki = new ArrayList<>();


                if(br.ready()){
                    while((vrstica = br.readLine()) != null){
                        String[] podatki = (vrstica.split("[, ;]"));

                        Modeli igralec = new Modeli(Integer.valueOf(podatki[0]), podatki[1], podatki[2], (podatki[3]), (podatki[4]), (podatki[5]), podatki[6], podatki[7]);
                        igralci.add(igralec);
                        for(int i = 0; i<podatki.length; i++){
                            System.out.println(podatki[i]);
                        }
                        System.out.println("---------------");
                    }
                }

                for(Modeli igralec : igralci){
                    System.out.println(igralec.toString());
                }



            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }


        }
        else if(args[0].equals("popravi")){
            Path pot = Paths.get(args[1]);
            String vrstica = null;
            System.out.println("Katerega igralca bi radi popravili?");

            Scanner sc = new Scanner(System.in);
            int stPopravi = sc.nextInt();
            int steviloVrstic = 0;
            int stevec = 0;
            String izhod = null;
            ArrayList<String> vse = new ArrayList<>();
            String novKlub;

            sc.nextLine();

            System.out.println("Na kater klub bi ga prestavili?");
            novKlub = sc.nextLine();



            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pot.toFile()), StandardCharsets.UTF_8.toString()))){
            boolean obstaja = false;

                if (br.ready()){
                    while ((vrstica = br.readLine()) != null){
                        String[] podatki = vrstica.split("[, ;]");
                        steviloVrstic++;
                        vse.add(vrstica);
                        if (Integer.valueOf(podatki[0]) == (stPopravi)){
                            System.out.println(stevec);
                            obstaja = true;

                            Modeli igralec = new Modeli(Integer.valueOf(podatki[0]), podatki[1], podatki[2], (podatki[3]), (podatki[4]), (podatki[5]), novKlub, podatki[7]);
                            izhod = igralec.toString();
                        }
                        else{
                            stevec++;
                            continue;
                        }

                    }

                    if(obstaja == false){
                        System.out.println("Ne obstaja");
                        System.exit(1);
                    }

                    
                }

            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }




            try(Writer w = Files.newBufferedWriter(pot, StandardCharsets.UTF_8, StandardOpenOption.WRITE)){
                PrintWriter pw = new PrintWriter(w);

                for(int i = 0 ; i<steviloVrstic; i++){
                    if (i == stevec){
                        pw.println(izhod);
                    }
                    else{
                        pw.println(vse.get(i));
                    }
                }

                
            }
            catch(IOException e){

            }


        }

        else{
            System.out.println("Napaka");
            System.exit(1);
        }


    }
}
