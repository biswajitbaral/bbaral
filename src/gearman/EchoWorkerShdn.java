package gearman;

import org.gearman.Gearman;

public class EchoWorkerShdn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Gearman gearman = Gearman.createGearman();
		 gearman.shutdown();
	}

}
