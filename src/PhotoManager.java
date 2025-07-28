import java.time.LocalDate;
import java.util.*;

public class PhotoManager {
   private HashMap<String, Set<Photo>> photoTag;
   private HashMap<Location, Set<Photo>> photoLocation;
   private HashMap<LocalDate, Set<Photo>> photoDate;
   private HashMap<String , Set<Photo>> photoName;


   public PhotoManager() {
       this.photoTag = new HashMap<>();
       this.photoLocation = new HashMap<>();
       this.photoDate = new HashMap<>();
       this.photoName = new HashMap<>();
   }
   public void uploadPhoto(Photo photo) {
       photo.getTags().forEach(tag -> {
           photoTag.computeIfAbsent(tag, k -> new HashSet<>()).add(photo);
       });
       photoLocation.computeIfAbsent(photo.getLocation(), k -> new HashSet<>()).add(photo);
       photoDate.computeIfAbsent(photo.getDate(), k -> new HashSet<>()).add(photo);
       photoName.computeIfAbsent(photo.getName(), k -> new HashSet<>()).add(photo);

   }
   public Set<Photo> searchByTag(String tag){
       return photoTag.getOrDefault(tag, Collections.emptySet());
   }
   public Set<Photo> searchByLocation(Location location){
       Set<Photo> photos = new HashSet<>();
       photoLocation.forEach((k,v)->{
           double distance = getDistance(location,k);
           if(distance<=location.getRedius()){
               photos.addAll(v);
           }


       });
       return photos;
   }
   public Set<Photo> searchByDate(LocalDate date){
       return photoDate.getOrDefault(date, Collections.emptySet());
   }
   public Set<Photo> searchByMultipleTags(Set<String> tags){
       Set<Photo> photos = new HashSet<>();
       tags.forEach(tag->{
           photos.addAll(searchByTag(tag));
       });
       return photos;
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
