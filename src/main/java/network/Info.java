package network;

public class Info {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Info(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof Info) {
			Info i = (Info) o;
			if (i.getName().equals(this.name)){

				return true;
				
			}
		}

		return false;

	}

}
