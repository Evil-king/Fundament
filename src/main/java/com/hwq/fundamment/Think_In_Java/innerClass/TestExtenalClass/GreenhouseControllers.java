package com.hwq.fundamment.Think_In_Java.innerClass.TestExtenalClass;

/**
 * @author hwq
 * @date 2018/10/23
 */
public class GreenhouseControllers extends Controller {

    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = true;
        }

        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = false;
        }

        public String toString() {
            return "Light is off";
        }

    }

    private boolean water = false;

    public class WaterOn extends Event {

        public WaterOn (long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water is on";
        }
    }

    public class WaterOff extends Event {

        public WaterOff (long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Water is off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {

        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            for (Event e : events) {
                addEvent(e);
            }
        }

        public void action() {
            for (Event e : events) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart system";
        }
    }

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
