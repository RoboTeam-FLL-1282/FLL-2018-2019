package EV3;

import java.util.LinkedList;
import java.util.List;

import EV3Library.Logging;

public class FileAccess { // Done!
	
	Logging l;
	int index = 0;
	List<String> dataList;
	List<String> insertedData = new LinkedList<String>();
	
	public FileAccess(String fileName) {
		l = new Logging(fileName);
		l.create();
	}
	
	public void write(String data) {
		insertedData.add(data);
	}
	
	public void write(double data) {
		insertedData.add(data + "");
	}
	
	public String readText() {
		if(index == 0) {
			dataList = l.readData();
		}
		if(index > dataList.size()-1)
			index = 0;
		index++;
		return dataList.get(index-1);
	}
	
	public double readNumeric() {
		if(index == 0) {
			dataList = l.readData();
		}
		index++;
		if(index > dataList.size())
			index = 0;
		return Double.parseDouble(dataList.get(index-1));
	}
	
	public void delete() {
		l.delete();
	}
	
	public void close() {
		index = 0;
		l.writeData(insertedData);
	}
	
}
