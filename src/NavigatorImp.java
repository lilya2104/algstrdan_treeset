public class NavigatorImp implements Navigator {

    public TreeSet<Route> routes;
    private int size;
    public NavigatorImp() {
        routes = new TreeSet<>();
    }

    @Override
    public void addRoute(Route route) {
        if (route == null) return;
        if (filter(route)) return;
        routes.add(route);
        size += 1;
    }
    @Override
    public void removeRoute(String routeId) {
        if (routeId == null || routes.isEmpty()) return;
        for (Route r : routes) {
            if (r.getId().equals(routeId)) {
                routes.remove(r);
                size -= 1;
            }
        }
    }
    @Override
    public boolean contains(Route route) {
        if (route == null) return false;
        return routes.contains(route);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public Route getRoute(String routeId) {
        if (routeId == null || routes.isEmpty()) return null;
        for (Route r : routes) {
            if (r.getId().equals(routeId)) {
                return r;
            }
        }
        return null;
    }
    @Override
    public void chooseRoute(String routeId) {
        if (routeId == null || routes.isEmpty()) return;
        for (Route r : routes) {
            if (r.getId().equals(routeId)) {
                r.setPopularity(r.getPopularity()+1);
            }
        }
    }
    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        if (startPoint.isEmpty() || endPoint.isEmpty()) return null;

        MyArrayList<Route> fav_search_routes = new MyArrayList<>();
        MyArrayList<Route> search_routes = new MyArrayList<>();
        MyArrayList<Route> result = new MyArrayList<>();
        if (routes.isEmpty()) return result;

        for (Route r : routes) {
            MyArrayList<String> rr = r.getLocationPoints();
            if (rr.get(0).equals(startPoint) && rr.get(rr.size() - 1).equals(endPoint)) {
                if (r.isFavorite()) fav_search_routes.add(r);
                else search_routes.add(r);
            }
        }

        fav_search_routes.sort(Route::compareSearchRoutes);
        search_routes.sort(Route::compareSearchRoutes);

        for (Route r : search_routes) {
            fav_search_routes.add(r);
        }

        result = fav_search_routes;
        return result;
    }
    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        if (destinationPoint.isEmpty()) return null;

        MyArrayList<Route> fav_routes = new MyArrayList<>();
        if (routes.isEmpty()) return fav_routes;
        for (Route r : routes) {
            if (r.isFavorite()) {
                MyArrayList<String> rr = r.getLocationPoints();
                for (int j = 1; j < rr.size(); j++) {
                    if (rr.get(j).equals(destinationPoint))
                        fav_routes.add(r);
                }
            }
        }

        fav_routes.sort(Route::compareFavoriteRoutes);

        return fav_routes;
    }
    @Override
    public Iterable<Route> getTop5Routes() {
        MyArrayList<Route> top_routes = new MyArrayList<>();
        MyArrayList<Route> top_5_routes = new MyArrayList<>();
        if (routes.isEmpty()) return top_5_routes;
        for (Route r : routes) {
            top_routes.add(r);
        }

        top_routes.sort(Route::compareTop5Routes);

        for (int i = 0; i < 5; i++) {
            top_5_routes.add(top_routes.get(i));
        }
        return top_5_routes;
    }

    private boolean filter(Route current) {
        if (!routes.isEmpty()) {
            for (Route r : routes) {
                if (r.equals(current)) {
                    r.setPopularity(r.getPopularity() + current.getPopularity());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "";
        for (Route r : routes) {
            res += r.toString() + "\n";
        }
        return res;
    }
}
