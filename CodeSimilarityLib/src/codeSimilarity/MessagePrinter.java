package codeSimilarity;

public abstract class MessagePrinter {
	public abstract void show(String msg);
	
	public static MessagePrinter getDefaultMessagePrinter() {
		return new MessagePrinter() {
			@Override
			public void show(String msg) {
				System.out.println(msg);
			}
		};
	}
}
