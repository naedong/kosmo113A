/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.front;

import ex1.dto.DeptDTO;
import ex1.dto.GogekDTO;
import ex1.dto.SawonDTO;
import ex1.model.SawonModel;
import java.util.ArrayList;

/**
 *
 * @author kosmo
 */
public class SawonListDemo {
    public static void main(String[] args) {
        // select sabun,saname,sajob,deptno,sahire
        // s.sabun,s.saname,s.sajob, s.deptno, d.dname,d.loc
        // g.gobun,g.goname,g.gotel, s.saname, s.sajob, s.deptno, d.dname,d.loc from gogek g, sawon s, dept d
        System.out.println("�ܼ� ��� �׽�Ʈ");
        SawonModel model = new SawonModel();
       // ArrayList<SawonDTO> list = model.getList();
      // ArrayList<DeptDTO> list = model.getSawonDeptModel();
      ArrayList<DeptDTO> list = model.getSawonDeptGogekModel();
        for(DeptDTO e: list){
            System.out.print("�μ� �̸�: "+e.getDname());
            System.out.print("��ġ: "+e.getLoc());
            //e �� DeptDTO�� �ּҸ� ����ؼ� SawonDTO�� �ּҸ� �޾ƿ´�.
            SawonDTO sawon = e.getSawon();
            System.out.print("�μ���ȣ: "+sawon.getDeptno());
            System.out.print(" �����ȣ :"+sawon.getSabun());
            System.out.print(" �̸�  :"+sawon.getSaname());
            System.out.print(" ��å  :"+sawon.getSajob());
            GogekDTO gogek = e.getSawon().getGogek();
            System.out.print("����ȣ : "+gogek.getGbun());
            System.out.print("���� :"+gogek.getGoname());
            System.out.println("������ó:"+gogek.getGotel());
            System.out.println("============================");
        }
    }
}
