import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.environment.Environment;
import java.util.Random;
import java.lang.Math;


public class WindowEnv extends Environment {
	Literal extHot  = Literal.parseLiteral("extHot");
	Literal extCold = Literal.parseLiteral("extCold");
	Literal intHot  = Literal.parseLiteral("intHot");
	Literal intCold = Literal.parseLiteral("intCold");
	
	Literal raining = Literal.parseLiteral("raining");
	Literal notRaining = Literal.parseLiteral("~raining");
	
	Literal sunny = Literal.parseLiteral("isSunny");
	Literal notSunny = Literal.parseLiteral("~isSunny");
	
	Literal checkSensors = Literal.parseLiteral("checkSensors");
	
	Random rand = new Random();
	double cnt = 0;
	double idealTemp = 22;
	double rainThreshold = 0.4;
	double lightThreshold = 0.5;

	public void addTempPercept(double sensorTemp, Literal hot, Literal cold){
		if(sensorTemp < idealTemp){
			addPercept(cold);
		}
		else if (sensorTemp > idealTemp){
			addPercept(hot);
		}
	}
	
	public void addRainPercept(double sensorRain){
		if(sensorRain < rainThreshold){
			addPercept(notRaining);
		}
		else if(sensorRain > rainThreshold){
			addPercept(raining);
		}
	}
	
	public void addLightPercept(double sensorLight){
		if(sensorLight < lightThreshold){
			addPercept(notSunny);
		}
		else if (sensorLight > lightThreshold){
			addPercept(sunny);
		}
	}
	
    @Override
    public void init(String[] args) {
		addPercept(extHot);
		addPercept(intHot);
		addPercept(checkSensors);
		addPercept(notRaining);
    }

    @Override
    public boolean executeAction(String ag, Structure act) {
        System.out.println(ag + " action: " + act);
		
		clearPercepts();
		addPercept(intHot);
		
		if(act.getFunctor().equals("checkSensors")){
			double extTemp = Math.sin(cnt)*30+15;
			System.out.println("Ext Temp: " + extTemp);
			addTempPercept(extTemp, extHot, extCold);
			
			double intTemp = Math.sin(cnt)*4+24;
			System.out.println("Int Temp: " + intTemp);
			addTempPercept(intTemp, intHot, intCold);
			
			double rainRate = rand.nextDouble();
			System.out.println("Rain Rate: " + rainRate);
			addRainPercept(rainRate);
			
			double lightRate = rand.nextDouble();;
			System.out.println("Light Rate: " + lightRate);
			addLightPercept(lightRate);
			
			try{
				Thread.sleep(1000);
			} catch(InterruptedException e){	}
			
			cnt = cnt + 0.5;
			addPercept(checkSensors);
		}
		
		informAgsEnvironmentChanged();
        return true;
    }
}

