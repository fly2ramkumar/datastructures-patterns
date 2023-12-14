package com.ds.patterns.mergeIntervals;

class CPULoad {
	
	int start;
	int end;
	int cpu;
	
	public CPULoad(int start, int end, int cpu) {
		this.start = start;
		this.end = end;
		this.cpu = cpu;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	
	
	
}