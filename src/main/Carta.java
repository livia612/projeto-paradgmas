package main;

public class Carta {
	private int id;
    private String name;
    private String ranks;
    private String element;

    public Carta(int id, String name, String ranks, String element) {
        this.id = id;
        this.name = name;
        this.ranks = ranks;
        this.element = element;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRanks() {
		return ranks;
	}

	public String getElement() {
		return element;
	}

}
