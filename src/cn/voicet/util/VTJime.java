package cn.voicet.util;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * static�����ķ����൱��ȫ�ֺ���ɱ��ⲿֱ�ӵ��ã������޹�
 * @author applexiang
 */
public class VTJime {
	
	private static Logger log = Logger.getLogger(VTJime.class);
	/**
	 * �������ȡ��ݣ��Ž�map
	 * @param map 	������
	 * @param rs	���
	 */
	public static void putMapDataByColName(Map<String, String> map,ResultSet rs) {
		String colName;
		try {
			//��Ԫ����л������ 
			ResultSetMetaData rsm =rs.getMetaData();
			//�����ֶε���Ŀ
			int col = rsm.getColumnCount();
			for(int i=1; i<=col; i++) {
				//����ֶε�����ֵȡ���ֶε����
				colName=rsm.getColumnName(i);
				if(null!=rs.getString(i) && !rs.getString(i).equals("")){
					map.put(colName, rs.getString(i));
				}else{
					map.put(colName, "");
				}
			}
		} catch (Exception e) {
			System.out.println("");
		}
	}
	
	/**
	 * ׼���洢������[SQLServer]
	 * m money
	 * i integer
	 * f float
	 * String ix[][]={{"-1","o"},{"2","m"},{"3","i"},{"4","f"}}; 
	 * @param cs
	 * @param sr String	ҳ��������� 
	 * @param ix index	�Դ洢������˳��Ϊ�±�,��0��ʼ����,������������	
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void prepareParamFromInputArray(CallableStatement cs, String sr[],String ix[][]) throws NumberFormatException, SQLException
	{
		log.info("ix length:"+ix.length);
		for(int i=0;i<ix.length;i++)
		{
			if(ix[i][1].equalsIgnoreCase("s"))
			{
				cs.setString(i+1,sr[Integer.parseInt(ix[i][0])]);
			}
			else if(ix[i][1].equalsIgnoreCase("m") || ix[i][1].equalsIgnoreCase("f"))
			{
				cs.setFloat(i+1,Float.parseFloat(sr[Integer.parseInt(ix[i][0])]));
			}
			else if(ix[i][1].equalsIgnoreCase("i"))
			{
				cs.setInt(i+1,Integer.parseInt(sr[Integer.parseInt(ix[i][0])]));
			}
			else if(ix[i][1].equalsIgnoreCase("o"))
			{
				log.info("do nothing");
			}
		}
	}
	
	public static void putMapDataByColNameWithColType(Map map,ResultSet rs) {
		String sColName;
		try {
			ResultSetMetaData rsm =rs.getMetaData();
			int col = rsm.getColumnCount();
			for(int i=1; i<=col; i++) {
				sColName=rsm.getColumnName(i);
				if(null!=rs.getString(i) && !rs.getString(i).equals("")){
					int dataType = rsm.getColumnType(i);
					if(dataType==3)
					{
						map.put(sColName, rs.getFloat(i));
					}
					else
					{
						map.put(sColName, rs.getString(i));
					}
					
				}else{
					map.put(sColName, "");
				}
			}
		} catch (Exception e) {
			System.out.println("");
		}
	}
	
}
