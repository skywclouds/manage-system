package com;

import java.sql.*;
import java.util.ArrayList;

/**����
 * */
public class Main {
	/**�������ݿ�Ķ���
	 * */
	public static Connection con;
	/**����T-SQL���Ķ���
	 * */
	public static Statement st;
	/**��ȡ����Ķ���
	 * */
	public static ResultSet rs;
	/**main����
	 * */
	public static void main(String [] args){
		link();//�������ݿ�
		new LogDialog().setVisible(true);//��ʾ��¼����		
	}
	/**�������ݿ�
	 * */
	public static void link() {
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=jinxiaocun";
		String userName="sa";
		String userPwd="123456";
		try{
			
			con=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("�������ݿ�ɹ�");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**��ѯ���ݿ������
	 * */
	public static ArrayList<ArrayList<String>> select(String sqlCodes, int n) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		//����ѯ����Զ�ά�ַ���������ʽ����
		try {
			st=con.createStatement();
			rs = st.executeQuery(sqlCodes);//ִ��sql���
			while(rs.next()) {
				//����������ά����
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 1;i <= n;i++) {
					if(rs.getString(i) != null) 
						temp.add(rs.getString(i).trim());					
					else 
						temp.add("null");					
				}
				list.add(temp);
			}
			System.out.println("��ѯ�ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;//���ؽ��
	}
	/**��listת��Ϊ��ά����
	 * */
	public static String[][] toArray(ArrayList<ArrayList<String>> list){
		int m = list.size();
		if(m == 0)
			return null;
		int n = list.get(0).size();
		String[][] array = new String[m][n];
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				array[i][j] = list.get(i).get(j);
			}
		}
		return array;
	}
	public static String randBianhao() {
		String s = "";
		for(int i = 0;i < 9;i++) {
			s = s + (char)('a' + (int)(Math.random()*26));
		}
		return s;
	}
	/**�����ݿ��в�������
	 * */
	public static void insert(String sqlCodes) {
		try {
			st=con.createStatement();
			st.executeUpdate(sqlCodes);//ִ��sql���
			
			System.out.println("����ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**�������ݿ�������
	 * */
	public static void update(String sqlCodes) {
		try {
			st=con.createStatement();
			st.executeUpdate(sqlCodes);//ִ��sql���
			System.out.println("���³ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**ɾ�����ݿ�������
	 * */
	public static void delete(String sqlCodes) {
		try {
			st=con.createStatement();
			st.executeUpdate(sqlCodes);//ִ��sql���
			
			System.out.println("ɾ���ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
