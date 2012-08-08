package eventProcessor;

import java.util.Random;
import java.lang.*;
import events.EventA;
import events.Events;


public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Processor.executeRules();
		for(int i=0;i<20;i++){
			Class class1=Class.forName("events.EventA");
			Events e=(Events)class1.newInstance();
			e.invoke(Processor.cepRT);
			
	}
}
}
