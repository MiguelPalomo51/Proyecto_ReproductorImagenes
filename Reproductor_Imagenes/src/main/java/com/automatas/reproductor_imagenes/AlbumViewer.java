/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.automatas.reproductor_imagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author miguel
 */
public class AlbumViewer extends javax.swing.JFrame {

    private AlbumManager albumManager;
    private JComboBox<String> albumComboBox;
    private JLabel photoLabel;
    private Timer slideShowTimer;
    private Album currentAlbum;
    private int currentPhotoIndex = 0;
    private boolean loopInfinite = false;
    private boolean manualPlayback = false;
    private boolean isPaused = false; // Nueva variable para controlar el estado de pausa

    public AlbumViewer() {
        albumManager = new AlbumManager();
        initUI();
    }

    private void initUI() {
        setTitle("Reproductor De Albumes");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        albumComboBox = new JComboBox<>();
        updateAlbumComboBox();

        JButton createAlbumButton = new JButton("Crear Album");
        createAlbumButton.addActionListener(e -> createAlbum());

        JButton saveButton = new JButton("Guardar Album");
        saveButton.addActionListener(e -> albumManager.saveAlbums());

        JButton loadButton = new JButton("Recargar Album");
        loadButton.addActionListener(e -> updateAlbumComboBox());

        photoLabel = new JLabel();
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.add(createAlbumButton);
        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        controlPanel.add(albumComboBox);

        panel.add(controlPanel, BorderLayout.NORTH);
        panel.add(photoLabel, BorderLayout.CENTER);

        JButton playButton = new JButton("Reproducir");
        playButton.addActionListener(e -> playAlbum());

        JButton pauseButton = new JButton("Pausar");
        pauseButton.addActionListener(e -> pauseAlbum());

        JButton stopButton = new JButton("Detener");
        stopButton.addActionListener(e -> stopAlbum());

        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(e -> showNextPhoto());

        JButton prevButton = new JButton("Anterior");
        prevButton.addActionListener(e -> showPreviousPhoto());

        JButton firstButton = new JButton("Primera foto");
        firstButton.addActionListener(e -> showFirstPhoto());

        JButton lastButton = new JButton("Ultima foto");
        lastButton.addActionListener(e -> showLastPhoto());
        
        JButton irButton = new JButton("Ir");
        irButton.addActionListener(e -> showXPhoto());

        JCheckBox loopCheckbox = new JCheckBox("Loop Infinito");
        loopCheckbox.addActionListener(e -> loopInfinite = loopCheckbox.isSelected());

        JCheckBox manualCheckbox = new JCheckBox("Reproducción Manual");
        manualCheckbox.addActionListener(e -> manualPlayback = manualCheckbox.isSelected());

        JPanel controlPanel2 = new JPanel();
        controlPanel2.add(playButton);
        controlPanel2.add(pauseButton);
        controlPanel2.add(stopButton);
        controlPanel2.add(prevButton);
        controlPanel2.add(nextButton);
        controlPanel2.add(firstButton);
        controlPanel2.add(lastButton);
        controlPanel2.add(irButton);
        controlPanel2.add(loopCheckbox);
        controlPanel2.add(manualCheckbox);

        panel.add(controlPanel2, BorderLayout.SOUTH);
        add(panel);
    }

    private void updateAlbumComboBox() {
        albumComboBox.removeAllItems();
        for (Album album : albumManager.getAlbums()) {
            albumComboBox.addItem(album.getName());
        }
    }

    private void createAlbum() {
        String name = JOptionPane.showInputDialog(this, "Ingrese el nombre del álbum:");
        if (name == null || name.trim().isEmpty()) {
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File[] files = fileChooser.getSelectedFiles();
        ArrayList<File> photoFiles = new ArrayList<>();
        for (File file : files) {
            photoFiles.add(file);
        }

        albumManager.createAlbum(name, photoFiles);
        updateAlbumComboBox();
    }

    private void playAlbum() {
        String selectedAlbumName = (String) albumComboBox.getSelectedItem();
        if (selectedAlbumName == null) {
            return;
        }

        currentAlbum = null;
        for (Album album : albumManager.getAlbums()) {
            if (album.getName().equals(selectedAlbumName)) {
                currentAlbum = album;
                break;
            }
        }

        if (currentAlbum != null) {
            if (isPaused) {
                isPaused = false;
                if (slideShowTimer == null) {
                    slideShowTimer = new Timer(1000, e -> showNextPhoto());
                }
                slideShowTimer.start();
            } else {
                currentPhotoIndex = 0;
                showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
                if (slideShowTimer != null) {
                    slideShowTimer.stop();
                }
                if (!manualPlayback) {
                    slideShowTimer = new Timer(1000, e -> showNextPhoto());
                    slideShowTimer.start();
                }
            }
        }
    }

    private void pauseAlbum() {
        if (slideShowTimer != null && slideShowTimer.isRunning()) {
            slideShowTimer.stop();
            isPaused = true; // Marca como pausado
        }
    }

    private void stopAlbum() {
        if (slideShowTimer != null) {
            slideShowTimer.stop();
        }
        currentPhotoIndex = 0;
        if (currentAlbum != null && !currentAlbum.getPhotos().isEmpty()) {
            showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
        }
        isPaused = false; // Resetea el estado de pausa
    }

    private void showNextPhoto() {
        if (currentAlbum == null || currentAlbum.getPhotos().isEmpty()) {
            return;
        }

        currentPhotoIndex++;
        if (currentPhotoIndex >= currentAlbum.getPhotos().size()) {
            if (loopInfinite) {
                currentPhotoIndex = 0;
            } else {
                currentPhotoIndex = currentAlbum.getPhotos().size() - 1;
                if (slideShowTimer != null) {
                    slideShowTimer.stop();
                }
                return;
            }
        }
        showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
    }

    private void showPreviousPhoto() {
        if (currentAlbum == null || currentAlbum.getPhotos().isEmpty()) {
            return;
        }

        currentPhotoIndex--;
        if (currentPhotoIndex < 0) {
            if (loopInfinite) {
                currentPhotoIndex = currentAlbum.getPhotos().size() - 1;
            } else {
                currentPhotoIndex = 0;
                if (slideShowTimer != null) {
                    slideShowTimer.stop();
                }
                return;
            }
        }
        showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
    }

    private void showFirstPhoto() {
        if (currentAlbum != null && !currentAlbum.getPhotos().isEmpty()) {
            currentPhotoIndex = 0;
            showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
        }
    }

    private void showLastPhoto() {
        if (currentAlbum != null && !currentAlbum.getPhotos().isEmpty()) {
            currentPhotoIndex = currentAlbum.getPhotos().size() - 1;
            showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
        }
    }
    
    private void showXPhoto() {
        if (currentAlbum != null && !currentAlbum.getPhotos().isEmpty()) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de foto: "));
            currentPhotoIndex = numero-1;
            showPhoto(currentAlbum.getPhotos().get(currentPhotoIndex).getPath());
        }
    }

    private void showPhoto(String path) {
        ImageIcon icon = new ImageIcon(path);
        photoLabel.setIcon(icon);
        photoLabel.setText("");
    }

    /**
     * Creates new form AlbumViewer
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
