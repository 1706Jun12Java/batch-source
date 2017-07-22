package Domain;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

public class RRequest {

	public RRequest(float amount, String desc, String author, String type, InputStream image) {
		super();
		this.amount = amount;
		this.desc = desc;
		this.author = author;
		this.type = type;
		this.image = image;
	}

	public RRequest() {
		super();
	}

	public RRequest(float amount, String desc, String type) {
		super();
		this.amount = amount;
		this.desc = desc;
		this.type = type;
	}

	public RRequest(float amount, String desc, String type, InputStream image) {
		super();
		this.amount = amount;
		this.desc = desc;
		this.type = type;
		this.image = image;
	}

	public RRequest(int iD, float amount, String desc, Date submitted, Date resolved, String author, String resolver,
			String type, String status) {
		super();
		ID = iD;
		this.amount = amount;
		this.desc = desc;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}

	public RRequest(int iD, float amount, String desc, Date submitted, Date resolved, String author, String resolver,
			String type, String status, InputStream image) {
		super();
		ID = iD;
		this.amount = amount;
		this.desc = desc;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
		this.image = image;
	}

	private int ID;
	private float amount;
	private String desc;
	private Date submitted;
	private Date resolved;
	private String author;
	private String resolver;
	private String type;
	private String status;
	private InputStream image;

	public String getID() {
		return Integer.toString(ID);
	}

	public void setID(int iD) {
		ID = iD;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date resolved) {
		this.resolved = resolved;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(FileInputStream image) {
		this.image = image;
	}

}
