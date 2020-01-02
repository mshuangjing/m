package com.byzoro.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	static final Pattern PATTERN = Pattern.compile(".0$");
	/**
	 * IP转换为数字
	 * 
	 * @param ipAddress
	 * @return
	 */
	public static long ipToLong(String ipAddress) {
		long result = 0;
		if("".equals(ipAddress)){
			return result;
		}
		String[] ipAddressInArray = ipAddress.split("\\.");
		for (int i = 3; i >= 0; i--) {
			long ip = Long.parseLong(ipAddressInArray[3 - i]);
			// left shifting 24,16,8,0 and bitwise OR
			// 1. 192 << 24
			// 1. 168 << 16
			// 1. 1 << 8
			// 1. 2 << 0
			result |= ip << (i * 8);
		}

		return result;
	}

	/**
	 * 数字转换为IP
	 * 
	 * @param ip
	 * @return
	 */
	public static String longToIp(long ip) {
		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
	}
	
	
	public static void download(String path, HttpServletResponse response) {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			// 清空response
			response.reset();
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/vnd.ms-excel;charset=gb2312");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
			if(file.exists()){
				file.delete();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * 从本地上传文件
	 * @param request
	 * @param response
	 * @return
	 */
	public static Map<String, Object> uploadConfig(HttpServletRequest request, HttpServletResponse response) {
		 String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
         File file = new File(savePath);
         Map<String,Object> mapMessage = new HashMap<String, Object>();
         //判断上传文件的保存目录是否存在
         if (!file.exists() && !file.isDirectory()) {
             System.out.println(savePath+"目录不存在，需要创建");
             //创建目录
             file.mkdir();
         }
         //消息提示
         String message = "";
         try{
            DiskFileItemFactory factory = new DiskFileItemFactory();
            
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8"); 
	        if(!ServletFileUpload.isMultipartContent(request)){
	        	message="提交上来的数据是非上传表单数据";
	        	mapMessage.put("message", message);
	           return mapMessage;
	        }
             List<FileItem> list = upload.parseRequest(request);
             for(FileItem item : list){
		          if(item.isFormField()){
		             String name = item.getFieldName();
		             String value = item.getString("UTF-8");
		             System.out.println(name + "=" + value);
		           }else{//如果fileitem中封装的是上传文件
		             //得到上传的文件名称，
		             String filename = item.getName();
		             System.out.println(filename);
		             if(filename==null || "".equals(filename.trim())){
		                 continue;
		             }
		             
		             filename = filename.substring(filename.lastIndexOf("\\")+1);
		             InputStream in = item.getInputStream();
		             FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
					  byte[] buffer = new byte[1024];
		             
		             int len = 0;
		             while((len=in.read(buffer))>0){
	                   out.write(buffer, 0, len);
		             }
	                  in.close();
	                  out.close();
	                  message = "文件上传成功！";
	                  mapMessage.put("savePath", savePath);
	                  mapMessage.put("fileName", item.getName());
	                  mapMessage.put("item", item);
	                  mapMessage.put("message", message);
	           }
            }
	      }catch (Exception e) {
	          message= "文件上传失败！";
	          mapMessage.put("message", message);
	          e.printStackTrace();
	          return mapMessage;
	      }
	     return mapMessage;
    }

	/**
	 * 根据keys过滤请求参数New
	 * @param resParams
	 * @param keys
	 * @return
	 */
	public static Map<String, String> getParamsByKeysNew(Map<String, String[]> resParams, String[] keys) {
		Map<String, String> params = new HashMap<String, String>();
		for (Map.Entry<String, String[]> entry : resParams.entrySet()) {
			if (Arrays.asList(keys).contains(entry.getKey())) {
				if (entry.getValue().length > 0) {
					params.put(entry.getKey(), entry.getValue()[0]);
				} else {
					params.put(entry.getKey(), "");
				}
			}
		}
		return params;
	}


	/**
	 * 根据keys过滤请求参数
	 * @param resParams
	 * @param keys
	 * @return
	 */
	public static Map<String, Object> getParamsByKeys(Map<String, String[]> resParams, String[] keys){
		Map<String, Object> params = new HashMap<String, Object>();
		for (Map.Entry<String, String[]> entry : resParams.entrySet()) {
			if (Arrays.asList(keys).contains(entry.getKey())) {
				if (entry.getValue().length > 0) {
					params.put(entry.getKey(), entry.getValue()[0]);
				} else {
					params.put(entry.getKey(), "");
				}
			}
		}
		return params;
	}

	/**
	 * 返回8位的随机数
	 * @return
	 */
	public static Long randNum(){
		Long randNum = System.nanoTime();
		return Long.parseLong(randNum.toString().substring(8, 14));
	}
	
	/** 
     * 获得一个UUID 
     * @return String UUID 
     */ 
    public static String getUUID(){ 
        String s = UUID.randomUUID().toString(); 
        //去掉“-”符号 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
    }
    
    /** 
     * 获得指定数目的UUID 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */ 
    public static String[] getUUID(int number){ 
        if(number < 1){ 
            return null; 
        } 
        String[] ss = new String[number]; 
        for(int i=0;i<number;i++){ 
            ss[i] = getUUID(); 
        } 
        return ss; 
    }
    
    
    /**
     * java TB GB MB K B 相互转换
     * @param size
     * @return
     */
    public static String readableFileSize(long size) {  
        if (size <= 0) {  
            return "0";  
        }  
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB","PB","EB","ZB","YB"};  
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));  
        return new DecimalFormat("#,##0.##").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];  
    }
    
    /**
     * 去掉java无法去除的双引号
     * @param str
     * @return
     */
    public static String filterDou(String str) {
    	if(str.indexOf("\"")==0){ str = str.substring(1,str.length());}   //去掉第一个 "
    	if(str.lastIndexOf("\"")==(str.length()-1)){ str = str.substring(0,str.length()-1);}  //去掉最后一个 "
    	return str;
    }
    
    
    /**
     * 获取json数据并返回对应对象
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException
     */
    public static ViewResult getJsonView(String response) throws JsonParseException, JsonMappingException, IOException{
    	 ViewResult viewResult = new ViewResult();
    	 ObjectMapper objectMapper = new ObjectMapper();
         HashMap<String, Object> jsonObj = objectMapper.readValue(response, HashMap.class);
         if (jsonObj != null && (int) jsonObj.get("status") == 1) {
             String datas = objectMapper.writeValueAsString(jsonObj);

             List<String> data = new ArrayList<>();
             data.add(datas);
             viewResult.setData(data);
             viewResult.setTotalNum((int) jsonObj.get("total"));
         } else {
             viewResult.setStatus(ViewResult.ERROR);
         }
         return viewResult;
    }
    
    
    public static void main(String[] args) {
    	
    	System.out.println(getUUID());
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); //得到前一天
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(df.format(date));
	}
    
    // 处理科学计数法与普通计数法的字符串显示，尽最大努力保持精度
    public static String getRealStringValueOfDouble(String doubleStr) {
        boolean b = doubleStr.contains("E");
        int indexOfPoint = doubleStr.indexOf('.');
        if (b) {
            int indexOfE = doubleStr.indexOf('E');
            // 小数部分
            BigInteger xs = new BigInteger(doubleStr.substring(indexOfPoint
                    + BigInteger.ONE.intValue(), indexOfE));
            // 指数
            int pow = Integer.valueOf(doubleStr.substring(indexOfE
                    + BigInteger.ONE.intValue()));
            int xsLen = xs.toByteArray().length;
            int scale = xsLen - pow > 0 ? xsLen - pow : 0;
            doubleStr = String.format("%." + scale + "f", Double.parseDouble(doubleStr));
        } else {
            Matcher m = PATTERN.matcher(doubleStr);
            if (m.find()) {
                doubleStr = doubleStr.replace(".0", "");
            }
        }
        return doubleStr;
    }
	/**
	 * 案件分析 比较<=2的作案工具
	 * @author lijigndi
	 * @param items
	 * @param value
	 * @return
	 */
	public static List frequencyOfListElements(List<String> items,String value) {
		if (items == null || items.size() == 0) return null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<Object> keyList = new ArrayList<>();
		for (String temp : items) {
			Integer count = map.get(temp);
			//查询元素是否出现两次以上 如果是 value置为2 否则count+1
			map.put(temp, (count == null) ? 1 : (count + 1 >=2 ? 2:count + 1));
		}
		if(map.size()>0){
			//根据value取出key
			for(Object key: map.keySet()){
				if(map.get(key).equals(Integer.valueOf(value))){
					keyList.add(key);
				}
			}
		}
		return keyList;
	}

	/**
	 * 利用反射将map集合封装成bean对象
	 * @author lijingdi
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {
		Object obj = clazz.newInstance();
		if (map != null && !map.isEmpty() && map.size() > 0) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String propertyName = entry.getKey(); 	// 属性名
				Object value = entry.getValue();		// 属性值
				String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
				Field field = getClassField(clazz, propertyName);	//获取和map的key匹配的属性名称
				if (field == null){
					continue;
				}
				Class<?> fieldTypeClass = field.getType();
				value = convertValType(value, fieldTypeClass);
				try {
					clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		return (T) obj;
	}

	/**
	 * 根据给定对象类匹配对象中的特定字段
	 * @param clazz
	 * @param fieldName
	 * @author lijingdi
	 * @return
	 */
	private static Field getClassField(Class<?> clazz, String fieldName) {
		if (Object.class.getName().equals(clazz.getName())) {
			return null;
		}
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}
		Class<?> superClass = clazz.getSuperclass();	//如果该类还有父类，将父类对象中的字段也取出
		if (superClass != null) {						//递归获取
			return getClassField(superClass, fieldName);
		}
		return null;
	}

	/**
	 * 将map的value值转为实体类中字段类型匹配的方法
	 * @param value
	 * @author lijingdi
	 * @param fieldTypeClass
	 * @return
	 */
	private static Object convertValType(Object value, Class<?> fieldTypeClass) {
		Object retVal = null;

		if (Long.class.getName().equals(fieldTypeClass.getName())
				|| long.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Long.parseLong(value.toString());
		} else if (Integer.class.getName().equals(fieldTypeClass.getName())
				|| int.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Integer.parseInt(value.toString());
		} else if (Float.class.getName().equals(fieldTypeClass.getName())
				|| float.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Float.parseFloat(value.toString());
		} else if (Double.class.getName().equals(fieldTypeClass.getName())
				|| double.class.getName().equals(fieldTypeClass.getName())) {
			retVal = Double.parseDouble(value.toString());
		} else {
			retVal = value;
		}
		return retVal;
	}

	private static final String regex = "[^!#$%&'()*+,./;:=?@[/] ]";

	public static String encode(String str, String charset) throws UnsupportedEncodingException {
		if (str == null || charset == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			matcher.appendReplacement(sb, URLEncoder.encode(matcher.group(0), charset));
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

}
