package bean;

public class orderItem {//������  
	//id num 
	private int id;
	private int num;//����
	private Product product ;//���ò�Ʒ���� ���������id and price
	private Order order;
	public int getId() {
		return id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
