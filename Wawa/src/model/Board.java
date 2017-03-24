package model;

public class Board {
	private int board_idx;
	private int board_code;
	private String title;
	private String writer;
	private String content;
	private String readcount;
	private String writedate;
	private String category;
	private String petname;
	private String resist;
	private String lostdate;
	private String kind;
	private int weight;
	private int age;
	private String sex;
	private String phone;
	private String email;
	private String birthday;
	private int starpoint;
	private int boastnum;
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReadcount() {
		return readcount;
	}
	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getResist() {
		return resist;
	}
	public void setResist(String resist) {
		this.resist = resist;
	}
	public String getLostdate() {
		return lostdate;
	}
	public void setLostdate(String lostdate) {
		this.lostdate = lostdate;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getStarpoint() {
		return starpoint;
	}
	public void setStarpoint(int starpoint) {
		this.starpoint = starpoint;
	}
	public int getBoastnum() {
		return boastnum;
	}
	public void setBoastnum(int boastnum) {
		this.boastnum = boastnum;
	}
	@Override
	public String toString() {
		return "Board [board_idx=" + board_idx + ", board_code=" + board_code + ", title=" + title + ", writer="
				+ writer + ", content=" + content + ", readcount=" + readcount + ", writedate=" + writedate
				+ ", category=" + category + ", petname=" + petname + ", resist=" + resist + ", lostdate=" + lostdate
				+ ", kind=" + kind + ", weight=" + weight + ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + ", birthday=" + birthday + ", starpoint=" + starpoint + ", boastnum=" + boastnum
				+ "]";
	}
	
	
}
