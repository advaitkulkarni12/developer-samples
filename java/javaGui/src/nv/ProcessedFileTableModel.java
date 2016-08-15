package nv;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

public class ProcessedFileTableModel extends AbstractTableModel implements Observer {
	//private Object[][] data;
    private String[] title;
    final private List<ProcessedImage> processedImages = new ArrayList<>();
    
    public void addProcessedImage(ProcessedImage anImage) {
        if (processedImages.add(anImage)) {
            anImage.addObserver(this);
            this.fireTableDataChanged();
        }
    }

    public ProcessedFileTableModel(String[] title){
      //this.data = data;
      this.title = title;
    }

    public String getColumnName(int col) {
      return this.title[col];
    }

    public int getColumnCount() {
      return this.title.length;
    }

    public int getRowCount() {
      return this.processedImages.size();
    }
    
    public ProcessedImage getImageAt(int row) {
    	return this.processedImages.get(row);
    }
    
    public Object getValueAt(int row, int col) {
    	if (col == 0){
    		return this.processedImages.get(row).getImagePath().getName();//.data[row][col];
    	}
    	else {
    		return this.processedImages.get(row).getStatus();
    	}
    }

	@Override
	public void update(Observable o, Object arg) {
		/*ProcessedImage image = (ProcessedImage)o;
        int index = processedImages.indexOf(image);*/
        this.fireTableDataChanged();
		
	}

    /*public void setValueAt(Object value, int row, int col) {
    	this.data[row][col] = value;
    }*/

    /*public Class getColumnClass(int col){
      return this.data[0][col].getClass();
    }*/
    
    /*public void removeRow(int position){
        
        int indice = 0, indice2 = 0;
        int nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
        Object temp[][] = new Object[nbRow][nbCol];
         
        for(Object[] value : this.data){
           if(indice != position){
              temp[indice2++] = value;
           }
           System.out.println("Indice = " + indice);
           indice++;
        }
        this.data = temp;
        temp = null;
        this.fireTableDataChanged();
     }*/
      
     /*public void addRow(Object[] data){
        int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
         
        Object temp[][] = this.data;
        this.data = new Object[nbRow+1][nbCol];
         
        for(Object[] value : temp)
           this.data[indice++] = value;
         
            
        this.data[indice] = data;
        temp = null;
        this.fireTableDataChanged();
     }

    public boolean isCellEditable(int row, int col){
      return true;
    }*/
}
