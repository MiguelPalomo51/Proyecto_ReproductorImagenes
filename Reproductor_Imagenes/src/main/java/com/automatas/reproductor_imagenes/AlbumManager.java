/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatas.reproductor_imagenes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author miguel
 */
public class AlbumManager {
   private ArrayList<Album> albums;

    public AlbumManager() {
        albums = AlbumXMLHandler.loadAlbums();
    }

    public void createAlbum(String name, ArrayList<File> photoFiles) {
        Album album = new Album(name);
        for (File file : photoFiles) {
            album.addPhoto(new Photo(file.getAbsolutePath()));
        }
        albums.add(album);
        saveAlbums();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void saveAlbums() {
        AlbumXMLHandler.saveAlbums(albums);
    }
}
