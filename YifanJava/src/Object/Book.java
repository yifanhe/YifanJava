package Object;

import java.awt.Color;

public class Book {
	private String title;
	private int numbOfPages;
	private Person author;  //custom class in this package
	private Color jacketColor; //class from hava.awt
	private boolean wasLitOnFire;
	private int height; //randomly
	private int thickness; //based on number of pages. 10 pages make one unit
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate ;
	int accumulatedUse;
	String description;
	static public String[] conditions = {"This appears to be a brand new book! How lucky!","This book is very gently used.", "This book is not bad","This book is old!"};
	
	public boolean isCheckedOut() {  //isCheckedOut
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	

	public Book(String title, int numOfPages, Person author){
		this.title = title;
		this.numbOfPages= numOfPages;
		this.author= author;
		height=(int) Math.floor(Math.random()*100)+150;
		thickness = (int) numOfPages / 10;
		jacketColor =Color.gray;
		wasLitOnFire=false;
		checkedOut = false;
		checkOutDate = 0;
		dueDate = 0;
		description = conditions[0];
		accumulatedUse =0;
	}
	
	public int getAccumulatedUse() {
		return accumulatedUse;
	}

	public String getDescription() {
		return description;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}
	public Color getColor() {
		return jacketColor;
	}
	public String toString(){
		if(wasLitOnFire) return  "\""+title+"\", by " +" The author of this book is too charred to make out " +": "+numbOfPages+" pages";
		else return "\""+title+"\", by " +author+": "+numbOfPages+" pages" + "height is: "+height;
	}
	
	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}
	public Color getJacketColor() {
		return jacketColor;
	}
	//getter
	 public String getTitle(){
		 return title;
	 }
	 public int getNumbOfPages(){
		 return numbOfPages;
	 }
	public Person getAuthor() {
		return author;
	}
	public void setOnFire(){
		jacketColor=Color.black;
		title = "The title of this book is too charred to make out";
		wasLitOnFire = true;
		//author = "The author's name is also unknown";
	}
	public long getSecondsRemaining(){		
		return (dueDate-System.currentTimeMillis())/1000;
	}
	public void updateCondition(long timeOfReturn){
		accumulatedUse += (int)(timeOfReturn/1000 - checkOutDate/1000);
		if(accumulatedUse >=10 && accumulatedUse <=20  ) description=conditions[1];
		if(accumulatedUse >=20 && accumulatedUse <=30 ) description=conditions[2];
		if(accumulatedUse >=30 ) description=conditions[3];
	}
}
