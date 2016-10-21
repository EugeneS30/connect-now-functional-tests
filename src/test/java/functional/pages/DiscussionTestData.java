package functional.pages;

public class DiscussionTestData implements TestData{

	private String className;
	private String discussionGroupName;
	private String title;
	private String message;
	private boolean isShown;

	public DiscussionTestData(String className, String discussionGroupName, String title, String message, boolean isShown) {
		this.className = className;
		this.discussionGroupName = discussionGroupName;
		this.title = title;
		this.message = message;
		this.isShown = isShown;
	}

	private DiscussionTestData() {
	}

	public static DiscussionTestData create() {
		return new DiscussionTestData();
	}
	
	public DiscussionTestData className(String className) {
		this.className = className;
		return this;
	}
	
	public DiscussionTestData discussionGroupName(String groupName) {
		this.discussionGroupName = groupName;
		return this;
	}
	
	public DiscussionTestData title(String title) {
		this.title = title;
		return this;
	}
	
	public DiscussionTestData message(String message) {
		this.message = message;
		return this;
	}
	
	public DiscussionTestData isShown(boolean isShown) {
		this.isShown = isShown;
		return this;
	}
	
	

}
