package class_11;

public class ReqResRootPOJO {

	private ReqResDataPOJO DataObject;
	private ReqResSupportPOJO SupportObject;

	// Getter Methods

	public ReqResDataPOJO getData() {
		return DataObject;
	}

	public ReqResSupportPOJO getSupport() {
		return SupportObject;
	}

	// Setter Methods

	public void setData(ReqResDataPOJO dataObject) {
		this.DataObject = dataObject;
	}

	public void setSupport(ReqResSupportPOJO supportObject) {
		this.SupportObject = supportObject;
	}

}
