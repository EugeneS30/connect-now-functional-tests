package functional.pages;

public interface Stream {
	
	void filterBy(FilterCriteria criteria);
	
	void addNotice(StreamType where, String id, NoticeTestData data);
	
	void addDiscussion(StreamType where, String id, TestData data);
	
	boolean cardExists(TestData data);

	

}
