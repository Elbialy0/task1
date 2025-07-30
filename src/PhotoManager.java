import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PhotoManager {

    private Set<Photo> photos;
    private Map<String, Location> locationMap;

    public PhotoManager() {
        photos = new HashSet<>();
        locationMap = new HashMap<>();
    }
    public void uploadPhoto(Photo photo) {
        photos.add(photo);
        locationMap.put(photo.getLocation().getName(), photo.getLocation());
    }
    public List<Photo> searchByTag(String tag){
        List<Photo> searchPhotos = new ArrayList<>();
        searchPhotos = photos.stream().filter(photo -> photo.getTags().contains(tag)).toList();
        return searchPhotos;
    }
    public List<Photo> searchByDate(LocalDate date){
        List<Photo> searchPhotos = new ArrayList<>();
        searchPhotos = photos.stream().filter(photo -> photo.getDate().equals(date)).toList();
        return searchPhotos;
    }
    public List<Photo> searchByYear(int year){
        return photos.stream().filter(photo -> photo.getDate().getYear() == year).toList();
    }

    public List<Photo> searchByMonthAndYear(int month, int year){
        return photos.stream().filter(photo ->  photo.getDate().getMonthValue() == month && photo.getDate().getYear() == year).toList();
    }
    public List<Photo> searchByLocation(String location){
        Location searchLocation = locationMap.get(location);
        if (location == null) return null;
        return photos.stream().filter(photo -> getDistance(photo.getLocation(), searchLocation) <= searchLocation.getRedius()).toList();
    }
    public List<Photo> searchByMultipleTags(Set<String> tags){ // And
        return photos.stream().filter(photo -> photo.getTags().containsAll(tags)).toList();
    }
    private double getDistance(Location location, Location k) {
        int R = 6371;// radius of earth
        double lat1 = location.getLatitude();
        double lat2 = k.getLatitude();
        double lon1 = location.getLongitude();
        double lon2 = k.getLongitude();
        double dLat = Math.toRadians(lat2-lat1);
        double dLon = Math.toRadians(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
