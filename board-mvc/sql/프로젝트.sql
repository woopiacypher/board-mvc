/*
    SPRING 웹프로젝트 : 게시판(tbl_table) 생성
    번호, 제목, 작성자, 내용, 조회수, 등록일
*/
create table tbl_board(
    no          number(5)       primary key
    , title     varchar2(200)   not null
    , writer    varchar2(200)   not null
    , content   varchar2(4000)  not null
    , view_cnt  number(5)       default 0
    , reg_date  date            default sysdate
);

-- 게시판 일련번호 생성
create sequence seq_tbl_board_no nocache;

insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '제목이오', '홍길동', '내용입니다');
insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '제목2이오', '윤길동', '내용2입니다');
insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '제목3이오', '홍길순', '내용일까');
insert into tbl_board(no, title, writer, content)
 values(seq_tbl_board_no.nextval, '제목4이오', '홍길동', '내용3입니다'); 
 
 
 
 
 
 
 
 
 
 