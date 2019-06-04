package boulderDashGame.contract;

public class Debug {
    private static final int DEBUG = 0;
	
	public static void debugprint(String msg) {
		if (DEBUG == 1)
		{
			System.out.println(msg);
		}
	}

}
