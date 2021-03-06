package com.gzzn.fgw.expExcel;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.gzzn.fgw.webUtil.JxlExcelCellUtil;
import com.gzzn.fgw.model.SysOperationlog;
import com.gzzn.fgw.model.SysProjectlog;
/**
 * <p>Title: SysOperationlogExpExcel</p>
 * <p>Description: 导出日志到Excel </p>
 * <p>Copyright: Copyright (c) 2013 ITDCL  All right reserved.</p>
 * <p>Company: ITDCL</p>
 * @author lhq
 * @version 1.0
 *
 * 修改记录:
 * 下面填写修改的内容以及修改的日期
 * 1.2013-12-19 上午10:40:48 lhq  new
 */
public class SysOperationlogExpExcel extends JxlExcelCellUtil<SysOperationlog> {

	@Override
	public WritableSheet writableSheetCell(String fdName, SysOperationlog obj,
			int column, int row, WritableSheet sheet) {
		try {
			if(fdName==null&&column==0){
				if(row==0){  
					sheet.addCell(new jxl.write.Label(0,row, "序号",topCellStyle())); sheet.setColumnView(0, 10);//列宽
					sheet.addCell(new jxl.write.Label(1,row, "用户名称",topCellStyle())); sheet.setColumnView(1, 15);//列宽
					sheet.addCell(new jxl.write.Label(2,row, "单位名称",topCellStyle())); sheet.setColumnView(2, 15);//列宽
					sheet.addCell(new jxl.write.Label(3,row, "部门名称",topCellStyle())); sheet.setColumnView(3, 15);//列宽
					sheet.addCell(new jxl.write.Label(4,row, "操作内容",topCellStyle())); sheet.setColumnView(4, 70);//列宽
					sheet.addCell(new jxl.write.Label(5,row, "操作时间",topCellStyle())); sheet.setColumnView(5, 20);//列宽
				}
				sheet.addCell(expDataType(0,row+1, Integer.valueOf(row+1)));
				sheet.addCell(expDataType(1,row+1,obj.getSysUser().getUserName()));
				sheet.addCell(expDataType(3,row+1,obj.getSysOrganization()==null?"":obj.getSysOrganization().getOrganizationName()));
				sheet.addCell(expDataType(2,row+1,obj.getSysDept()==null?"":obj.getSysDept().getDeptname()));
				sheet.addCell(expDataType(4,row+1,obj.getOperationContent()));
				sheet.addCell(expDataType(5,row+1,obj.getOperationDatetime()));
			}
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return sheet;
	}

}
