package property.placeholder.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("popular")
@PropertySource("classpath:/property/placeholder/value/app.properties")
public class PopularDisc implements CompactDisc {

    @Value("${popular.title}")
    private String title;

    @Value("${popular.artist}")
    private String artist;

    public PopularDisc() {}

    public PopularDisc(String title) {
        this.title = title;
    }

    public PopularDisc(String title, String artist) {
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
