package il.me.liranfunaro.motion.client;

import java.util.regex.Pattern;

public enum CameraStatus {
	ACTIVE,PAUSE,UNAUTHORIZED,UNAVALIBLE,UNKNOWN;
	
	public static final Pattern PATTERN = CameraStatus.getPattern();
	
	public String getUserMessage() {
		switch(this) {
		case ACTIVE: return "Motion detect is ACTIVE";
		case PAUSE: return "Motion detect is PAUSED";
		case UNAUTHORIZED: return "Username or Password is not correct";
		case UNAVALIBLE: return "Host is unavailible";
		default: return "Status is unknown";
		}
	}
	
	public static Pattern getPattern() {
		StringBuilder result = new StringBuilder();
		
		boolean isFirst = true;
		result.append('(');
		
		for(CameraStatus status : CameraStatus.values()) {
			if(!isFirst) {
				result.append('|');
			}
			isFirst = false;
			result.append(status.toString());
		}
		result.append(')');
		
		return Pattern.compile(result.toString());
	}
}