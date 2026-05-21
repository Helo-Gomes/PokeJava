package PokeJava;

import javax.sound.sampled.*;
import java.io.File;

public class Musica {

    private Clip clip;

    public void tocar(String caminho){

        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(caminho));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }catch (Exception e){
            System.out.println("Erro ao tocar musiquinha");
        }
    }

    public void parar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
