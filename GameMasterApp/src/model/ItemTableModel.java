package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ItemTableModel extends AbstractTableModel {
	ArrayList<Item> dataItems;
	String[] arrColumns = {"id","name","avail","bprice","description","Parent"};
	
	public ItemTableModel(){
		
	}
	
	public ItemTableModel(ArrayList<Item> alData){
		this.dataItems = alData;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return arrColumns.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataItems.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Object objTemp = null;
		switch(col){
			case 0:	objTemp = dataItems.get(row).getId();break;
			case 1: objTemp = dataItems.get(row).getName();break;
			case 2: objTemp = dataItems.get(row).getAvailability();break;
			case 3: objTemp = dataItems.get(row).getBasePrice();break;
			case 4: objTemp = dataItems.get(row).getDescription();break;
			case 5: if(dataItems.get(row).getItem()!= null){
						objTemp = dataItems.get(row).getItem().getId();break;
					} else {objTemp = 0;break;}
		}
		return objTemp;
	}

}
