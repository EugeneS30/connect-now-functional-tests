package functional.pages;

public class NoticeTestData implements TestData {

	private String className;
	private String title;
	private String message;
	private boolean isShown;

	public NoticeTestData(String className, String title, String message, boolean isShown) {
		this.className = className;
		this.title = title;
		this.message = message;
		this.isShown = isShown;
	}

	private NoticeTestData() {
	}

	public static NoticeTestData create() {
		return new NoticeTestData();
	}
	
	public NoticeTestData className(String className) {
		this.className = className;
		return this;
	}
	
	public NoticeTestData title(String title) {
		this.title = title;
		return this;
	}
	
	public NoticeTestData message(String message) {
		this.message = message;
		return this;
	}
	
	public NoticeTestData isShown(boolean isShown) {
		this.isShown = isShown;
		return this;
	}

	public String getClassName() {
		return className;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public boolean isShown() {
		return isShown;
	}
	
	

}
