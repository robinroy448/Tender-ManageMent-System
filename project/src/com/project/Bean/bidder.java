package com.project.Bean;

public class bidder {
	

	private int vid;
	private String name;
	private String tid;
	private int price;
	private String deadline;
	
	public bidder(int vid, String name, String tid, int price, String deadline) {
		super();
		this.vid = vid;
		this.name = name;
		this.tid = tid;
		this.price = price;
		this.deadline = deadline;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "bidder [vid=" + vid + ", name=" + name + ", tid=" + tid + ", price=" + price + ", deadline=" + deadline
				+ ", location=" + "]";
	}
	

	
	
	
}
