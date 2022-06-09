package ex1.dao;

import ex1.TestConn;
import ex1.dto.DeptDTO;
import ex1.dto.GogekDTO;
import ex1.dto.SawonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.net.nt.ConnOption;

public class SawonDeptDao {
    private static SawonDeptDao sawonDao;
    private SawonDeptDao() {}
    // �������� getSawonDao() ȣ���ϸ�
    // �������� getSawonDao() 2��° ȣ���ϸ�
    public static SawonDeptDao getSawonDao() {
        // static sawonDao ���� null�̸� ó�� ȣ��
        if(sawonDao == null){
            //static  �����ϰ�
            sawonDao = new SawonDeptDao();
        }
        // 2��°�� static���� �̹� ������ �ּҸ� ��ȯ 
        return sawonDao;
    }
    // select , insert,update,delete �۾��鸸 DaoŬ�������� ���� 
    // sawon���� ������ ����ϴ� �⺻ �޼��� 
    // �޼��� ���¸� �ľ��ϰ� ����
    // while(rs.next()){
    
    // }
    // --> select sabun,saname,sajob,deptno,sahire from sawon order by 1 desc
    public ArrayList<SawonDTO> getSawonList(){
        //1. Connection
        //2. PreparedStatement
        //3. ResultSet
        //4. SQL�ۼ�
        //5. ArrayList ����
        // 5-1. Connection ���� 
        // 5-2. PreparedStatement ����ؼ� �ش� SQL���� [���ε�] ���� executeUpdate(), executeQuery();
        //6. while(rs.next()){
        //7. ArrayList�� �� SawonDTO �����ϰ�
        //8. rs.getXX() -> SawonDTO�� �����ϰ� , �̰��� ArrayList�� ����
        //9. }
        //10. �ڿ����� 
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select sabun,saname,sajob,deptno,sahire from sawon order by 1 desc";
        // ArrayList�� �����Ѵ�. 
        ArrayList<SawonDTO> arlist = new ArrayList<>();
        try {
            //5-1
            con = TestConn.getConn();
            //5-2
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //6
            while(rs.next()){
                //7 ������ row�ϳ��� DTO ��ü ����
                SawonDTO vo = new SawonDTO();
                vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                vo.setDeptno(rs.getInt("deptno"));
                vo.setSahire(rs.getString("sahire"));
                // ArrayList�� ����Ѵ�.
                arlist.add(vo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
               if(rs != null) rs.close();
               if(pstmt != null) pstmt.close();
               if(con != null) con.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        return arlist;
    }
    public ArrayList<DeptDTO> getSawonDept(){
        /*
        select s.sabun,s.saname,s.sapay, s.deptno, d.dname,d.loc from sawon s, dept d
        where s.deptno=d.deptno order by 1 desc
        */
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select s.sabun,s.saname,s.sajob, s.deptno, d.dname,d.loc from sawon s, dept d ");
        sql.append(" where s.deptno=d.deptno order by 1 desc");
        ArrayList<DeptDTO> arlist = new ArrayList<>();
        try {
            con = TestConn.getConn();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                DeptDTO dvo = new DeptDTO();
                dvo.setDname(rs.getString("dname"));
                dvo.setLoc(rs.getString("loc"));
                SawonDTO vo = new SawonDTO();
                vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                vo.setDeptno(rs.getInt("deptno"));
                dvo.setSawon(vo);
                // ArrayList�� ����Ѵ�.
                arlist.add(dvo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
               if(rs != null) rs.close();
               if(pstmt != null) pstmt.close();
               if(con != null) con.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        return arlist;
    }
    public ArrayList<DeptDTO> getSawonDeptGogek(){
        /*
       select g.gobun,g.goname,g.gotel, s.saname, s.sajob, s.deptno, d.dname,d.loc from gogek g, sawon s, dept d
            where g.godam=s.sabun(+)
            and s.deptno=d.deptno(+);
        */
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuilder sql = new StringBuilder();
        sql.append("select g.gobun,g.goname,g.gotel,s.sabun, s.saname, s.sajob, s.deptno, d.dname,d.loc from gogek g, sawon s, dept d ");
        sql.append("  where g.godam=s.sabun(+)  and s.deptno=d.deptno(+) ");
        ArrayList<DeptDTO> arlist = new ArrayList<>();
        try {
            con = TestConn.getConn();
            pstmt = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                DeptDTO dvo = new DeptDTO();
                dvo.setDname(rs.getString("dname"));
                dvo.setLoc(rs.getString("loc"));
                SawonDTO vo = new SawonDTO();
                vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                vo.setDeptno(rs.getInt("deptno"));
                GogekDTO gvo = new GogekDTO();
                gvo.setGbun(rs.getInt("gobun"));
                gvo.setGoname(rs.getString("goname"));
                gvo.setGotel(rs.getString("gotel"));
                vo.setGogek(gvo);   // SawonDTO���� select�� GogekDTO�� �����Ѵ�.
                dvo.setSawon(vo);  // DeptDTO���� select�� SawonDTO�� �����Ѵ�.
                // ArrayList�� ����Ѵ�.
                arlist.add(dvo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
               if(rs != null) rs.close();
               if(pstmt != null) pstmt.close();
               if(con != null) con.close();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        return arlist;
    }
    
    // �μ���ȣ�� �Է¹޾Ƽ� �ش� ������� ��� -- 
    // --> select * from sawon where deptno = 10
    public ArrayList<SawonDTO> getSawonList(int deptno){
        
        return null;
    }
    // �����ȣ�� �Է� �޾Ƽ� �ش� ����� ��� -- 
    // --> select * from sawon where sabun=2; 
    public SawonDTO getSawonView(int sabun){
        return null;
    }
    
}
