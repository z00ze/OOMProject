package oomharjoitustyo;
/**
 * Olio-ohjelmmoinin metodiikan harjoitustyö. 
 * Syksy 2016. Tehtävä 3.
 * @author Marko Loponen, Opiskelijanumero 515655, majulop@utu.fi
 * @version 1.0
 * Vaihe-olio : Vaihe-olio sisältää String-olion jossa on kyseisessä 
 * vaiheessa tehtävä toimenpide, sekä int-muuttujan joka kuvaa millä tasolla
 * kyseinen toimenpide voidaan tehdä, jota sitten käytetään niiden sekoittamiseen
 * muiden samantasoisten toimenpiteiden kanssa.
 * 
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * DEBUG VERSIO - SISÄLTÄÄ YLIMÄÄRÄISIÄ TULOSTUKSIA (TASOT, LISTAN JÄRJESTYS JNE.)
 * HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! HUOM! 
 * 
 */
public class Vaihe {
    // Työvaiheen String
    private String vaihe;
    // Työvaiheen taso
    private int taso;
    /**
     * Olion konstruktori.
     * @.pre null
     * @.post EXISTS(Vaihe)
     */
    public Vaihe(){
        this.vaihe = "";
        this.taso = 0;
    }
    /**
     * Olion konstruktori parametreistä.
     * @.pre null
     * @.post EXISTS(Vaihe) && this.vaihe == x && this.taso == i
     */
    public Vaihe(String x, int i){
        this.vaihe = x;
        this.taso = i;
    }
    /**
     * Palauttaa olion vaihe-muuttujan. (String)
     * @.pre this.vaihe != null
     */
    public String getVaihe(){
        return this.vaihe;
    }
    /**
     * Palauttaa olion taso-muuttujan. (int)
     * @.pre this.vaihe != null
     */
    public int getTaso(){
        return this.taso;
    }
}
