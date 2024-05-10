package Helper;

import Model.SoundsEnum;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffects {
    public Clip clip;
    private boolean paused = false;

    public SoundEffects() {
    }

    public void PlaySoundWithEnum(SoundsEnum soundEnum, boolean loop) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String path = "";
        switch (soundEnum)
        {
            case SoundsEnum.MAIN_MENU -> path = "src/resources/mainsound.wav";
            case SoundsEnum.BOARD -> path = "src/resources/playing.wav";
            case SoundsEnum.GAME_OVER -> path = "src/resources/game_over.wav";
            case SoundsEnum.EATS -> path = "src/resources/collect_sound.wav";
            case SoundsEnum.JOKER -> path = "src/resources/joker.wav";
        }
        SetSound(path, loop);
        play();
    }

    public void SetSound(String path, boolean loop) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File(path);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        this.clip = (Clip) AudioSystem.getLine(info);
        this.clip.open(audioStream);
        if (loop) {
            // LineListener ekleyerek müzik bitince tekrar başlat (yalnızca loop true ise)
            clip.addLineListener(new LineListener() {
                public void update(LineEvent evt) {
                    if (!paused){
                        if (evt.getType() == LineEvent.Type.STOP) {
                            clip.setFramePosition(0); // Müziği başa sar
                            clip.start(); // Müziği tekrar başlat
                        }
                    }

                }
            });
        }
    }


    public void play(){
        this.clip.setFramePosition(10);
        this.clip.start();
    }
    public void stop(){
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public void pause(){
        if (!this.paused){
            this.paused = true;
            clip.stop();
        }
    }
    public void notPause(){
        if (this.paused){
            this.paused = false;
            clip.start();
        }
    }
}


