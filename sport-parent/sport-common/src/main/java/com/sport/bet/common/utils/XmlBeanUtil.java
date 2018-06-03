package com.sport.bet.common.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlBeanUtil {
	/**
	 * convert xml to object
	 * @param data - xml String to be converted
	 * @param classes - the class types to be converted to
	 * @return converted object
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Object(String data, Class<?>... classes ) throws Exception{
		Unmarshaller um = JAXBContext.newInstance(classes).createUnmarshaller();
		StringReader reader = new StringReader(data);
		final T obj = (T)um.unmarshal(reader);	
		return obj;
	}

	/**
	 * convert object to xml string
	 * @param object - the object to be converted
	 * @param classes - class types the object contains
	 * @return xml string
	 * @throws Exception
	 */
	public static <T> String object2Xml(T object, Class<?>... classes) throws Exception{
		Marshaller m = JAXBContext.newInstance(classes).createMarshaller();
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		StringWriter writer = new StringWriter();
		m.marshal(object, writer);
		String xmlString = writer.toString();
		
		int index = 0;
		while((index = xmlString.indexOf(" xsi:type", index)) != -1){
			int tmpIndex = xmlString.indexOf(">", index);
			if(tmpIndex != -1){
				String subString = xmlString.substring(index, tmpIndex);
				xmlString = xmlString.replace(subString, "");
			}
			index++;
		}
		
		return xmlString.replace("standalone=\"yes\"", "");
	}
	
	/**
	 * convert object to xml fragment, without xml header
	 * @param object - object to be converted
	 * @param clazz - class type of the object
	 * @return xml fragment string
	 * @throws Exception
	 */
	public static <T> String object2XmlFragemnt(T object, Class<T> clazz) throws Exception{
		Marshaller m = JAXBContext.newInstance(clazz).createMarshaller();
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty(Marshaller.JAXB_FRAGMENT, true);
		m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		
		StringWriter writer = new StringWriter();
		m.marshal(object, writer);
		
		return writer.toString();
	}
	
	/**
	 * convert xml fragment to object
	 * @param data - the whole xml string
	 * @param startStr - start string
	 * @param endStr - end string 
	 * @param struct - the structure name of the xml fragment
	 * @param clazz - class type to be converted to 
	 * @return object of type T
	 * @throws Exception
	 */
	public static <T> T parseXmlFragment(String data, String startStr, String endStr, String struct, Class<T> clazz) throws Exception {
		int start = data.indexOf(startStr);
		int end = data.indexOf(endStr);
		if(start == -1 || end == -1 || start >= end){
			throw new JAXBException(struct);
		}
		
		String fragment = data.substring(start, end + endStr.length());
		try{
			T obj = xml2Object(fragment, clazz);
			return obj;
		} catch (Exception e){
			throw new JAXBException(struct);
		}
	}
	
	/**
	 * concatenation string
	 * @param initStr 初始字符串
	 * @param addStr  追加字符串
	 * @param beforeStr 追加位置,在beforeStr之前追加
	 * @return 拼接后字符串
	 */
	public static String concatXmlString(String initStr, String addStr, String beforeStr){
		int index = initStr.indexOf(beforeStr);
		if(index == -1){
			return initStr;
		}
		
		return initStr.replace(beforeStr, addStr + beforeStr);
	}
}
