class Interval {

	private double middlePoint;
	
	private double length;
	
	private double getBottom() {
		return middlePoint - length/2;
	}

	private void setBottom(double bottom) {
		length = this.getUp() - bottom;
		middlePoint = bottom + length/2;
	}

	private double getUp() {
		return middlePoint + length/2;
	}

	private void setUp(double up) {
		length = up - this.getBottom();
		middlePoint = up - length/2;
	}

	public Interval(double bottom, double up) {
		this.setBottom(bottom);
		this.setUp(up);
	}

	public Interval(double up) {
		this(0, up);
	}

	public Interval(Interval interval) {
		this(interval.getBottom(), interval.getUp());
	}

	public Interval() {
		this(0, 0);
	}

	public Interval clone() {
		return new Interval(this);
	}

	public double length() {
		return getUp() - getBottom();
	}

	public void desplazar(double desplazamiento) {
		setBottom(getBottom() + desplazamiento);
		setUp(getUp() + desplazamiento);
	}

	public Interval desplazado(double desplazamiento) {
		Interval interval = this.clone();
		interval.desplazar(desplazamiento);
		return interval;
	}

	public boolean include(double valor) {
		return getBottom() <= valor && valor <= getUp();
	}

	public boolean include(Interval interval) {
		assert interval!=null;
		return this.include(interval.getBottom()) && 
				this.include(interval.getUp());
	}

	public boolean equals(Interval interval) {
		assert interval!=null;
		return getBottom() == interval.getBottom() && 
				getUp() == interval.getUp();
	}

	public Interval interseccion(Interval interval) {
		assert this.intersecta(interval);
		if (this.include(interval)){
			return interval.clone();
		} else if (interval.include(this)){
			return this.clone();
		} else if (this.include(interval.getBottom())){
			return new Interval(interval.getBottom(), getUp());
		} else {
			return new Interval(getBottom(), interval.getUp());
		}
	}

	public boolean intersecta(Interval interval) {
		assert interval!=null;
		return this.include(interval.getBottom()) ||
				this.include(interval.getUp()) || 
				interval.include(this);
	}

	public void oponer() {
		double inferiorInicial = getBottom();
		double superiorInicial = getUp();
		setBottom(-superiorInicial);
		setUp(-inferiorInicial);
	}

	public void doblar() {
		double longitudInicial = this.length();
		setBottom(getBottom() - longitudInicial / 2);
		setUp(getUp() + longitudInicial / 2);
	}

	public void recoger() {
		Console console = new Console();
		console.out("Bottom?");
		setBottom(console.inDouble());
		console.out("Up?");
		setUp(console.inDouble());
	}

	public void show() {
		new Console().out("[" + getBottom() + "," + getUp() + "]");
	}

}

