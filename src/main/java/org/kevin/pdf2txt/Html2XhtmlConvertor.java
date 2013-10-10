/**
 * 
 */
package org.kevin.pdf2txt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

/**
 * @author yang
 * 
 */
public class Html2XhtmlConvertor {

	public static void main(String[] args) {
		convert();
	}

	public static void convert() {
		try {
			Parser parser = new HtmlParser();
			URL url = new URL("http://www.taobao.com/");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			ContentHandler contentHandler = new BodyContentHandler(
					new OutputStreamWriter(new FileOutputStream(new File(
							"/Users/yang/Downloads/testurl/1.html"))));
			Metadata metadata = new Metadata();
			parser.parse(is, contentHandler, metadata);
		} catch (Exception e) {
			System.out.println("系统异常了，My god!");
		}
	}

}
