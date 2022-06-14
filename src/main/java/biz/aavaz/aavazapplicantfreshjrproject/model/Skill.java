package biz.aavaz.aavazapplicantfreshjrproject.model;

public class Skill {

	private int id;
	private String name;
	private int level;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", level=" + level + "]";
	}

}
