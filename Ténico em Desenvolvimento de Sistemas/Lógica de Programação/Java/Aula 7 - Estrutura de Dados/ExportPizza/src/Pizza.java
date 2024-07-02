
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wilian_g_cardoso
 */
public class Pizza {

    private static ArrayList<Pizza> listap = new ArrayList<Pizza>();

    private int cod;
    private static int codigoP = 0;
    private String tam;
    private String sabor1;
    private boolean bord;
    private String formato;
    private int fatias;
    private String sabor2;
    private boolean premium;

    //Metodo construtor
    public Pizza() {
        //auto encremento add +1
        cod++;
        cod = codigoP;
    }

    //Construtor
    public Pizza(String tam, String sabor1, String sabor2, boolean bord, String formato, int fatias, boolean premium) {
        cod++;
        cod = codigoP;
        this.tam = tam;
        this.sabor2 = sabor2;
        this.sabor1 = sabor1;
        this.premium = premium;
        this.formato = formato;
        this.fatias = fatias;
        this.bord = bord;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public static int getCodigoP() {
        return codigoP;
    }

    public static void setCodigoP(int codigoP) {
        Pizza.codigoP = codigoP;
    }

    public String getTam() {
        return tam;
    }

    public void setTam(String tam) {
        this.tam = tam;
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public boolean isBord() {
        return bord;
    }

    public void setBord(boolean bord) {
        this.bord = bord;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getFatias() {
        return fatias;
    }

    public void setFatias(int fatias) {
        this.fatias = fatias;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String toString() {
        return "" + tam + ", "
                + sabor1 + ", " 
                + sabor2 + ", "
                + bord + ", "
                + formato + ", "
                + fatias + ", "
                + premium;
    }
}
