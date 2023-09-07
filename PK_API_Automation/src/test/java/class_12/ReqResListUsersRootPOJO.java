package class_12;

import java.util.ArrayList;

public class ReqResListUsersRootPOJO {

	private float page;
	private float per_page;
	private float total;
	private float total_pages;
	ArrayList<ReqResListUsersDataPOJO> Data;
	ReqResListUsersSupportPOJO Support;

	public float getPage() {
		return page;
	}

	public void setPage(float page) {
		this.page = page;
	}

	public float getPer_page() {
		return per_page;
	}

	public void setPer_page(float per_page) {
		this.per_page = per_page;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(float total_pages) {
		this.total_pages = total_pages;
	}

	public ArrayList<ReqResListUsersDataPOJO> getData() {
		return Data;
	}

	public void setData(ArrayList<ReqResListUsersDataPOJO> data) {
		Data = data;
	}

	public ReqResListUsersSupportPOJO getSupport() {
		return Support;
	}

	public void setSupport(ReqResListUsersSupportPOJO support) {
		Support = support;
	}

}
