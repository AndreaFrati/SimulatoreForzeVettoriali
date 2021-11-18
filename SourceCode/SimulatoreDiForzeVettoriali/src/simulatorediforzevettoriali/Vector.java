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
    protected Color colore = Color.GREEN;
    protected double x;
    protected double y;
    protected double angolo;
    public String getName(){
        return this.name;
    }
    
    public Vector(double x, double y, String name){
        this.name = name;
        this.x = x;
        this.y = y;
        this.forza = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        if(x == 0){
            x = 1;
        }
        this.angolo = Math.toDegrees(Math.atan(y/x));
    }
    public Vector(String name, double angolo, double forza){
        this.name = name;
        this. forza = forza;
        this.angolo = angolo;
        this.x = forza * Math.cos(angolo);
        this.y = forza * Math.sin(angolo);
    }
}
