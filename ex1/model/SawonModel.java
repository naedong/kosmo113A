package ex1.model;

import ex1.dao.SawonDeptDao;
import ex1.dto.DeptDTO;
import ex1.dto.SawonDTO;
import java.util.ArrayList;
// 항상 모델을 통해서 Dao로 가야한다는 개념 필수!!!!!!
public class SawonModel {
    
    public ArrayList<SawonDTO> getList(){
        //Dao를 불러서 반환하는 기본 모델
        //1. 기본적으로 return 할 경우
       // return SawonDeptDao.getSawonDao().getSawonList();
        
       //2. Dao를 받아서 처리 할경우 
       SawonDeptDao dao = SawonDeptDao.getSawonDao();
       ArrayList<SawonDTO> arlist = dao.getSawonList();
       // 추가작업 
       return arlist;
      
    }
    
    public ArrayList<DeptDTO> getSawonDeptModel(){
        return SawonDeptDao.getSawonDao().getSawonDept();
    }
    
    public ArrayList<DeptDTO> getSawonDeptGogekModel(){
        return SawonDeptDao.getSawonDao().getSawonDeptGogek();
    }
}
