import java.util.ArrayList;

public class MediaManager {
    private ArrayList<Media> mediaList;

    public MediaManager() {
        this.mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public void printAllMedia() {
        if (mediaList.isEmpty()) {
            System.out.println("The media list is empty");
            return;
        }
        System.out.println("--- Media List ---");
        for (Media media : mediaList) {
            media.print();
            System.out.println("-------------------------");
        }
    }
}
