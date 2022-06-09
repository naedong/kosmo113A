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
        System.out.println("콘솔 모드 테스트");
        SawonModel model = new SawonModel();
       // ArrayList<SawonDTO> list = model.getList();
      // ArrayList<DeptDTO> list = model.getSawonDeptModel();
      ArrayList<DeptDTO> list = model.getSawonDeptGogekModel();
        for(DeptDTO e: list){
            System.out.print("부서 이름: "+e.getDname());
            System.out.print("위치: "+e.getLoc());
            //e 는 DeptDTO의 주소를 사용해서 SawonDTO의 주소를 받아온다.
            SawonDTO sawon = e.getSawon();
            System.out.print("부서번호: "+sawon.getDeptno());
            System.out.print(" 사원번호 :"+sawon.getSabun());
            System.out.print(" 이름  :"+sawon.getSaname());
            System.out.print(" 직책  :"+sawon.getSajob());
            GogekDTO gogek = e.getSawon().getGogek();
            System.out.print("고객번호 : "+gogek.getGbun());
            System.out.print("고객명 :"+gogek.getGoname());
            System.out.println("고객연락처:"+gogek.getGotel());
            System.out.println("============================");
        }
    }
}
