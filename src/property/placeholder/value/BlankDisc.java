package property.placeholder.value;

import org.springframework.beans.factory.annotation.Value;

public class BlankDisc implements CompactDisc {

    private String title;

    private String artist;

    public BlankDisc() {
    }

    public BlankDisc(String title) {
        this.title = title;
    }

    public BlankDisc(@Value("${blank.title}") String title, @Value("${blank.artist}") String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void play() {
        Util.printDisc(this);
    }

}
