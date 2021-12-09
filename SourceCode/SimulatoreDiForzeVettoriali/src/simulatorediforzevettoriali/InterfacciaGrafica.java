/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorediforzevettoriali;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author andrea.frati
 */
public class InterfacciaGrafica extends javax.swing.JFrame {
    
    private ArrayList<Vector> vectors = new ArrayList<>();
    private Vector vectorTemp = new Vector(0, 0, "a", false);
    private Vector fRis = new Vector(0, 0, "forza risultante", false);
    private double xRis = 0;
    private double yRis = 0;
    private double xObject;
    private double yObject;
    private double xCenter;
    private double yCenter;
    private boolean firstVec = true;
    private boolean enableKeyInput;
    private boolean firstPaint = true;
    boolean animationStarted = false;
    int x;
    int y;
    int finalX;
    int finalY;
    int num = 0;
    boolean drag = false;
    BufferedImage bi;
    Graphics2D big;
    Timer timer;
    ActionListener act;

    /**
     * Creates new form InterfacciaGrafica
     */
    public InterfacciaGrafica() {
        initComponents();
        allInvisible();
        backButton.setVisible(false);
        createButton.setVisible(false);
        vectors.add(fRis);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g = canvasPanel.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        drawGrid(g2);
        bi = new BufferedImage(canvasPanel.getWidth(), canvasPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        big = bi.createGraphics();
        
        big.setStroke(new BasicStroke(0.8f));
        big.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        big.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        xCenter = (canvasPanel.getX() + canvasPanel.getWidth()) / 2;
        yCenter = (canvasPanel.getY() + canvasPanel.getHeight()) / 2;
        if (firstPaint) {
            firstPaint = false;
            xObject = xCenter;
            yObject = yCenter;
        }
        big.setColor(Color.RED);
        for (int i = 0; i < vectors.size(); i++) {
            big.draw(new Line2D.Double(xObject, yObject, (int) vectors.get(i).x + xObject, (int) vectors.get(i).y + yObject));
            big.setColor(vectors.get(i).colore);
            
        }
        if (drag) {
            big.setColor(Color.BLACK);
            big.draw(new Line2D.Double(x, y, (int) vectorTemp.x, (int) vectorTemp.y));
           // big.draw(new Line2D.Double(xCenter, yCenter, (int) vectorTemp.x, (int) vectorTemp.y));
        }
        //big.setColor(Color.BLUE);
        //big.draw(new Line2D.Double(xCenter, yCenter, xObject, yObject));
        big.setColor(Color.BLACK);
        big.fill(new Ellipse2D.Double(xObject - 10, yObject - 10, 20, 20));
        
        g2.drawImage(bi, 0, 0, this);
    }
    
    private void drawGrid(Graphics g) {
        int size = 10;
        int gw = canvasPanel.getWidth();
        int gh = canvasPanel.getHeight();
        g.drawString(String.format("0;0"), 0, 10);
        for (int gx = 0; gx < gw; gx += size) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(gx, 0, gx, gh);
            if (x == gh/gw){
                g.setColor(Color.BLACK);
                g.drawString(String.format("%d",gx), gx, 0);
            }            
        }
        for (int gy = 0; gy < gh; gy += size) { 
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, gy, gw, gy);
            if (y == gw/gw){
                g.setColor(Color.BLACK);
                g.drawString(String.format("%d",gy), 0, gy);
            }
        }        
    }
    
    public void allVisible() {
        buttonColor.setVisible(true);
        angoloLabel.setVisible(true);
        forzaLabel.setVisible(true);
        xCoordLabel.setVisible(true);
        yCoordLabel.setVisible(true);
        nameLabel.setVisible(true);
        
        textColor.setVisible(true);
        textForza.setVisible(true);
        textAngolo.setVisible(true);
        textX1.setVisible(true);
        textY1.setVisible(true);
        textName.setVisible(true);
    }
    
    public void allInvisible() {
        buttonColor.setVisible(false);
        angoloLabel.setVisible(false);
        forzaLabel.setVisible(false);
        xCoordLabel.setVisible(false);
        yCoordLabel.setVisible(false);
        nameLabel.setVisible(false);
        
        textColor.setVisible(false);
        textForza.setVisible(false);
        textAngolo.setVisible(false);
        textX1.setVisible(false);
        textY1.setVisible(false);
        textName.setVisible(false);
    }
    
    public void setEmptyText() {
        textX1.setText("");
        textY1.setText("");
        textForza.setText("");
        textAngolo.setText("");
        textName.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlsPanel = new javax.swing.JPanel();
        vectorInputPanel = new javax.swing.JPanel();
        angoloLabel = new javax.swing.JLabel();
        forzaLabel = new javax.swing.JLabel();
        xCoordLabel = new javax.swing.JLabel();
        yCoordLabel = new javax.swing.JLabel();
        textAngolo = new javax.swing.JTextField();
        textForza = new javax.swing.JTextField();
        textX1 = new javax.swing.JTextField();
        textY1 = new javax.swing.JTextField();
        textName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        buttonColor = new javax.swing.JButton();
        textColor = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        vectorsScrollPane = new javax.swing.JScrollPane();
        vectorList = new javax.swing.JList<>();
        newVectorButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        canvasPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        startButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        controlsPanel.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                controlsPanelAncestorResized(evt);
            }
        });

        angoloLabel.setText("Angolo°");

        forzaLabel.setText("Forza");

        xCoordLabel.setText("X");

        yCoordLabel.setText("Y");

        textAngolo.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAngoloCaretUpdate(evt);
            }
        });

        textForza.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textForzaCaretUpdate(evt);
            }
        });

        textX1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textX1CaretUpdate(evt);
            }
        });

        textY1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textY1CaretUpdate(evt);
            }
        });

        textName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textNameCaretUpdate(evt);
            }
        });
        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });
        textName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textNamePropertyChange(evt);
            }
        });
        textName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNameKeyTyped(evt);
            }
        });

        nameLabel.setText("Nome");

        buttonColor.setText("color");
        buttonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColorActionPerformed(evt);
            }
        });

        textColor.setText("colore");

        javax.swing.GroupLayout vectorInputPanelLayout = new javax.swing.GroupLayout(vectorInputPanel);
        vectorInputPanel.setLayout(vectorInputPanelLayout);
        vectorInputPanelLayout.setHorizontalGroup(
            vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vectorInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(angoloLabel)
                    .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(xCoordLabel)
                        .addComponent(forzaLabel)
                        .addComponent(yCoordLabel))
                    .addComponent(textColor))
                .addGap(18, 18, 18)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textName)
                    .addGroup(vectorInputPanelLayout.createSequentialGroup()
                        .addComponent(buttonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 121, Short.MAX_VALUE))
                    .addComponent(textAngolo)
                    .addComponent(textForza)
                    .addComponent(textX1)
                    .addComponent(textY1))
                .addContainerGap())
        );
        vectorInputPanelLayout.setVerticalGroup(
            vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vectorInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAngolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(angoloLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textForza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forzaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xCoordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yCoordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vectorInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vectorInputPanelLayout.createSequentialGroup()
                        .addComponent(textColor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        createButton.setText("CREATE");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        jCheckBox1.setText("coordinate polari");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        vectorList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        vectorList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vectorListMouseClicked(evt);
            }
        });
        vectorList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                vectorListKeyPressed(evt);
            }
        });
        vectorsScrollPane.setViewportView(vectorList);

        newVectorButton.setText("NUOVO VETTORE");
        newVectorButton.setFocusable(false);
        newVectorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newVectorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        newVectorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newVectorButtonActionPerformed(evt);
            }
        });

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        removeButton.setText("remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlsPanelLayout = new javax.swing.GroupLayout(controlsPanel);
        controlsPanel.setLayout(controlsPanelLayout);
        controlsPanelLayout.setHorizontalGroup(
            controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlsPanelLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(controlsPanelLayout.createSequentialGroup()
                        .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vectorsScrollPane)
                            .addGroup(controlsPanelLayout.createSequentialGroup()
                                .addComponent(newVectorButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(controlsPanelLayout.createSequentialGroup()
                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlsPanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(removeButton))
                    .addGroup(controlsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(vectorInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        controlsPanelLayout.setVerticalGroup(
            controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsPanelLayout.createSequentialGroup()
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vectorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vectorInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newVectorButton)
                    .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createButton)
                        .addComponent(backButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(controlsPanel, java.awt.BorderLayout.EAST);

        canvasPanel.setBackground(new java.awt.Color(255, 255, 255));
        canvasPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        canvasPanel.setForeground(new java.awt.Color(255, 255, 255));
        canvasPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        canvasPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        canvasPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasPanelMouseDragged(evt);
            }
        });
        canvasPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout canvasPanelLayout = new javax.swing.GroupLayout(canvasPanel);
        canvasPanel.setLayout(canvasPanelLayout);
        canvasPanelLayout.setHorizontalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        canvasPanelLayout.setVerticalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        getContentPane().add(canvasPanel, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(startButton);

        resetButton.setText("RESET");
        resetButton.setFocusable(false);
        resetButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(resetButton);

        stopButton.setText("STOP");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(stopButton);

        saveButton.setText("SAVE");
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(saveButton);

        importButton.setText("IMPORT");
        importButton.setFocusable(false);
        importButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(importButton);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public String[] addVectorNames() {
        String[] vectorNames = new String[vectors.size() + 1];
        for (int i = 0; i < vectors.size(); i++) {
            vectorNames[i] = vectors.get(i).getName();
        }
        return vectorNames;
    }
    private void newVectorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newVectorButtonActionPerformed
        allVisible();
        setEmptyText();
        repaint();
        createButton.setVisible(true);
        if (jCheckBox1.isSelected()) {
            textX1.setVisible(false);
            textY1.setVisible(false);
        } else {
            textForza.setVisible(false);
            textAngolo.setVisible(false);
        }
        jCheckBox1.setEnabled(false);
        backButton.setVisible(true);
    }//GEN-LAST:event_newVectorButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

    }//GEN-LAST:event_jCheckBox1ActionPerformed
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        String nameVar = textName.getText();
        /*int[] selected = vectorList.getSelectedIndices();
        if (selected[0] != 0) {*/
        if (!(nameVar.equals(""))) {
            Vector vector = null;
            if (jCheckBox1.isSelected() && isDouble(textAngolo.getText()) && isDouble(textForza.getText())) {
                vector = new Vector(Double.parseDouble(textAngolo.getText()), Double.parseDouble(textForza.getText()), nameVar, true);
                vectors.add(vector);
            } else if (isDouble(textX1.getText()) && isDouble(textY1.getText())) {
                vector = new Vector(Double.parseDouble(textX1.getText()), Double.parseDouble(textY1.getText()), nameVar, false);
                vectors.add(vector);
            }
            if (vector != null) {
                enableKeyInput = false;
                updateList();
                allVisible();
                createButton.setVisible(false);
                textX1.setText(vector.x + "");
                textY1.setText(vector.y + "");
                textForza.setText(vector.forza + "");
                textAngolo.setText(vector.angolo + "");
                jCheckBox1.setEnabled(true);
                enableKeyInput = true;
                repaint();
                
            }
        }
        

    }//GEN-LAST:event_createButtonActionPerformed

    private void vectorListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vectorListKeyPressed

    }//GEN-LAST:event_vectorListKeyPressed

    private void vectorListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vectorListMouseClicked
        
        int[] selectedVectors = vectorList.getSelectedIndices();
        if (selectedVectors.length == 1) {
            enableKeyInput = false;
            
            textX1.setText(String.valueOf(vectors.get(selectedVectors[0]).x));
            textY1.setText(String.valueOf(vectors.get(selectedVectors[0]).y));
            textForza.setText(String.valueOf(vectors.get(selectedVectors[0]).forza));
            textAngolo.setText(String.valueOf(vectors.get(selectedVectors[0]).angolo));
            textName.setText(vectors.get(selectedVectors[0]).name);
            enableKeyInput = true;
        }
    }//GEN-LAST:event_vectorListMouseClicked

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed
    
    private void updateList() {
        xRis = 0;
        yRis = 0;
        for (int i = 1; i < vectors.size(); i++) {
            xRis += vectors.get(i).x;
            yRis += vectors.get(i).y;
        }
        fRis = new Vector(xRis, yRis, "forza risultante", false);
        vectors.set(0, fRis);
        vectorList.setModel(new javax.swing.AbstractListModel<String>() {
            
            String[] strings = addVectorNames();
            
            public int getSize() {
                return strings.length;
            }
            
            public String getElementAt(int i) {
                return strings[i];
            }
        });
        vectorsScrollPane.setViewportView(vectorList);
        vectorsScrollPane.updateUI();
        vectorList.setSelectedIndex(vectors.size() - 1);
        repaint();
    }
    private void canvasPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanelMouseReleased
        
        finalX = evt.getX() - x;
        finalY = evt.getY() - y;
        Vector vector = new Vector(finalX, finalY, "drawVector" + num, false);
        
        vectors.add(vector);
        enableKeyInput = false;
        allVisible();
        vectorInputPanel.updateUI();
        textX1.setText(vector.x + "");
        textY1.setText(vector.y + "");
        textForza.setText(vector.forza + "");
        textAngolo.setText(vector.angolo + "");
        textName.setText("drawVector" + num);
        enableKeyInput = true;
        num += 1;
        //jCheckBox1.setEnabled(true);
        if (!firstVec) {
            xRis += vector.x;
            yRis += vector.y;
        }
        firstVec = false;
        fRis = new Vector(xRis, yRis, "forza risultante", false);
        vectors.set(0, fRis);
        
        updateList();
        
        drag = false;
        
        repaint();
    }//GEN-LAST:event_canvasPanelMouseReleased

    private void canvasPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanelMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_canvasPanelMousePressed

    private void canvasPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanelMouseDragged
        finalX = evt.getX();
        finalY = evt.getY();
        vectorTemp = new Vector(finalX, finalY, "vettoreTemporaneoXMouseDragged", false);
        drag = true;
        repaint();
        //repaint(finalX, finalY, 0, 0);
    }//GEN-LAST:event_canvasPanelMouseDragged

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        allInvisible();
        setEmptyText();
        repaint();
        jCheckBox1.setEnabled(true);
        backButton.setVisible(false);
        createButton.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        timer.stop();
        xObject = xCenter;
        yObject = yCenter;
        repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        
        timer.stop();
        repaint();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        ActionListener act;
        act = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                xObject += xRis / 150;
                yObject += yRis / 150;
                repaint();
            }
        };
        timer = new Timer(1, act);
        timer.start();
        animationStarted = true;
    }//GEN-LAST:event_startButtonActionPerformed

    private void buttonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorActionPerformed
        int[] selected = vectorList.getSelectedIndices();
        if (selected.length == 1) {
            Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLUE);
            vectors.get(selected[0] - 1).colore = newColor;
            repaint();
        }
    }//GEN-LAST:event_buttonColorActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        int[] selected = vectorList.getSelectedIndices();
        if (selected == null || selected.length == 0) {
            return;
        }
        if (selected[0] != 0 && vectors.size() - selected.length > 1) {
            for (int i = 0; i < selected.length; i++) {
                vectors.remove(selected[i]);
            }
        }
        updateList();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        for (int i = 1; i < vectors.size(); i++) {
            Vector vector = vectors.get(i);
            try {
                saveState(vector);
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile.getName());
            try {
                importFile(selectedFile);
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void controlsPanelAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_controlsPanelAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_controlsPanelAncestorResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        xCenter = (canvasPanel.getX() + canvasPanel.getWidth()) / 2;
        yCenter = (canvasPanel.getY() + canvasPanel.getHeight()) / 2;
        xObject = xCenter;
        yObject = yCenter;
        repaint();
    }//GEN-LAST:event_formAncestorResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (!animationStarted) {
            xCenter = (canvasPanel.getX() + canvasPanel.getWidth()) / 2;
            yCenter = (canvasPanel.getY() + canvasPanel.getHeight()) / 2;
            xObject = xCenter;
            yObject = yCenter;
        }
        repaint();
    }//GEN-LAST:event_formComponentResized

    private void textNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textNamePropertyChange
