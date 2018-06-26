package com.sport.bet.datasource.parsing.pin1111;

import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.springframework.stereotype.Component;

import com.sport.bet.bean.model.SportModule;
import com.sport.bet.datasource.parsing.AbstractPaser;

@Component
public class PagePin1111Paser extends AbstractPaser<SportModule> {

	
	@Override
	public List<SportModule> parsed(String page) {
		HtmlCleaner hc = new HtmlCleaner();
		
		TagNode tn = hc.clean(page);
		String xpath = "//li[@class='level-1 no-live']//li[@class='level-2']/span/span[@class='sport-icon soccer']";
		
		SportModule sportModule = null;
		try {
			Object[] obj = tn.evaluateXPath(xpath);
			if(obj == null || obj.length <= 0){
				return null;
			}
			TagNode spantn = (TagNode) obj[0];
		
			Object[] subObjArr = spantn.getParent().getParent().evaluateXPath("/ul[@style='display:none']/li");
			
			for (Object object : subObjArr) {
				TagNode submenuTn = (TagNode) object;
				
				Object[] submenuObjArr = submenuTn.evaluateXPath("/span/span[@class='trigger']");
				Object[] submenuItemObjArr = submenuTn.evaluateXPath("/ul/li/a[@class='text'][@onclick]");
				if(submenuObjArr == null || submenuObjArr.length <= 0 
						|| submenuItemObjArr == null || submenuItemObjArr.length <= 0 ){
					continue;
				}
				TagNode  submenuSpanTn = (TagNode) submenuObjArr[0];
				String groupName = submenuSpanTn.getAttributeByName("title");
				
				for (Object object2 : submenuItemObjArr) {
					
					TagNode itemTn = (TagNode) object2;
					
					sportModule =  new SportModule();
					sportModule.setGroupName(groupName);
					sportModule.setGroupItemName(itemTn.getText().toString().trim());
					sportModule.setGameLinesPd(itemTn.getAttributeByName("href"));
					sportModule.setResourceId(resourceId);
					list.add(sportModule);
				}
			}
		} catch (XPatherException e) {
			e.printStackTrace();
		} 
		return list;
	}

}
