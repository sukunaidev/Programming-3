public class SmartLight extends SmartDevice implements Adjustable{
    private int brightness;
    
    public SmartLight(String deviceName, boolean isOn, int brightness)
    {
        super( deviceName, isOn);
        this.brightness = brightness;
        
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
    public void turnOn()
    {
        SmartDevice.activeDevicesCount += 1;
        isOn = true;
    }
   

    @Override
    public void turnOff()
    {
        SmartDevice.activeDevicesCount--;
        isOn = false;
    }



    @Override
    public void setLevel(int level) 
    {
        if(isOn ==  false)
        {
            System.out.println("Cannot adjust: Device is OFF.");
        }


    }

    @Override
    public void performSelfDiagnostic()
    {
        System.out.println("Checking LED Health...");

    }

}