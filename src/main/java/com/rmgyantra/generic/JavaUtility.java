package com.rmgyantra.generic;

import java.util.Random;
	/**
	 * this class is consist of java related methods
	 * @author Vinay
	 *
	 */
public class JavaUtility {
	/**
	 * this method gives the random number
	 * @return
	 */
	public int random() {
		Random ran= new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
	}

}
