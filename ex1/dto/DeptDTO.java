package ex1.dto;
/*
select s.sabun,s.saname,s.sapay, s.deptno, d.dname,d.loc from sawon s, dept d
where s.deptno=d.deptno
//ArrayList<DeptDTO> ar
while(rs.next()){
    DeptDTO dept = new DeptDTO();
    SawonDTO sawon = new SawonDTO();
    
}
*/
public class DeptDTO {
    private SawonDTO sawon;
    private int deptno;
    private String dname;
    private String loc;

    public SawonDTO getSawon() {
        return sawon;
    }

    public void setSawon(SawonDTO sawon) {
        this.sawon = sawon;
    }

    
    
    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    
}
