package mallpage;
//칼럼 실수하지말기 (수정해도 반영하기 까지 좀 시간이 걸리게 되고 꼬이게 되서 고치고 서버 스타트를 다시해야되는거같음)
// dto 불러오는 클래스 다 저장 새로고침함(실수하지말기)
//product(상품정보) DTO (setter,getter),VO(getter)
public class dto_product {
int midx;//
String pcode,pnm,pmoney,psales;
String psmoney,pimg,pdate;
// get => getter =>DTO 에 저장된 값을 가져 올때
public int getMidx() {
	return midx;
}
public void setMidx(int midx) {
	this.midx = midx;
}
public String getPcode() {
	return pcode;
}
public void setPcode(String pcode) {
	this.pcode = pcode;
}
public String getPnm() {
	return pnm;
}
public void setPnm(String pnm) {
	this.pnm = pnm;
}
public String getPmoney() {
	return pmoney;
}
public void setPmoney(String pmoney) {
	this.pmoney = pmoney;
}
public String getPsales() {
	return psales;
}
public void setPsales(String psales) {
	this.psales = psales;
}
public String getPsmoney() {
	return psmoney;
}
public void setPsmoney(String psmoney) {
	this.psmoney = psmoney;
}
public String getPimg() {
	return pimg;
}
public void setPimg(String pimg) {
	this.pimg = pimg;
}
public String getPdate() {
	return pdate;
}
public void setPdate(String pdate) {
	this.pdate = pdate;
}
}