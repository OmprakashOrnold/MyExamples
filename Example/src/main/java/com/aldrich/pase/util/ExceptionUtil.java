package com.aldrich.pase.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;

import org.json.JSONException;

public class ExceptionUtil {
	
	public static int determineExceptionCodeByException(Object exceptionObj)
	{
		
		int exceptionCode = 0 ;
		
		Exception exception = (Exception)exceptionObj;
		
		if(exception instanceof SocketTimeoutException)
		{
			exceptionCode = PASEConstants.SOCKET_TIMEOUT_EXCEPTION;
			
		}
		else if(exception instanceof IOException)
		{
			exceptionCode = PASEConstants.IO_EXCEPTION;
		}
		else if(exception instanceof MalformedURLException)
		{
			exceptionCode = PASEConstants.MOLFORMED_EXCEPTION_CODE;
		}
		else if(exception instanceof NullPointerException)
		{
			exceptionCode = PASEConstants.NULL_POINTER_EXCEPTION_CODE;
		}
		else if(exception instanceof ArrayIndexOutOfBoundsException)
		{
			exceptionCode = PASEConstants.ARRAY_INDEX_BOUNDS_EXCEPTION_CODE;
		}
		else if(exception instanceof JSONException)
		{
			exceptionCode = PASEConstants.JSON_EXCEPTION;
		}
		else if(exception instanceof Exception)
		{
			exceptionCode = PASEConstants.ANY_OTHER_EXCEPTION;
		}
		
		return exceptionCode;
	}

}
