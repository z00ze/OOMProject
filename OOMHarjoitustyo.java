package oomharjoitustyo;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Random;
import java.io.PrintWriter;
/**
 * Olio-ohjelmmoinin metodiikan harjoitustyö. 
 * Syksy 2016. Tehtävä 3.
 * @author Marko Loponen, Opiskelijanumero 515655, majulop@utu.fi
 * @version 1.0
 * Main metodi : Ohjelmaa käytetään kirjoittamalla ohjelmalle reseptin eri työvaiheita
 * jotka tallennetaan listaan. Ohjelma alkaa tasosta 0 ja käyttäjä voi edetä tasojen välillä
 * antamalla kyseisen tason numeron johon haluaa kirjoittaa. Ohjelman lopetus tapahtuu
 * kirjoittamalla "exit" ja ohjelma tallentaa reseptin tekstitiedostoon.
 * 
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * DEBUG VERSIO - SISÄLTÄÄ YLIMÄÄRÄISIÄ TULOSTUKSIA (TASOT, LISTAN JÄRJESTYS JNE.)
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * 
 */
public class OOMHarjoitustyo {
    static int kirjoitustaso = 0;
    public static void main(String[] args) {
        Scanner luku = new Scanner(System.in);
        // Luodaan Tyovaiheet olio
        Tyovaiheet resepti = new Tyovaiheet();
        // Toisto niin kauan kunnes käyttäjä kirjoittaa "exit" jolloin break;
        while(true){
            // käyttäjän kirjoitustaso Tyovaiheisiin
            System.out.println("Kirjoitustasosi on " + kirjoitustaso);
            // jos luku ei ole numero (tason vaihto)
            if(!luku.hasNextInt()){
                // luetaan luettu rivi String-muuttujaan s
                String s = luku.nextLine();
                // jos String-muuttuja s on "exit" lopetetaan toisto, jos rivi ensimmäinen rivi joten
                // Tyovaiheet-olion vaiheet-lista on tyhjä, lopetetaan koko ohjelma.
                if(s.equalsIgnoreCase("exit")){
                    if(resepti.getLista().size()<1){
                        System.exit(1);
                        }
                    break;
                }
                // lisätään reseptiin vaihe ja sen kirjoitus taso
                resepti.addVaihe(s, kirjoitustaso);
            }
            else {
                // jos luku on numero, kirjoitetaan se kirjoitustasoon 
                kirjoitustaso = luku.nextInt();
                luku.nextLine();
            }
        }
            // Tulostetaan lista
            tulostaLista(resepti);
            /** Järjestetään lista ei vähenevään järjestykseen Tyovaiheet-oliossa
            *  olevan listan Vaihe-olioiden tason perusteella. */
            resepti.jarjesta();
            // Tulostetaan lista, että nähdään onko järjestetty.
            tulostaLista(resepti);
            System.out.println("---");
            // Sekoitetaan samantasoiset reseptit
            resepti.sekoitaSamanTasoiset();
            // Tulostetaan uudestaan lista (että nähdään ovatko ne sekoittuneet)
            tulostaLista(resepti);
            // Tulostetaan lista tiedostoon.
            tulostaTiedostoon(resepti);
        }
        /**
         * Tulostaa parametrina annetun Tyovaiheet-olion listan alkiot.
         * @.pre    resepti != null && EXISTS(i : resepti ; resepti.getVaihe())
         */
        public static void tulostaLista(Tyovaiheet resepti){
                for(int i = 0;i< resepti.getLista().size();i++){
                System.out.println(resepti.getVaihe(i).getVaihe() + " ja taso on : " + resepti.getVaihe(i).getTaso());
                }
        }
        /**
         *  Tulostaa parametrina annetun Tyovaiheet-olion listan alkiot tiedostoon.
         *  @.pre   resepti != null
         *  @.post  EXISTS(resepti.txt) & FORALL(i : resepti.getLista() ; EXISTS(j : i; resepti.txt))
         */
        public static void tulostaTiedostoon(Tyovaiheet resepti){
            try{
                PrintWriter writer = new PrintWriter("resepti.txt", "UTF-8");
                writer.println("RESEPTI : ");
                for(int i = 0;i< resepti.getLista().size();i++){
                writer.println(resepti.getVaihe(i).getVaihe() + " " + i);
                }
                writer.close();
            } catch (Exception e) {
            System.out.println(e);
}
        }
}
        
        
        
    
        
    
    

