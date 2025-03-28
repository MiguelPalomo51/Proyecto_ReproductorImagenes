/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatas.reproductor_imagenes;

import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Album {
   private String name;
    private ArrayList<Photo> photos;
    private int tiempo;
    
    public Album(String name) {
        this.name = name;
        this.photos = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public int Largo(){
        return this.photos.size();
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    } 

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
