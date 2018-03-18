package arbitrator;

public class InputReaderDeconstructedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InputReaderDeconstructedException() {
		super("InputReader cannot be used after it was deconstructed");
	}
	
}
