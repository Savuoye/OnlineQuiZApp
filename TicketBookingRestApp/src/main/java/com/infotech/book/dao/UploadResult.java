package com.infotech.book.dao;

import java.util.List;

public class UploadResult {

	private int successCount;
	private List<String> errorRows;

	public UploadResult(int successCount, List<String> errorRows) {
		this.successCount = successCount;
		this.errorRows = errorRows;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public List<String> getErrorRows() {
		return errorRows;
	}

	public void setErrorRows(List<String> errorRows) {
		this.errorRows = errorRows;
	}

	@Override
	public String toString() {
		return "UploadResult [successCount=" + successCount + ", errorRows=" + errorRows + "]";
	}

}
