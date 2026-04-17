class UndergroundSystem {
    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkInMap.get(id);
        String key = in.stationName + "->" + stationName;
        
        Route route = routeMap.getOrDefault(key, new Route());
        route.totalTime += (t - in.time);
        route.count++;
        routeMap.put(key, route);
        
        checkInMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        Route route = routeMap.get(key);
        return (double) route.totalTime / route.count;
    }
    
    static class CheckIn {
        String stationName;
        int time;
        
        CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }
    
    static class Route {
        long totalTime = 0;
        int count = 0;
    }
}