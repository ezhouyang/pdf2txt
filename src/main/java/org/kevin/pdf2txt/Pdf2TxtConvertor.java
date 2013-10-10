/**
 * 
 */
package org.kevin.pdf2txt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

/**
 * PDF转换为TXT转换器
 * <p>
 * do with it Apache tika
 * </p>
 * 
 * @author 四郎
 * 
 */
public class Pdf2TxtConvertor {

	/** txt标识符 */
	private static String TXT_INDENTIFIER = ".txt";

	/**
	 * 输出文件重命名
	 * 
	 * @param pdfName
	 *            输入pdf文件绝对文件路径名
	 * @return 输出txt文件绝对文件路径名
	 */
	private static String renameForOutput(String pdfName) {

		return pdfName.substring(0, pdfName.indexOf(".pdf")) + TXT_INDENTIFIER;
	}

	/**
	 * 转换
	 * 
	 * @param filePath
	 *            文件路径名称
	 */
	private static void convert(String filePath) {
		try {
			Parser parser = new PDFParser();
			ContentHandler contentHandler = new BodyContentHandler(
					new OutputStreamWriter(new FileOutputStream(new File(
							renameForOutput(filePath)))));
			Metadata metadata = new Metadata();
			parser.parse(new FileInputStream(new File(filePath)),
					contentHandler, metadata);
		} catch (Exception e) {

		}
	}

	/**
	 * 读取文件夹中所有PDF文件并转换
	 * 
	 * @param dirPath
	 *            文件夹路径
	 */
	public static String readFiles(String dirPath) {
		try {
			File dir = new File(dirPath);
			File[] files = dir.listFiles();
			if (null == files) {
				return "文件夹内没有PDF文件可供转化，请检查！";
			}

			for (File file : files) {

				if (file.isDirectory()) {
					readFiles(file.getAbsolutePath());
				} else if (null != file.getAbsolutePath()
						&& file.getAbsolutePath().endsWith("pdf")) {
					convert(file.getAbsolutePath());
				}
			}
		} catch (Exception e) {
			return "系统异常了，my god!";
		}
		return "well done!";
	}

}
