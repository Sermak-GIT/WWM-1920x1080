/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwm;

import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.System.out;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Egidius Mysliwietz
 */
public class Studio extends javax.swing.JFrame {

    /**
     * Creates new form Studio
     */
    public Studio() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Background Stuff");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d.width, d.height);
        this.setVisible(true);
        //this.setAlwaysOnTop(true);
        labello.setBounds(0, 0, d.width, d.height);
        randomBg();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labello = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labello.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelloMouseClicked(evt);
            }
        });
        getContentPane().add(labello, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelloMouseClicked
        V.u.wip();
    }//GEN-LAST:event_labelloMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel labello;
    // End of variables declaration//GEN-END:variables

    private void randomBg() {
        Random r = new Random();
        labello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/studio/bgs/bg" + (r.nextInt(5) + 1) + ".png")));
    }
}
