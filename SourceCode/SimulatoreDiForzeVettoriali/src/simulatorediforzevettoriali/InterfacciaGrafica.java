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
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author andrea.frati
 */
public class InterfacciaGrafica extends javax.swing.JFrame {

    private ArrayList<Vector> vectors = new ArrayList<>();
    private Vector vectorTemp = new Vector(0, 0, "a");
    private Vector fRis = new Vector(0, 0, "forza risultante");
    private double xRis = 0;
    private double yRis = 0;
    private double xObject;
    private double yObject;
    private double xCenter;
    private double yCenter;
    private boolean firstPaint = true;
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
        bi = new BufferedImage(canvasPanel.getWidth(), canvasPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        big = bi.createGraphics();
        big.setStroke(new BasicStroke(0.8f));
        big.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        big.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        xCenter = (canvasPanel.getX() + canvasPanel.getWidth()) / 2;
        yCenter = (canvasPanel.getY() + canvasPanel.getHeight()) / 2;
        if(firstPaint){
            firstPaint = false;
            xObject = xCenter;
            yObject = yCenter;
        }
        for (int i = 0; i < vectors.size(); i++) {
            big.draw(new Line2D.Double(xObject, yObject, (int) vectors.get(i).x + xObject, (int) vectors.get(i).y + yObject));
        }
        if (drag) {
            big.draw(new Line2D.Double(x, y, (int) vectorTemp.x, (int) vectorTemp.y));
        }
        big.draw(new Line2D.Double(xCenter, yCenter, xObject, yObject));
        big.fill(new Ellipse2D.Double(xObject - 10, yObject - 10, 20, 20));
        
        g2.drawImage(bi, 0, 0, this);
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
        jButton1 = new javax.swing.JButton();
        canvasPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        startButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        angoloLabel.setText("Angolo");

        forzaLabel.setText("Forza");

        xCoordLabel.setText("X");

        yCoordLabel.setText("Y");

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
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
                    .addComponent(textAngolo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textForza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textX1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textY1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColor, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
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

        jButton1.setText("remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controlsPanelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(vectorInputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox1))
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
                .addGap(99, 99, 99)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        controlsPanelLayout.setVerticalGroup(
            controlsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
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

        canvasPanel.setBackground(new java.awt.Color(255, 0, 51));
        canvasPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        String nameVar = textName.getText();
        if (!(nameVar.equals(""))) {
            Vector vector;
            if (jCheckBox1.isSelected()) {
                vector = new Vector(nameVar, Double.parseDouble(textAngolo.getText()), Double.parseDouble(textForza.getText()));
            } else {
                vector = new Vector(Double.parseDouble(textX1.getText()), Double.parseDouble(textY1.getText()), nameVar);
            }
            vectors.add(vector);
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
            allVisible();
            createButton.setVisible(false);
            textX1.setText(vector.x + "");
            textY1.setText(vector.y + "");
            textForza.setText(vector.forza + "");
            textAngolo.setText(vector.angolo + "");
            jCheckBox1.setEnabled(true);
            xRis += vector.x;
            yRis += vector.y;
            fRis = new Vector(xRis, yRis, "forza risultante");
            vectors.set(0, fRis);
            repaint();
        }

    }//GEN-LAST:event_createButtonActionPerformed

    private void vectorListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vectorListKeyPressed

    }//GEN-LAST:event_vectorListKeyPressed

    private void vectorListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vectorListMouseClicked
        int[] selectedVectors = vectorList.getSelectedIndices();
        if (selectedVectors.length == 1) {
            textX1.setText(String.valueOf(vectors.get(selectedVectors[0]).x));
            textY1.setText(String.valueOf(vectors.get(selectedVectors[0]).y));
            textForza.setText(String.valueOf(vectors.get(selectedVectors[0]).forza));
            textAngolo.setText(String.valueOf(vectors.get(selectedVectors[0]).angolo));
            textName.setText(vectors.get(selectedVectors[0]).name);
        }
    }//GEN-LAST:event_vectorListMouseClicked

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed
    int x;
    int y;
    int finalX;
    int finalY;
    int num = 0;
    boolean drag = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed
    private void updateList() {
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
        xRis = 0;
        yRis = 0;
        for (int i = 1; i < vectors.size(); i++) {
            xRis += vectors.get(i).x;
            yRis += vectors.get(i).y;
        }
        repaint();
    }
    private void canvasPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasPanelMouseReleased
        finalX = evt.getX() - x;
        finalY = evt.getY() - y;
        Vector vector = new Vector(finalX, finalY, "drawVector" + num);
        num += 1;
        vectors.add(vector);
        updateList();
        allVisible();
        vectorInputPanel.updateUI();
        textX1.setText(vector.x + "");
        textY1.setText(vector.y + "");
        textForza.setText(vector.forza + "");
        textAngolo.setText(vector.angolo + "");
        jCheckBox1.setEnabled(true);
        xRis += vector.x;
        yRis += vector.y;
        fRis = new Vector(xRis, yRis, "forza risultante");
        vectors.set(0, fRis);
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
        vectorTemp = new Vector(finalX, finalY, "vettoreTemporaneoXMouseDragged");
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
        repaint();
    }//GEN-LAST:event_startButtonActionPerformed

    private void buttonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColorActionPerformed
        /*Color color = Color.BLACK;
        color = JColorChooser.showDialog(null, 'scegli un colore', colore);
        vectorList.setSelectedIndices(indices);
         for (int i = 0; i < vectors.size(); i++) {
            
        }*/
    }//GEN-LAST:event_buttonColorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

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
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newVectorButton;
    private javax.swing.JButton resetButton;
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
