package com.xyc.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xyc.crm.domain.BaseDict;
import com.xyc.crm.service.BaseDictService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * �ֵ��Action����
 * @author YuChen_Xu
 *
 */
public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	//ģ��������ʹ�õ���
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	//ע��Service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	/**
	 * �����������Ʋ�ѯ�ֵ�ķ�����findByTypeCode
	 * @throws IOException 
	 */
	public String findByTypeCode() throws IOException {
		System.out.println("BaseDictAction�е�findByTypeCode����ִ����");
		//����ҵ����ѯ
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//��ListתΪJSON-----jsonlib��fastjson
		/**
		 * JSONConfig��JSON�����ö���
		 * JSONArray���������list����ת����JSON
		 * JSONObject���������map����ת����JSON
		 */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		System.out.println(jsonArray.toString());
		//��json��ӡ��ҳ��
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
