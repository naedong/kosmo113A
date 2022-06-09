/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kosmo
 */
public class MyTable extends  AbstractTableModel{
 
    private String[] columnNames;
    private Object[][] data;

    public MyTable(Object[][] data,String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;
    }
             
   @Override
   public int getRowCount() {
        return data.length;
   }

  @Override
   public int getColumnCount() {
         return columnNames.length;
   }

  @Override
 public Object getValueAt(int rowIndex, int columnIndex) {
       return data[rowIndex][columnIndex];
  }           

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


}
