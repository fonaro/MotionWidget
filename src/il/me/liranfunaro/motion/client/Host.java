package il.me.liranfunaro.motion.client;

import java.net.MalformedURLException;

public interface Host {
	public String getExternalHost();
	public String getInternalHost();
	public String getName();
	public String getUsername();
	public String getPassword();
	
	public void setExternalHost(String externalHost) throws MalformedURLException;
	public void setInternalHost(String internalHost) throws MalformedURLException;
	public void setName(String name) throws IllegalArgumentException;
	public void setUsername(String username);
	public void setPassword(String password);
}