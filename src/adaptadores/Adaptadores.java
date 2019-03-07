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
        reproductor = new FormatAdapter(new VLC());
        reproductor.playFilm("file.avi");
    }

    private static class FormatAdapter implements MediaPlayer,MediaDivX {

        private MediaPackage media;
        
        public FormatAdapter(MediaPackage m) {
            media = m;
        }

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
        }

        @Override
        public void playFilm(String filename) {
            System.out.print("Using Adapter2 --> ");
            media.playFile(filename);
        }
        
    }
}
