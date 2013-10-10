package org.kevin.pdf2txt;

/**
 * Pdf转换为Txt应用入口
 * 
 * @author 四郎
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println(Pdf2TxtConvertor
				.readFiles("/Users/yang/Downloads/input"));
	}
}
