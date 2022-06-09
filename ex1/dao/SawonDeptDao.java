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
    // 누군가가 getSawonDao() 호출하면
    // 누군가가 getSawonDao() 2번째 호출하면
    public static SawonDeptDao getSawonDao() {
        // static sawonDao 값이 null이면 처음 호출
        if(sawonDao == null){
            //static  생성하고
            sawonDao = new SawonDeptDao();
        }
        // 2번째는 static에서 이미 생성된 주소를 반환 
        return sawonDao;
    }
    // select , insert,update,delete 작업들만 Dao클래스에서 정의 
    // sawon들의 정보를 출력하는 기본 메서드 
    // 메서드 형태를 파악하고 정의
    // while(rs.next()){
    
    // }
    // --> select sabun,saname,sajob,deptno,sahire from sawon order by 1 desc
    public ArrayList<SawonDTO> getSawonList(){
        //1. Connection
        //2. PreparedStatement
        //3. ResultSet
        //4. SQL작성
        //5. ArrayList 생성
        // 5-1. Connection 연결 
        // 5-2. PreparedStatement 사용해서 해당 SQL문을 [바인딩] 전송 executeUpdate(), executeQuery();
        //6. while(rs.next()){
        //7. ArrayList에 들어갈 SawonDTO 생성하고
        //8. rs.getXX() -> SawonDTO에 저장하고 , 이값을 ArrayList에 저장
        //9. }
        //10. 자원해제 
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select sabun,saname,sajob,deptno,sahire from sawon order by 1 desc";
        // ArrayList를 생성한다. 
        ArrayList<SawonDTO> arlist = new ArrayList<>();
        try {
            //5-1
            con = TestConn.getConn();
            //5-2
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //6
            while(rs.next()){
                //7 데이터 row하나당 DTO 객체 생성
                SawonDTO vo = new SawonDTO();
                vo.setSabun(rs.getInt("sabun"));
                vo.setSaname(rs.getString("saname"));
                vo.setSajob(rs.getString("sajob"));
                vo.setDeptno(rs.getInt("deptno"));
                vo.setSahire(rs.getString("sahire"));
                // ArrayList에 기억한다.
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
                // ArrayList에 기억한다.
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
                vo.setGogek(gvo);   // SawonDTO에게 select된 GogekDTO를 전달한다.
                dvo.setSawon(vo);  // DeptDTO에게 select된 SawonDTO를 전달한다.
                // ArrayList에 기억한다.
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
    
    // 부서번호를 입력받아서 해당 사원들을 출력 -- 
    // --> select * from sawon where deptno = 10
    public ArrayList<SawonDTO> getSawonList(int deptno){
        
        return null;
    }
    // 사원번호를 입력 받아서 해당 사원을 출력 -- 
    // --> select * from sawon where sabun=2; 
    public SawonDTO getSawonView(int sabun){
        return null;
    }
    
}
