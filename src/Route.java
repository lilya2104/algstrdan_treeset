public class Route implements Comparable<Route> {
    private String id;
    private double distance;
    private int popularity;
    private boolean isFavorite;
    private MyArrayList<String> locationPoints;
    private static int forID = -1;

    public Route(double distance, int popularity,
                 boolean isFavorite, MyArrayList<String> locationPoints) {
        this.setId(++forID);
        this.setDistance(distance);
        this.setPopularity(popularity);
        this.isFavorite = isFavorite;
        this.locationPoints = locationPoints;
    }

    public String getId() { return id; }
    private void setId(int forID) {
        this.id = String.valueOf(forID);
    }
    public double getDistance() { return distance; }
    public void setDistance(double distance) {
        if (distance == 0) throw new IllegalArgumentException("distance = 0!!");
        else this.distance = distance;
    }
    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
    public MyArrayList<String> getLocationPoints() { return locationPoints; }
    public int getNumberLocationPoints() {
        return (getLocationPoints().size());
    }
    public int getNumberMiddleLocationPoints() {
        return (getLocationPoints().size()-2);
    }


    public boolean equals(Route other) {
        if (this == other) return true;
        if (other == null) return false;
        if ((this.getDistance() == other.getDistance()) &&
                (this.locationPoints.get(0).equals(other.locationPoints.get(0)))
                && (locationPoints.get(locationPoints.size()-1).equals(other.locationPoints.get(locationPoints.size()-1)))) { return true; }
        return false;
    }

    public int hashCode() {
        int hash = 4;
        hash = 41 * hash + (int) distance;
        hash = 41 * hash + (id == null ? 0 : id.hashCode());
        hash = 41 * hash + (locationPoints == null ? 0 : locationPoints.hashCode());
        return hash;
    }

    @Override
    public int compareTo(Route r) {
        return (Integer.compare(this.hashCode(), r.hashCode()));
    }
    public int compareToID(Route r) {
        return (Integer.compare(Integer.parseInt(this.getId()), Integer.parseInt(r.getId())));
    }
    public static int compareSearchRoutes(Route r1, Route r2) {
        int i1 = Integer.compare(r1.getNumberMiddleLocationPoints(), r2.getNumberMiddleLocationPoints());
        if (i1 != 0) return i1;
        int i2 = Integer.compare(r2.getPopularity(), r1.getPopularity());
        if (i2 != 0) return i2;
        return r1.compareToID(r2);
    }
    public static int compareFavoriteRoutes(Route r1, Route r2) {
        int i1 = Integer.compare((int) r1.getDistance(), (int) r2.getDistance());
        if (i1 != 0) return i1;
        int i2 = Integer.compare(r2.getPopularity(), r1.getPopularity());
        if (i2 != 0) return i2;
        return r1.compareToID(r2);
    }
    public static int compareTop5Routes(Route r1, Route r2) {
        int i1 = Integer.compare(r2.getPopularity(), r1.getPopularity());
        if (i1 != 0) return i1;
        int i2 = Integer.compare((int) r1.getDistance(), (int) r2.getDistance());
        if (i2 != 0) return i2;
        int i3 = Integer.compare(r1.getNumberLocationPoints(), r2.getNumberLocationPoints());
        if (i3 !=0) return i3;
        return r1.compareToID(r2);
    }



    @Override
    public String toString() {
        return "\n" + "Route --> " +
                "id: '" + id + '\'' +
                ", distance: " + distance +
                ", popularity: " + popularity +
                ", isFavorite: " + isFavorite +
                ", \nlocationPoints: " + locationPoints;
    }
}
