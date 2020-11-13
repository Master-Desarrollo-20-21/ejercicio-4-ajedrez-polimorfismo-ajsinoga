

public class Turn {

	private int value;

	public Turn(int totalMovements) {
		this.value = totalMovements;
	}

	public int whoPlay() {
		return this.value;
	}

	public void change(int totalMovements) {
		this.value = totalMovements % 2;
	}
}
