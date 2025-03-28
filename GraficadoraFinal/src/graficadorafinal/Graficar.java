/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graficadorafinal;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author carlos
 */
public class Graficar {
    
    static Color celeste = new Color(153,203,255);
    static Color cafe = new Color(161,130,98);
    static Color morado = new Color(102,0,161);
    
    public static void graficarCuadrado(int x, int y, int l, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillRect(x, y, l, l);
        }else{
            g.drawRect(x, y, l, l);
        }
        
    }
    
    public static void graficarLinea(int x1, int y1, int x2, int y2, String color){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        g.drawLine(x1,y1,x2,y2);
        
    }
    
    public static void graficarRectangulo(int x, int y, int b, int a, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillRect(x, y, b, a);
        }else{
            g.drawRect(x, y, b, a);
        }
        
    }
    
    public static void graficarOvalo(int x, int y, int ejex, int ejey, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillOval(x, y, ejex, ejey);
        }else{
            g.drawOval(x, y, ejex, ejey);
        }
        
    }
    
    public static void graficarCirculo(int x, int y, int r, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        int xi = x-(r/2);
        int yi = y-(r/2);
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillOval(xi, yi, r, r);
        }else{
            g.drawOval(xi, yi, r, r);
        }
        
    }
    
    
    public static void graficarTriRect(int x, int y, int b, int a, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        int b1 = x + b;
        int a1 = y - a;
        
        int[] puntosX = {b1,x,x};
        int[] puntosY = {y,y,a1};
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillPolygon(puntosX, puntosY, 3);
        }else{
            g.drawPolygon(puntosX, puntosY, 3);
        }
        
    }
    
    public static void graficarEstrella(int x, int y, int p, String color, String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
    
    // Obtener las dimensiones del panel
    int panelWidth = Interfaz.jPanel1.getWidth();
    int panelHeight = Interfaz.jPanel1.getHeight();
    
    // Ajustar las coordenadas para asegurar que la estrella esté dentro del panel
    x = Math.max(p, Math.min(x, panelWidth - p));
    y = Math.max(p, Math.min(y, panelHeight - p));
    
    int[] xPoints = new int[10];
    int[] yPoints = new int[10];
    
    int radioExterior = p;

    int radioInterior = p * 1/2;
    

    double angulo = Math.PI / 2;

    double incrementoAngulo = 2 * Math.PI / 10;

    for (int i = 0; i < 10; i++) {
        int radio = (i % 2 == 0) ? radioExterior : radioInterior;
        
        double currentAngle = angulo - (i * incrementoAngulo);
        xPoints[i] = (int) (x + radio * Math.cos(currentAngle));
        yPoints[i] = (int) (y - radio * Math.sin(currentAngle));
    }
        
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if ("rellena".equals(tipo.toLowerCase())) {
            g.fillPolygon(xPoints, yPoints, 10);
    } else {
            g.drawPolygon(xPoints, yPoints, 10);
    }
        
    }
    
    public static void graficarPoligono(int[] x,int[] y, int n, String color , String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
            
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillPolygon(x, y, n);
        }else{
            g.drawPolygon(x, y, n);
        }
        
        }
    
    public static void graficarPacman(int x, int y, String s, String color , String tipo){
        Graphics g = Interfaz.jPanel1.getGraphics();
        
        int t = 50;
        
        if("pequeno".equals(s)){
            t = t;
        }
        if("mediano".equals(s)){
            t = t*2;
        }
        if("grande".equals(s)){
            t = t*3;
        }
        
        
        switch (color){
            case "rojo":{
                g.setColor(Color.red);
                break;
            }
            case "azul":{
                g.setColor(Color.blue);
                break;
            }
            case "celeste":{
                g.setColor(celeste);
                break;
            }
            case "verde":{
                g.setColor(Color.green);
                break;
            }
            case "negro":{
                g.setColor(Color.black);
                break;
            }
            case "morado":{
                g.setColor(morado);
                break;
            }
            case "anaranjado":{
                g.setColor(Color.orange);
                break;
            }
            case "rosado":{
                g.setColor(Color.pink);
                break;
            }
            case "cafe":{
                g.setColor(cafe);
                break;
            }
            case "amarillo":{
                g.setColor(Color.yellow);
                break;
            }
            case "gris":{
                g.setColor(Color.gray);
                break;
            }
            default:{
                System.out.println("Ingrese un color vólido.");
            }
        }
        
        if("rellena".equals(tipo)){
            g.fillArc(x, y, t, t, 30, 260);
        }else{
            g.drawArc(x, y, t, t, 30, 260);
        }
    }
    
}
