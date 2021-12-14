package model;

public class MeetingRoom {


	Integer roomid;
	Integer roomnum;
	String roomname;
	Integer capacity;
	String status;

	public MeetingRoom(Integer roomid, Integer roomnum, String roomname, Integer capacity, String status, String description) {
		this.roomid = roomid;
		this.roomnum = roomnum;
		this.roomname = roomname;
		this.capacity = capacity;
		this.status = status;
		this.description = description;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String description;
}
