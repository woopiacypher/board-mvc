package kr.ac.kopo.board.vo;

public class PageVO {

	private int currentPage;	// 현재 페이지
	private int pageSize;		// 한 페이지에 보여줄 게시글 수
	private int pageBlock;		// 한 번에 보여줄 페이지 번호 개수
	private int totalCount;		// 전체 게시글 수
	private int totalPage;		// 전체 페이지 수
	private int startPage;		// 화면에 보여줄 시작 페이지 번호
	private int endPage;		// 화면에 보여줄 끝 페이지 번호

	public PageVO(int currentPage, int totalCount, int pageSize, int pageBlock) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageBlock = pageBlock;

		this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
		if (this.totalPage == 0) {
			this.totalPage = 1;
		}

		this.startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
		this.endPage = Math.min(startPage + pageBlock - 1, totalPage);
	}

	public boolean isHasPrevBlock() {
		return startPage > 1;
	}

	public boolean isHasNextBlock() {
		return endPage < totalPage;
	}

	public int getCurrentPage() { return currentPage; }
	public int getPageSize() { return pageSize; }
	public int getPageBlock() { return pageBlock; }
	public int getTotalCount() { return totalCount; }
	public int getTotalPage() { return totalPage; }
	public int getStartPage() { return startPage; }
	public int getEndPage() { return endPage; }
}