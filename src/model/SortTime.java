package model;

import java.util.Comparator;

public class SortTime implements Comparator<Information>{

	@Override
	public int compare(Information arg0, Information arg1) {
		// TODO Auto-generated method stub
		return arg0.getTime().compareTo(arg1.getTime());
	}

}
