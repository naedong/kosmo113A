package ex1.model;

import ex1.dao.SawonDeptDao;
import ex1.dto.DeptDTO;
import ex1.dto.SawonDTO;
import java.util.ArrayList;
// �׻� ���� ���ؼ� Dao�� �����Ѵٴ� ���� �ʼ�!!!!!!
public class SawonModel {
    
    public ArrayList<SawonDTO> getList(){
        //Dao�� �ҷ��� ��ȯ�ϴ� �⺻ ��
        //1. �⺻������ return �� ���
       // return SawonDeptDao.getSawonDao().getSawonList();
        
       //2. Dao�� �޾Ƽ� ó�� �Ұ�� 
       SawonDeptDao dao = SawonDeptDao.getSawonDao();
       ArrayList<SawonDTO> arlist = dao.getSawonList();
       // �߰��۾� 
       return arlist;
      
    }
    
    public ArrayList<DeptDTO> getSawonDeptModel(){
        return SawonDeptDao.getSawonDao().getSawonDept();
    }
    
    public ArrayList<DeptDTO> getSawonDeptGogekModel(){
        return SawonDeptDao.getSawonDao().getSawonDeptGogek();
    }
}
