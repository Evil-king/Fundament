package com.hwq.fundament.Think_In_Java.innerClass.TestExtenalClass;

/**
 * @author hwq
 * @date 2018/10/23
 */
public class GreenhouseController {

    public static void main(String[] args) {
        GreenhouseControllers gc = new GreenhouseControllers();

        gc.addEvent(gc.new Bell(900));

        Event[] events = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400),
        };

        gc.addEvent(gc.new Restart(2000, events));

        //咦，args还可以这样用。。。好厉害
        if (args.length == 1) { //然而这一步并没有执行。。。
            gc.addEvent(new GreenhouseControllers.Terminate(new Integer(args[0]))); //拿掉if条件，抛出异常ArrayIndexOutOfBoundsException
            gc.run();
        }

    }
}
