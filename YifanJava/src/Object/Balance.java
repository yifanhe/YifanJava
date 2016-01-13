package Object;

public class Balance {
	double amount;
	long lastWorked;
	
	public Balance(){
		amount = 0;
		lastWorked = 0;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getLastWorked() {
		return lastWorked;
	}
	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}
	public void subtractLateFees(long timeOverdue){
		if (timeOverdue<0){
			int late = (int)(timeOverdue/1000)*-1;
			if(late<=1)amount-=5;
			if(late>1){amount -= (5 + (late-1));}
		}
	}
	public boolean canWork(long time){
		if((time-lastWorked)/1000>10){
			return true;
		}
		return false;
	}
	public String earnMoney(long time){
		if(canWork(time)){
			amount+= 5.0;
			lastWorked = time;
			return "did some work at the library and earned $5";
		}
		return "can not do a double shifft! Wait until the first job is done!";
	}
	public double getAmount() {
		int temp = (int) (amount);
		return temp;
	}
}
