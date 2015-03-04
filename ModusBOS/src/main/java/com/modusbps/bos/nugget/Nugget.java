package com.modusbps.bos.nugget;

import java.io.IOException;

public interface Nugget {
	
	public Object process();
	
	public Object process(String URL) throws IOException;

}
