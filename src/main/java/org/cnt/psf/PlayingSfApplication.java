package org.cnt.psf;

import org.cnt.util.Logger;
import org.cnt.util.Sleeper;

public class PlayingSfApplication {

	public static void main(String[] args) {
		Logger log = Logger.getLogger();
		log.info("{}{}", 1, 2);
		Sleeper.sleep(3);
		log.info("{}{}", "a", 2);
	}

}
