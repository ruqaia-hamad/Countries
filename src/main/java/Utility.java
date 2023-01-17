
public class Utility {
	public static boolean checkNull(String x) {
		if (x == null) {
			return false;
		}
		return true;
	}

	public static String checkIfNull(String x) {
		if (x == null) {
			return "";
		}
		return x;
	}

	public static boolean checkNull(Integer x) {
		if (x == null) {
			return false;
		}
		return true;
	}
	
	
	
	public static Double checkIfNull(Double x) {
		if (x == null) {
			return new Double(0.0);
		}
		return x;
	}

	public static boolean checkNull(Double x) {
		if (x == null) {
			return false;
		}
		return true;
	}

	public static boolean checkNull(Boolean x) {
		if (x == null) {
			return false;
		}
		return true;
	}

	public static boolean checkNull(Float x) {
		if (x == null) {
			return false;
		}
		return true;
	}
}
