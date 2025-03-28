/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatas.reproductor_imagenes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author miguel
 */
public class AlbumXMLHandler {
    private static final String XML_FILE = "albumes.xml";

    public static void saveAlbums(ArrayList<Album> albums) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();
            Element root = document.createElement("albumes");
            document.appendChild(root);

            for (Album album : albums) {
                Element albumElement = document.createElement("album");
                root.appendChild(albumElement);

                Element nameElement = document.createElement("nombre");
                nameElement.appendChild(document.createTextNode(album.getName()));
                albumElement.appendChild(nameElement);
                
                Element cantElement = document.createElement("cantidad");
                cantElement.appendChild(document.createTextNode(String.valueOf(album.Largo())));
                albumElement.appendChild(cantElement);

                Element photosElement = document.createElement("fotos");
                albumElement.appendChild(photosElement);

                for (Photo photo : album.getPhotos()) {
                    Element pathElement = document.createElement("ruta");
                    pathElement.appendChild(document.createTextNode(photo.getPath()));
                    photosElement.appendChild(pathElement);
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(XML_FILE));

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Album> loadAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        try {
            File file = new File(XML_FILE);
            if (!file.exists()) {
                return albums;
            }

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList albumList = document.getElementsByTagName("album");

            for (int i = 0; i < albumList.getLength(); i++) {
                Element albumElement = (Element) albumList.item(i);
                String name = albumElement.getElementsByTagName("nombre").item(0).getTextContent();

                Album album = new Album(name);
                NodeList photoList = albumElement.getElementsByTagName("ruta");
                for (int j = 0; j < photoList.getLength(); j++) {
                    String path = photoList.item(j).getTextContent();
                    album.addPhoto(new Photo(path));
                }

                albums.add(album);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return albums;
    }
}
