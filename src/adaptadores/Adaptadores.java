package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        MediaDivX reproductor = new DVD();
        reproductor.playFilm("file.dvd");
        reproductor = new FormatAdapter2(new VLC());
        reproductor.playFilm("file.avi");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage media;

        public FormatAdapter(MediaPackage m) {
            media = m;
        }

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
        }
    }
    private static class FormatAdapter2 implements MediaDivX{
        
        private MediaPackage video;
        
        public FormatAdapter2 (MediaPackage v){
            video = v;
        }
        
        @Override
        public void playFilm(String filename) {
            System.out.print("Using Adapter2 --> ");
            video.playFile(filename);
        }
        
    }
}
