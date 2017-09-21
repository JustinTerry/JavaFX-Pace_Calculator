import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pace {
	double paceInSec, paceSec, paceMin, paceHr, marTime, marHr, marMin, marSec, tenKTime, tenKHr, tenKMin, tenKSec;
	NumberFormat dec = new DecimalFormat("00");

	public void calcPace(Double dist, int hr, int mn, int sc) {
		// Variable instantiation
		int totalTime;

		// Calculations
		totalTime = ((hr * 3600) + (mn * 60) + (sc));
		paceInSec = totalTime / dist;

		// Inititial run pace calculations
		paceHr = Math.floor(paceInSec / 3600);
		paceSec = Math.round((paceInSec % 60));
		paceMin = (Math.floor((paceInSec - paceHr * 3600) / 60));
		// Marathon pace calculations
		marTime = paceInSec * 26.2;
		marHr = Math.floor(marTime / 3600);
		marMin = Math.floor((marTime - marHr * 3600) / 60);
		marSec = Math.ceil(marTime % 60);
		// 10K pace calculations
		tenKTime = paceInSec * 6.2;
		tenKHr = Math.floor(tenKTime / 3600);
		tenKMin = Math.floor((tenKTime - tenKHr * 3600) / 60);
		tenKSec = Math.ceil(tenKTime % 60);
		// End of calculations
	}

	// Returns pace for most recent run
	public String getThisPace() {
		return (dec.format(paceHr) + ":" + dec.format(paceMin) + ":" + dec.format(paceSec));
	}
	// Returns pace for marathon
	public String getMaraPace() {
		return (dec.format(marHr) + ":" + dec.format(marMin) + ":" + dec.format(marSec));
	}
	// Returns pace for 10K
	public String getTenKPace() {
		return (dec.format(tenKHr) + ":" + dec.format(tenKMin) + ":" + dec.format(tenKSec));
	}
}
