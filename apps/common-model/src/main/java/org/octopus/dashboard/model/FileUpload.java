package org.octopus.dashboard.model;

public class FileUpload {
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	private String name;
	private String savedName;

	/**
	 * it's the exactly saved file name<br>
	 * if savedName not set,the use 'uuid + "-" + name;'
	 * 
	 * @return
	 */
	public String getSavedName() {
		if (savedName != null)
			return savedName;
		return uuid + "-" + name;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	private byte[] file;

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public byte[] getFile() {
		return file;
	}
}
