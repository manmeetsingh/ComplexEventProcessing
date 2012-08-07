package eventProcessor;

import java.util.Random;

import events.EventA;


public class Main {
	public static void main(String[] args){
		Processor.executeRules();
		for(int i=0;i<20;i++){
			EventA.eventA(Processor.cepRT);
	}
}
}
