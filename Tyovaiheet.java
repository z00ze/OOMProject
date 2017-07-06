package oomharjoitustyo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
/**
 * Olio-ohjelmmoinin metodiikan harjoitustyö. 
 * Syksy 2016. Tehtävä 3.
 * @author Marko Loponen, Opiskelijanumero 515655, majulop@utu.fi
 * @version 1.0
 * Tyovaiheet-olio : Sisältää LinkedList-listan jossa on alkioina Vaihe-olioita.
 * Olion luomisen jälkeen kyseinen lista on tyhjä ja siihen voidaan lisätä
 * Vaihe-olioita addVaihe-metodilla joka saa parametreinä String-oliona kyseisen
 * vaiheen toimenpiteen teksti esityksen sekä int muuttujana kyseisen toimenpiteen tason.
 * 
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * DEBUG VERSIO - SISÄLTÄÄ YLIMÄÄRÄISIÄ TULOSTUKSIA (TASOT, LISTAN JÄRJESTYS JNE.)
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * 
 */
public class Tyovaiheet {
    // luodaan Tyovaiheelle linkedlist<Vaihe>
    private LinkedList<Vaihe> vaiheet = new LinkedList<Vaihe>();
    
    /**
     * Olion konstruktori.
     *  @.pre null
     *  @.post EXISTS(Tyovaiheet) && this.vaiheet.size() == 0
     */
    public Tyovaiheet(){
    }
    /**
     * Lisää työvaiheen vaiheet listaan, viimeiseksi.
     * @.pre s != null && i != null
     * @.post this.vaiheet.getLast() == RESULT
     */
    public void addVaihe(String s, int i){
        this.vaiheet.add(new Vaihe(s,i));
    }
    /**
     * Palauttaa vaiheet-listasta parametrina annetun indeksin mukaisen Vaihe-olion.
     * @.pre x < this.vaiheet.size()
     * @return Vaihe-olion vaiheet-listasta.
     */
    public Vaihe getVaihe(int x){
        return this.vaiheet.get(x);
    }
    /**
     * @.pre this.tyovaiheet != null
     * @return Olion vaiheet-LinkedList:n joka sisältää Vaihe-olioita.
     */
    public LinkedList<Vaihe> getLista(){
        return this.vaiheet;
    }
    /**
     * Sekoitetaan samalla työn tasolla olevat työvaiheet keskenään.
     * @.pre this.vaiheet != null
     * @.post this.equals(OLD(this))
     */
    public void sekoitaSamanTasoiset(){
        // Aloitustaso
        int taso = this.vaiheet.get(0).getTaso();
        // Nollakohta (indexi)
        int nollakohta = 0;
            // Käydään alkiot läpi
            for(int a = 0;a<this.vaiheet.size();a++){
                // Jos alkio ei ole samantasoinen tason kanssa niin määritetään uusi
                // nollakohta.
                if(this.vaiheet.get(a).getTaso()!=taso){
                    nollakohta = a;
                    taso = this.vaiheet.get(a).getTaso();
                }
                else{
                    // Jos on samantasoinen, sekoitetaan nollakohdasta alkioon asti.
                    Collections.shuffle(this.vaiheet.subList(nollakohta, a)); 
                }
            }
        }
    /**
     * Järjestetään lista tasojen mukaan. Lisäyslajittelu.
     * @.pre this.vaiheet != null
     * @.post this.vaiheet (järjestetty ei vähenevään järjestykseen listassa
     * olevien Vaihe-olioiden tasojen mukaan)
     */
    public void jarjesta(){
        for(int i = 0; i<this.vaiheet.size();i++){
            int j = i;
            while(j>0 && this.vaiheet.get(j-1).getTaso() > this.vaiheet.get(j).getTaso()){
                Collections.swap(this.vaiheet, j, j-1);
                System.out.println(this.vaiheet.get(j).getTaso() + " " + this.vaiheet.get(j-1).getTaso());
                j--;
            }
            
        }
    }
    }