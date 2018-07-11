package com.ness.bean;

public class CustomerDetails {
	private String name;
	private int usedId;
	private String region;
	private String trackDate;
	
	public CustomerDetails() {
		
	}
	
	public CustomerDetails(String name, int usedId, String region, String trackDate) {
		super();
		this.name = name;
		this.usedId = usedId;
		this.region = region;
		this.trackDate = trackDate;
	}

	public CustomerDetails(String name, int usedId, String region) {
		this.name = name;
		this.usedId = usedId;
		this.region = region;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((trackDate == null) ? 0 : trackDate.hashCode());
		result = prime * result + usedId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetails other = (CustomerDetails) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (trackDate == null) {
			if (other.trackDate != null)
				return false;
		} else if (!trackDate.equals(other.trackDate))
			return false;
		if (usedId != other.usedId)
			return false;
		return true;
	}*/

	public String getTrackDate() {
		return trackDate;
	}

	public void setTrackDate(String trackDate) {
		this.trackDate = trackDate;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getUsedId() {
		return usedId;
	}
	public void setUsedId(int usedId) {
		this.usedId = usedId;
	}

	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", usedId=" + usedId + ", region=" + region + ", trackDate="
				+ trackDate + "]";
	}
	
	
}
