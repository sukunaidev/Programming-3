import java.util.ArrayList;

public class App
{
public static void main(String[] args) {

    ArrayList<SmartDevice> homeHub = new ArrayList<>();

    homeHub.add(new SmartLight("LivingRoom", true, 80));
    homeHub.add(new SmartLight("Kitchen", true, 75));
    homeHub.add(new SmartThermostat("Hallway", true, 8));
   
    

    for(int i=0; i<homeHub.size(); i++)
        {
            homeHub.get(i).performSelfDiagnostic();
           // homeHub.get(i).turnOn();
        }

        System.out.println(SmartDevice.activeDevicesCount);


}
}