/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorediforzevettoriali;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author andrea.frati
 */
public class Vector {
    protected String name;
    protected double forza;
    protected Color colore;
    protected double x;
    protected double y;
    protected double angolo;
    public Vector(double xOrAngle, double yOrForza, String name, boolean polarCoord){
        if(polarCoord){
            this.name = name;
            this.forza = yOrForza;
            this.angolo = xOrAngle;
            this.x = calcolaX(xOrAngle, yOrForza);
            this.y = calcolaY(xOrAngle, yOrForza);
        }else{
            this.name = name;
            this.x = xOrAngle;
            this.y = yOrForza;
            this.forza = calcolaForza(xOrAngle, yOrForza);
            this.angolo = calcolaAngolo(xOrAngle, yOrForza);
        }
    }
    public Vector(double xOrAngle, double yOrForza, String name, boolean polarCoord, Color color){
        this(xOrAngle, yOrForza, name, polarCoord);
        this.colore = color;
    }
    public void setColore(Color colore) {
        this.colore = colore;
    }  
    
    public static double calcolaForza(double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    public static double calcolaAngolo(double x, double y){
        return Math.toDegrees(Math.atan(y/x));
    }
    public static double calcolaX(double angolo, double forza){
        return forza * Math.cos(Math.toRadians(angolo));
    }
    public static double calcolaY(double angolo, double forza){
        return forza * Math.sin(Math.toRadians(angolo));
    }

    public void setAngolo(double angolo) {
        this.angolo = angolo;
        this.x = Vector.calcolaX(angolo,forza);
        this.y = Vector.calcolaY(angolo,forza);  
    }
    public void setForza(double forza) {
        this.forza = forza;
        this.x = Vector.calcolaX(angolo,forza);
        this.y = Vector.calcolaY(angolo,forza);  
    }
    public void setX(double x) {
        this.x = x;
        this.angolo = Vector.calcolaAngolo(x,y);
        this.forza = Vector.calcolaForza(x,y);
    }
    public void setY(double y) {
        this.y = y;
        this.angolo = Vector.calcolaAngolo(x,y);
        this.forza = Vector.calcolaForza(x,y);        
    }

    @Override
    public String toString() {
        String str = "";
        str += "Vector (";
        str += String.format("name: %s, angolo: %s, forza: %s, x: %s, y: %s", name, angolo, forza, x, y);
        str += ")";
        return str;
    }
    
    
    
}