//        if(changedKeyInput){
//            int[] selected = vectorList.getSelectedIndices();
//            System.out.println("a");
//            if (selected.length == 1 && selected[0] != 0) {
//                vectors.get(selected[0]).name = textName.getText();
//                updateList();
//            }
//            
//        }
    }//GEN-LAST:event_textNamePropertyChange

    private void textNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNameKeyReleased

    }//GEN-LAST:event_textNameKeyReleased

    private void textNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNameKeyTyped

    }//GEN-LAST:event_textNameKeyTyped

    private void textNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textNameCaretUpdate
        if (enableKeyInput) {
            int selected = vectorList.getSelectedIndex();
            if (selected > 0 && (textName.getText()).length() > 0) {
                vectors.get(selected).name = textName.getText();
                updateList();
                vectorList.setSelectedIndex(selected);
            }
        }
    }//GEN-LAST:event_textNameCaretUpdate

    private void textAngoloCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textAngoloCaretUpdate
        if (enableKeyInput) {
            int selected = vectorList.getSelectedIndex();
            System.out.println(String.format("A  selected %d, text: %s, angolo %s, forza %s, x: %s, y: %s", selected, textName.getText(), textAngolo.getText(), textForza.getText(), textX1.getText(), textY1.getText()));
            if (selected > 0 && (textAngolo.getText()).length() > 0) {
                if (isDouble(textAngolo.getText())) {
                    
                    Double angolo = Double.parseDouble(textAngolo.getText());
                    vectors.get(selected).setAngolo(angolo);
                    System.out.println(vectors.get(selected));
                    enableKeyInput = false;
                    textX1.setText(vectors.get(selected).x + "");
                    textY1.setText(vectors.get(selected).y + "");
                    enableKeyInput = true;
                    updateList();
                    vectorList.setSelectedIndex(selected);
                }
            }
        }
    }//GEN-LAST:event_textAngoloCaretUpdate

    private void textForzaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textForzaCaretUpdate
        if (enableKeyInput) {
            int selected = vectorList.getSelectedIndex();
            System.out.println(String.format("F  selected %d, text: %s, angolo %s, forza %s, x: %s, y: %s", selected, textName.getText(), textAngolo.getText(), textForza.getText(), textX1.getText(), textY1.getText()));
            if (selected > 0 && (textForza.getText()).length() > 0) {
                if (isDouble(textForza.getText())) {
                    //if(vectors.get(selected).x<0 && vectors.get(selected).y<0){
                    //vectors.get(selected).x = vectors.get(selected).x*-1;
                    //vectors.get(selected).y = vectors.get(selected).y*-1;
                    //}
                    Double forza = Double.parseDouble(textForza.getText());
                    vectors.get(selected).setForza(forza);
                    System.out.println(vectors.get(selected));
                    enableKeyInput = false;
                    textX1.setText(vectors.get(selected).x + "");
                    textY1.setText(vectors.get(selected).y + "");
                    enableKeyInput = true;
                    updateList();
                    vectorList.setSelectedIndex(selected);
                }
            }
        }
    }//GEN-LAST:event_textForzaCaretUpdate

    private void textX1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textX1CaretUpdate
        if (enableKeyInput) {
            int selected = vectorList.getSelectedIndex();
            System.out.println(String.format("X1 selected %d, text: %s, angolo %s, forza %s, x: %s, y: %s", selected, textName.getText(), textAngolo.getText(), textForza.getText(), textX1.getText(), textY1.getText()));
            if (selected > 0 && (textX1.getText()).length() > 0) {
                if (isDouble(textX1.getText())) {
                    
                    Double x = Double.parseDouble(textX1.getText());
                    vectors.get(selected).setX(x);
                    System.out.println(vectors.get(selected));
                    enableKeyInput = false;
                    textAngolo.setText(vectors.get(selected).angolo + "");
                    textForza.setText(vectors.get(selected).forza + "");
                    enableKeyInput = true;
                    updateList();
                    vectorList.setSelectedIndex(selected);
                }
            }
        }
    }//GEN-LAST:event_textX1CaretUpdate

    private void textY1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_textY1CaretUpdate
        if (enableKeyInput) {
            int selected = vectorList.getSelectedIndex();
            System.out.println(String.format("Y1 selected %d, text: %s, angolo %s, forza %s, x: %s, y: %s", selected, textName.getText(), textAngolo.getText(), textForza.getText(), textX1.getText(), textY1.getText()));
            
            if (selected > 0 && (textY1.getText()).length() > 0) {
                if (isDouble(textY1.getText())) {
                    
                    Double y = Double.parseDouble(textY1.getText());
                    vectors.get(selected).setY(y);
                    System.out.println(vectors.get(selected));
                    enableKeyInput = false;
                    textAngolo.setText(vectors.get(selected).angolo + "");
                    textForza.setText(vectors.get(selected).forza + "");
                    enableKeyInput = true;
                    updateList();
                    vectorList.setSelectedIndex(selected);
                }
            }
        }
    }//GEN-LAST:event_textY1CaretUpdate
    private void saveState(Vector vector) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        String nameFile = "vectors" + dtf.format(now) + ".txt";
        Path fileName = Paths.get(nameFile);
        String text = vector.x + ";" + vector.y + ";" + vector.forza + ";" + vector.angolo + ";" + vector.name + ";" + xObject + ";" + yObject + "\n";
        File myObj = new File("vectors" + dtf.format(now) + ".txt");
        myObj.createNewFile();
        Files.write(fileName, text.getBytes(), StandardOpenOption.APPEND);

        //String file_content = Files.readString(fileName);
    }
    
    private void importFile(File selectedFile) throws IOException {
        Path fileName = selectedFile.toPath();
        if (Files.exists(fileName) && Files.isReadable(fileName)) {
            List<String> lines = Files.readAllLines(fileName);
            vectors.clear();
            vectors.add(fRis);
            for (String line : lines) {
                String[] parts = line.split(";");
                Vector vector = new Vector(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]), parts[4], false);
                xObject = Double.parseDouble(parts[5]);
                yObject = Double.parseDouble(parts[6]);
                vectors.add(vector);
            }
            updateList();
            allVisible();
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacciaGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacciaGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel angoloLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JButton buttonColor;
    private javax.swing.JPanel canvasPanel;
    private javax.swing.JPanel controlsPanel;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel forzaLabel;
    private javax.swing.JButton importButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newVectorButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTextField textAngolo;
    private javax.swing.JLabel textColor;
    private javax.swing.JTextField textForza;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textX1;
    private javax.swing.JTextField textY1;
    private javax.swing.JPanel vectorInputPanel;
    private javax.swing.JList<String> vectorList;
    private javax.swing.JScrollPane vectorsScrollPane;
    private javax.swing.JLabel xCoordLabel;
    private javax.swing.JLabel yCoordLabel;
    // End of variables declaration//GEN-END:variables
}
