package eventProcessor;

import events.*;


public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException{
		Processor.executeRules();
		(new SampleTransactionGenerator()).invoke(Processor.cepRT);
			
	}

}
