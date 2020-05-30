package restful.form;

import javax.ws.rs.FormParam;

/**
 * EndTypeForm, LinkForm, OperatorForm
 */
public class ELOForm {
	@FormParam("id")
	private int id;
	@FormParam("caption")
	private String caption;
	@FormParam("description")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
