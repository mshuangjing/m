package com.byzoro.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExUtil {

	  //Ip地址验证
	  private static String rexpIP = "([0-9]|[0-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

	  //验证8位的机房Id
	  private static String rexphouseId = "^\\d{8}$";

	  //定义script的正则表达式
	  private static String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>";

	  //定义style的正则表达式
	  private static String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>";

	  //定义iframe的正则表达式
	  private static String regEx_iframe="<iframe[^>]*?>[\\s\\S]*?<\\/iframe>";

      //定义HTML标签的正则表达式
	  private static String regEx_html="<[^>]+>";

	  //定义空格回车换行符
	  private static String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符

	  //url
	  private static String regEx_url = "(https|http)(://)(([a-zA-Z0-9]+(.)){1,}):[0-9]{1,}";

	  /**
	   * 验证Ip格式是否正确
	   * @param rptCode
	   * @return
	   */
	  public static boolean isRegularRptCode(String rptCode) {
	        Pattern p1 = Pattern.compile(rexpIP);
	        Matcher m1 = p1.matcher(rptCode);
	        boolean rs1 = m1.matches();
	        return rs1 ;
	  }

	  /**
	   * 验证8位的机房Id是否符合
	   * @param rptCode
	   * @return
	   */
	  public static boolean isRegularRptHouseIdCode(String rptCode) {
	        Pattern regular = Pattern.compile(rexphouseId);
	        Matcher matcher = regular.matcher(rptCode);
	        boolean rs1 = matcher.matches();
	        return rs1 ;
	  }

	  /**
	   * 验证名称中是否含有标签，并返回字符串
	   * @param htmlStr
	   * @return
	   */
	  public static String delHTMLTag(String htmlStr) {
	        Pattern pScript = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
	        Matcher mScript = pScript.matcher(htmlStr);
	        htmlStr = mScript.replaceAll(""); // 过滤script标签

	        Pattern pStyle = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	        Matcher mStyle = pStyle.matcher(htmlStr);
	        htmlStr = mStyle.replaceAll(""); // 过滤style标签

	        Pattern pIframe = Pattern.compile(regEx_iframe, Pattern.CASE_INSENSITIVE);
	        Matcher mIframe = pIframe.matcher(htmlStr);
	        htmlStr = mIframe.replaceAll(""); // 过滤iframe标签

	        Pattern pHtml = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	        Matcher mHtml = pHtml.matcher(htmlStr);
	        htmlStr = mHtml.replaceAll(""); // 过滤html标签

	        Pattern pSpace = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
	        Matcher mSpace = pSpace.matcher(htmlStr);
	        htmlStr = mSpace.replaceAll(""); // 过滤空格回车标签
	        return htmlStr.trim(); // 返回文本字符串
	    }

	  	/**
	  	 * 获取标签中的字符串
	  	 * @param htmlStr
	  	 * @return
	  	 */
	  	public static String getTextFromHtml(String htmlStr){
	        htmlStr = delHTMLTag(htmlStr);
	        htmlStr = htmlStr.replaceAll("&nbsp;","");
	        return htmlStr;
	    }

		/**
		 * 正则匹配Http+ip+端口 替换空
		 * @param url
		 * @return
		 */
		public static String replaceUrl(String url){
			if(StringUtils.isBlank(url)){
				return "";
			}
			try {
				URL image = new URL(url);
				url= image.getPath();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			return url;
		}

	  	public static void main(String[] args) {
	  		String str = "0.0.21.1";
	  		boolean regularRptCode = isRegularRptCode(str);
	        System.out.println(regularRptCode);
	    }
}
