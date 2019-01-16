package EV3;

import java.util.LinkedList;
import java.util.List;

import EV3Library.Logging;

public class FileAccess {
	
	Logging l;
	int index = 0;
	List<String> dataList;
	List<String> insertedData = new LinkedList<String>();
	
	/**
	 * @param fileName - The file name.
	 * If there is no such file, a new one will be created.
	 */
	public FileAccess(String fileName) {
		l = new Logging(fileName);
		l.create();
	}
	
	/**
	 * Creates a new file. Notice that this should only be called if the
	 * delete() was called before. Otherwise the file was already created. 
	 */
	public void create() {
		l.create();
	}
	/**
	 * Writes a new line to the file.
	 * @param data - String of data.
	 */
	public void write(String data) {
		insertedData.add(data);
	}
	
	/**
	 * Writes a new line to the file.
	 * @param data - Numerical data.
	 */
	public void write(double data) {
		insertedData.add(data + "");
	}
	
	/**
	 * Reads the next line every time.
	 * @return - A string that contains the whole line.
	 */
	public String readText() {
		if(index == 0) {
			dataList = l.readData();
		}
		if(index > dataList.size()-1)
			index = 0;
		index++;
		return dataList.get(index-1);
	}
	
	/**
	 * Reads the next line every time.
	 * @return - Numerical data.
	 */
	public double readNumeric() {
		if(index == 0) {
			dataList = l.readData();
		}
		index++;
		if(index > dataList.size())
			index = 0;
		return Double.parseDouble(dataList.get(index-1));
	}
	
	/**
	 * Deletes the file.
	 */
	public void delete() {
		l.delete();
	}
	
	/**
	 * Closes the file.
	 * Notice - After writing to a file, it must be closed before it is read.
	 */
	public void close() {
		index = 0;
		l.writeData(insertedData);
	}
	
}
