package com.aldrich.pase.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * See http://en.wikipedia.org/wiki/URL_normalization for a reference Note: some
 * parts of the code are adapted from: http://stackoverflow.com/a/4057470/405418
 * 
 */
@SuppressWarnings("nls")
public class URLCanonicalizer
{
	public static String getCanonicalURL(String url)
	{
		URL canonicalURL = getCanonicalURL(url, null);
		if (canonicalURL != null)
		{
			return canonicalURL.toExternalForm();
		}
		return null;
	}

	public static URL getCanonicalURL(String href, String context)
	{
		try
		{

			URL canonicalURL;
			if (context == null)
			{
				canonicalURL = new URL(href);
			}
			else
			{
				canonicalURL = new URL(new URL(context), href);
			}
			String path = canonicalURL.getPath();
			path = new URI(path).normalize().toString();

			int idx = path.indexOf("//");
			while (idx >= 0)
			{
				path = path.replace("//", "/");
				idx = path.indexOf("//");
			}

			while (path.startsWith("/../"))
			{
				path = path.substring(3);
			}

			path = path.trim();

			final SortedMap<String, String> params = createParameterMap(canonicalURL.getQuery());
			final String queryString;

			if (params != null && params.size() > 0)
			{
				String canonicalParams = canonicalize(params);
				queryString = (canonicalParams.isEmpty() ? "" : "?" + canonicalParams);
			}
			else
			{
				queryString = "";
			}

			if (path.length() == 0)
			{
				path = "/" + path;
			}

			int port = canonicalURL.getPort();
			if (port == canonicalURL.getDefaultPort())
			{
				port = -1;
			}

			String protocol = canonicalURL.getProtocol().toLowerCase();
			String host = canonicalURL.getHost().toLowerCase();
			String pathAndQueryString = normalizePath(path) + queryString;

			return new URL(protocol, host, port, pathAndQueryString);

		}
		catch (MalformedURLException ex)
		{
			return null;
		}
		catch (URISyntaxException ex)
		{
			return null;
		}
	}

	/**
	 * Takes a query string, separates the constituent name-value pairs, and
	 * stores them in a SortedMap ordered by lexicographical order.
	 * 
	 * @return Null if there is no query string.
	 */
	private static SortedMap<String, String> createParameterMap(final String queryString)
	{
		if (queryString == null || queryString.isEmpty())
		{
			return null;
		}

		final String[] pairs = queryString.split("&");
		final Map<String, String> params = new HashMap<>(pairs.length);

		for (final String pair : pairs)
		{
			if (pair.length() == 0)
			{
				continue;
			}

			String[] tokens = pair.split("=", 2);
			switch (tokens.length)
			{
			case 1:
				if (pair.charAt(0) == '=')
				{
					params.put("", tokens[0]);
				}
				else
				{
					params.put(tokens[0], "");
				}
				break;
			case 2:
				params.put(tokens[0], tokens[1]);
				break;
			default:
				break;
			}
		}
		return new TreeMap<>(params);
	}

	/**
	 * Canonicalize the query string.
	 * 
	 * @param sortedParamMap
	 *            Parameter name-value pairs in lexicographical order.
	 * @return Canonical form of query string.
	 */
	private static String canonicalize(final SortedMap<String, String> sortedParamMap)
	{
		if (sortedParamMap == null || sortedParamMap.isEmpty())
		{
			return "";
		}

		final StringBuffer sb = new StringBuffer(100);
		for (Map.Entry<String, String> pair : sortedParamMap.entrySet())
		{
			final String key = pair.getKey().toLowerCase();
			if (key.equals("jsessionid") || key.equals("phpsessid") || key.equals("aspsessionid"))
			{
				continue;
			}
			if (sb.length() > 0)
			{
				sb.append('&');
			}
			sb.append(percentEncodeRfc3986(pair.getKey()));
			if (!pair.getValue().isEmpty())
			{
				sb.append('=');
				sb.append(percentEncodeRfc3986(pair.getValue()));
			}
		}
		return sb.toString();
	}

	/**
	 * Percent-encode values according the RFC 3986. The built-in Java
	 * URLEncoder does not encode according to the RFC, so we make the extra
	 * replacements.
	 * 
	 * @param string
	 *            Decoded string.
	 * @return Encoded string per RFC 3986.
	 */
	private static String percentEncodeRfc3986(String string)
	{
		String variable = "";
		try
		{
			variable = string;
			variable = string.replace("+", "%2B");
			variable = URLDecoder.decode(string, "UTF-8");
			variable = URLEncoder.encode(string, "UTF-8");
			return variable.replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
		}
		catch (Exception e)
		{
			return variable;
		}
	}

	private static String normalizePath(final String path)
	{
		return path.replace("%7E", "~").replace(" ", "%20");
	}
}
