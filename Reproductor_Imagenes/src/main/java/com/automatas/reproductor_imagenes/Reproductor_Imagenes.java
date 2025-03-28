/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.automatas.reproductor_imagenes;

import javax.swing.SwingUtilities;

/**
 *
 * @author miguel
 */
public class Reproductor_Imagenes {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlbumViewer viewer = new AlbumViewer();
            viewer.setVisible(true);
        });
    }
}
