package Generic_Utililities;

import java.util.Random;

public class Java_Utility {

	
		// TODO Auto-generated method stub
		/**
		 * This MEthod is used to avoid duplicate values
		* @return
		 * author Pranutha
		 */
		public int getRandamNum()
		{
			Random ran = new Random();
			int radNum = ran.nextInt(1000);
			return radNum;
		}
		
	

}
