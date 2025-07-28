import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Photo {
    private int id ;
    private String name ;
    private LocalDate date ;
    private Location location ;
    private Set<String> tags;

    public Photo() {
    }

    public Photo(int id, String name, LocalDate date, Location location, Set<String> tags) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", location=" + location +
                ", tags=" + tags +
                '}';
    }
}
