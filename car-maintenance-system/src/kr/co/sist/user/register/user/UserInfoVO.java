package kr.co.sist.user.register.user;

import java.util.List;
import kr.co.sist.admin.register.car.RegisteredCarVO;

public class UserInfoVO {
  private String id, pw, name, tel, addr, currentUser;
  private boolean isAdmin;
  private List<RegisteredCarVO> registeredCar;

  public UserInfoVO() {}

  public UserInfoVO(String id, String pw, boolean isAdmin, String name, String tel, String addr,
      List<RegisteredCarVO> registeredCar) {
    super();
    this.id = id;
    this.pw = pw;
    this.isAdmin = isAdmin;
    this.name = name;
    this.tel = tel;
    this.addr = addr;
    this.registeredCar = registeredCar;
  }

  public UserInfoVO(String currentUser) {
    super();
    this.currentUser = currentUser;
  }

  public String getCurrentUser() {
    return currentUser;
  }

  public void setCurrentUser(String currentUser) {
    this.currentUser = currentUser;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public List<RegisteredCarVO> getRegisteredCar() {
    return registeredCar;
  }

  public void setRegisteredCar(List<RegisteredCarVO> registeredCar) {
    this.registeredCar = registeredCar;
  }

  @Override
  public String toString() {
    return "UserInfoVO [id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", isAdmin="
        + isAdmin + ", registeredCar=" + registeredCar + "]";
  }



}
