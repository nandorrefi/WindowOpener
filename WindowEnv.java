import jason.asSyntax.Literal;
import jason.asSyntax.Structure;
import jason.environment.Environment;

public class WindowEnv extends Environment {
	Literal extHot  = Literal.parseLiteral("extHot");
	Literal extCold = Literal.parseLiteral("extCold");
	Literal intHot  = Literal.parseLiteral("intHot");
	Literal intCold = Literal.parseLiteral("intCold");

    @Override
    public void init(String[] args) {
		addPercept(extHot);
		addPercept(intHot);
    }

    @Override
    public boolean executeAction(String ag, Structure act) {
        System.out.println(ag + " action: " + act);
		
		clearPercepts();
		addPercept(intHot);
		
		if(act.getFunctor().equals("openWindow")){
			addPercept(extHot);
		}
		
		if(act.getFunctor().equals("closeWindow")){
			addPercept(extCold);
		}
		
		informAgsEnvironmentChanged();
        return true;
    }
}

