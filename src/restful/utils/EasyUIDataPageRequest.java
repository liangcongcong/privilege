package restful.utils;

import javax.ws.rs.FormParam;

/**
 * 分页请求
 *
 */
public class EasyUIDataPageRequest {
	/**
	 * 第几页，从1开始
	 */
	@FormParam("page")
	private int page = 1;
	/**
	 * 页容量，默认为１条记录
	 */
	@FormParam("rows")
	private int rows = 1;
	/**
	 * 排序属性，默认为id
	 */
	@FormParam("sort")
	private String sort;
	private static final String DEFAULT_SORT = "id";
	/**
	 * 排序方式，默认为升序
	 */
	@FormParam("order")
	private String order;
	private static final String DEFAULT_ORDER = "asc";
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		if (sort == null)
			return DEFAULT_SORT;
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		if (order == null)
			return DEFAULT_ORDER;
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}