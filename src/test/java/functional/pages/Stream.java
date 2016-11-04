package functional.pages;

public interface Stream {
	
	void filterBy(FilterCriteria criteria);
	
	void addNotice(StreamType where, String id, NoticeTestData data);
	
	void addDiscussion(StreamType where, String id, TestData data);
	
	boolean noticeExists(Notice notice);
	
	boolean discussionExists(Discussion discussion);
	
	Stream view();
	
	Stream refresh();
	
	boolean isClean();
	
	void clean();
	
	Card getCard(Notice notice);
	
	Card getCard(Discussion notice);

}
