/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author airin
 */
public class Music {
    
    void playMusic(String musiclocation){
        try
        {
            File musicpath = new File(musiclocation);
            
            if(musicpath.exists()){
                AudioInputStream audio = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
                
//                JOptionPane.showMessageDialog(null, "Hit OK to pause music");
//                long clipTimePosition = clip.getMicrosecondPosition();
//                clip.stop();
//                
//                JOptionPane.showMessageDialog(null, "Hit OK to resume music");
//                clip.setMicrosecondPosition(clipTimePosition);
//                clip.start();
//                
//                JOptionPane.showMessageDialog(null, "Hit OK to stop music");
            }
            else{
                System.out.println("Can't find file");
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
