package com.gzzn.fgw.service.sys;

import com.gzzn.fgw.service.IPagedService;
import com.gzzn.fgw.model.XmsbZjxz;
/**
 * <p>Title: ISysRoleService</p>
 * <p>Description: 资金性质维护接口  </p>
 * <p>Copyright: Copyright (c) 2014 ITDCL  All right reserved.</p>
 * <p>Company: ITDCL</p>
 * @author amzhang	
 * @version 1.0
 *
 * 修改记录:
 * 下面填写修改的内容以及修改的日期
 * 1.2014-2-18 下午4:38:31 amzhang  new
 */
public interface IXmsbZjxzService extends IPagedService<XmsbZjxz> {

	/**
	 * 获取资金性质的树形list：按照上级ID、ID排序
	 * @param organizationId
	 * @param nocheck 父节点的单选或复选按钮是否显示 true不显示 false显示
	 * @return
	 */
	public String findXmsbZjxzTreeJson(Boolean nocheck);
}
