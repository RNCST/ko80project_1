package proj_back;

public class TransactionVO {
	private int 	t_num 		= 0;
	private String 	t_date 		= "";
	private int 	t_total		= 0;
	
	
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public int getT_total() {
		return t_total;
	}
	public void setT_total(int t_total) {
		this.t_total = t_total;
	}
	
}
