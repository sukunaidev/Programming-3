public class SmartThermostat extends SmartDevice implements Adjustable
{
    private int temperature;

    public SmartThermostat(String deviceName, boolean isOn, int temperature)
    {
        super(deviceName, isOn);
        this.temperature = temperature;
        

        if(isOn)
            {
                turnOn();
                System.out.println("");
            }
            else
            {
                turnOff();
            }
    }

        

    @Override
    public void setLevel(int level)
    {
        if(level >= 60)
        {
            temperature = level;
        }
        else if(level <=80)
        {
            temperature = level;
        }

    }

    @Override
    public void turnOn()
    {
        System.out.println("HVAC System Starting...");
        activeDevicesCount++;
        this.isOn = true;
         
    }

    @Override
    public void turnOff()
    {
        //System.out.println("HVAC System Starting...");
       //super.turnOn();
       activeDevicesCount--;
        this.isOn = false;
    }


    @Override
    public void performSelfDiagnostic()
    {
         System.out.println("Checking LED Health..");
    }

}