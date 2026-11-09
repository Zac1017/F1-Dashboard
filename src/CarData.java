public class CarData {
    private String driver_number;
    private String session_key;
    private int speed;
    private double throttle;
    private int rpm;
    private int gear;
    private int drs;
    private String date;
    private int brake;

    public CarData(String json) {
        this.driver_number = getValue(json, "driver_number");
        this.session_key = getValue(json, "session_key");
        this.speed = Integer.parseInt(getValue(json, "speed"));
        this.throttle = Double.parseDouble(getValue(json, "throttle"));
        this.rpm = Integer.parseInt(getValue(json, "rpm"));
        this.gear = Integer.parseInt(getValue(json, "n_gear"));
        this.drs = Integer.parseInt(getValue(json, "drs"));
        this.date = getValue(json, "date");
        this.brake = Integer.parseInt(getValue(json, "brake"));
    }
    public static String getValue(String json, String key) {
        return json.split("\"" + key + "\":")[1]
                .split("[,}]")[0]
                .trim()
                .replaceAll("\"", "");
    }

    public String getDriverNumber() {
        return driver_number;
    }

    public String getSessionKey() {
        return session_key;
    }

    public int getSpeed() {
        return speed;
    }

    public double getThrottle() {
        return throttle;
    }

    public int getRpm() {
        return rpm;
    }

    public int getGear() {
        return gear;
    }

    public int getDrs() {
        return drs;
    }

    public String getDate() {
        return date;
    }

    public int isBrake() {
        return brake;
    }



}
