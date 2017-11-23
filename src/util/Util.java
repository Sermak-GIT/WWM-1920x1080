/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Egidius Mysliwietz
 */
public class Util {
    
    Clip clip;
    
    public void playSound(String name) {
        try {
         URL url = getClass().getResource("/assets/music/"+ name +".wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         Clip clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loopSound(String name) {
        try {
         URL url = getClass().getResource("/assets/music/"+ name +".wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.loop(-1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loopSound(String name, int times) {
        try {
         URL url = getClass().getResource("/assets/music/"+ name +".wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.loop(times);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void stopSound() {
        clip.close();
    }
    
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        System.out.println(dimension.getSize());
        //       setLocationRelativeTo(null); ODER SO
        frame.setLocation(x, y);
    }
    
    public static void setWindow(Window frame, double xProz, double yProz) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) * (xProz / 100));
        int y = (int) ((dimension.getHeight() - frame.getHeight()) * (yProz /100));
        //System.out.println(dimension.getSize( ));
        frame.setLocation(x, y);
    }
    
    public  void wip() {
        JOptionPane.showMessageDialog(null, "Wörk in prögress", "Stüff nöt wörking yet", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/assets/img/util/wörk.png")));
    }
    
    public void appendToPane(JTextPane tp, String msg, Color c, String font) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, font);
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
    
    public void writeToPane(JTextPane tp, String msg, Color c, String font) {
        tp.setText("");
        appendToPane(tp, msg, c, font);
    }
    
    public String convertTimeFromMilSecsToReadable(Long time) {
        int minutes = (int) (time/60000);
        time -= minutes*60000;
        int seconds = (int) (time/1000);
        time -= seconds*1000;
        return minutes+":"+seconds+":"+time;
    }
}
